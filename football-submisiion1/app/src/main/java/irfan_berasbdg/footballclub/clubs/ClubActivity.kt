package irfan_berasbdg.footballclub.clubs

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DefaultItemAnimator
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import irfan_berasbdg.footballclub.R
import irfan_berasbdg.footballclub.clubdetail.ClubDetailActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

class ClubActivity : AppCompatActivity() {

    private var clubs: MutableList<Club> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupClubs()
        ClubActivityUI(clubs, this).setContentView(this)
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
