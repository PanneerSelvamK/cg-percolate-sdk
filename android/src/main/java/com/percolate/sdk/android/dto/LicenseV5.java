package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.percolate.sdk.dto.UserRolesLicenseData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Android version of {@link com.percolate.sdk.dto.LicenseV5}.  Implements {@link Parcelable}
 */
public class LicenseV5 extends com.percolate.sdk.dto.LicenseV5 implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.id);
        dest.writeString(this.name);
        dest.writeString(this.timezone);
        dest.writeString(this.avatarId);
        dest.writeString(this.parentId);
        dest.writeString(this.status);
        dest.writeString(this.updatedAt);
        dest.writeList(this.userRolesLicenseData);
        dest.writeMap(this.extraFields);
    }

    public LicenseV5() {
    }

    protected LicenseV5(Parcel in) {
        this.id = in.readString();
        this.name = in.readString();
        this.timezone = in.readString();
        this.avatarId = in.readString();
        this.parentId = in.readString();
        this.status = in.readString();
        this.updatedAt = in.readString();
        this.userRolesLicenseData = new ArrayList<UserRolesLicenseData>();
        in.readList(this.userRolesLicenseData, List.class.getClassLoader());
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<com.percolate.sdk.android.dto.LicenseV5> CREATOR = new Creator<com.percolate.sdk.android.dto.LicenseV5>() {
        public com.percolate.sdk.android.dto.LicenseV5 createFromParcel(Parcel source) {
            return new com.percolate.sdk.android.dto.LicenseV5(source);
        }

        public com.percolate.sdk.android.dto.LicenseV5[] newArray(int size) {
            return new com.percolate.sdk.android.dto.LicenseV5[size];
        }
    };
}
