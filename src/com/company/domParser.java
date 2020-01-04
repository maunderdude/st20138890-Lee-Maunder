package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.util.Map;
import java.util.TreeMap;

public class domParser {

    //Variables
    private Map<Integer, quizQuestions> listOfQuestions;
    private int numOfPlayers;

    // Parse xml to add questions
    public domParser(String file) {
        parseXml(file);
    }

    // Store xml file in map
    private void parseXml(String file) {
        listOfQuestions = new TreeMap<>();

        try {
            File inputFile = new File(file);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList questionList = doc.getElementsByTagName("Question");

            // Assigning number of players to the "players tag" in xml script
            numOfPlayers = Integer.parseInt(doc.getDocumentElement().getAttribute("players"));

            // reading through xml
            for (int i = 0; i < questionList.getLength(); i++) {
                Node q = questionList.item(i);

                if (q.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) q;

                    // Assigning variables to xml tags
                    int questionId = Integer.parseInt(eElement.getAttribute("id"));
                    int answerId = Integer.parseInt(eElement.getAttribute("answerid"));

                    // Assigning variable to "text" tag within xml
                    String text = eElement.getElementsByTagName("text").item(0).getTextContent();

                    // Assigning variable to "answers" tag within xml
                    NodeList answer = eElement.getElementsByTagName("answers").item(0).getChildNodes();

                    // Creating object to hold questions
                    quizQuestions quizQuestions = new quizQuestions(questionId, answerId, text);

                    // Reading through xml
                    for (int a = 0; a < answer.getLength(); a++) {
                        Node nod = answer.item(a);

                        if (nod.getNodeType() == Node.ELEMENT_NODE) {
                            Element e = (Element) nod;

                            // Assigning optionId
                            int optionId = Integer.parseInt(e.getAttribute("id"));
                            String option = e.getTextContent();

                            // Adding answers
                            quizQuestions.addOption(optionId, option);
                        }
                    }

                    // Adding question
                    listOfQuestions.put(questionId, quizQuestions);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Return number of players
    public int getNumOfPlayers() {
        return numOfPlayers;
    }

    // return questions
    public Map<Integer, quizQuestions> getListOfQuestions() {
        return listOfQuestions;
    }
}
