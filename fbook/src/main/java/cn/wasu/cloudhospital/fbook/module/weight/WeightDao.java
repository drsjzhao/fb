package cn.wasu.cloudhospital.fbook.module.weight;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface WeightDao {

  public void insert(Weight w);

  public boolean exist(long person_index);

  public double getWeight(long person_index);

  public void updateWeight(long person_index, double weight);
}
