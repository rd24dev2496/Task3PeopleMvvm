package com.example.task3peoplemvvm.viewmodel;

import android.view.View;

import com.example.task3peoplemvvm.model.Location;
import com.example.task3peoplemvvm.model.People;

public class PeopleDetailViewModel {
    private final People people;
    Location location;


    public PeopleDetailViewModel(People people) {
        this.people = people;
    }

    public String getFullUserName() {
        return people.getFullName();
    }

    public String getUserName() {
        return people.getLogin().getUserName();
    }

    public String getEmail() {
        return people.getMail();
    }

    public int getEmailVisibility() {
        return people.hasEmail() ? View.VISIBLE : View.GONE;
    }

    public String getCell() {
        return people.getCell();
    }

    public String getPictureProfile() {
        return people.getPicture().getLarge();
    }

    public String getAddress() {
        return people.getLocation().getStreet().getName()
                + " "
                + people.getLocation().getStreet().getNumber() + " "
                + people.getLocation().getCity()
                + " "
                + people.getLocation().getState();
    }
    public String getGender() {
        return people.getGender();
    }
    public  String  getCity()
    {
        return people.getLocation().getCity();
    }
}
