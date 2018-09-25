package irfan_berasbdg.footballclub

import android.app.Application
import c.gits.feature_submission2.ClubNavigator
import c.gits.feature_submission2.ClubProvider
import c.gits.feature_submission3.Submission3Activity

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class MyApps : Application(), ClubProvider {

    override fun provideClubNavigator(): ClubNavigator {
        return object : ClubNavigator {
            override fun openSubmission2() {
                Submission3Activity.openSubmission3(this@MyApps)
            }
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

}