package com.example.rebeckareitmaier.faceless.data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gustav on 2016-05-14.
 */
public class UserData {
    private List<User> users;

    public UserData(List<User> users){
        users = new ArrayList<User>();
        users.add(new User("gurrabz", "Gustav B", "Att leva är att simma från stranden jag till stranden du i havet vi", "Green",
                "Hejhej jag är en glad spontan och social kille på 23 vårar. Gillar månskenspromenader och solsemester.",
                new ArrayList<String>(), new ArrayList<String>(), new ArrayList<User>()));
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
