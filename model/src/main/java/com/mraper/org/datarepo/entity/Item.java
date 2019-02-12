package com.mraper.org.datarepo.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Represents one repo. Field names in this class must match those from github api response.
 */
public class Item implements Parcelable {

    private long id;
    private String full_name;
    private ItemOwner owner;
    private String description;
    private String html_url;
    private long open_issues_count;
    private String contributors_url;
    private String subscribers_url;
    private String subscription_url;

    public Item(Parcel in) {
        id = in.readLong();
        full_name = in.readString();
        owner = in.readParcelable(ItemOwner.class.getClassLoader());
        description = in.readString();
        html_url = in.readString();
        open_issues_count = in.readLong();
        contributors_url = in.readString();
        subscribers_url = in.readString();
        subscription_url = in.readString();
    }

    public static final Creator<Item> CREATOR = new Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public ItemOwner getOwner() {
        return owner;
    }

    public void setOwner(ItemOwner owner) {
        this.owner = owner;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getHtml_url() {
        return html_url;
    }

    public void setHtml_url(String html_url) {
        this.html_url = html_url;
    }

    public long getOpen_issues_count() {
        return open_issues_count;
    }

    public void setOpen_issues_count(long open_issues_count) {
        this.open_issues_count = open_issues_count;
    }

    public String getContributors_url() {
        return contributors_url;
    }

    public void setContributors_url(String contributors_url) {
        this.contributors_url = contributors_url;
    }

    public String getSubscribers_url() {
        return subscribers_url;
    }

    public void setSubscribers_url(String subscribers_url) {
        this.subscribers_url = subscribers_url;
    }

    public String getSubscription_url() {
        return subscription_url;
    }

    public void setSubscription_url(String subscription_url) {
        this.subscription_url = subscription_url;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(id);
        parcel.writeString(full_name);
        parcel.writeParcelable(owner, i);
        parcel.writeString(description);
        parcel.writeString(html_url);
        parcel.writeLong(open_issues_count);
        parcel.writeString(contributors_url);
        parcel.writeString(subscribers_url);
        parcel.writeString(subscription_url);
    }
}