package cn.wasu.cloudhospital.fbook.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import cn.wasu.cloudhospital.fbook.module.person.Person;
import cn.wasu.cloudhospital.fbook.module.person.PersonDao;
import cn.wasu.cloudhospital.fbook.module.person.PersonDaoImpl;
import cn.wasu.cloudhospital.fbook.util.LongRandom;

public class PersonService {

  private PersonDao personDao;
  private LongRandom longRandom;

  public PersonService() {
    this.personDao = new ClassPathXmlApplicationContext("classpath:/config/spring/*.xml").getBean(PersonDaoImpl.class);
    this.longRandom = new LongRandom();
  }

  /**
   * 增加一个person
   * 
   * @param person
   * @return
   */
  public synchronized boolean addPerson(Person person) {
    try {
      // 设置index
      person.setIndex(personDao.maxIndex() + 1);

      this.personDao.insert(person);
    } catch (Exception e) {
      e.printStackTrace();
      return false;
    }
    return true;
  }

  /**
   * 随机获取两个person
   * 
   * @return
   */
  public List<Person> getPairOfPersonRandom() {
    List<Person> list = new ArrayList<>(2);

    long maxIndex = personDao.maxIndex();
    Random random = new Random();

    // 随机获取两个index
    long index_1 = longRandom.nextlong(random, maxIndex + 1);
    long index_2 = longRandom.nextlong(random, maxIndex + 1);

    // 排除index_1 == index_2
    while (index_2 == index_1) {
      index_2 = longRandom.nextlong(random, maxIndex);
    }

    list.add(personDao.find(index_1));
    list.add(personDao.find(index_2));

    return list;
  }

  public List<Person> list(int ps, int cp) {
    int skip = ps * (cp - 1);
    int limit = ps;

    return personDao.list(skip, limit);
  }
}
