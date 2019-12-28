package com.company;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Scanner;

public class domParser {

    // Variables
    private int numOfPlayers;

    // Parse xml method to add questions
    public domParser(String file){
        parseXml(file);
    }




    private void parseXml(String file) {


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(".idea/question.xml");
            NodeList quesionList = doc.getElementsByTagName("Question");

            numOfPlayers = Integer.parseInt(doc.getDocumentElement().getAttribute("Players"));

            for(int i = 0; i < quesionList.getLength(); i++){
                Node q = quesionList.item(i);


                if(q.getNodeType()== Node.ELEMENT_NODE){
                    Element eElement = (Element) q;

                    int questionId = Integer.parseInt(eElement.getAttribute("id"));
                    int answerId = Integer.parseInt(eElement.getAttribute("answerid"));

                    String text = eElement.getElementsByTagName("text").item(0).getTextContent();

                    NodeList answer = eElement.getElementsByTagName("answers").item(0).getChildNodes();

                    quizQuestions quizQuestions = new quizQuestions(questionId, answerId, text);

                    for(int a = 0; a < answer.getLength(); a++ ){
                        Node nod = answer.item(a);

                        if(nod.getNodeType() == Node.ELEMENT_NODE){
                            Element e = (Element) nod;

                            int optionId = Integer.parseInt(e.getAttribute("id"));
                            String option = e.getTextContent();

                            quizQuestions.addOption(optionId, option);
                        }
                    }

                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getNumOfPlayers(){
        return  numOfPlayers;
    }

}