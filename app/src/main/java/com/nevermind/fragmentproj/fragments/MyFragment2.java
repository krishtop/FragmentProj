package com.nevermind.fragmentproj.fragments;

import android.app.AlertDialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;



import com.nevermind.fragmentproj.R;
import com.nevermind.fragmentproj.model.Place;

public class MyFragment2 extends Fragment  {

    TextView telephoneView;
    TextView addressView;
    TextView infoView;
    TextView distanceView;
    TextView rateView;

    Place place;
    int position;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_layout_2, null);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        if (getArguments()!=null) {
            place = (Place) getArguments().getSerializable("key");
            position = getArguments().getInt("position", -1);
        }
        telephoneView = (TextView) view.findViewById(R.id.telephoneView);
        addressView = (TextView) view.findViewById(R.id.headAddress);
        infoView = (TextView) view.findViewById(R.id.headInfo);
        distanceView = (TextView) view.findViewById(R.id.headDistance);
        rateView = (TextView) view.findViewById(R.id.headRate);

        final Button rateButton = (Button) view.findViewById(R.id.buttonRate);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final AlertDialog.Builder ratingdialog = new AlertDialog.Builder(getActivity());

                final Bundle bundle = new Bundle();
                ratingdialog.setIcon(android.R.drawable.btn_star_big_on);
                ratingdialog.setTitle("Оцените отделение");

                View linearlayout = getActivity().getLayoutInflater().inflate(R.layout.rate_dialog, null);
                ratingdialog.setView(linearlayout);

                final RatingBar rating = (RatingBar)linearlayout.findViewById(R.id.ratingbar);

                ratingdialog.setPositiveButton("Готово",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                rateView.setText("Оценка отделения: "+String.valueOf(rating.getRating()));
                                place.setRate((int) Math.round(rating.getRating()));
                                bundle.putSerializable("place",place);
                                bundle.putInt("position2", position);

                                dialog.dismiss();
                            }
                        })

                        .setNegativeButton("Отмена",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int id) {
                                        dialog.cancel();
                                    }
                                });

                ratingdialog.create();
                ratingdialog.show();


            }
        });


        addressView.setText(place.getAddress());
        infoView.setText(place.getInfo());
        telephoneView.setText(place.getTelephone());
        distanceView.setText(Long.toString(place.getDistance())+" км");
        rateView.setText("Оценка отделения: "+Integer.toString(place.getRate()));
    }


}