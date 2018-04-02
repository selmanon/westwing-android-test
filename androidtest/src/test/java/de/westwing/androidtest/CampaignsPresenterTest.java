package de.westwing.androidtest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.RuntimeEnvironment;
import org.robolectric.annotation.Config;

import rx.schedulers.Schedulers;
import de.westwing.androidtest.model.WestwingService;
import de.westwing.androidtest.presenter.CampaignsPresenter;
import de.westwing.androidtest.view.CampaignsMvpView;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 21)
public class CampaignsPresenterTest {
    CampaignsPresenter mainPresenter;
    CampaignsMvpView mainMvpView;
    WestwingService githubService;

    @Before
    public void setUp() {
        WestwingApplication application = (WestwingApplication) RuntimeEnvironment.application;
        githubService = mock(WestwingService.class);

        // Mock the retrofit service so we don't call the API directly
        application.setWestwingService(githubService);

        // Change the default subscribe schedulers so all observables
        // will now run on the same thread
        application.setDefaultSubscribeScheduler(Schedulers.immediate());
        mainPresenter = new CampaignsPresenter();
        mainMvpView = mock(CampaignsMvpView.class);
        when(mainMvpView.getContext()).thenReturn(application);
        mainPresenter.attachView(mainMvpView);
    }

    @After
    public void tearDown() {
        mainPresenter.detachView();
    }

    @Test
    public void loadCampaignsCallsShowCampaigns() {

    }

    @Test
    public void loadCampaignsCallsShowMessage_withEmptyCampaignsString() {

    }

    @Test
    public void loadCampaignsCallsShowMessage_withDefaultErrorString() {

    }

    @Test
    public void loadCampaignsCallsShowMessage_withCampaignsnameNotFoundString() {

    }

}
