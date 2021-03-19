package javax.mail;

import jakarta.mail.MessagingException;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.junit.jupiter.api.Test;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

public class MailTest {

    @Test
    void mail() throws UnsupportedEncodingException, MessagingException {
        Properties props = new Properties();
        props.setProperty("mail.transport.protocol", "smtp");
        props.setProperty("mail.smtp.host", "smtp.aliyun.com");
        props.setProperty("mail.smtp.auth", "true");

        Session session= Session.getInstance(props);
        MimeMessage message = new MimeMessage(session);
        InternetAddress internetAddress = new InternetAddress("yunlelongzai@aliyun.com", "李林峰", StandardCharsets.UTF_8.name());
        message.setFrom(internetAddress);
        message.setRecipient(MimeMessage.RecipientType.TO,internetAddress);
        message.setSubject("TEST邮件主题", StandardCharsets.UTF_8.name());
        message.setContent("TEST这是邮件正文。。。", "text/html;charset=UTF-8");
        message.saveChanges();

        Transport transport = session.getTransport();
        transport.connect("yunlelongzai@aliyun.com", "fWr2W5%sQrte");
    }
}
