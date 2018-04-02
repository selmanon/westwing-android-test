package de.westwing.androidtest.model;

import java.util.List;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import rx.Observable;
import de.westwing.androidtest.model.entities.Campaigns;


public interface WestwingService {


    @GET("/cms/dont-delete/programming_task/data.json")
    Observable<List<Campaigns>> getCampaigns();


    class Factory {
        public static WestwingService create() {
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl("http://static.westwing.de/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .build();
            return retrofit.create(WestwingService.class);
        }
    }
}
