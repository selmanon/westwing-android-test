package de.westwing.androidtest.view.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.List;

import de.westwing.androidtest.CampaignsAdapter;
import de.westwing.androidtest.presenter.CampaignsPresenter;
import de.westwing.androidtest.view.CampaignsMvpView;
import de.westwing.androidtest.R;
import de.westwing.androidtest.model.entities.Campaigns;

public class CampaignsActivity extends AppCompatActivity implements CampaignsMvpView {

    private CampaignsPresenter presenter;

    private RecyclerView mCampaignsRecycleView;
    private ProgressBar progressBar;
    private TextView infoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Set up presenter
        presenter = new CampaignsPresenter();
        presenter.attachView(this);

        setContentView(R.layout.activity_campaigns_main);

        initUI();

        presenter.getCampaigns();
    }

    private void initUI() {
        progressBar = (ProgressBar) findViewById(R.id.progress);
        infoTextView = (TextView) findViewById(R.id.text_info);

        //Set up ToolBar
        setUpToolBar();

        //Set up RecyclerView
        setUpRecyclerView();
    }

    private void setUpRecyclerView() {
        mCampaignsRecycleView = (RecyclerView) findViewById(R.id.campaigns_recycler_view);
        setupRecyclerView(mCampaignsRecycleView);
    }

    private void setUpToolBar() {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayShowHomeEnabled(false);
        }
    }

    // CampaignsMvpView interface methods implementation

    @Override
    protected void onDestroy() {
        presenter.detachView();
        super.onDestroy();
    }

    @Override
    public Context getContext() {
        return this;
    }

    @Override
    public void showCampaigns(List<Campaigns> campaigns) {
        CampaignsAdapter adapter = (CampaignsAdapter) mCampaignsRecycleView.getAdapter();

        adapter.setCampaigns(campaigns);
        adapter.notifyDataSetChanged();

        mCampaignsRecycleView.requestFocus();
        progressBar.setVisibility(View.INVISIBLE);
        infoTextView.setVisibility(View.INVISIBLE);
        mCampaignsRecycleView.setVisibility(View.VISIBLE);
    }

    @Override
    public void showCampaignsDetail(int id) {

    }

    @Override
    public void showMessage(int stringId) {
        progressBar.setVisibility(View.INVISIBLE);
        infoTextView.setVisibility(View.VISIBLE);
        mCampaignsRecycleView.setVisibility(View.INVISIBLE);
        infoTextView.setText(getString(stringId));
    }

    @Override
    public void showProgressIndicator() {
        progressBar.setVisibility(View.VISIBLE);
        infoTextView.setVisibility(View.INVISIBLE);
        mCampaignsRecycleView.setVisibility(View.INVISIBLE);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        CampaignsAdapter adapter = new CampaignsAdapter();
        adapter.setCallback(new CampaignsAdapter.Callback() {
            @Override
            public void onItemClick(Campaigns campaigns) {
                startActivity(CampaignsDetailsActivity.newIntent(CampaignsActivity.this, campaigns));
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
