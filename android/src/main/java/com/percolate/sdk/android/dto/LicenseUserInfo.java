package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.percolate.sdk.dto.LicenseV3;

import java.util.HashMap;

/**
 * Android version of {@link com.percolate.sdk.dto.LicenseUserInfo}.  Implements {@link Parcelable}
 */
public class LicenseUserInfo extends com.percolate.sdk.dto.LicenseUserInfo implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeValue(this.userId);
        dest.writeValue(this.roleId);
        dest.writeByte(approver ? (byte) 1 : (byte) 0);
        dest.writeValue(this.licenseId);
        dest.writeSerializable(this.user);
        dest.writeSerializable(this.license);
        dest.writeMap(this.extraFields);
    }

    public LicenseUserInfo() {
    }

    protected LicenseUserInfo(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.userId = (Long) in.readValue(Long.class.getClassLoader());
        this.roleId = (Long) in.readValue(Long.class.getClassLoader());
        this.approver = in.readByte() != 0;
        this.licenseId = (Long) in.readValue(Long.class.getClassLoader());
        this.user = (com.percolate.sdk.dto.User) in.readSerializable();
        this.license = (LicenseV3) in.readSerializable();
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<LicenseUserInfo> CREATOR = new Creator<LicenseUserInfo>() {
        public LicenseUserInfo createFromParcel(Parcel source) {
            return new LicenseUserInfo(source);
        }

        public LicenseUserInfo[] newArray(int size) {
            return new LicenseUserInfo[size];
        }
    };
}
