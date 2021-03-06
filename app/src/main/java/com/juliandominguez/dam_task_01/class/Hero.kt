package com.juliandominguez.dam_task_01.`class`

import android.graphics.Bitmap
import android.os.Parcel
import android.os.Parcelable

data class Hero(val nameHero: String, val ratingPower: Float, val photo: Bitmap) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readFloat(),
        parcel.readParcelable(Bitmap::class.java.classLoader)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(nameHero)
        parcel.writeFloat(ratingPower)
        parcel.writeParcelable(photo, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Hero> {
        override fun createFromParcel(parcel: Parcel): Hero {
            return Hero(parcel)
        }

        override fun newArray(size: Int): Array<Hero?> {
            return arrayOfNulls(size)
        }
    }


}