package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.notebook.db.Issue;

import org.litepal.LitePal;

import java.util.List;

public class ReviewActivity extends AppCompatActivity {
 //   private List<Issue> issues;
TextView review_question;
RadioButton review_optionA,review_optionB,review_optionC,review_optionD;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_review);
        review_question=(TextView) findViewById(R.id.review_question);
        review_optionA=(RadioButton) findViewById(R.id.review_optionA);
        review_optionB=(RadioButton) findViewById(R.id.review_optionB);
        review_optionC=(RadioButton) findViewById(R.id.review_optionC);
        review_optionD=(RadioButton) findViewById(R.id.review_optionD);

        Intent intent1=getIntent();
        int notebook_id=intent1.getIntExtra("notebook_id",0);
        Log.d("fff",Integer.toString(notebook_id));//检测复习界面传入的notebookId是否正确
  //     int i=0;
       // Issue issue=LitePal.limit(1).offset(i).find(Issue.class);
        List<Issue> issues = LitePal.findAll(Issue.class);
       for (Issue issue : issues) {
           if(notebook_id==issue.getNotebookId()){
               review_question.setText(issue.getQuestion());
               review_optionA.setText(issue.getOptionA());
               review_optionB.setText(issue.getOptionB());
               review_optionC.setText(issue.getOptionC());
               review_optionD.setText(issue.getOptionD());

           }
        }

    }
}