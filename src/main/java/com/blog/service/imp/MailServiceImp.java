package com.blog.service.imp;

import java.util.List;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.blog.nosqldao.MailRepositoryImp;
import com.blog.nosqldomain.Mail;
import com.blog.service.MailService;

@Service
public class MailServiceImp implements MailService{
	@Autowired
    private JavaMailSender mailSender;
	
    @Autowired
    private TemplateEngine templateEngine;
    
    @Autowired
    MailRepositoryImp mongoDBMailRepository;

    @Value("${mail.fromMail.addr}")
    private String form;	


	@Override
	public Mail save(Mail mail) {
		return mongoDBMailRepository.save(mail);
	}

	@Override
	public List<Mail> findMail(HttpServletRequest request) {
		String uid = request.getParameter("uid");
		// TODO Auto-generated method stub
		return mongoDBMailRepository.findByUid(Integer.valueOf(uid));
	}
 
	 /**
     * 发送简单邮件
     * @param to 接受者
     * @param subject 主题
     * @param content 内容
     */
	@Override
	public void sendSimpleMail(String to, String subject, String content,Mail mail) {
		SimpleMailMessage mailMessage=new SimpleMailMessage();
        mailMessage.setFrom(form);//发起者
        mailMessage.setTo(to);//接受者

    //如果发给多个人的：
    //mailMessage.setTo("1xx.com","2xx.com","3xx.com");     
        mailMessage.setSubject(subject);
        mailMessage.setText(content+"123lkk");
        
        try {
            mailSender.send(mailMessage);
            System.out.println("发送简单邮件");
            this.save(mail);
        }catch (Exception e){
            System.out.println("发送简单邮件失败");
        }
		
	}

    /**
     * 发送html格式的邮件
     * @param to 接受者
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendHtmlMail(String to, String subject, String content,Mail mail) {
        MimeMessage message=mailSender.createMimeMessage();
        try {
            //true表示需要创建一个multipart message
            MimeMessageHelper helper=new MimeMessageHelper(message,true);
            helper.setFrom(form);
            helper.setTo(form);
            helper.setSubject(subject);
            helper.setText(content,true);
            mailSender.send(message);
            System.out.println("html格式邮件发送成功");
            this.save(mail);
        }catch (Exception e){
            System.out.println("html格式邮件发送失败");
        }
    }

 
 
	@SuppressWarnings("unused")
	@Override
    public void sendMail(HttpServletRequest request) {
    	String to = request.getParameter("to");
        String subject =request.getParameter("subject"); 
    	String content =request.getParameter("content"); 
    	Context context = new Context();
        context.setVariable("message", content+"123");
        String mailctx = "";
        Mail mail = new Mail();
        mail.setUid(1);
        mail.setAddressEmailFrom(form);
        mail.setAddressEmailTo(to);
        mail.setSubject(subject);
        if(null != context) {
        	mail.setContext(context);
        	mailctx = templateEngine.process("MailTemplate1", context);
           	this.sendHtmlMail(to, subject, mailctx,mail);
 
        }else{
        	 mail.setText(content);
	      	 this.sendSimpleMail(to, subject, content,mail);
        }
   
    }
}
