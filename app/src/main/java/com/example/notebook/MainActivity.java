package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import com.example.notebook.adapter.NotebookAdapter;
import com.example.notebook.db.Notebook;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.litepal.LitePal;
import org.litepal.crud.LitePalSupport;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private FloatingActionButton add;
    private List<Notebook> notebookList = new ArrayList<>();

    String name;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getlitepalData();//初始化

        add = (FloatingActionButton) findViewById(R.id.add);
        add.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_cover);
        StaggeredGridLayoutManager layoutManager = new
                StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        NotebookAdapter adapter = new NotebookAdapter(this, notebookList);
        recyclerView.setAdapter(adapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add: {
                Intent intent = new Intent(this, CreatebookActivity.class);
                startActivity(intent);
                break;
            }

            default:
                break;
        }
    }

    private void getlitepalData() {
        List<Notebook> notebooks = LitePal.findAll(Notebook.class);
        for (Notebook notebook : notebooks) {
            //取出数据库的每一项数据
            name = notebook.getName();

            notebookList.add(notebook);
        }
    }

}