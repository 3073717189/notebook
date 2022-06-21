package com.example.notebook.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.notebook.NotebookActivity;
import com.example.notebook.R;
import com.example.notebook.db.Notebook;

import java.util.List;

public class NotebookAdapter extends RecyclerView.Adapter<NotebookAdapter.ViewHolder> {

    Context context;
    private List<Notebook> mNotebook;
    public NotebookAdapter(Context context,List<Notebook>mNotebook){
        this.context=context;
        this.mNotebook=mNotebook;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.notebook_item,parent,false);
        ViewHolder holder=new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Notebook notebook=mNotebook.get(position);
        holder.notebookName.setText(notebook.getName());
        holder.notebook_cover.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //      Intent intent=new Intent(context.getApplicationContext(), NotebookActivity.class);
                //   context.startActivities(intent);
                Intent intent = new Intent(context, NotebookActivity.class);
                  intent.putExtra("id",notebook.getId());//传入错题本id到下一级，记为id；
                Log.d("aaa",Integer.toString(notebook.getId()));//该行用于通过日志检测id传入是否正确

                context.startActivity(intent);

            }
        });
/*
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

    }
});*/
    }

    @Override
    public int getItemCount() {
        return mNotebook.size ();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        CardView cardView;
        TextView notebookName;
        ImageButton notebook_cover;
        public ViewHolder(View itemView) {
            super (itemView);
            cardView = itemView.findViewById (R.id.notebook_item);
            notebookName = itemView.findViewById (R.id.notebook_cover_name);
            notebook_cover=itemView.findViewById(R.id.notebook_cover);
        }
    }
}
