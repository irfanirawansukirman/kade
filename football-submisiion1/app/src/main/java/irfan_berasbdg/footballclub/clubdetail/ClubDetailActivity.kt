package irfan_berasbdg.footballclub.clubdetail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import irfan_berasbdg.footballclub.GlideApp
import org.jetbrains.anko.*

/**
 * Dibuat oleh Irfan Irawan Sukirman
 * @Copyright 2018
 */
class ClubDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ClubDetailActivityUI(this).setContentView(this)
    }

    class ClubDetailActivityUI(private val appContext: AppCompatActivity) : AnkoComponent<ClubDetailActivity> {
        override fun createView(ui: AnkoContext<ClubDetailActivity>) = with(ui) {
            verticalLayout {
                gravity = Gravity.CENTER_HORIZONTAL
                GlideApp.with(this.context)
                        .load(appContext.intent.getIntExtra("image", 0))
                        .into(imageView {
                            adjustViewBounds = true
                        }.lparams(width = dip(48), height = dip(48)) {
                            topMargin = dip(16)

                        })

                textView(appContext.intent.getStringExtra("name")) {
                    textSize = sp(8).toFloat()
                }.lparams(width = matchParent, height = wrapContent) {
                    leftMargin = dip(16)
                    rightMargin = dip(16)
                    topMargin = dip(16)
                }
            }
        }
    }

}