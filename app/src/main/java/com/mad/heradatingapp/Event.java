package com.mad.heradatingapp;

public class Event {
    private String title;
    private String type;
    private String host;
    private String description;

    public Event(){}

    public Event(String title, String type, String host, String description) {
        this.title = title;
        this.type = type;
        this.host = host;
        this.description = description;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDescription(){ return description; }

    public void setDescription(String description){ this.description = description; }
}
