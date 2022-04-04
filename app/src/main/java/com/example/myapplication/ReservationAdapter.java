package com.example.myapplication;

import android.content.Context;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ReservationAdapter extends BaseAdapter {
    ArrayList<ReservationClass> Reservations = new ArrayList<>();
    private Context context;
    TextView time;


    public ReservationAdapter(ArrayList<ReservationClass> reservations, Context context) {
        Reservations = reservations;
        this.context = context;
    }

    public int getCount() {
        return Reservations.size();
    }

    @Override
    public Object getItem(int position) {
        return Reservations.get(position);
    }


    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.reservation, parent, false);

        }
        ReservationClass currentReservation = (ReservationClass) getItem(position);

        TextView SpecialRequest =
                convertView.findViewById(R.id.SpecialRequestReservation);
        TextView Date =
                convertView.findViewById(R.id.DateReservation);
        TextView Time =
                convertView.findViewById(R.id.TimeReservation);
        TextView GuestNumber =
                convertView.findViewById(R.id.GuestNumberReservation);
        TextView GuestOrder =convertView.findViewById(R.id.GuestOrder);
        TextView GuestName =convertView.findViewById(R.id.GuestName);
        TextView GuestPhone=convertView.findViewById(R.id.GuestPhoneNumber);
        GuestOrder.setMovementMethod(new ScrollingMovementMethod());


        GuestName.setText(currentReservation.getGuestName());
        GuestPhone.setText(currentReservation.getGuestPhoneNumber());
        GuestOrder.setText(currentReservation.getOrder());
        GuestNumber.setText(currentReservation.getGuestNumber());
        Date.setText(currentReservation.getDate());
        Time.setText(currentReservation.getTime());
        SpecialRequest.setText(currentReservation.getSpecialRequest());


        return convertView;


    }
}
