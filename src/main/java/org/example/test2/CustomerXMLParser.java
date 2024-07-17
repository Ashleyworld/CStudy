package org.example.test2;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.InputStream;


public class CustomerXMLParser {
    public static void main(String[] args){
        try{
            // XML 문서 파싱
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // 리소스 폴더에서 XML 파일을 읽기 위해 ClassLoader를 사용해서 리소스 파일 읽음
            // InputStream 가져오기 : getResourceAsStream 메서드를 사용해서 리소스 폴더 파일을
            // inputStream 으로 가져옴
            // 예외처리 :  파일이 없는 경우 illegalArgumentException
            // InputStream 을 파싱 : InputStream 을 builder.parse 메서드에 전달하여
            // XML 문서를 파싱

            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
            InputStream inputStream = classLoader.getResourceAsStream("xml/samplexml.xml");

            if (inputStream == null) {
                throw new IllegalArgumentException("file not found! " + "xml/samplexml.xml");
            }

            // InputStream을 파싱하여 Document 객체 생성
            Document document = builder.parse(inputStream);

            // 루트 엘리먼트 가져오기
            Element root = document.getDocumentElement();

            // customer 엘리먼트 가져오기
            NodeList customers = root.getElementsByTagName("customer");

            for(int i = 0; i < customers.getLength(); i++){
                Node customer = customers.item(i);

                if (customer.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) customer;

                    // name, age, address 엘리먼트 값 가져오기
                    String name = element.getElementsByTagName("name").item(0).getTextContent();
                    String age = element.getElementsByTagName("age").item(0).getTextContent();
                    String address = element.getElementsByTagName("address").item(0).getTextContent();

                    System.out.println("Name : " + name);
                    System.out.println("Age : " + age);
                    System.out.println("Address : " + address);
                }
            }



        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        }
    }
}
