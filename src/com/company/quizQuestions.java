package com.company;

import java.util.TreeMap;

public class quizQuestions {

    // Variables
    private int questionId;
    private int answerId;
    private String text;

    private TreeMap<Integer, String> options;

// Constructor
    public quizQuestions(int questionId, int answerId, String text) {
        this.questionId = questionId;
        this.answerId = answerId;
        this.text = text;

        options = new TreeMap<>();
    }

    // Get ID method
    public int getQuestionId() {
        return questionId;
    }

    // Get answer ID method
    public int getAnswerId() {
        return answerId;
    }

    // Get text method
    public String getText() {
        return text;
    }

    // Get options method
    public TreeMap<Integer, String> getOptions() {
        return options;
    }

    // Add option method
    public void addOption(int id, String option) {
        options.put(id, option);
    }
}