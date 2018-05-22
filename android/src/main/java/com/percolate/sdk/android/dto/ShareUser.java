package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.percolate.sdk.dto.LicenseV3;

import java.util.HashMap;

/**
 * Android version of {@link com.percolate.sdk.dto.ShareUser}.  Implements {@link Parcelable}
 */
public class ShareUser extends com.percolate.sdk.dto.ShareUser implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeString(this.UID);
        dest.writeSerializable(this.license);
        dest.writeString(this.type);
        dest.writeMap(this.extraFields);
    }

    public ShareUser() {
    }

    protected ShareUser(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.UID = in.readString();
        this.license = (LicenseV3) in.readSerializable();
        this.type = in.readString();
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<ShareUser> CREATOR = new Creator<ShareUser>() {
        public ShareUser createFromParcel(Parcel source) {
            return new ShareUser(source);
        }

        public ShareUser[] newArray(int size) {
            return new ShareUser[size];
        }
    };
}
