package kz.just_code.mvvm.repository

import android.os.Parcelable
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Movie(
    var id:Int,
    @StringRes
    var title:Int,
    @StringRes
    var description:Int,
    @DrawableRes
    var image:Int,

):Parcelable