package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.HashMap;

/**
 * Android version of {@link com.percolate.sdk.dto.Tenant}.  Implements {@link Parcelable}
 */
public class Tenant extends com.percolate.sdk.dto.Tenant implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.updatedAt);
        dest.writeMap(this.extraFields);
    }

    public Tenant() {
    }

    protected Tenant(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.updatedAt = in.readString();
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<Tenant> CREATOR = new Creator<Tenant>() {
        public Tenant createFromParcel(Parcel source) {
            return new Tenant(source);
        }

        public Tenant[] newArray(int size) {
            return new Tenant[size];
        }
    };
}

