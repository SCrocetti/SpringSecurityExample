package com.example.spring_security_demo.persistance.entity;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private Integer bookId;
    @Column(name="book_name")
    private String bookName;



    @CreatedDate
    @Column(name="creation_date_time")
    private LocalDateTime creationDateTime;
    @Column(name="creation_user_id")
    private Integer creationUserId;
    @LastModifiedDate
    @Column(name="modification_date_time")
    private LocalDateTime modificationDateTime;
    @Column(name="modification_user_id")
    private Integer modificationUserId;
    private boolean enabled = true;

    @ManyToOne
    @JoinColumn(name = "creation_user_id",insertable = false,updatable = false)
    private User creationUser;
    @ManyToOne
    @JoinColumn(name = "modification_user_id",insertable = false,updatable = false)
    private User modificationUser;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public LocalDateTime getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(LocalDateTime creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Integer getCreationUserId() {
        return creationUserId;
    }

    public void setCreationUserId(Integer creationUserId) {
        this.creationUserId = creationUserId;
    }

    public LocalDateTime getModificationDateTime() {
        return modificationDateTime;
    }

    public void setModificationDateTime(LocalDateTime modificationDateTime) {
        this.modificationDateTime = modificationDateTime;
    }

    public Integer getModificationUserId() {
        return modificationUserId;
    }

    public void setModificationUserId(Integer modificationUserId) {
        this.modificationUserId = modificationUserId;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public User getModificationUser() {
        return modificationUser;
    }

    public void setModificationUser(User modificationUser) {
        this.modificationUser = modificationUser;
    }
}
