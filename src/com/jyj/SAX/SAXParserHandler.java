package com.jyj.SAX;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * @Classname SAXParserHandler
 * @Description TODO
 * @Date 2019/2/26 11:10
 * @Created by jyj
 */
public class SAXParserHandler extends DefaultHandler {

    int bookIndex = 0;
    /**
     * 用来遍历xml文件开始标签
     * @param uri
     * @param localName
     * @param qName 元素的名称
     * @param attributes
     * @throws SAXException
     */
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, qName, attributes);
        // 开始解析book元素属性
        if (qName.equals("book")) {
//            String value = attributes.getValue("id");
//            System.out.println("book的属性值：" + value);
            bookIndex += 1;
            System.out.println("=====开始遍历第" + bookIndex + "书=====");
            for (int i = 0; i < attributes.getLength(); i++) {
                String name = attributes.getQName(i);
                String name_value = attributes.getValue(i);
                System.out.println("第" + (i+1) + "个属性名" + name + "值为" + name_value);
            }
        } else if (!qName.equals("book") && !qName.equals("bookstore")) {
            System.out.print("节点名：" + qName + "值为：");
        }
    }

    /**
     * 用来遍历xml文件结束标签
     * @param uri
     * @param localName
     * @param qName
     * @throws SAXException
     */
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        super.endElement(uri, localName, qName);
        if (qName.equals("book")) {
            System.out.println("=====结束遍历第" + bookIndex + "书=====");
        }
    }

    /**
     * 用来标识解析开始
     * @throws SAXException
     */
    @Override
    public void startDocument() throws SAXException {
        super.startDocument();
        System.out.println("SAX解析开始");
    }

    /**
     * 用来标识解析结束
     * @throws SAXException
     */
    @Override
    public void endDocument() throws SAXException {
        super.endDocument();
        System.out.println("SAX解析结束");
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        String value = new String(ch, start, length);
        if (!value.trim().equals("")) {
            System.out.println(value);
        }
    }
}
