package com.example.arouterapplication.bean;

import android.os.Parcel;
import android.os.Parcelable;

public class ARouterBean implements Parcelable {
    private String name;

    @Override
    public String toString() {
        return "ARouterBean{" +
                "name='" + name + '\'' +
                '}';
    }

    public ARouterBean(String name) {
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
    }

    public ARouterBean() {
    }

    protected ARouterBean(Parcel in) {
        this.name = in.readString();
    }

    public static final Creator<ARouterBean> CREATOR = new Creator<ARouterBean>() {
        @Override
        public ARouterBean createFromParcel(Parcel source) {
            return new ARouterBean(source);
        }

        @Override
        public ARouterBean[] newArray(int size) {
            return new ARouterBean[size];
        }
    };
}
