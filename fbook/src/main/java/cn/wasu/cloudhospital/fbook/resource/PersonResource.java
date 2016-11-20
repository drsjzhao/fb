package cn.wasu.cloudhospital.fbook.resource;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import cn.wasu.cloudhospital.fbook.module.person.Person;
import cn.wasu.cloudhospital.fbook.service.PersonService;

@Singleton
@Path("/person")
public class PersonResource {

  private PersonService personService = new PersonService();

  @GET
  @Produces({ "application/json;charset=UTF-8" })
  public String get() {
    return "test person";
  }

  @GET
  @Path("/pair_of_person_random")
  @Produces({ "application/json;charset=UTF-8" })
  public List<Person> pair_of_person_random() {
    return personService.getPairOfPersonRandom();
  }

  @POST
  @Consumes({ "application/json" })
  public boolean addPerson(Person person) {
    if (person == null) return false;
    return personService.addPerson(person);
  }
}
