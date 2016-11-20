package cn.wasu.cloudhospital.toufu.module;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.jvnet.hk2.annotations.Service;

import cn.wasu.cloudhospital.toufu.util.Config;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

@Service
@SuppressWarnings("unchecked")
public class PersonModuleImpl implements PersonModule {

  private String fbook_server;

  public PersonModuleImpl() {
    this.fbook_server = Config.getInstance().get("fbook.server");
  }

  @Override
  public List<Map<String, Object>> getPairOfPersonRandom() {
    Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
    WebTarget target = client.target(fbook_server + "person/pair_of_person_random");
    Response response = target.request().get();
    List<Map<String, Object>> value = response.readEntity(List.class);
    response.close();
    return value;
  }

  // @Override
  // public Map<String, Object> get_doctor_info_by_id(String doctor_id) {
  // if (!exist(String.format(keyboard_server + "doctor/exist/%s", doctor_id))) return null;
  //
  // Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
  // WebTarget target = client.target(String.format(keyboard_server + "doctor/detail/%s", doctor_id));
  // Response response = target.request().get();
  // Map<String, Object> value = response.readEntity(Map.class);
  // response.close();
  // return value;
  // }
  //
  // @Override
  // public List<Map<String, Object>> search(Map<String, Object> request) {
  // Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
  // WebTarget target = client.target(keyboard_server + "doctor/search");
  // Response response = target.request().buildPost(Entity.entity(request, MediaType.APPLICATION_JSON)).invoke();
  // List<Map<String, Object>> value = response.readEntity(List.class);
  // response.close();
  // return value;
  // }

}
