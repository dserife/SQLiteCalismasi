package com.example.sqlitecalismasi.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Environment;

import com.example.sqlitecalismasi.Model.Kitap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/*

 * SQLite database kullanabilmek için gerekli olarak helper sınıfı.

 */

public class SqlHelper extends SQLiteOpenHelper {

    /**
     * tablo elemanlarını tanımladık. ='den sonraki değerler Kitap classındaki değişkenlerle aynı olmalıdır
     */
    private static final int database_VERSION=1;
    private static final String database_NAME="KitapDB";
    private static final String table_BOOKS="kitaplar";
    private static final String book_ID="id";
    private static final String book_kitapAdi="kitapAdi";
    private static final String book_kitapYazari="yazarAdi";

    //tablomuzu oluşturduk.
    private static final String CREATE_BOOK_TABLE= "CREATE TABLE kitaplar(id INTEGER PRIMARY KEY AUTOINCREMENT, kitapAdi TEXT, yazarAdi TEXT )";



    //implement edilen metotlar
    public SqlHelper(Context context) {

        super(context, database_NAME, null, database_VERSION);

    }

    //implement edilen metotlar
    @Override
    public void onCreate(SQLiteDatabase db) {

        /**
         * veritabanı ilk açıldığında çağrılan metot. tablo oluşturma işlemleri yapılır.
         */

        db.execSQL(CREATE_BOOK_TABLE);

    }

    //implement edilen metotlar
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        /**
         *
         */
        db.execSQL("DROP TABLE IF EXISTS "+table_BOOKS);
        this.onCreate(db);
    }



    public void kitapEkle(Kitap kitap){

        /**
         * veritabanının içini doldurmak için yazdığımız metot
         */

        SQLiteDatabase database= this.getWritableDatabase();
        ContentValues degerler=new ContentValues();

        degerler.put(book_kitapAdi,kitap.getKitapAdi());
        degerler.put(book_kitapYazari,kitap.getYazarAdi());

        database.insert(table_BOOKS,null,degerler);
        database.close();

    }

    public  List<Kitap> kitapGetir(){
/**
 * veritabanına kaydettiğimiz verileri çekmemiz için yazdığımız metot
 */
        List<Kitap> kitaplar= new ArrayList<>();

        String query= "SELECT * FROM "+table_BOOKS;

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor =db.rawQuery(query,null);
        Kitap kitap=null;

        if (cursor.moveToFirst()){
            do {
                kitap= new Kitap();
                kitap.setId(Integer.parseInt(cursor.getString(0)));
                kitap.setKitapAdi(cursor.getString(1));
                kitap.setYazarAdi(cursor.getString(2));
                kitaplar.add(kitap);

            }while (cursor.moveToNext());
        }

        return kitaplar;
    }
}
