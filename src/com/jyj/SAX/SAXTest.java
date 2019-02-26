package com.jyj.SAX;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.IOException;

/**
 * @Classname SAXTest
 * @Description TODO
 * @Date 2019/2/26 10:54
 * @Created by jyj
 */
public class SAXTest {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        // 获取SAXParserFactory实例
        SAXParserFactory factory = SAXParserFactory.newInstance();
        // 获取SAXParser实例
        SAXParser parser = factory.newSAXParser();
        //
        SAXParserHandler handler = new SAXParserHandler();
        parser.parse("books.xml", handler);
    }
}
