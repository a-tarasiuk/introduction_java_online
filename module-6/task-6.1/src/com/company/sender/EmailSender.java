package com.company.sender;

import com.company.book.Book;
import com.company.message.MsgSender;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Отправлять письма пользователям будем через почтовый сервер Gmail.
 * Для этого нам нужны данные SMTP от Gmail сервера:
 * Host:                    smtp.gmail.com
 * Use Authentication:      Yes
 * Port for TLS/STARTTLS:   587
 * Port for SSL:            465
 *
 * И с помощью этих выше данных мы будем обращаться к серверу Gmail.
 * С данными ознакомиться можно - https://support.google.com/mail/answer/13287?hl=en.
 *
 * В JavaMail API используются классы, один из которых:
 * - Session - класс, который определяет основные сессии почты. Чтобы передать значения в объект сессии, может использоваться класс Properties.
 * - Authenticator – класс, который обеспечивает доступ к защищенным ресурсам с помощью имени пользователя и пароля.
 * Приложения используют этот класс при получении сессии. Когда требуется авторизация, система будет вызывать метод подкласса (например, getPasswordAuthentication).
 *
 * [Вопрос] С какой почты будут отправляться письма?
 * [Ответ] Это будет почта администратора.
 * Логин:   java0tutoronline@gmail.com
 * Пароль:  uBjqtN7ikNGBy65
 *
 * [Вопрос] Появляется исключение - javax.mail.AuthenticationFailedException: 535-5.7.8 Username and Password not accepted
 * [Ответ]
 * Обязательно выполнить следующие шаги:
 * - https://stackoverflow.com/questions/35347269/javax-mail-authenticationfailedexception-535-5-7-8-username-and-password-not-achttps://stackoverflow.com/questions/35347269/javax-mail-authenticationfailedexception-535-5-7-8-username-and-password-not-ac
 */

public class EmailSender {
    static final String ENCODING = "UTF-8";
    private Address[] addresses;
    private Properties properties;
    private MsgSender msg;

    public EmailSender(ArrayList<String> mailsTo){
        msg = new MsgSender();
        // добавляем электронные почты пользователей из mails в addresses
        addresses = new InternetAddress[mailsTo.size()];
        for(int i = 0; i < mailsTo.size(); i++) {
            try {
                addresses[i] = new InternetAddress(mailsTo.get(i));
            } catch (AddressException e) {
                e.printStackTrace();
            }
        }

        properties = new Properties();

        // загружаем в Properties свойства из файла. Создал файл для удобства хранения информации.
        try (FileInputStream in = new FileInputStream("./src/com/company/sender/gmail_properties.txt");){
            properties.load(in);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    private Session createSession(){
        return Session.getInstance(properties, new javax.mail.Authenticator(){
            protected PasswordAuthentication getPasswordAuthentication(){
                return new PasswordAuthentication(properties.getProperty("mail.smtp.from"), properties.getProperty("mail.smtp.password"));
            }
        });
        //session.setDebug(true);
    }

    public void send(String subject, Book book, String oldDescription){
        try {
            Message message = new MimeMessage(createSession());
            InternetAddress myAddress = new InternetAddress("NOTIFICATIONS");
            myAddress.setPersonal("NOTIFICATIONS");
            message.setFrom(myAddress);
            message.setRecipients(Message.RecipientType.TO, addresses);
            message.setSubject(subject);

            if(oldDescription == null)
                message.setText(book.toStringBuilder().toString());
            else
                message.setText(getMessageAboutChangedDescription(book, oldDescription).toString());

            // отправляем сообщение
            Transport.send(message);
            msg.msgNotificationsSentSuccessfully();
        } catch (MessagingException | UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    private StringBuilder getMessageAboutChangedDescription(Book book, String oldDescription){
        return new StringBuilder().append("\nBook description has been changed!").
                append("\nNew Information about this book:").
                append(book.toStringBuilder()).
                append("Old description:\n").
                append(oldDescription);
    }
}
