package org.java.finalprove.photoalbum.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Message cannot be blank")
    @Size(min = 3, max = 500, message = "Message must be between 3 and 500 characters")
    @Lob
    private String body;

    @NotBlank(message = "Sender cannot be blank")
    @Size(min = 3, max = 50, message = "Sender must be between 3 and 50 characters")
    private String senderEmail;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}
