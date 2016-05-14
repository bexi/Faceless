package com.example.rebeckareitmaier.faceless.data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by gustav on 2016-05-14.
 */
public class UserData {
    private List<User> users;

    public UserData(List<User> users){
        User gurrabz = new User("gurrabz", "Gustav B", "Att leva är att simma från stranden jag till stranden du i havet vi", "Green",
                "Hejhej jag är en glad spontan och social kille på 23 vårar. Gillar månskenspromenader och solsemester.",
                Arrays.asList("Fotboll", "Spel"), Arrays.asList("zidane"), new ArrayList<User>());

        User lovre = new User("lovre", "Katarina B", "Spa är mitt liv", "Blue",
                "Hejhej jag är en glad spontan och social tjej på 22 vårar. Spenderar större delen av mitt liv på spa.",
                Arrays.asList("Foto", "Fotboll"), Arrays.asList("spa"), new ArrayList<User>());

        User bexi = new User("bexi", "Rebecka R", "Jag tycker det är mysigt att lyssna på fotboll", "Pink",
                "Hejhej jag är en glad spontan och social tjej på 22 vårar. Gillar månskenspromenader och äckliga hundar.",
                Arrays.asList("Konst", "Fotboll"), Arrays.asList("sleeptalker"), new ArrayList<User>());

        User ting = new User("ting", "Michelle TL", "SUSHI!!!", "Purple",
                "Hejhej jag är en glad spontan och social tjej på 22 vårar. Gillar bara sushi.",
                Arrays.asList("Sushi"), Arrays.asList("sushi"), new ArrayList<User>());

        users = Arrays.asList(gurrabz, lovre, bexi);

        addUser(ting);

        addFriends(lovre, ting);
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addFriends(User user1, User user2){
        user1.getFriends().add(user2);
        user2.getFriends().add(user1);
    }

    public void addUser(User user){
        users.add(user);
    }
}
