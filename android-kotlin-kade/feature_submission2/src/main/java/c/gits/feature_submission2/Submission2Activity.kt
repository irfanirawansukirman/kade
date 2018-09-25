package c.gits.feature_submission2

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Spinner
import c.gits.mydriver.BaseActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

class Submission2Activity : BaseActivity() {
    // Training, sharing n communication

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Submission2UI().setContentView(this)
    }

    class Submission2UI : AnkoComponent<Submission2Activity> {
        private lateinit var listTeam: RecyclerView
        private lateinit var progressBar: ProgressBar
        private lateinit var swipeRefresh: SwipeRefreshLayout
        private lateinit var spinner: Spinner

        override fun createView(ui: AnkoContext<Submission2Activity>) = with(ui) {
            linearLayout {
                lparams(width = matchParent, height = wrapContent)
                orientation = LinearLayout.VERTICAL
                topPadding = dip(16)
                leftPadding = dip(16)
                rightPadding = dip(16)

                spinner = spinner()
                swipeRefresh = swipeRefreshLayout {
                    setColorSchemeResources(android.R.color.holo_blue_bright,
                            android.R.color.holo_green_light,
                            android.R.color.holo_orange_light,
                            android.R.color.holo_red_light)

                    relativeLayout {
                        lparams(width = matchParent, height = wrapContent)

                        listTeam = recyclerView {
                            lparams(width = matchParent, height = wrapContent)
                            layoutManager = LinearLayoutManager(ctx)
                        }

                        progressBar = progressBar {
                        }.lparams {
                            centerHorizontally()
                        }
                    }
                }
            }
        }
    }
}
