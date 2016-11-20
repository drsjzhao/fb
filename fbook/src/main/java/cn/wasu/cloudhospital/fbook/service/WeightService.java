package cn.wasu.cloudhospital.fbook.service;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wasu.cloudhospital.fbook.module.weight.Weight;
import cn.wasu.cloudhospital.fbook.module.weight.WeightDao;
import cn.wasu.cloudhospital.fbook.module.weight.WeightDaoImpl;
import cn.wasu.cloudhospital.fbook.request.CompeteRequest;
import cn.wasu.cloudhospital.fbook.util.Config;

public class WeightService {

  private WeightDao weightDao;

  public WeightService() {
    this.weightDao = new ClassPathXmlApplicationContext("classpath:/config/spring/*.xml").getBean(WeightDaoImpl.class);
  }

  public boolean addWeight(Weight w) {
    try {
      this.weightDao.insert(w);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  public double getWeight(long person_index) {
    if (!this.weightDao.exist(person_index)) {

      // 生成一条原始数据
      Weight w = new Weight();
      w.setPerson_index(person_index);
      w.setWeight(0);
      this.weightDao.insert(w);

      return w.getWeight();
    } else return this.weightDao.getWeight(person_index);
  }

  public boolean complete(CompeteRequest cr) {
    try {
      // RA,RB
      double r_a = getWeight(cr.getPerson_index_1());
      double r_b = getWeight(cr.getPerson_index_2());
      // 获取EA,EB
      double e_a = getE(r_b, r_a);
      double e_b = getE(r_a, r_b);
      // 获取SA,SB
      int s_a = (1 == cr.getWinner_index()) ? 1 : 0;
      int s_b = (2 == cr.getWinner_index()) ? 1 : 0;
      // 获取RA',RB'
      r_a = r_a + Config.K * (s_a - e_a);
      r_b = r_b + Config.K * (s_b - e_b);
      // 更新
      this.weightDao.updateWeight(cr.getPerson_index_1(), r_a);
      this.weightDao.updateWeight(cr.getPerson_index_2(), r_b);

    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }

    return true;
  }

  private double getE(double x, double y) {
    return 1.0 / (1 + Math.pow(10, (x - y) / 400));
  }

}
