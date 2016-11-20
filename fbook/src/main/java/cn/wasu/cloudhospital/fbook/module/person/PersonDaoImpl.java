package cn.wasu.cloudhospital.fbook.module.person;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.Sort.Order;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import cn.wasu.cloudhospital.fbook.util.FieldName;

@Repository
public class PersonDaoImpl implements PersonDao {

  public static final Logger logger = LoggerFactory.getLogger(PersonDaoImpl.class);
  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void insert(Person person) {
    this.mongoTemplate.insert(person);
  }

  @Override
  public Person find(long index) {
    Query query = new Query();
    query.addCriteria(new Criteria(FieldName.index).is(index));

    return this.mongoTemplate.findOne(query, Person.class);
  }

  @Override
  public List<Person> list(int skip, int limit) {
    Query query = new Query();

    query.skip(skip);
    query.limit(limit);

    return this.mongoTemplate.find(query, Person.class);
  }

  @Override
  public long maxIndex() {
    Query query = new Query();
    if (!this.mongoTemplate.exists(query, Person.class)) return -1;

    query.with(new Sort(new Order(Direction.DESC, FieldName.index)));
    query.fields().include(FieldName.index);

    return this.mongoTemplate.findOne(query, Person.class).getIndex();
  }
}
