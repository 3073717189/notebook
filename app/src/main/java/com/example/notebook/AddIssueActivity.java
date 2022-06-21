package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.notebook.db.Issue;
import com.example.notebook.db.Notebook;

import java.util.Calendar;

public class AddIssueActivity extends AppCompatActivity implements View.OnClickListener {


    EditText question, optionA, optionB, optionC, optionD;//编辑框
    Button save, cancel;//保存，取消按钮
    RadioButton A, B, C, D,answer;//单选按钮
    RadioGroup group_option;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_issue);

        question = (EditText) findViewById(R.id.edit_question);
        optionA = (EditText) findViewById(R.id.edit_optionA);
        optionB = (EditText) findViewById(R.id.edit_optionB);
        optionC = (EditText) findViewById(R.id.edit_optionC);
        optionD = (EditText) findViewById(R.id.edit_optionD);
        save = (Button) findViewById(R.id.issue_save);
        cancel = (Button) findViewById(R.id.issue_cancel);
        A = (RadioButton) findViewById(R.id.button_optionA);
        B = (RadioButton) findViewById(R.id.button_optionB);
        C = (RadioButton) findViewById(R.id.button_optionC);
        D = (RadioButton) findViewById(R.id.button_optionD);
        group_option=(RadioGroup)findViewById(R.id.group_option);

        save.setOnClickListener(this);
        cancel.setOnClickListener(this);

        group_option.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                answer=(RadioButton) findViewById(i);
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            case R.id.issue_save:{
                Intent intent1=getIntent();
                int notebook_id=intent1.getIntExtra("notebook_id",0);
                Log.d("ccc",Integer.toString(notebook_id));//测试传入的notebook_id是否正确
                Issue issue=new Issue();
                issue.setCalendar(Calendar.getInstance());
                issue.setReview(0);
                issue.setQuestion(question.getText().toString());
                issue.setOptionA(optionA.getText().toString());
                issue.setOptionB(optionB.getText().toString());
                issue.setOptionC(optionC.getText().toString());
                issue.setOptionD(optionD.getText().toString());
                issue.setNotebookId(notebook_id);
                issue.setAnswer(answer.getText().toString());
                issue.save();
                Toast.makeText(this,"保存成功",Toast.LENGTH_SHORT).show();
                finish();
                break;}
            case R.id.issue_cancel:{
                Toast.makeText(this,"取消保存",Toast.LENGTH_SHORT).show();
                Intent intent1=getIntent();
                int notebook_id=intent1.getIntExtra("notebook_id",0);
                Log.d("ddd",Integer.toString(notebook_id));//测试传入的notebook_id是否正确
                finish();
                break;}
        }
    }

}