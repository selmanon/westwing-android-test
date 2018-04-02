package de.westwing.androidtest.model.entities;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by abdellahselassi on 7/28/16.
 */
public class Images implements Parcelable {
    private Banner banner;

    public Banner getBanner ()
    {
        return banner;
    }

    public void setBanner (Banner banner)
    {
        this.banner = banner;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [banner = "+banner+"]";
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable((Parcelable) this.banner, flags);
    }

    public Images() {
    }

    protected Images(Parcel in) {
        this.banner = in.readParcelable(Banner.class.getClassLoader());
    }

    public static final Parcelable.Creator<Images> CREATOR = new Parcelable.Creator<Images>() {
        @Override
        public Images createFromParcel(Parcel source) {
            return new Images(source);
        }

        @Override
        public Images[] newArray(int size) {
            return new Images[size];
        }
    };
}
