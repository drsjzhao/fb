package cn.wasu.cloudhospital.fbook.module.weight;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.wasu.cloudhospital.fbook.util.TableName;

@Document(collection = TableName.weight)
public class Weight {

  @Id
  private String id;
  private long person_index;
  private double weight;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getPerson_index() {
    return person_index;
  }

  public void setPerson_index(long person_index) {
    this.person_index = person_index;
  }

  public double getWeight() {
    return weight;
  }

  public void setWeight(double weight) {
    this.weight = weight;
  }

}
