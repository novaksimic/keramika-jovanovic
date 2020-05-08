package com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri_activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.GridView;
import android.widget.TextView;

import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_centar_novi_sad;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_centar_ogrev;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_center_kragujevac;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_salon_beograd;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_salon_kikinda;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_salon_sabac;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_salon_sombor;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_salon_subotica;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_salon_temerin;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri.Prodajni_salon_zajecar;
import com.example.strucnapraksa.keramikajovanovic.Prodajni_centar.prodajni_centri_adapter.GridAdapter;
import com.example.strucnapraksa.keramikajovanovic.R;


public class ProdajniSaloniActivity extends AppCompatActivity {

    GridView grid;
    RecyclerView recyclerView;
    GridLayoutManager layoutManager;

    public static String[] saloniNameList = {
            "Продајни центар Београд",
            "Продајни центар Крагујевац",
            "Продајни центар Нови сад",
            "Продајни салон Суботица",
            "Продајни салон Шабац",
            "Продајни салон Кикинда",
            "Продајни салон Темерин",
            "Продајни салон Зајечар",
            "Продајни центар Огрев",
            "Продајни салон Сомбор",
    };
    public static int[] saloniImages = {
            R.mipmap.beograd,
            R.mipmap.kragujevac,
            R.mipmap.novi_sad,
            R.mipmap.subotica,
            R.mipmap.sabac,
            R.mipmap.kikinda,
            R.mipmap.temerin,
            R.mipmap.zajecar,
            R.mipmap.ogrev,
            R.mipmap.sombor };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.prodajni_saloni);

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);


        GridAdapter gridAdapter = new GridAdapter(ProdajniSaloniActivity.this, saloniNameList, saloniImages);

        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(gridAdapter);

        if(ProdajniSaloniActivity.this.getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 2));
        }
        else{
            recyclerView.setLayoutManager(new GridLayoutManager(getApplicationContext(), 4));
        }


        recyclerView.addOnItemTouchListener(new GridAdapter.RecyclerTouchListener(getApplicationContext(), recyclerView, new GridAdapter.ClickListener() {


            @Override
            public void onClick(View view, int position) {
                switch (position) {
                    case 0:
                        Intent newActivity = new Intent(ProdajniSaloniActivity.this, Prodajni_salon_beograd.class);
                        startActivity(newActivity);
                        break;
                    case 1:
                        Intent newActivity1 = new Intent(ProdajniSaloniActivity.this, Prodajni_center_kragujevac.class);
                        startActivity(newActivity1);
                        break;
                    case 2:
                        Intent newActivity2 = new Intent(ProdajniSaloniActivity.this, Prodajni_centar_novi_sad.class);
                        startActivity(newActivity2);
                        break;
                    case 3:
                        Intent newActivity3 = new Intent(ProdajniSaloniActivity.this, Prodajni_salon_subotica.class);
                        startActivity(newActivity3);
                        break;
                    case 4:
                        Intent newActivity4 = new Intent(ProdajniSaloniActivity.this, Prodajni_salon_sabac.class);
                        startActivity(newActivity4);
                        break;
                    case 5:
                        Intent newActivity5 = new Intent(ProdajniSaloniActivity.this, Prodajni_salon_kikinda.class);
                        startActivity(newActivity5);
                        break;
                    case 6:
                        Intent newActivity6 = new Intent(ProdajniSaloniActivity.this, Prodajni_salon_temerin.class);
                        startActivity(newActivity6);
                        break;
                    case 7:
                        Intent newActivity7 = new Intent(ProdajniSaloniActivity.this, Prodajni_salon_zajecar.class);
                        startActivity(newActivity7);
                        break;
                    case 8:
                        Intent newActivity8 = new Intent(ProdajniSaloniActivity.this, Prodajni_centar_ogrev.class);
                        startActivity(newActivity8);
                        break;
                    case 9:
                        Intent newActivity9 = new Intent(ProdajniSaloniActivity.this, Prodajni_salon_sombor.class);
                        startActivity(newActivity9);
                        break;


                }
            }

            @Override
            public void onLongClick(View view, int position) {

            }


                })
        );


        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        if(getSupportActionBar() != null)
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


    }

}
