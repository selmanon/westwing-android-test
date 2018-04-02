package de.westwing.androidtest.view;

import java.util.List;

import de.westwing.androidtest.view.baseview.BaseMvpView;
import de.westwing.androidtest.model.entities.Campaigns;

public interface CampaignsMvpView extends BaseMvpView {

    void showCampaigns(List<Campaigns> campaigns);

    void showCampaignsDetail(int id);

    void showMessage(int stringId);

    void showProgressIndicator();
}
