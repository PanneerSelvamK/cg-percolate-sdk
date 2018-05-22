package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.percolate.sdk.dto.Channel;
import com.percolate.sdk.dto.EnabledProperty;
import com.percolate.sdk.dto.LicenseV3;
import com.percolate.sdk.dto.TokenStatus;

import java.util.HashMap;

/**
 * Android version of {@link com.percolate.sdk.dto.LicenseChannel}.  Implements {@link Parcelable}
 */
public class LicenseChannel extends com.percolate.sdk.dto.LicenseChannel implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeByte(displayed ? (byte) 1 : (byte) 0);
        dest.writeValue(this.id);
        dest.writeString(this.uid);
        dest.writeValue(this.licenseId);
        dest.writeValue(this.channelId);
        dest.writeValue(this.tokenId);
        dest.writeSerializable(this.publishing);
        dest.writeSerializable(this.ingesting);
        dest.writeSerializable(this.following);
        dest.writeSerializable(this.monitoring);
        dest.writeSerializable(this.inbox);
        dest.writeSerializable(this.token);
        dest.writeSerializable(this.license);
        dest.writeSerializable(this.channel);
        dest.writeString(this.scopedChannelUid);
        dest.writeMap(this.extraFields);
    }

    public LicenseChannel() {
    }

    protected LicenseChannel(Parcel in) {
        this.displayed = in.readByte() != 0;
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.uid = in.readString();
        this.licenseId = (Long) in.readValue(Long.class.getClassLoader());
        this.channelId = (Long) in.readValue(Long.class.getClassLoader());
        this.tokenId = (Long) in.readValue(Long.class.getClassLoader());
        this.publishing = (com.percolate.sdk.dto.Publishing) in.readSerializable();
        this.ingesting = (EnabledProperty) in.readSerializable();
        this.following = (EnabledProperty) in.readSerializable();
        this.monitoring = (EnabledProperty) in.readSerializable();
        this.inbox = (EnabledProperty) in.readSerializable();
        this.token = (TokenStatus) in.readSerializable();
        this.license = (LicenseV3) in.readSerializable();
        this.channel = (Channel) in.readSerializable();
        this.scopedChannelUid = in.readString();
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<LicenseChannel> CREATOR = new Creator<LicenseChannel>() {
        public LicenseChannel createFromParcel(Parcel source) {
            return new LicenseChannel(source);
        }

        public LicenseChannel[] newArray(int size) {
            return new LicenseChannel[size];
        }
    };
}
