package com.example.notebook.db;

import org.litepal.crud.LitePalSupport;

import java.util.Calendar;

public class Issue extends LitePalSupport {
    private int id,notebookId;
    private String question,optionA,optionB,optionC,optionD,answer;
    private Calendar calendar;
    private int review;

    public int getId() {
        return id;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public int getReview() {
        return review;
    }

    public String getQuestion() {
        return question;
    }

    public String getAnswer() {
        return answer;
    }

    public String getOptionA() {
        return optionA;
    }

    public String getOptionB() {
        return optionB;
    }

    public String getOptionC() {
        return optionC;
    }

    public String getOptionD() {
        return optionD;
    }

    public int getNotebookId() {return notebookId;}

    public void setId(int id) {
        this.id = id;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public void setReview(int review) {
        this.review = review;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public void setOptionA(String optionA) {
        this.optionA = optionA;
    }

    public void setOptionB(String optionB) {
        this.optionB = optionB;
    }

    public void setOptionC(String optionC) {
        this.optionC = optionC;
    }

    public void setOptionD(String optionD) {
        this.optionD = optionD;
    }

    public void setNotebookId(int notebookId) {this.notebookId = notebookId;}
}
