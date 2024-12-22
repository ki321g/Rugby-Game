package ie.setu.rugbygame.main

import android.app.Application
import timber.log.Timber

class RugbyGameApp  : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("Starting RugbyGame Application")
    }
}