package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Android version of {@link com.percolate.sdk.dto.Tenants}.  Implements {@link Parcelable}
 */
public class Tenants extends com.percolate.sdk.dto.Tenants implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.meta);
        dest.writeList(this.data);
        dest.writeList(this.errors);
        dest.writeMap(this.extraFields);
    }

    public Tenants() {
    }

    protected Tenants(Parcel in) {
        this.meta = (com.percolate.sdk.dto.V5Meta) in.readSerializable();
        this.data = new ArrayList<>();
        in.readList(this.data, List.class.getClassLoader());
        this.errors = new ArrayList<>();
        in.readList(this.errors, List.class.getClassLoader());
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<Tenants> CREATOR = new Creator<Tenants>() {
        public Tenants createFromParcel(Parcel source) {
            return new Tenants(source);
        }

        public Tenants[] newArray(int size) {
            return new Tenants[size];
        }
    };
}

