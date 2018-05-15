package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.percolate.sdk.dto.LicenseV3;

import java.util.HashMap;

/**
 * Android version of {@link com.percolate.sdk.dto.Owner}.  Implements {@link Parcelable}
 */
public class Owner extends com.percolate.sdk.dto.Owner implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.type);
        dest.writeString(this.id);
        dest.writeSerializable(this.license);
        dest.writeMap(this.extraFields);
    }

    public Owner() {
    }

    protected Owner(Parcel in) {
        this.type = in.readString();
        this.id = in.readString();
        this.license = (LicenseV3) in.readSerializable();
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<Owner> CREATOR = new Creator<Owner>() {
        public Owner createFromParcel(Parcel source) {
            return new Owner(source);
        }

        public Owner[] newArray(int size) {
            return new Owner[size];
        }
    };
}
