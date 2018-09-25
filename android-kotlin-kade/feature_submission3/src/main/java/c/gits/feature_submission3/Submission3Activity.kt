package c.gits.feature_submission3

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class Submission3Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_submission3)
    }

    companion object {
        fun openSubmission3(context: Context) {
            context.startActivity(Intent(context, Submission3Activity::class.java)
                    .setFlags(Intent.FLAG_ACTIVITY_NEW_TASK))
        }
    }
}
