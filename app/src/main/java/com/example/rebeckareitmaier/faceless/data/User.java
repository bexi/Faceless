package com.example.rebeckareitmaier.faceless.data;

import java.util.List;

/**
 * Created by gustav on 2016-05-14.
 */
public class User {

    private String userName;
    private String name;
    private String quote;
    private String color;
    private String description;

    private List<String> categories;
    private List<String> tags;
    private List<User> friends;

    public User(String userName, String name, String quote, String color, String description, List<String> categories, List<String> tags, List<User> friends){
        this.userName = userName;
        this.name = name;
        this.quote = quote;
        this.color = color;
        this.description = description;
        this.categories = categories;
        this.tags = tags;
        this.friends = friends;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }
}
