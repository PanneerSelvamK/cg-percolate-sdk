package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import com.percolate.sdk.dto.LicenseV3;

import java.util.HashMap;

/**
 * Android version of {@link com.percolate.sdk.dto.Topic}.  Implements {@link Parcelable}
 */
public class Topic extends com.percolate.sdk.dto.Topic implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(this.id);
        dest.writeValue(this.parentId);
        dest.writeString(this.name);
        dest.writeString(this.color);
        dest.writeString(this.ownerUid);
        dest.writeSerializable(this.owner);
        dest.writeMap(this.extraFields);
    }

    public Topic() {
    }

    protected Topic(Parcel in) {
        this.id = (Long) in.readValue(Long.class.getClassLoader());
        this.parentId = (Long) in.readValue(Long.class.getClassLoader());
        this.name = in.readString();
        this.color = in.readString();
        this.ownerUid = in.readString();
        this.owner = (LicenseV3) in.readSerializable();
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<Topic> CREATOR = new Creator<Topic>() {
        public Topic createFromParcel(Parcel source) {
            return new Topic(source);
        }

        public Topic[] newArray(int size) {
            return new Topic[size];
        }
    };
}
