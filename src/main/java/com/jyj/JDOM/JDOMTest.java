package com.jyj.JDOM;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname JDOMTest
 * @Description TODO
 * @Date 2019/2/26 15:10
 * @Created by jyj
 */
public class JDOMTest {
    public static void main(String[] args) throws IOException, JDOMException {
        // 对books.xml解析
        // 创建SAXBuilder对象
        SAXBuilder saxBuilder = new SAXBuilder();
        // 创建输入流，将xml文件加载到文件中
        InputStream in = new FileInputStream("src/main/resources/books.xml");
        // saxBuilder的build方法，将输入流加载到saxBuilder
        Document document = saxBuilder.build(in);
        // 通过document对象获取xml文件的根节点
        Element rootElement = document.getRootElement();
//        System.out.println(rootElement.getName());
        // 获取根节点下的子节点
        List<Element> bookList = rootElement.getChildren();
        for (int i = 0; i < bookList.size(); i++) {
            System.out.println(bookList.get(i).getName() + ":" + bookList.get(i).getValue());
        }
    }
}
