package com.email.model;

import com.email.form.EmailForm;
import jakarta.mail.Folder;
import jakarta.mail.Message;
import jakarta.mail.Session;
import jakarta.mail.Store;
import org.springframework.context.annotation.Bean;

import java.util.*;


public class EmailModel {
    public List<EmailForm> getList() {
        String host = "imap.gmail.com";

        // Set up JavaMail properties
        Properties properties = new Properties();
        properties.put("mail.store.protocol", "imap");
        properties.put("mail.imap.ssl.enable", "true");
        properties.put("mail.impa.host", host);
        properties.put("mail.imap.port", "993");
        properties.put("mail.imap.timeout", "10000");
        properties.put("mail.imap.connectiontimeout", "10000"); // IMAP over SSL/TLS

        EmailForm form = null;
        List<EmailForm> listt = null;
        try {
            // Create a session with the properties
            Session session = Session.getDefaultInstance(properties);

            // Get the IMAP store
            Store store = session.getStore("imaps");

            // Connect to the server
            store.connect("imap.gmail.com", "basantvishwakarma0449@gmail.com", "jbxl jodn wnfi tcze");

            // Get the Inbox folder
            Folder inbox = store.getFolder("INBOX");

            // Open the folder in read-only mode
            inbox.open(Folder.READ_ONLY);

            // Get the messages in the Inbox
            Message[] messages = inbox.getMessages();
            System.out.println(messages.length);

            // list = new ArrayList<EmailForm>();
            List<Message> list = Arrays.asList(messages);

            Iterator it = list.iterator();
            listt = new ArrayList<EmailForm>();
            while (it.hasNext()) {
                form = new EmailForm();

                Message message = (Message) it.next();

                System.out.println("---------------------");

                form.setSubject(message.getSubject());
                form.setFrom(String.valueOf(message.getFrom()));
                form.setDate(String.valueOf(message.getSentDate()));

                System.out.println(it.next());

                listt.add(form);
            }
            // Close the folder and store
            inbox.close(false);
            store.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listt;
    }
}
