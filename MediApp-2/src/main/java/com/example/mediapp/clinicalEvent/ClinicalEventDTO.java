package com.example.mediapp.clinicalEvent;


import java.util.Date;

public class ClinicalEventDTO {
    Date createDate;
    Date date;
    String eventName;
    String venue;
    String description;
    String imageUrl;
    String targetAudience;//aim- send notifications and when updating attendance
    String time;

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getTargetAudiance() {
        return targetAudience;
    }

    public void setTargetAudiance(String targetAudiance) {
        this.targetAudience = targetAudiance;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }
}
