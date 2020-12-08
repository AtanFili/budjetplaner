package com.gsixacademy.android.budgetplanner.data

import android.os.Parcel
import android.os.Parcelable
import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
class FeeData():Parcelable {

    var name:String?=null
    var category:String?=null
    var image:String?=null
    var amount:Long?=null


    constructor(parcel: Parcel):this(){
        name=parcel.readString()
        category=parcel.readString()
        image=parcel.readString()
        amount=parcel.readLong()

    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(category)
        amount?.let { parcel.writeLong(it) }

    }

    override fun describeContents(): Int {
        return 0
    }
companion object CREATOR:Parcelable.Creator<FeeData>{
    override fun createFromParcel(parcel: Parcel): FeeData {
        return FeeData(parcel)
    }

    override fun newArray(size: Int): Array<FeeData?> {
        return arrayOfNulls(size)
    }
}
}