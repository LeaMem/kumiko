package com.lea.kumiko.juc.bas;

import com.sun.org.apache.xpath.internal.NodeSet;
import org.apache.ibatis.builder.xml.XMLMapperEntityResolver;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.*;

import javax.annotation.Resources;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;

public class TestXml {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException, XPathExpressionException {
        DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
        documentBuilderFactory.setValidating(false);
        documentBuilderFactory.setNamespaceAware(false);
        documentBuilderFactory.setIgnoringComments(true);
        documentBuilderFactory.setCoalescing(false);
        documentBuilderFactory.setExpandEntityReferences(true);

        DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
        documentBuilder.setErrorHandler(new ErrorHandler() {
            @Override
            public void warning(SAXParseException exception) throws SAXException {

            }

            @Override
            public void error(SAXParseException exception) throws SAXException {
                throw exception;
            }

            @Override
            public void fatalError(SAXParseException exception) throws SAXException {
                throw exception;
            }
        });

        documentBuilder.setEntityResolver(new XMLMapperEntityResolver());
        Document document = documentBuilder.parse("/Users/lea/IdeaProjects/kumiko/juc/src/main/java/com/lea/kumiko/juc/bas/tst.xml");

        XPathFactory xPathFactory = XPathFactory.newInstance();
        XPath xPath = xPathFactory.newXPath();


//        System.out.println(schema.)

        NodeList nodeList = (NodeList) xPath.evaluate("//book", document, XPathConstants.NODESET);
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node item = nodeList.item(i);
            NodeList childNodes = item.getChildNodes();
            System.out.println("     " + childNodes.getLength());
            for (int j = 0; j < childNodes.getLength(); j++) {
                if(childNodes.item(j).getNodeType() == Node.TEXT_NODE){
                    String nodeValue = childNodes.item(j).getNodeValue();
                    System.out.println(nodeValue);
//                    System.out.println(childNodes.item(j).getNodeValue());
                }
//                System.out.println(childNodes.item(j).getNodeName() + " " + (childNodes.item(j).getNodeType() == Node.TEXT_NODE));

            }
//            NamedNodeMap attributes = item.getAttributes();
//            if(attributes != null){
//                for (int j = 0; j < attributes.getLength(); j++) {
//                    Node item1 = attributes.item(j);
//                    System.out.println(item1.getNodeName() + "  " + item1.getNodeValue());
//                }
//            }
        }


    }

}
