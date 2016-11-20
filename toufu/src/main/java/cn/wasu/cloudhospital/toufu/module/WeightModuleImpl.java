package cn.wasu.cloudhospital.toufu.module;

import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cn.wasu.cloudhospital.toufu.util.Config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class WeightModuleImpl implements WeightModule {

  private String fbook_server;

  public WeightModuleImpl() {
    this.fbook_server = Config.getInstance().get("fbook.server");
  }

  @Override
  public boolean compete(Map<String, Object> request) {
    Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
    WebTarget target = client.target(fbook_server + "weight/compete");
    Response response = target.request().buildPost(Entity.entity(request, MediaType.APPLICATION_JSON)).invoke();
    boolean value = response.readEntity(Boolean.class);
    response.close();
    return value;
  }

}
