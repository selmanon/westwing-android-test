package de.westwing.androidtest;

import android.app.Application;
import android.content.Context;

import de.westwing.androidtest.model.WestwingService;
import rx.Scheduler;
import rx.schedulers.Schedulers;

public class WestwingApplication extends Application {

    private WestwingService westwingService;
    private Scheduler defaultSubscribeScheduler;

    public static WestwingApplication get(Context context) {
        return (WestwingApplication) context.getApplicationContext();
    }

    public WestwingService getWestwingService() {
        if (westwingService == null) {
            westwingService = WestwingService.Factory.create();
        }
        return westwingService;
    }

    //For setting mocks during testing
    public void setWestwingService(WestwingService westwingService) {
        this.westwingService = westwingService;
    }

    public Scheduler defaultSubscribeScheduler() {
        if (defaultSubscribeScheduler == null) {
            defaultSubscribeScheduler = Schedulers.io();
        }
        return defaultSubscribeScheduler;
    }

    //Campaigns to change scheduler from tests
    public void setDefaultSubscribeScheduler(Scheduler scheduler) {
        this.defaultSubscribeScheduler = scheduler;
    }
}
