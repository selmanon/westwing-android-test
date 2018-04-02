package de.westwing.androidtest.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by abdellahselassi on 7/28/16.
 */
public class Campaigns implements Parcelable{
    private String remaining_days_formatted;

    private String end_time_formatted;

    private String badge_url;

    private String newsletter_urlkey;

    private String id_campaign;

    private String navigation_url;

    private Object promotion_line;

    private List<Videos> videos;

    private String start_time_formatted;

    private String subline;

    private String banner_url;

    private Object banner_url_original;

    private String message_line_style;

    private String end_time;

    private String description;

    private String name;

    private Images images;

    private String start_time;

    private String url_key;

    private String message_line;

    private Object themeday;

    public String getRemaining_days_formatted ()
    {
        return remaining_days_formatted;
    }

    public void setRemaining_days_formatted (String remaining_days_formatted)
    {
        this.remaining_days_formatted = remaining_days_formatted;
    }

    public String getEnd_time_formatted ()
    {
        return end_time_formatted;
    }

    public void setEnd_time_formatted (String end_time_formatted)
    {
        this.end_time_formatted = end_time_formatted;
    }

    public String getBadge_url ()
    {
        return badge_url;
    }

    public void setBadge_url (String badge_url)
    {
        this.badge_url = badge_url;
    }

    public String getNewsletter_urlkey ()
    {
        return newsletter_urlkey;
    }

    public void setNewsletter_urlkey (String newsletter_urlkey)
    {
        this.newsletter_urlkey = newsletter_urlkey;
    }

    public String getId_campaign ()
    {
        return id_campaign;
    }

    public void setId_campaign (String id_campaign)
    {
        this.id_campaign = id_campaign;
    }

    public String getNavigation_url ()
    {
        return navigation_url;
    }

    public void setNavigation_url (String navigation_url)
    {
        this.navigation_url = navigation_url;
    }

    public Object getPromotion_line ()
    {
        return promotion_line;
    }

    public void setPromotion_line (Object promotion_line)
    {
        this.promotion_line = promotion_line;
    }

    public List<Videos> getVideos ()
    {
        return videos;
    }

    public void setVideos (List<Videos> videos)
    {
        this.videos = videos;
    }

    public String getStart_time_formatted ()
    {
        return start_time_formatted;
    }

    public void setStart_time_formatted (String start_time_formatted)
    {
        this.start_time_formatted = start_time_formatted;
    }

    public String getSubline ()
    {
        return subline;
    }

    public void setSubline (String subline)
    {
        this.subline = subline;
    }

    public String getBanner_url ()
    {
        return banner_url;
    }

    public void setBanner_url (String banner_url)
    {
        this.banner_url = banner_url;
    }

    public Object getBanner_url_original ()
    {
        return banner_url_original;
    }

    public void setBanner_url_original (Object banner_url_original)
    {
        this.banner_url_original = banner_url_original;
    }

    public String getMessage_line_style ()
    {
        return message_line_style;
    }

    public void setMessage_line_style (String message_line_style)
    {
        this.message_line_style = message_line_style;
    }

    public String getEnd_time ()
    {
        return end_time;
    }

    public void setEnd_time (String end_time)
    {
        this.end_time = end_time;
    }

    public String getDescription ()
    {
        return description;
    }

    public void setDescription (String description)
    {
        this.description = description;
    }

    public String getName ()
    {
        return name;
    }

    public void setName (String name)
    {
        this.name = name;
    }

    public Images getImages ()
    {
        return images;
    }

    public void setImages (Images images)
    {
        this.images = images;
    }

    public String getStart_time ()
    {
        return start_time;
    }

    public void setStart_time (String start_time)
    {
        this.start_time = start_time;
    }

    public String getUrl_key ()
    {
        return url_key;
    }

    public void setUrl_key (String url_key)
    {
        this.url_key = url_key;
    }

    public String getMessage_line ()
    {
        return message_line;
    }

    public void setMessage_line (String message_line)
    {
        this.message_line = message_line;
    }

    public Object getThemeday ()
    {
        return themeday;
    }

    public void setThemeday (Object themeday)
    {
        this.themeday = themeday;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [remaining_days_formatted = "+remaining_days_formatted+", end_time_formatted = "+end_time_formatted+", badge_url = "+badge_url+", newsletter_urlkey = "+newsletter_urlkey+", id_campaign = "+id_campaign+", navigation_url = "+navigation_url+", promotion_line = "+promotion_line+", videos = "+videos+", start_time_formatted = "+start_time_formatted+", subline = "+subline+", banner_url = "+banner_url+", banner_url_original = "+banner_url_original+", message_line_style = "+message_line_style+", end_time = "+end_time+", description = "+description+", name = "+name+", images = "+images+", start_time = "+start_time+", url_key = "+url_key+", message_line = "+message_line+", themeday = "+themeday+"]";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.remaining_days_formatted);
        dest.writeString(this.end_time_formatted);
        dest.writeString(this.badge_url);
        dest.writeString(this.newsletter_urlkey);
        dest.writeString(this.id_campaign);
        dest.writeString(this.navigation_url);
        dest.writeParcelable((Parcelable) this.promotion_line, flags);
        dest.writeList(this.videos);
        dest.writeString(this.start_time_formatted);
        dest.writeString(this.subline);
        dest.writeString(this.banner_url);
        dest.writeParcelable((Parcelable) this.banner_url_original, flags);
        dest.writeString(this.message_line_style);
        dest.writeString(this.end_time);
        dest.writeString(this.description);
        dest.writeString(this.name);
        dest.writeParcelable((Parcelable) this.images,flags);
        dest.writeString(this.start_time);
        dest.writeString(this.url_key);
        dest.writeString(this.message_line);
        dest.writeParcelable((Parcelable) this.themeday, flags);
    }

    public Campaigns() {
    }

    protected Campaigns(Parcel in) {
        this.remaining_days_formatted = in.readString();
        this.end_time_formatted = in.readString();
        this.badge_url = in.readString();
        this.newsletter_urlkey = in.readString();
        this.id_campaign = in.readString();
        this.navigation_url = in.readString();
        this.promotion_line = in.readParcelable(Object.class.getClassLoader());
        this.videos = in.readArrayList(Videos.class.getClassLoader());
        this.start_time_formatted = in.readString();
        this.subline = in.readString();
        this.banner_url = in.readString();
        this.banner_url_original = in.readParcelable(Object.class.getClassLoader());
        this.message_line_style = in.readString();
        this.end_time = in.readString();
        this.description = in.readString();
        this.name = in.readString();
        this.images = in.readParcelable(Images.class.getClassLoader());
        this.start_time = in.readString();
        this.url_key = in.readString();
        this.message_line = in.readString();
        this.themeday = in.readParcelable(Object.class.getClassLoader());
    }

    public static final Creator<Campaigns> CREATOR = new Creator<Campaigns>() {
        @Override
        public Campaigns createFromParcel(Parcel source) {
            return new Campaigns(source);
        }

        @Override
        public Campaigns[] newArray(int size) {
            return new Campaigns[size];
        }
    };
}
