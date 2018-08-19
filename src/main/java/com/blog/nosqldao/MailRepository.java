package com.blog.nosqldao;

import java.util.List;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import com.blog.nosqldomain.Mail;


@NoRepositoryBean
public interface MailRepository extends Repository<Mail, Long>{
	
	List<Mail> findByUid(int Uid);
	
	List<Mail> findAll();
	
	Mail save(Mail mail);

}
