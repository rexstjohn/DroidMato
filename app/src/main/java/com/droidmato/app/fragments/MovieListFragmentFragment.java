package com.droidmato.app.fragments;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.TextView;
import com.droidmato.app.R;

import com.droidmato.app.adapters.PhotoAdapter;
import com.droidmato.app.adapters.items.MovieListItem;
import com.droidmato.app.models.MovieContainerModel;
import com.droidmato.app.models.MovieModel;
import com.droidmato.app.queries.GetMoviesQueryModel;
import com.droidmato.app.tasks.GetMoviesAsyncTask;
import com.droidmato.app.views.TwoWayView;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * A fragment representing a list of Items.
 * <p />
 * Large screen devices (such as tablets) are supported by replacing the ListView
 * with a GridView.
 * <p />
 * Activities containing this fragment MUST implement the {@link Callbacks}
 * interface.
 */
public class MovieListFragmentFragment extends Fragment implements AbsListView.OnItemClickListener, GetMoviesAsyncTask.GetMoviesAsyncTaskResponse {

    // Section
    private static final String ARG_SECTION_NUMBER = "section_number";

    // Ivars.
    private AbsListView mListView;
    private PhotoAdapter mAdapter;
    private TwoWayView mHorizontalListView;
    private ArrayList<MovieListItem> mPhotoListItem;
    private TextView mEmptyTextView;
    private ProgressDialog mLoadingProgressDialog;

    public MovieListFragmentFragment(){
        super();
    }

    /**
     * Static factory method
     * @param sectionNumber
     * @return
     */
    public static MovieListFragmentFragment newInstance(int sectionNumber) {
        MovieListFragmentFragment fragment = new MovieListFragmentFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_SECTION_NUMBER, sectionNumber);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Create an empty loader and pre-initialize the photo list items as an empty list.
        Context context = getActivity().getBaseContext();

        // Set up empty mAdapter
        mPhotoListItem = new ArrayList<MovieListItem>() ;
        mAdapter = new PhotoAdapter(context,
                R.layout.photo_item,
                mPhotoListItem, false);

        // Load movies.
        GetMoviesQueryModel moviesQueryModel = new GetMoviesQueryModel();
        moviesQueryModel.setCountry("us");
        moviesQueryModel.setPage_limit(12);
        moviesQueryModel.setPage(1);
        GetMoviesAsyncTask task = new GetMoviesAsyncTask();
        task.delegate = this;
        task.execute(moviesQueryModel);
        mLoadingProgressDialog = new ProgressDialog(getActivity());
        mLoadingProgressDialog.show();
    }

    /**
     * Create View!
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View view = null;
        view = inflater.inflate(R.layout.fragment_horizontal_gallery, container, false);

        // Set the mAdapter
        mEmptyTextView = (TextView)view.findViewById(R.id.empty);
        mHorizontalListView = (TwoWayView)  view.findViewById(R.id.horizontalList);
        mHorizontalListView.setAdapter(mAdapter);
        mHorizontalListView.setItemMargin(10);

        resolveEmptyText();

        return view;
    }

    /**
     * Used to show a generic empty text warning. Override in inheriting classes.
     */
    protected void resolveEmptyText(){
        if(mAdapter.isEmpty()){
            mEmptyTextView.setVisibility(View.VISIBLE);
            setEmptyText();
        } else {
            mEmptyTextView.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * The default content for this Fragment has a TextView that is shown when
     * the list is empty. If you would like to change the text, call this method
     * to supply the text it should use.
     */
    public void setEmptyText() {
        mEmptyTextView.setText("No Photos!");
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        //
    }

    @Override
    public void onRegisterDeviceAsyncTaskCompletion(MovieContainerModel result) {
        mPhotoListItem.clear();

        Iterator<MovieModel> iterator = result.getMovies().iterator();
        while(iterator.hasNext()) {
            MovieModel movie = iterator.next();
            MovieListItem item = new MovieListItem(movie);
            mPhotoListItem.add(item);
        }

        mAdapter.notifyDataSetChanged();
        cancelProgressDialog();
    }

    @Override
    public void onRegisterDeviceAsyncTaskFailure() {
        cancelProgressDialog();
    }

    /**
     * Safe cancel for the progress loader
     */
    private void cancelProgressDialog(){
        if(mLoadingProgressDialog != null){
            if(mLoadingProgressDialog.isShowing()){
                mLoadingProgressDialog.cancel();
            }
        }
    }
}
