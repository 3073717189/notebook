package com.example.notebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.notebook.db.Issue;
import com.example.notebook.db.Notebook;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.litepal.LitePal;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class NotebookActivity extends AppCompatActivity implements View.OnClickListener {
 //   private List<Issue> issueList = new ArrayList<>();
    TextView review_yes, review_not, review_remember;
    FloatingActionButton add_issue;
    int yes = 0, not = 0, remember = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notebook);

        review_yes = (TextView) findViewById(R.id.review_yes);
        review_not = (TextView) findViewById(R.id.review_not);
        review_remember = (TextView) findViewById(R.id.review_remember);
        add_issue = (FloatingActionButton) findViewById(R.id.add_issue);
        add_issue.setOnClickListener(this);
        review_not.setOnClickListener(this);

        List<Issue> issues = LitePal.findAll(Issue.class);
        for (Issue issue : issues) {
            Calendar calendar_now = Calendar.getInstance();
            int now = calendar_now.DAY_OF_YEAR;
            int begin = issue.getCalendar().DAY_OF_YEAR;
            int time = now - begin;
            Intent intent1 = getIntent();
            int notebook_id = intent1.getIntExtra("id", 0);
            Log.d("eee",Integer.toString(issue.getNotebookId()));//测试是否读取到了正确的issue中的notebookId
            if (issue.getNotebookId() == notebook_id && ((time > 0 && issue.getReview() < 1) || (time > 2 && issue.getReview() < 2) || (time > 6 && issue.getReview() < 3))) {
                not = not + 1;
            } else if (issue.getReview() == 3) {
                remember = remember + 1;
            } else if(issue.getNotebookId() == notebook_id ){
                yes = yes + 1;
            }
        }
        review_yes.setText(Integer.toString(yes));
        review_not.setText(Integer.toString(not));
        review_remember.setText(Integer.toString(remember));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.add_issue: {
                Intent intent = new Intent(NotebookActivity.this, AddIssueActivity.class);
                Intent intent1 = getIntent();
                int notebook_id = intent1.getIntExtra("id", 0);
                Log.d("bbb",Integer.toString(notebook_id));//测试传入的notebook_id是否正确

                intent.putExtra("notebook_id", notebook_id);
                startActivity(intent);
                break;
            }
            case R.id.review_not:
                Intent intent = new Intent(NotebookActivity.this, ReviewActivity.class);
                Intent intent1 = getIntent();
                int notebook_id = intent1.getIntExtra("id", 0);
                intent.putExtra("notebook_id", notebook_id);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}