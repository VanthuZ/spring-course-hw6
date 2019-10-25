package pl.vanthus.hw6.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Aspect
@Component
public class SendEmail {

    @Autowired
    private JavaMailSender sender;


    @After("@annotation(InfoAfterAddMovie)")
    private void test() throws MessagingException {
        MimeMessage message = sender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        helper.setTo("uradres@email.com");
        helper.setText("How are you?");
        helper.setSubject("Hi");

        sender.send(message);

    }



}
