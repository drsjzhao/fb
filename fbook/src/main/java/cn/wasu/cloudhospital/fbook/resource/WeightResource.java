package cn.wasu.cloudhospital.fbook.resource;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import cn.wasu.cloudhospital.fbook.request.CompeteRequest;
import cn.wasu.cloudhospital.fbook.service.WeightService;

@Singleton
@Path("/weight")
public class WeightResource {

  private WeightService weightService = new WeightService();

  @GET
  @Produces({ "application/json;charset=UTF-8" })
  public String get() {
    return "test weight";
  }

  @POST
  @Path("/compete")
  @Consumes({ "application/json" })
  public boolean compete(CompeteRequest cr) {
    if (cr == null) return false;
    return weightService.complete(cr);
  }

}
