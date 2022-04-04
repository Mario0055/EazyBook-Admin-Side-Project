package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.sql.Time;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static ArrayList<ReservationClass> Reservations = new ArrayList<>();
    ListView reservationlist;
    FirebaseFirestore db;
    FirebaseFirestore db1;
    TextView mario;
    ReservationClass Reservation;
    String GuestNumber;
    String Date;
    String Time;
    String SpecialRequest;
    String GuestOrder;
    String GuestName;
    String GuestPhone;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        reservationlist=findViewById(R.id.ReservationListView);
        db1=FirebaseFirestore.getInstance();

        db=FirebaseFirestore.getInstance();
        db.collection("Reservation").get().addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
            @Override
            public void onComplete(@NonNull Task<QuerySnapshot> task) {
                if(task.isSuccessful()){

                        for (QueryDocumentSnapshot document : task.getResult()) {
//                            ReservationClass Reservation = new ReservationClass(document.getString("Date").toString().trim(),
//                                    document.getString("GuestNumber").toString().trim()
//                                    , document.getString("SpecialRequest"), document.getString("Time").toString().trim());
                             GuestNumber=document.getString("GuestNumber");
                             Date=document.getString("Date");
                             Time=String.valueOf(document.getString("GuestBookingTime "));
                             SpecialRequest =document.getString("SpecialRequest");
                             GuestName=document.getString("GuestName");
                             GuestPhone=document.getString("GuestPhoneNumber");
                             GuestOrder=document.getString("Order");
                             Reservation =new ReservationClass(Date ,GuestNumber ,SpecialRequest ,Time ,GuestOrder ,GuestName ,GuestPhone);
                             Reservations.add(Reservation);
                             ReservationAdapter Adapter =new ReservationAdapter (Reservations, MainActivity.this);
                             Adapter.notifyDataSetChanged();
                             reservationlist.setAdapter(Adapter);


                        }




                }else{
                    Log.w("Oh Shit ----->" ,"Error Getting Documents" +task.getException());
                }

            }
        });


    }
}