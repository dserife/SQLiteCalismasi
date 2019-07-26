package com.example.sqlitecalismasi.Activity;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.sqlitecalismasi.Helper.SqlHelper;
import com.example.sqlitecalismasi.Model.Kitap;
import com.example.sqlitecalismasi.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ListView lvKitap;
    SqlHelper database= new SqlHelper(context);

    List<Kitap> kitapList= new ArrayList<>();

    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvKitap=findViewById(R.id.lvKitap);

        database.onUpgrade(database.getWritableDatabase(),0,1);

        database.kitapEkle(new Kitap("Çalıkuşu","Reşat Nuri Güntekin"));
        database.kitapEkle(new Kitap("Çalıkuşu","Reşat Nuri Güntekin"));
        database.kitapEkle(new Kitap("Çalıkuşu","Reşat Nuri Güntekin"));
        database.kitapEkle(new Kitap("Çalıkuşu","Reşat Nuri Güntekin"));
        database.kitapEkle(new Kitap("Çalıkuşu","Reşat Nuri Güntekin"));

        kitapList= database.kitapGetir();

        List<String> listKitapAdi = new ArrayList<>();

        for (int i = 0; i <kitapList.size() ; i++) {

            listKitapAdi.add(i,kitapList.get(i).getKitapAdi());
        }

        arrayAdapter = new ArrayAdapter<String>(context,R.layout.satir_layout,R.id.tvKitapAdi,listKitapAdi);
        lvKitap.setAdapter(arrayAdapter);
    }
}
