package com.example.task3peoplemvvm.data;

import com.example.task3peoplemvvm.model.People;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PeopleResponse {
    @SerializedName("results")
    private List<People> peopleList;

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void setPeopleList(List<People> peopleList) {
        this.peopleList = peopleList;
    }
}
