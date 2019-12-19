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

public class domParser {

    public static void main(String[] args) {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(".idea/question.xml");
            NodeList quesionList = doc.getElementsByTagName("Question");
            for(int i = 0; i < quesionList.getLength(); i++){
                Node q = quesionList.item(i);
                if(q.getNodeType()== Node.ELEMENT_NODE){
                    Element question = (Element) q;
                    String questionNumber = question.getAttribute("id");


                    System.out.println("Question " + questionNumber + ": ");
                    System.out.println(question.getElementsByTagName("text").item(0).getTextContent());
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
    }

