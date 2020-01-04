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

    // Return question Id
    public int getQuestionId() {
        return questionId;
    }

    // Return answer id
    public int getAnswerId() {
        return answerId;
    }

    // Return text
    public String getText() {
        return text;
    }

    // get answers
    public TreeMap<Integer, String> getOptions() {
        return options;
    }

    // Add question
    public void addOption(int id, String option) {
        options.put(id, option);
    }
}
