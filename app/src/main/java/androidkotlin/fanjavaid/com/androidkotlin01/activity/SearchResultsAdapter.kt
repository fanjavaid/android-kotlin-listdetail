package androidkotlin.fanjavaid.com.androidkotlin01.activity

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidkotlin.fanjavaid.com.androidkotlin01.R
import org.jetbrains.annotations.NotNull

/**
 * Created by fanjavaid on 10/20/17.
 */
class SearchResultsAdapter(var results: List<SearchResult>?, @NotNull var listener: OnResultItemClickListener) : RecyclerView.Adapter<SearchResultsAdapter.SearchResultsViewHolder>() {

    override fun getItemCount(): Int {
        // Jika results == null return 0
        // Jika results != null return results.size
        return results?.size ?: 0
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): SearchResultsViewHolder {
        val itemLayout = R.layout.item_result
        val inflater: LayoutInflater = LayoutInflater.from(parent?.context)
        val view = inflater.inflate(itemLayout, parent, false)

        return SearchResultsViewHolder(view)
    }

    override fun onBindViewHolder(holder: SearchResultsViewHolder?, position: Int) {
        val result = results?.get(position)

        holder?.title?.text = result?.title
        holder?.description?.text = result?.description
    }

    inner class SearchResultsViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView), View.OnClickListener {
        val title = itemView?.findViewById<TextView>(R.id.text_item_title)
        val description = itemView?.findViewById<TextView>(R.id.text_item_desc)

        init {
            itemView?.setOnClickListener(this)
        }

        override fun onClick(p0: View?) {
            val index = adapterPosition
            listener.onClickResult(index)
        }
    }

    interface OnResultItemClickListener {
        public fun onClickResult(index: Int)
    }
}