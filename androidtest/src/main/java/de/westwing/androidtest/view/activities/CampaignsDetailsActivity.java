package de.westwing.androidtest.view.activities;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.graphics.Palette;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;

import java.util.List;

import de.westwing.androidtest.presenter.CampaignsPresenter;
import de.westwing.androidtest.R;
import de.westwing.androidtest.model.entities.Campaigns;
import de.westwing.androidtest.view.CampaignsMvpView;

public class CampaignsDetailsActivity extends AppCompatActivity implements CampaignsMvpView {

    private static final String EXTRA_REPOSITORY = "EXTRA_REPOSITORY";

    private TextView nameText;
    private TextView sublineText;
    private TextView descriptionText;
    private TextView startTimeFormattedText;
    private FloatingActionButton navigationUrlText;
    private ImageView campaignsImage;
    private View ownerLayout;

    private CampaignsPresenter presenter;

    public static Intent newIntent(Context context, Campaigns campaigns) {
        Intent intent = new Intent(context, CampaignsDetailsActivity.class);
        intent.putExtra(EXTRA_REPOSITORY, campaigns);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = new CampaignsPresenter();
        presenter.attachView(this);

        setContentView(R.layout.activity_campaigns_details);
        nameText = (TextView) findViewById(R.id.title);
        sublineText = (TextView) findViewById(R.id.subline);
        descriptionText = (TextView) findViewById(R.id.description);
        startTimeFormattedText = (TextView) findViewById(R.id.start_time);
        navigationUrlText = (FloatingActionButton) findViewById(R.id.navigation_url);
        campaignsImage = (ImageView) findViewById(R.id.photo);
        ownerLayout = findViewById(R.id.container);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        Campaigns campaigns = getIntent().getParcelableExtra(EXTRA_REPOSITORY);
        bindCampaignsData(campaigns);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.detachView();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public Context getContext() {
        return this;
    }


    private void bindCampaignsData(final Campaigns campaigns) {
        setTitle(campaigns.getName());
        nameText.setText(campaigns.getName());
        sublineText.setText(campaigns.getSubline());
        navigationUrlText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openWebLink(campaigns.getNavigation_url());
            }
        });
        startTimeFormattedText.setText(campaigns.getStart_time_formatted());
        descriptionText.setText(campaigns.getDescription());

        Glide.with(this)
                .load(campaigns.getNavigation_url())
                .asBitmap()
                .into(new BitmapImageViewTarget(campaignsImage) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        super.setResource(resource);
                        colorize(resource);
                    }
                });



    }

    private void openWebLink(String navigation_url) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(navigation_url));
        startActivity(browserIntent);
    }

    @Override
    public void showCampaigns(List<Campaigns> campaigns) {

    }

    @Override
    public void showCampaignsDetail(int id) {

    }

    @Override
    public void showMessage(int stringId) {

    }

    @Override
    public void showProgressIndicator() {

    }



    private void colorize(Bitmap photo) {
        Palette.generateAsync(photo, new Palette.PaletteAsyncListener() {
            @Override
            public void onGenerated(Palette palette) {
                Palette.Swatch swatch = palette.getDarkVibrantSwatch();
                if(swatch!=null){
                    getWindow().setBackgroundDrawable(new ColorDrawable(swatch.getRgb()));
                    descriptionText.setTextColor(swatch.getBodyTextColor());
                }
            }

        });
    }

}


