package com.example.task3peoplemvvm;

import android.content.Context;

import androidx.multidex.MultiDexApplication;

import com.example.task3peoplemvvm.data.PeopleFactory;
import com.example.task3peoplemvvm.data.PeopleService;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class PeoplesApplication extends MultiDexApplication {
    private PeopleService peopleService;
    private Scheduler scheduler;

    private  static  PeoplesApplication get(Context context)
    {
      return  (PeoplesApplication) context.getApplicationContext();
    }
    public  static  PeoplesApplication create(Context context)
    {
        return PeoplesApplication.get(context);
    }
    public PeopleService getPeopleService()
    {
        if(peopleService==null)
        {
            peopleService= PeopleFactory.create();
        }
        return peopleService;
    }
    public  Scheduler subscribeScheduler()
    {
        if (scheduler==null)
        {
            scheduler= Schedulers.io();
        }
    return scheduler;
    }
}
