package com.zybooks.MyWeight;
/*
*===================================================================================================
* The user class is needed to store the parameter for id, date, and weight inside the SQLite
* database.
*
* BEFORE CHANGES:
* Username, password, and goal were also stored in User. Getters and setters were present for each,
* but entirely unused by some of them.
*
* AFTER CHANGES:
* Username, password, and goal were removed due to design decisions, unused setters and getters were
* removed.
*
*===================================================================================================
*/
public class User {
    int id;
    String date, weight;

    public User(int id, String date, String weight) {
        this.id = id;
        this.date = date;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    //The setters for these are unused. Date and weight are set via SQLite database put commands.
    public String getDate() {
        return date;
    }

    public String getWeight() {
        return weight;
    }
}

