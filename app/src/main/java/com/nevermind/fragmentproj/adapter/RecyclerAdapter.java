package com.nevermind.fragmentproj.adapter;

/**
 * Created by Dmitry on 06.11.2017.
 */

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.nevermind.fragmentproj.activity.MainActivity;
import com.nevermind.fragmentproj.fragments.MyFragment1;
import com.nevermind.fragmentproj.fragments.MyFragment2;
import com.nevermind.fragmentproj.model.Place;
import com.nevermind.fragmentproj.R;

import java.util.ArrayList;

import static com.nevermind.fragmentproj.R.id.view;

/**
 * Created by Dmitry on 22.10.2017.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private ArrayList<Place> mDataset;
    private FragmentTransaction fTrans;
    private Context context;

    // класс view holder-а с помощью которого мы получаем ссылку на каждый элемент
    // отдельного пункта списка
    public static class ViewHolder extends RecyclerView.ViewHolder {
        // items
        public ImageView imageView;
        public TextView addressView;
        public TextView infoView;
        public TextView distanceView;
        public TextView rateView;



        public ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.imageView);
            addressView = (TextView) view.findViewById(R.id.addressView);
            infoView = (TextView) view.findViewById(R.id.infoView);
            distanceView = (TextView) view.findViewById(R.id.distanceView);
            rateView = (TextView) view.findViewById(R.id.rateV);
        }

    }

    // Конструктор
    public RecyclerAdapter(ArrayList<Place> dataset) {
        mDataset = new ArrayList<Place>(dataset);

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycler_item, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }



    // Заменяет контент отдельного view (вызывается layout manager-ом)
    @Override
    public void onBindViewHolder(final ViewHolder holder,final int position) {

        final Place place = mDataset.get(position);
        final  int CHOOSE_THIEF = 0;

        holder.addressView.setText(mDataset.get(position).getAddress());
        holder.infoView.setText(mDataset.get(position).getInfo());
        holder.distanceView.setText(Long.toString(mDataset.get(position).getDistance())+" км");
        holder.rateView.setText("Оценка отделения: "+Integer.toString(mDataset.get(position).getRate()));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                MyFragment2 fragment2= new MyFragment2();
                Bundle bundle = new Bundle();
                bundle.putSerializable("key", place);
                bundle.putInt("position", position);
                fragment2.setArguments(bundle);

                Activity activity = (Activity) v.getContext();

                //Create a bundle to pass data, add data, set the bundle to your fragment and:


                activity.getFragmentManager().beginTransaction()
                        .replace(R.id.frgmContainer, fragment2)
                        .addToBackStack(null)
                        .commit();









            }
        });
    }



    // Возвращает размер данных (вызывается layout manager-ом)
    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
