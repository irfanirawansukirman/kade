package id.co.gits.feature_submission1.clubs

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.view.Menu
import android.view.MenuItem
import android.widget.LinearLayout
import c.gits.feature_submission2.ClubProvider
import c.gits.mydriver.BaseActivity
import id.co.gits.feature_submission1.R
import id.co.gits.feature_submission1.clubdetail.ClubDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ClubActivity : BaseActivity() {

    private var clubs: MutableList<Club> = mutableListOf()

    lateinit var context: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupClubs()
        ClubActivityUI(clubs, this).setContentView(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.action_open_subs2 -> (application as ClubProvider).provideClubNavigator().openSubmission2()
            R.id.action_open_subs3 -> ""
            else -> ""
        }
        return false
    }

    class ClubActivityUI(private val clubs: List<Club>,
                         private val appContext: AppCompatActivity) : AnkoComponent<ClubActivity>,
            AnkoLogger, (Club) -> Unit {

        override fun invoke(club: Club) {
            appContext.toast(club.name ?: appContext.resources.getString(R.string.app_name))
            appContext.startActivity(appContext.intentFor<ClubDetailActivity>(
                    "name" to club.name,
                    "image" to club.image
            ))
        }

        override fun createView(ui: AnkoContext<ClubActivity>) = with(ui) {
            verticalLayout {
                orientation = LinearLayout.VERTICAL
                recyclerView {
                    layoutManager = LinearLayoutManager(context)
                    setHasFixedSize(true)
                    itemAnimator = DefaultItemAnimator()
                    adapter = ClubAdapter(clubs, this@ClubActivityUI)
                }.lparams(width = matchParent, height = matchParent)
            }
        }
    }

    private fun setupClubs() {
        val clubNames = resources.getStringArray(R.array.club_name)
        val clubLogos = resources.obtainTypedArray(R.array.club_image)

        clubs.apply {
            clear()
            for (i in clubNames.indices) {
                add(Club(clubNames[i], clubLogos.getResourceId(i, 0)))
            }
        }

        //Recycle the typed array
        clubLogos.recycle()
    }
}
