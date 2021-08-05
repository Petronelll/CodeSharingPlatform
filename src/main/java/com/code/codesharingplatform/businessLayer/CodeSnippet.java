package com.code.codesharingplatform.businessLayer;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
public class CodeSnippet {

    @Id
    @JsonIgnore
    @GeneratedValue
    private UUID id;

    @Column(length = 1000000)
    private String code;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime date = LocalDateTime.now();

    private int time;
    private int views;

    public CodeSnippet() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public void updateViews() {
        views--;
    }

    @JsonIgnore
    public int getTimeLeft() {
        LocalDateTime currentDate = LocalDateTime.now();
        return time - (int) Duration.between(date, currentDate).getSeconds();
    }

    @JsonIgnore
    public boolean isTimeRestricted() {
        return time > 0;
    }

    @JsonIgnore
    public boolean isViewsRestricted() {
        return views > 0;
    }

}