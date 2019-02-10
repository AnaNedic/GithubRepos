package com.mraper.org.datarepo.model;

import android.os.Parcel;
import android.os.Parcelable;

public class ItemOwner implements Parcelable {

    private long id;
    private String avatar_url;
    private String html_url;
    private String type;

    protected ItemOwner(Parcel in) {
        id = in.readLong();
        avatar_url = in.readString();
        html_url = in.readString();
        type = in.readString();
    }

    public static final Creator<ItemOwner> CREATOR = new Creator<ItemOwner>() {
        @Override
        public ItemOwner createFromParcel(Parcel in) {
            return new ItemOwner(in);
        }

        @Override
        public ItemOwner[] newArray(int size) {
            return new ItemOwner[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(avatar_url);
        parcel.writeString(html_url);
        parcel.writeString(type);
    }
}