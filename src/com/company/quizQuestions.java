package com.company;

import java.util.TreeMap;

public class quizQuestions {

    // Variables
    private int qId;
    private int answerId;
    private String text;

    private TreeMap<Integer, String> options;

// Constructor
    public quizQuestions(int qId, int answerId, String text) {
        this.qId = qId;
        this.answerId = answerId;
        this.text = text;

        options = new TreeMap<>();
    }

    // Get ID method
    public int getqId() {
        return qId;
    }

    // Get answer ID method
    public int getAnswerId() {
        return answerId;
    }

    // Get text method
    public String getText() {
        return text;
    }



    // Add option method
    public void addOption(int id, String option) {
        options.put(id, option);
    }
}