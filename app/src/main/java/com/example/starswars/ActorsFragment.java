package com.example.starswars;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ActorsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ActorsFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private RecyclerView mRecyclerView;
    private MyAdapterActors myAdapter;
    SharedPreferences mPrefs ;
    private ArrayList<People> mPeople =new ArrayList<>();

    public ActorsFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ActorsFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ActorsFragment newInstance(String param1, String param2) {
        ActorsFragment fragment = new ActorsFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_actors, container, false);
        mRecyclerView = view.findViewById(R.id.recyclerViews2);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));

        NetworkService.getInstance()
                .getJsonApi()
                .getAllPeople(1)
                .enqueue(new Callback<SWModelList<People>>() {
                    @Override
                    public void onResponse(Call<SWModelList<People>> call, Response<SWModelList<People>> response) {
                        if (response.isSuccessful() && response.body()!=null){
                            SWModelList<People> people = response.body();
                            myAdapter=new MyAdapterActors(mPrefs,mPeople);
                            mRecyclerView.setAdapter(myAdapter);

                        }
                        Log.d("TAG2", "onResponse"+ (response.body()));
                    }

                    @Override
                    public void onFailure(Call<SWModelList<People>> call, Throwable throwable) {
                        Log.d("TAG", "Response Failure =" + throwable.toString());
                        // Toast.makeText(CatalogActivity.this,"Упс! Что то пошло не так", Toast.LENGTH_SHORT).show();
                    }
                });
        // Inflate the layout for this fragment
        return view;
    }
}