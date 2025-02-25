package hu.zsoltkiss.githubsearch.app

import android.app.Application
import android.content.Context

class TheApp : Application() {
    init {
        app = this
    }

    companion object {
        private lateinit var app: TheApp

        fun getAppContext(): Context = app.applicationContext
    }
}