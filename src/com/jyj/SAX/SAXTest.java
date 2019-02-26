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
        System.out.println("共有：" + handler.getBookList().size() + "本书");
        for (Book book :
                handler.getBookList()) {
            System.out.println(book.getId());
            System.out.println(book.getName());
            System.out.println(book.getAuthor());
            System.out.println(book.getYear());
            System.out.println(book.getPrice());
            System.out.println(book.getLanguage());
            System.out.println("=========");
        }
    }
}
