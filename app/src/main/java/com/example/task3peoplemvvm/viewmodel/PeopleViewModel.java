package com.example.task3peoplemvvm.viewmodel;
import android.content.Context;
import android.view.View;
import androidx.annotation.NonNull;
import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;
import com.example.task3peoplemvvm.PeopleApplication;
import com.example.task3peoplemvvm.R;
import com.example.task3peoplemvvm.data.PeopleFactory;
import com.example.task3peoplemvvm.data.PeopleResponse;
import com.example.task3peoplemvvm.data.PeopleService;
import com.example.task3peoplemvvm.model.People;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

public class PeopleViewModel extends Observable {

    public ObservableInt peopleProgress;
    public ObservableInt peopleRecycler;
    public ObservableInt peopleLabel;
    public ObservableField<String> messageLabel;

    private List<People> peopleList;
    private Context context;
    private CompositeDisposable compositeDisposable = new CompositeDisposable();

    public PeopleViewModel(@NonNull Context context) {
        this.context = context;
        this.peopleList = new ArrayList<>();
        peopleProgress = new ObservableInt(View.GONE);
        peopleRecycler = new ObservableInt(View.GONE);
        peopleLabel = new ObservableInt(View.VISIBLE);
    }
    public void onClickFabLoad(View view) {
        initializeViews();
        fetchPeopleList();
    }
    public void initializeViews() {
        peopleLabel.set(View.GONE);
        peopleRecycler.set(View.GONE);
        peopleProgress.set(View.VISIBLE);
    }

    private void fetchPeopleList() {
        PeopleApplication peopleApplication=PeopleApplication.create(context);
        PeopleService peopleService= peopleApplication.getPeopleService();
        Disposable disposable = peopleService.fetchPeople(PeopleFactory.RANDOM_USER_URL)
                .subscribeOn(peopleApplication.subscribeScheduler())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe((Consumer<PeopleResponse>) peopleResponse -> {
                    changePeopleDataSet(peopleResponse.getPeopleList());
                    peopleProgress.set(View.GONE);
                    peopleLabel.set(View.GONE);
                    peopleRecycler.set(View.VISIBLE);
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) {
                        messageLabel.set(context.getString(R.string.error_loading_people));
                        peopleProgress.set(View.GONE);
                        peopleLabel.set(View.VISIBLE);
                        peopleRecycler.set(View.GONE);
                        throwable.printStackTrace();
                    }
                });
        compositeDisposable.add(disposable);
    }


    private void changePeopleDataSet(List<People> peoples) {
        peopleList.addAll(peoples);
        setChanged();
        notifyObservers();
    }

    public List<People> getPeopleList() {
        return peopleList;
    }

    public void reset() {
        compositeDisposable.dispose();
        compositeDisposable = null;
        context = null;
    }
}

