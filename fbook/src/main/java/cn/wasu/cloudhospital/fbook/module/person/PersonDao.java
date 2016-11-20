package cn.wasu.cloudhospital.fbook.module.person;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface PersonDao {

  /**
   * 增加
   * 
   * @param person
   */
  public void insert(Person person);

  /**
   * 获取
   * 
   * @return
   */
  public Person find(long index);

  /**
   * 获取最大的index
   * 
   * @return
   */
  public long maxIndex();

  /**
   * 列表获取
   * 
   * @param skip
   * @param limit
   * @return
   */
  public List<Person> list(int skip, int limit);
}
