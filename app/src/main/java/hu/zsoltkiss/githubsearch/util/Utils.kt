package hu.zsoltkiss.githubsearch.util

import android.util.Log
import hu.zsoltkiss.githubsearch.BuildConfig

fun debugPrint(message: String, module: String? = null, id: Int? = null) {
    if (BuildConfig.DEBUG) {
        val msg = id?.let { "$id $message" } ?: message

        Log.d(module, msg)
    }
}