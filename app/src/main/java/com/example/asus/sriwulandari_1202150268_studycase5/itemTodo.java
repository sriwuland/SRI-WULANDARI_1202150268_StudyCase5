package com.example.asus.sriwulandari_1202150268_studycase5;

/**
 * Created by Asus on 03/25/2018.
 */

public class itemTodo {
    //mendeklarasikan variable yang akan dibutuhkan
    String todo, deskripsi, prioritas;

    public itemTodo(String todo, String deskripsi, String prioritas) {
        this.todo = todo;
        this.deskripsi = deskripsi;
        this.prioritas = prioritas;

    }
    //method setter dan getter
    public String getTodo(){ return todo; }

    public void setTodo(String todo){ this.todo=todo; }

    public String getDeskripsi(){ return deskripsi; }

    public void setDesripsi(String deskripsi){ this.deskripsi = deskripsi; }

    public String getPrioritas() { return prioritas; }

    public void setPrioritas (String prioritas){ this.prioritas = prioritas; }
}
