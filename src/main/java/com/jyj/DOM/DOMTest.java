package com.jyj.DOM;

import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;

/**
 * @Classname DOMTest
 * @Description TODO
 * @Date 2019/2/26 9:25
 * @Created by jyj
 */
public class DOMTest {

    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        // 创建DocumentBuilderFactory对象
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        // 创建DocumentBuilder对象
        DocumentBuilder db = dbf.newDocumentBuilder();
        // 通过DocumentBuilders对象的parse方法加载books.xml文件，创建Document对象
//        D:\Office\IdeaProjects\imoocXML\src\main\resources\books.xml
        Document document = db.parse("src/main/resources/books.xml");
        // 获取书的集合
        NodeList bookList = document.getElementsByTagName("book");
        // 通过nodelist的getLength()方法获取List长度
        System.out.println("共有书" + bookList.getLength() + "本");
        // 遍历每一个book节点
        for (int i = 0; i < bookList.getLength(); i++) {
            System.out.println("=====开始遍历第" + (i+1) + "本书=====");
            // 通过 获取-个book节点
            Node book = bookList.item(i);
//            System.out.println(book.getTextContent());
            // 获取book节点的所有属性和集合
            NamedNodeMap attrs = book.getAttributes();
            System.out.println("第" + (i+1) + "本书有" + attrs.getLength() + "属性");
            for (int j = 0; j < attrs.getLength(); j ++) {
                // 通过item(index)获取属性
                Node attr = attrs.item(j);
                System.out.print("属性名：" + attr.getNodeName() + " ");
                System.out.println("属性值：" + attr.getNodeValue());
            }
            // 前提：知道book节点有且只有1个id属性
            // 强制类型转换
//            Element book = (Element) bookList.item(i);
//            String attrValue = book.getAttribute("id");
//            System.out.println("id属性值：" + attrValue);
            NodeList childNodes = book.getChildNodes();
            // 遍历childNodes获取每个节点的节点名和节点值
//            System.out.println("第" + (i+1) + "有" + childNodes.getLength() + "个子节点");
            for (int k = 0; k < childNodes.getLength(); k++) {
                // 区分text类型的node以及element类型的node
                if (childNodes.item(k).getNodeType() == Node.ELEMENT_NODE) {
                    // 获取element节点名
                    System.out.print(childNodes.item(k).getNodeName() + ":");
//                    System.out.println(childNodes.item(k).getFirstChild().getNodeValue());
                    System.out.println(childNodes.item(k).getTextContent());
                }
            }
            System.out.println("=====结束遍历第" + (i+1) + "本书=====");
        }
    }
}
