package cn.wasu.cloudhospital.toufu.module;

import java.util.Map;

public interface WeightModule {

  /**
   * 竞争
   * 
   * @param request
   * @return
   */
  public boolean compete(Map<String, Object> request);
}
