package com.app.jsonexample

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ModelData(var main_title: String, var category: List<Category>) : Parcelable {

    @Parcelize
    data class Category(var sub_title: String, var tags: String) : Parcelable

}









