package com.example.asus.sriwulandari_1202150268_studycase5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.myapplication.R;

public class Todo extends AppCompatActivity {

    EditText todo, deskrip, prior;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todo);

        //mengakses id yang ada di layout
        todo = findViewById(R.id.todo);
        deskrip = findViewById(R.id.des);
        prior = findViewById(R.id.prio);

        //inisiais database
        db = new Database(this);

    }

    //method saat tombol kembali diklik
    public void onBackPressed(){
        //MEMBUAT INTEN BARU
        startActivity(new Intent(Todo.this, mulai.class));
        this.finish();
    }
    //method saat button tambah to do diklik
    public void tambah(View view){
        //jika data terisi semua
        if (db.inputdata(new itemTodo(todo.getText().toString(), deskrip.getText().toString(), prior.getText().toString()))){
            Toast.makeText(this, "Todo Ditambahkan", Toast.LENGTH_SHORT).show();
            onBackPressed();
        }else {
            //jika data ada yang tidak terisis
            Toast.makeText(this, "Todo Gagal Ditambah", Toast.LENGTH_SHORT).show();
            //seting semua edit text menjadi null
            todo.setText(null);
            deskrip.setText(null);
            prior.setText(null);
        }
    }

}
