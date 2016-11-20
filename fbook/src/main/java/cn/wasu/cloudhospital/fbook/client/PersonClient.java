package cn.wasu.cloudhospital.fbook.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import cn.wasu.cloudhospital.fbook.module.person.Person;

import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class PersonClient {

  private static String serverUri = "http://127.0.0.1:8081/fbook/";

  public static void main(String[] args) {
    PersonClient client = new PersonClient();

    Person person = new Person();
    person.setName("yuanyuan gao");
    person.setGender(2);
    person.setIntro("演员");
    person.setHead("http://ldl.holier.cn:8087/resources/fbook/yuanyuan gao.jpg");

    client.addPerson(person);
  }

  public void addPerson(Person person) {
    Client client = ClientBuilder.newClient().register(JacksonJsonProvider.class);
    WebTarget target = client.target(serverUri + "person");
    Response response = target.request().buildPost(Entity.entity(person, MediaType.APPLICATION_JSON)).invoke();
    Boolean value = response.readEntity(Boolean.class);
    response.close();
    System.out.println(value);
  }

}
