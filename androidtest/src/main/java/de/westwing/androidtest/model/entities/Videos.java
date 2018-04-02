package de.westwing.androidtest.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abdellahselassi on 7/28/16.
 */
public class Videos implements Parcelable {
    private String thumbnail;

    private String url;

    public String getThumbnail ()
    {
        return thumbnail;
    }

    public void setThumbnail (String thumbnail)
    {
        this.thumbnail = thumbnail;
    }

    public String getUrl ()
    {
        return url;
    }

    public void setUrl (String url)
    {
        this.url = url;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [thumbnail = "+thumbnail+", url = "+url+"]";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.thumbnail);
        dest.writeString(this.url);
    }

    public Videos() {
    }

    protected Videos(Parcel in) {
        this.thumbnail = in.readString();
        this.url = in.readString();
    }

    public static final Parcelable.Creator<Videos> CREATOR = new Parcelable.Creator<Videos>() {
        @Override
        public Videos createFromParcel(Parcel source) {
            return new Videos(source);
        }

        @Override
        public Videos[] newArray(int size) {
            return new Videos[size];
        }
    };
}
