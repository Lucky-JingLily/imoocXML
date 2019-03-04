package com.jyj.FSImage;

import com.jyj.entity.Block;
import org.dom4j.Element;

import java.io.File;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname FSImageTest
 * @Description TODO
 * @Date 2019/2/28 10:12
 * @Created by lipeijing
 */
public class FSImage_bak {

    public static void main(String[] args) {
        List<Block> blockList = null;
        List<File> fileList = null;
        List<DirectoryList> directories = null;

        Utils utils = new Utils();
        int count = 0;
        Element fsimage = utils.getRootElement("src/main/resources/fsimage.xml");
        Iterator it = fsimage.elementIterator();
        while (it.hasNext()) {
            System.out.println("==========开始遍历第" + (count+1) + "个一级标签==========");
            Element element = (Element) it.next();
            System.out.println(element.getName());
//                if (element.getName().equals("NameSection")) {
//                    Iterator iterator = element.elementIterator();
//                    while (iterator.hasNext()) {
//                        Element elm = (Element) iterator.next();
//                        System.out.println(elm.getName() + ":" + elm.getStringValue());
//                    }
//                }
//                if (element.getName().equals("SnapshotSection")) {
//                    Iterator iterator = element.elementIterator();
//                    while (iterator.hasNext()) {
//                        Element elm = (Element) iterator.next();
//                        System.out.println(elm.getName() + ":" + elm.getStringValue());
//                    }
//                }
//                if (element.getName().equals("FileUnderConstructionSection")) {
//                    Iterator iterator = element.elementIterator();
//                    while (iterator.hasNext()) {
//                        Element elm = (Element) iterator.next();
//                        System.out.println(elm.getName() + ":" + elm.getStringValue());
//                    }
//                }
//                if (element.getName().equals("SecretManagerSection")) {
//                    Iterator iterator = element.elementIterator();
//                    while (iterator.hasNext()) {
//                        Element elm = (Element) iterator.next();
//                        System.out.println(elm.getName() + ":" + elm.getStringValue());
//                    }
//                }
//                if (element.getName().equals("CacheManagerSection")) {
//                    Iterator iterator = element.elementIterator();
//                    while (iterator.hasNext()) {
//                        Element elm = (Element) iterator.next();
//                        System.out.println(elm.getName() + ":" + elm.getStringValue());
//                    }
//                }
                if (element.getName().equals("INodeSection")) {
                    Iterator iterator = element.elementIterator();
                    while (iterator.hasNext()) {
                        Element elm = (Element) iterator.next();
                        if (elm.getName().equals("lastInodeId")) {
                            System.out.println(elm.getName() + ":" + elm.getStringValue());
                        } else {
                            Iterator iter = elm.elementIterator();
                            while (iter.hasNext()) {
                                Element elem = (Element) iter.next();
                                if (elem.getName().equals("blocks")) {
                                    Iterator itera = elem.elementIterator();
                                    for (Iterator it1 = itera; it1.hasNext(); ) {
                                        Element e = (Element) it1.next();
                                        Iterator iterator1 = e.elementIterator();
                                        while (iterator1.hasNext()) {
                                            Element element1 = (Element) iterator1.next();
                                            System.out.println("block" + element1.getName() + ":" + element1.getStringValue());
                                        }
                                    }
                                } else {
                                    System.out.println(elem.getName() + ":" + elem.getStringValue());
                                }
                            }
                        }
                    }
                }
//                if (element.getName().equals("INodeDirectorySection")) {
//                    Iterator iterator = element.elementIterator();
//                    while (iterator.hasNext()) {
//                        Element elm = (Element) iterator.next();
//                        Iterator iter = elm.elementIterator();
//                        while (iter.hasNext()) {
//                            Element elem = (Element) iter.next();
//                            System.out.println(elem.getName() + ":" + elem.getStringValue());
//                        }
//                    }
//                }
//                Iterator iterator = element.elementIterator();
//                while (iterator.hasNext()) {
//                    Element elm = (Element) iterator.next();
//                    System.out.println("节点名：" + elm.getName() + "--节点值：" + elm.getStringValue());
//                }
//                System.out.println("==========结束遍历第" + (count+1) + "一级标签==========");
            count += 1;
        }

    }
}
