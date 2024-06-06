package com.example.listpariwisata

import android.os.Parcel
import android.os.Parcelable

data class WisataModel (
    val wisataName : String,
    val wisataImage : Int,
    val detailedActivity: String
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readInt(),
        parcel.readString()!!
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(wisataName)
        parcel.writeInt(wisataImage)
        parcel.writeString(detailedActivity)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<WisataModel> {
        override fun createFromParcel(parcel: Parcel): WisataModel {
            return WisataModel(parcel)
        }

        override fun newArray(size: Int): Array<WisataModel?> {
            return arrayOfNulls(size)
        }
    }
}