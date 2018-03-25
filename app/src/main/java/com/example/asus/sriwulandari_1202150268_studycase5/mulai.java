package com.example.asus.sriwulandari_1202150268_studycase5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;

import com.example.asus.myapplication.R;

import java.util.ArrayList;

public class mulai extends AppCompatActivity {
    //deklarasi variable
    Database database;
    RecyclerView recyclerView;
    adapter adapter;
    ArrayList<itemTodo> listitem;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mulai);

        //akses recyclerview yang beradad di layout
        recyclerView = findViewById(R.id.list);
        //membuat array
        listitem = new ArrayList<>();
        //membuat database
        database = new Database(this);
        //memanggil method getAllitem
        database.getAllItem(listitem);
        //inisiasi share preferences
        SharedPreferences a = this.getApplicationContext().getSharedPreferences("a",0);
        int warna = a.getInt("background", R.color.putih);
        //membuat adapter baru
        adapter = new adapter(this, listitem, warna);
        //menghindari perubahan pada saaat menghapus/menambah item
        recyclerView.setHasFixedSize(true);
        //menentukan layout linear
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //inisisiasi adapter
        recyclerView.setAdapter(adapter);
        //menjalani method geser
        hapus();
    }
    //membuat method untuk menhhapus item
    public void hapus(){
        //membuat touch helper baru untuk recycle vie
        ItemTouchHelper.SimpleCallback sc = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int letak = viewHolder.getAdapterPosition();
                itemTodo now = adapter.getItem(letak);
                //apabila todolist digeser ke kanan atau kiri maka data akan terhapus
                if (direction==ItemTouchHelper.LEFT||direction==ItemTouchHelper.RIGHT){
                    if (database.hapusdata(now.getTodo())){
                        adapter.removeitem(letak);
                    }
                }
            }
        };
        //menentukan itemtouchhelper untuk recyclerview
        ItemTouchHelper helper = new ItemTouchHelper(sc);
        helper.attachToRecyclerView(recyclerView);
    }
//saat menu activity dibuat
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //mendapatkan id dari item
        int id = item.getItemId();
        //jika id yang dipilih setting
        if (id==R.id.setting){
            startActivity(new Intent(mulai.this,Pengaturan.class));//mengakhiri activity setelah intent dijalankan
            finish();
        }
        return true;
    }
    //method ketika tombol + diklik
    public void masuk(View view) {
        //membuat intent baru
        startActivity(new Intent(mulai.this, Todo.class));
        //mengakhiri activity setelah intent dijalankan
        finish();
    }
}
