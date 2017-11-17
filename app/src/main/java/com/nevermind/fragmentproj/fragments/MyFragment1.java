package com.nevermind.fragmentproj.fragments;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nevermind.fragmentproj.R;
import com.nevermind.fragmentproj.adapter.RecyclerAdapter;
import com.nevermind.fragmentproj.model.Place;


import java.util.ArrayList;

public class MyFragment1 extends Fragment {

    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Place> myDataset;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Place place;
        int position;
        myDataset = getDataset();
        if (getArguments()!=null) {
            place = (Place) getArguments().getSerializable("place");
            position = getArguments().getInt("position2", -1);
            myDataset.set(position, place);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_layout_1,container, false);
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        mRecyclerView.setHasFixedSize(true);
        //layout manager
        mLayoutManager = new LinearLayoutManager(view.getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);
        //adapter
        mAdapter = new RecyclerAdapter(myDataset);
        mRecyclerView.setAdapter(mAdapter);


    }


    private ArrayList<Place> getDataset(){
        ArrayList <Place> mDataset = new ArrayList<Place>();


        mDataset.add(0,new Place("Ввавилова, 23", "Доп. офис №9038/01370",12,"0000000000", 0) );
        mDataset.add(1,new Place("Панфилова, 24", "Доп. офис №9138/01354",13,"1111111111", 0) );
        mDataset.add(2,new Place("Левилова, 25", "Доп. офис №9238/01312",14,"2222222222", 0) );
        mDataset.add(3,new Place("Кириллова, 26", "Доп. офис №9338/01373",15,"3333333333", 0) );
        mDataset.add(4,new Place("Певилова, 27", "Доп. офис №9438/02958",16,"4444444444", 0) );
        return mDataset;
    }

}