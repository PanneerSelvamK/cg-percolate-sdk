package com.percolate.sdk.android.dto;

import android.os.Parcel;
import android.os.Parcelable;
import com.percolate.sdk.dto.LicenseV3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Android version of {@link com.percolate.sdk.dto.LicensesV3}.  Implements {@link Parcelable}
 */
public class LicensesV3 extends com.percolate.sdk.dto.LicensesV3 implements Parcelable {
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeSerializable(this.paginationData);
        dest.writeList(this.licenses);
        dest.writeMap(this.extraFields);
    }

    public LicensesV3() {
    }

    protected LicensesV3(Parcel in) {
        this.paginationData = (com.percolate.sdk.dto.PaginationData) in.readSerializable();
        this.licenses = new ArrayList<LicenseV3>();
        in.readList(this.licenses, List.class.getClassLoader());
        this.extraFields = new HashMap<>();
        in.readMap(this.extraFields, HashMap.class.getClassLoader());
    }

    public static final Creator<com.percolate.sdk.android.dto.LicensesV3> CREATOR = new Creator<com.percolate.sdk.android.dto.LicensesV3>() {
        public com.percolate.sdk.android.dto.LicensesV3 createFromParcel(Parcel source) {
            return new com.percolate.sdk.android.dto.LicensesV3(source);
        }

        public com.percolate.sdk.android.dto.LicensesV3[] newArray(int size) {
            return new com.percolate.sdk.android.dto.LicensesV3[size];
        }
    };
}
