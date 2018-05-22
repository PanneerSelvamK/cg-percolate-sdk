package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.percolate.sdk.dto.UserRolesLicenseData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Android version of {@link com.percolate.sdk.dto.LicenseV3}.  Implements {@link Parcelable}
 */
public class LicenseV3 extends com.percolate.sdk.dto.LicenseV3 implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.UID);
        dest.writeString(this.name);
        dest.writeString(this.timezone);
        dest.writeString(this.viralityThreshold);
        dest.writeString(this.photoUrl);
        dest.writeString(this.targeting);
        dest.writeSerializable(this.brand);
        dest.writeValue(this.brandId);
        dest.writeString(this.state);
        dest.writeString(this.type);
        dest.writeList(this.userRolesLicenseData);
        dest.writeMap(this.extraFields);
    }

    public LicenseV3() {
    }

    protected LicenseV3(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.UID = in.readString();
        this.name = in.readString();
        this.timezone = in.readString();
        this.viralityThreshold = in.readString();
        this.photoUrl = in.readString();
        this.targeting = in.readString();
        this.brand = (com.percolate.sdk.dto.Brand) in.readSerializable();
        this.brandId = (Long) in.readValue(Long.class.getClassLoader());
        this.state = in.readString();
        this.type = in.readString();
        this.userRolesLicenseData = new ArrayList<UserRolesLicenseData>();
        in.readList(this.userRolesLicenseData, List.class.getClassLoader());
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<com.percolate.sdk.android.dto.LicenseV3> CREATOR = new Creator<com.percolate.sdk.android.dto.LicenseV3>() {
        public com.percolate.sdk.android.dto.LicenseV3 createFromParcel(Parcel source) {
            return new com.percolate.sdk.android.dto.LicenseV3(source);
        }

        public com.percolate.sdk.android.dto.LicenseV3[] newArray(int size) {
            return new com.percolate.sdk.android.dto.LicenseV3[size];
        }
    };
}
