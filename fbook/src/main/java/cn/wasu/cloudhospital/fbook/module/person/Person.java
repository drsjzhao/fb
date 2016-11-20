package cn.wasu.cloudhospital.fbook.module.person;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import cn.wasu.cloudhospital.fbook.util.TableName;

@Document(collection = TableName.person)
public class Person {

  @Id
  private String id;
  private long index;
  private String name;
  private int gender;
  private String intro;
  private String head;

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public long getIndex() {
    return index;
  }

  public void setIndex(long index) {
    this.index = index;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getGender() {
    return gender;
  }

  public void setGender(int gender) {
    this.gender = gender;
  }

  public String getIntro() {
    return intro;
  }

  public void setIntro(String intro) {
    this.intro = intro;
  }

  public String getHead() {
    return head;
  }

  public void setHead(String head) {
    this.head = head;
  }

}
