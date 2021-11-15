package com.example.githubuserapp.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GithubUser implements Parcelable {
    private int avatar;
    private String username, name, follower, following, company, location, repository;

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollower() {
        return follower;
    }

    public void setFollower(String follower) {
        this.follower = follower;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }

    public GithubUser(){}

    protected GithubUser(Parcel in) {
        avatar = in.readInt();
        username = in.readString();
        name = in.readString();
        follower = in.readString();
        following = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readString();
    }

    public static final Creator<GithubUser> CREATOR = new Creator<GithubUser>() {
        @Override
        public GithubUser createFromParcel(Parcel in) {
            return new GithubUser(in);
        }

        @Override
        public GithubUser[] newArray(int size) {
            return new GithubUser[size];
        }
    };

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(avatar);
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(follower);
        dest.writeString(following);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(repository);
    }
}
