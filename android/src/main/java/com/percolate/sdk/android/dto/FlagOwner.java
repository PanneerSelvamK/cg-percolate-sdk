package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.percolate.sdk.dto.LicenseV3;

import java.util.HashMap;

/**
 * Android version of {@link com.percolate.sdk.dto.FlagOwner}.  Implements {@link Parcelable}
 */
public class FlagOwner extends com.percolate.sdk.dto.FlagOwner implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.type);
        dest.writeSerializable(this.license);
        dest.writeMap(this.extraFields);
    }

    public FlagOwner() {
    }

    protected FlagOwner(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.type = in.readString();
        this.license = (LicenseV3) in.readSerializable();
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<FlagOwner> CREATOR = new Creator<FlagOwner>() {
        public FlagOwner createFromParcel(Parcel source) {
            return new FlagOwner(source);
        }

        public FlagOwner[] newArray(int size) {
            return new FlagOwner[size];
        }
    };
}
