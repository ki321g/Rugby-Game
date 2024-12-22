package ie.setu.rugbygame.main

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class RugbyGameApp  : Application() {
    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
        Timber.i("Starting RugbyGame Application")
    }
}