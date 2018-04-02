package de.westwing.androidtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;

import java.util.Collections;
import java.util.List;

import de.westwing.androidtest.R;
import de.westwing.androidtest.model.entities.Campaigns;

public class CampaignsAdapter extends RecyclerView.Adapter<CampaignsAdapter.CampaignsViewHolder> {

    private List<Campaigns> campaigns;
    private Callback callback;


    public CampaignsAdapter() {
        this.campaigns = Collections.emptyList();
    }

    public CampaignsAdapter(List<Campaigns> campaigns) {
        this.campaigns = campaigns;
    }

    public void setCampaigns(List<Campaigns> campaigns) {
        this.campaigns = campaigns;
    }

    public void setCallback(Callback callback) {
        this.callback = callback;
    }

    @Override
    public CampaignsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_campaigns, parent, false);
        final CampaignsViewHolder viewHolder = new CampaignsViewHolder(itemView);
        viewHolder.contentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (callback != null) {
                    callback.onItemClick(viewHolder.campaigns);
                }
            }
        });
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final CampaignsViewHolder holder, int position) {
        Campaigns campaign = campaigns.get(position);
        Context context = holder.nameTextView.getContext();

        holder.nameTextView.setText(campaign.getName());
        holder.nameTextView.setMaxLines(1);
        holder.sublineTextView.setText(campaign.getSubline());
        holder.campaigns = campaign;

        Glide.with(context).load(campaign.getNavigation_url()).into(new GlideDrawableImageViewTarget(holder.navigation_url) {
            @Override
            public void onResourceReady(GlideDrawable drawable, GlideAnimation anim) {
                super.onResourceReady(drawable, anim);
            }
        });
    }

    @Override
    public int getItemCount() {
        return campaigns.size();
    }

    static class CampaignsViewHolder extends RecyclerView.ViewHolder {
        public View contentLayout;
        public TextView nameTextView;
        public TextView sublineTextView;
        public ImageView navigation_url;
        public Campaigns campaigns;

        public CampaignsViewHolder(View itemView) {
            super(itemView);
            contentLayout = itemView.findViewById(R.id.linear_layout_campaigns);
            nameTextView = (TextView) itemView.findViewById(R.id.name_textView_photo);
            sublineTextView = (TextView) itemView.findViewById(R.id.subline_textView_photo);
            navigation_url = (ImageView) itemView.findViewById(R.id.photo);
        }
    }

    public interface Callback {
        void onItemClick(Campaigns campaigns);
    }
}
