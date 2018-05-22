package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Android version of {@link com.percolate.sdk.dto.LicensesV5}.  Implements {@link Parcelable}
 */
public class LicensesV5 extends com.percolate.sdk.dto.LicensesV5 implements Parcelable {

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.meta);
        dest.writeList(this.licenses);
        dest.writeMap(this.extraFields);
    }

    public LicensesV5() {
    }

    protected LicensesV5(Parcel in) {
        this.meta = (com.percolate.sdk.dto.V5Meta) in.readSerializable();
        this.licenses = new ArrayList<>();
        in.readList(this.licenses, List.class.getClassLoader());
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<com.percolate.sdk.android.dto.LicensesV5> CREATOR = new Creator<com.percolate.sdk.android.dto.LicensesV5>() {
        public com.percolate.sdk.android.dto.LicensesV5 createFromParcel(Parcel source) {
            return new com.percolate.sdk.android.dto.LicensesV5(source);
        }

        public com.percolate.sdk.android.dto.LicensesV5[] newArray(int size) {
            return new com.percolate.sdk.android.dto.LicensesV5[size];
        }
    };
}

