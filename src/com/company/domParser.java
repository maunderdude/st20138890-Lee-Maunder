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
import java.util.Map;
import java.util.TreeMap;

public class domParser {

    // Variables
    private int numOfPlayers;
    private Map<Integer, quizQuestions> listOFQuestions;

    // Parse xml method to add questions
    public domParser(String file){
        parseXml(file);
    }

    // Store xml file in map
    private void parseXml(String file) {
        listOFQuestions = new TreeMap<>();


        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(".idea/question2.xml");
            NodeList questionList = doc.getElementsByTagName("Question");

            // Assigning number of players to the "players tag" in xml
            numOfPlayers = Integer.parseInt(doc.getDocumentElement().getAttribute("players"));

            //
            for(int i = 0; i < questionList.getLength(); i++){
                Node q = questionList.item(i);

                //
                if(q.getNodeType()== Node.ELEMENT_NODE){
                    Element eElement = (Element) q;

                    // Assigning variables to xml tags
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

    public Map<Integer, quizQuestions> getListOFQuestions() {
        return listOFQuestions;
    }


}