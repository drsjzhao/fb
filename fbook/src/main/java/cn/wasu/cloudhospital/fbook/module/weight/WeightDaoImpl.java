package cn.wasu.cloudhospital.fbook.module.weight;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import cn.wasu.cloudhospital.fbook.util.FieldName;

@Repository
public class WeightDaoImpl implements WeightDao {

  public static final Logger logger = LoggerFactory.getLogger(WeightDaoImpl.class);
  @Autowired
  private MongoTemplate mongoTemplate;

  @Override
  public void insert(Weight w) {
    this.mongoTemplate.insert(w);
  }

  @Override
  public double getWeight(long person_index) {
    Query query = new Query();

    query.addCriteria(new Criteria(FieldName.person_index).is(person_index));
    query.fields().include(FieldName.weight);

    return this.mongoTemplate.findOne(query, Weight.class).getWeight();
  }

  @Override
  public void updateWeight(long person_index, double weight) {
    Query query = new Query();
    query.addCriteria(new Criteria(FieldName.person_index).is(person_index));

    Update update = new Update();
    update.set(FieldName.weight, weight);

    this.mongoTemplate.upsert(query, update, Weight.class);
  }

  @Override
  public boolean exist(long person_index) {
    Query query = new Query();
    query.addCriteria(new Criteria(FieldName.person_index).is(person_index));

    return this.mongoTemplate.exists(query, Weight.class);
  }

}
