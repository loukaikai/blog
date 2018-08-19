package com.blog.nosqldao;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.aggregation.Aggregation;
import org.springframework.data.mongodb.core.aggregation.AggregationOperation;
import org.springframework.data.mongodb.core.aggregation.AggregationResults;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.stereotype.Repository;

import com.blog.nosqldomain.Mail;

@Repository
public class MailRepositoryImp implements MailRepository{
	@Resource
	MongoTemplate mongoTemplate;

	@Override
	public List<Mail> findByUid(int Uid) {
		List<AggregationOperation> list = new ArrayList<>();
		Criteria critria = Criteria.where("uid").is(Uid);
		AggregationOperation aggre = Aggregation.match(critria);
		list.add(aggre);
		Aggregation aggregation = Aggregation.newAggregation(list);
		AggregationResults<Mail> results = mongoTemplate.aggregate(aggregation, "mail", Mail.class);
		List<Mail> mail_lsit = results.getMappedResults();
		System.out.println("*********"+mail_lsit+"*********");
		return mail_lsit;
	}

 	@Override
	public List<Mail> findAll() {
		return mongoTemplate.findAll(Mail.class, "mail");
	}

	@Override
	public Mail save(Mail mail) {
		mongoTemplate.save(mail);
		return mail;
	}
}
