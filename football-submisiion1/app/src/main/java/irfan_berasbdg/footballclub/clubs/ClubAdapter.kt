package irfan_berasbdg.footballclub.clubs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import irfan_berasbdg.footballclub.GlideApp
import irfan_berasbdg.footballclub.R
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.club_item.*

class ClubAdapter(private var data: List<Club>,
                  private var clubListener: (Club) -> Unit) :
        RecyclerView.Adapter<ClubAdapter.ClubItemHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ClubItemHolder(
            LayoutInflater.from(parent.context)
                    .inflate(R.layout.club_item, parent, false)
    )

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: ClubItemHolder, position: Int) {
        holder.bindItem(data[position], clubListener)
    }

    class ClubItemHolder(override val containerView: View) : RecyclerView.ViewHolder(containerView),
            LayoutContainer {

        fun bindItem(item: Club, clubListener: (Club) -> Unit) {
            GlideApp.with(containerView.context)
                    .load(item.image)
                    .transition(DrawableTransitionOptions.withCrossFade(300))
                    .into(img_club_logo)

            txt_club_name.text = item.name
            containerView.setOnClickListener {
                clubListener(item)
            }
        }
    }
}