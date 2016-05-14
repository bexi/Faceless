package com.example.rebeckareitmaier.faceless;

/**
 * Created by MichelleTL on 14/05/16.
 */
public class ForumMessage {
    private String name, message, timeStamp;

    public ForumMessage() {
    }

    public ForumMessage(String name, String message, String timeStamp) {
        this.name = name    ;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}