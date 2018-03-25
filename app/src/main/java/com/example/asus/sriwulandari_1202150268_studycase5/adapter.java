package com.example.asus.sriwulandari_1202150268_studycase5;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.asus.myapplication.R;

import java.util.List;

/**
 * Created by Asus on 03/25/2018.
 */

public class adapter extends RecyclerView.Adapter<adapter.holder> {
    //membuat variable
    private Context context;
    private List<itemTodo> item;
    int id;

    //constructor
    public adapter(Context context, List<itemTodo> item, int id){
        this.context = context;
        this.item = item;
         this.id = id;
    }

    //menentukan viewholder
    @Override
    public holder onCreateViewHolder(ViewGroup parent, int viewType){
        //membuat view baru
        View view = LayoutInflater.from(context).inflate(R.layout.recyclerview, parent, false);
        holder holder = new holder(view);
        return holder;
    }

    //menentukan nilai objek sesuai view holder
    @Override
    public void onBindViewHolder(holder holder, int letak) {
        itemTodo itemm = item.get(letak);
        holder.todo.setText(itemm.getTodo());
        holder.deskripsi.setText(itemm.getDeskripsi());
        holder.prioritas.setText(itemm.getPrioritas());
        holder.card.setCardBackgroundColor(context.getResources().getColor(this.id));
    }
    //mendapatkan item dar adapter
    public itemTodo getItem(int letak){
        return item.get(letak);}
    //menghapus item data pada todolist
    public void removeitem(int a){
        item.remove(a);
        notifyItemRemoved(a);
        notifyItemChanged(a, item.size());
    }
    //mendapat jumlah item
    @Override
    public int getItemCount() {
        return item.size();}

    //class holder yang terhubung dengan recyclerview
    class holder extends RecyclerView.ViewHolder{
        TextView todo, deskripsi, prioritas;
        CardView card;

        public holder(View itemView) {
            super(itemView);
            todo = itemView.findViewById(R.id.todorv);
            deskripsi = itemView.findViewById(R.id.deskripsirv);
            prioritas = itemView.findViewById(R.id.prioritasrv);
            card = itemView.findViewById(R.id.card);
        }
    }

}
