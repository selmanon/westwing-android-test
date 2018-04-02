package de.westwing.androidtest.presenter;

import java.util.List;

import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import de.westwing.androidtest.WestwingApplication;
import de.westwing.androidtest.model.WestwingService;
import de.westwing.androidtest.model.entities.Campaigns;
import de.westwing.androidtest.presenter.basepresenter.BasePresenter;
import de.westwing.androidtest.view.CampaignsMvpView;

public class CampaignsPresenter implements BasePresenter<CampaignsMvpView> {

    private static final String TAG = "CampaignsPresenter";

    private CampaignsMvpView campaignsMvpView;
    private Subscription subscription;

    @Override
    public void attachView(CampaignsMvpView view) {
        this.campaignsMvpView = view;
    }

    @Override
    public void detachView() {
        this.campaignsMvpView = null;
        if (subscription != null) subscription.unsubscribe();
    }

    public void getCampaigns() {
        WestwingApplication application = WestwingApplication.get(campaignsMvpView.getContext());
        WestwingService westwingService = application.getWestwingService();
        subscription = westwingService.getCampaigns()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(application.defaultSubscribeScheduler())
                .subscribe(new Observer<List<Campaigns>>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(List<Campaigns> campaigns) {
                        campaignsMvpView.showCampaigns(campaigns);
                    }
                });
    }
}
