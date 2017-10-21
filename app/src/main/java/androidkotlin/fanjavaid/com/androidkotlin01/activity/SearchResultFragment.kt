package androidkotlin.fanjavaid.com.androidkotlin01.activity

//import android.widget.Toast

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidkotlin.fanjavaid.com.androidkotlin01.R

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [SearchResultFragment.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [SearchResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchResultFragment : Fragment(), SearchResultsAdapter.OnResultItemClickListener {
    var onViewDetailListener: OnClickViewResultDetail? = null

    override fun onClickResult(index: Int) {
//        Toast.makeText(activity, "$index", Toast.LENGTH_SHORT).show()

        onViewDetailListener?.onViewDetail(
                getDummySearchResults().get(index).thumbnail,
                getDummySearchResults().get(index).title,
                getDummySearchResults().get(index).description
        )
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)

        onViewDetailListener = if (context is OnClickViewResultDetail) {
            context
        } else throw ClassCastException("must implement onClickViewResultDetail interface")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        // Inflate the layout for this fragment
        return inflater?.inflate(R.layout.fragment_search_result, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val results = getDummySearchResults()

        val recyclerViewResult = view?.findViewById<RecyclerView>(R.id.recyclerview_results)
        val resultAdapter = SearchResultsAdapter(results, this)
        recyclerViewResult?.adapter = resultAdapter
        recyclerViewResult?.setHasFixedSize(true)
        recyclerViewResult?.layoutManager = LinearLayoutManager(activity)
    }

    fun getDummySearchResults(): List<SearchResult> {
        val searchResults: List<SearchResult> = listOf(
                SearchResult("https://www.bbcgoodfood.com/sites/default/files/editor_files/" +
                        "2016/07/instagram-symmetry-breakfast-300.jpg","Connect to a device over Wi-Fi",
                        "adb usually communicates with the device over USB, but you can also use adb over Wi-Fi"),

                SearchResult("https://demo.themegrill.com/flash-food/wp-content/uploads/sites/89/2016/10/blog-3-300x300.jpg","Query for devices",
                        "Before issuing adb commands, it is " +
                        "helpful to know what device instances are connected to the adb server")
        )

        return searchResults
    }

    companion object {

        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @return A new instance of fragment SearchResultFragment.
         */
        fun newInstance(param1: String, param2: String): SearchResultFragment {
            val fragment = SearchResultFragment()
            val args = Bundle()
            fragment.arguments = args
            return fragment
        }
    }

    interface OnClickViewResultDetail {
        public fun onViewDetail(thumbnail: String?, title: String?, description: String?)
    }
}// Required empty public constructor
