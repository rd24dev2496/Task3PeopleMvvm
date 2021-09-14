package com.example.task3peoplemvvm.viewmodel;
import android.content.Context;
import android.view.View;
import androidx.databinding.BaseObservable;
import com.example.task3peoplemvvm.model.People;

public class ItemPeopleViewModel extends BaseObservable {
    private final Context context;
    private People people;

    public ItemPeopleViewModel(Context context, People people) {
        this.context = context;
        this.people = people;
    }

    public String getFullName() {
        return people.getName().getTitle() + "." + people.getName().getFirst() + " " + people.getName().getLast();
    }

    public String getCell() {
        return people.getCell();
    }

    public String getMail() {
        return people.getMail();
    }

    public String getPictureProfile() {
        return people.getPicture().getMedium();
    }

    public void onItemClick(View view) {
     //   context.startActivity(PeopleDetailActivity.launchDetail(view.getContext(), people));
    }

    public void setPeople(People people) {
        this.people = people;
        notifyChange();
    }
}

