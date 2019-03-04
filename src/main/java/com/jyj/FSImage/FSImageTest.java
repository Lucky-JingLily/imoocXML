package com.jyj.FSImage;

import com.jyj.entity.Block;
import com.jyj.entity.Directory;
import com.jyj.entity.Inode;
import org.apache.ibatis.session.SqlSession;
import org.dom4j.Element;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @Classname FSImageTest
 * @Description TODO
 * @Date 2019/2/28 10:12
 * @Created by lipeijing
 */
public class FSImageTest {

    public static void main(String[] args) {
        List<Block> blockList = null;
        List<File> fileList = null;
        List<Inode> inodes = null;
        SqlSession sqlSession = MysqlTools.getSqlSession();

        Utils utils = new Utils();
        int count = 0;
        Element fsimage = utils.getRootElement("src/main/resources/fsimage.xml");
        Iterator it = fsimage.elementIterator();
        while (it.hasNext()) {
            System.out.println("==========开始遍历第" + (count+1) + "个一级标签==========");
            Element element = (Element) it.next();
            System.out.println(element.getName());

            String elementName = element.getName();
            if (elementName.equals("NameSection")) {
                utils.getElementContext(element);
            } else if (elementName.equals("SnapshotSection")) {
                utils.getElementContext(element);
            } else if (elementName.equals("FileUnderConstructionSection")) {
                utils.getElementContext(element);
            } else if (elementName.equals("INodeReferenceSection")) {
                utils.getElementContext(element);
            } else if (elementName.equals("SecretManagerSection")) {
                utils.getElementContext(element);
            } else if (elementName.equals("CacheManagerSection")) {
                utils.getElementContext(element);
            } else if (element.getName().equals("INodeDirectorySection")) {
                ArrayList list = utils.getINodeDirectorySection(element);
                Directory directory = null;
                for (int i = 0; i < list.size(); i++) {
                    directory = (Directory) list.get(i);
                    System.out.println("parent:" + directory.getParent());
                    System.out.println("inode:" + directory.getInodes());
                    sqlSession.insert("directory.insert", directory);
                    System.out.println("===========inode结束==========");
                }
                sqlSession.commit();
            } else if (element.getName().equals("INodeSection")) {
//                ArrayList list = utils.getINodeSection(element);
//                System.out.println(list.size());
//                Inode inode = null;
//                for (int i = 0; i < list.size(); i++) {
//                    inode = (Inode) list.get(i);
//                    sqlSession.insert("inode.insert", inode);
//                    System.out.println(inode.getId());
//                }
//                sqlSession.commit();
//                System.out.println(list.size());
//                for (int i = 0; i < list.size(); i++) {
//                    System.out.println(list.get(i));
//                }
            }
            System.out.println("==========结束遍历第" + (count+1) + "一级标签==========");
            count += 1;
        }

    }
}
