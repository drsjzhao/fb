package cn.wasu.cloudhospital.toufu.module;

import java.util.List;
import java.util.Map;

public interface PersonModule {

  /**
   * 随机获取一对person
   * 
   * @return
   */
  public List<Map<String, Object>> getPairOfPersonRandom();
}
