package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.notebook.db.Notebook;

import org.litepal.LitePal;

public class CreatebookActivity extends AppCompatActivity implements View.OnClickListener{
 private Button enter,cancel;
 private EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createbook);
        enter=(Button) findViewById(R.id.create_enter);
        cancel=(Button) findViewById(R.id.create_cancel);
        name=(EditText)findViewById(R.id.create_name);

        enter.setOnClickListener(this);
        cancel.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.create_enter:
            {
                Notebook notebook=new Notebook();
                notebook.setName(name.getText().toString());
                notebook.save();
                finish();
                break;
            }
            case R.id.create_cancel:
            {
                    finish();
                    break;
            }

        }

    }
}