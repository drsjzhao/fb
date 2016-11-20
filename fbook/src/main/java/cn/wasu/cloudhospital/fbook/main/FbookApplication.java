package cn.wasu.cloudhospital.fbook.main;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import cn.wasu.cloudhospital.fbook.resource.PersonResource;
import cn.wasu.cloudhospital.fbook.resource.WeightResource;

@ApplicationPath("/")
public class FbookApplication extends Application {

  @Override
  public Set<Class<?>> getClasses() {
    final Set<Class<?>> classes = new HashSet<Class<?>>();
    classes.add(PersonResource.class);
    classes.add(WeightResource.class);
    return classes;
  }
}
