package com.jyj.FSImage;

import com.jyj.entity.Block;
import com.jyj.entity.Directory;
import com.jyj.entity.Inode;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * @Classname Utils
 * @Description TODO
 * @Date 2019/2/28 11:57
 * @Created by lipeijing
 */
public class Utils {

    public static SAXReader READER = new SAXReader();

    public Element getRootElement(String filePath) {
        Element element = null;
        try {
            Document document = READER.read(new File(filePath));
            element = document.getRootElement();
        } catch (DocumentException e) {
            e.printStackTrace();
            System.out.println("Document创建失败，查看文件路径是否正确");
        }
        return element;
    }

    public void getElementContext (Element element) {
        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()) {
            Element elm = (Element) iterator.next();
            System.out.println(elm.getName() + ":" + elm.getStringValue());
        }
    }

//    public ArrayList<DirectoryList> getINodeDirectorySection (Element element) {
//        ArrayList<DirectoryList> directories = new ArrayList<DirectoryList>();
//        ArrayList<String> inodeIds = null;
//        DirectoryList directoryList = null;
//        Iterator iterator = element.elementIterator();
//        while (iterator.hasNext()) {
//            Element elm = (Element) iterator.next();
//            Iterator iter = elm.elementIterator();
//            directoryList = new DirectoryList();
//            inodeIds = new ArrayList<String>();
//            while (iter.hasNext()) {
//                Element elem = (Element) iter.next();
//                String elemName = elem.getName();
//                if (elemName.equals("parent")) {
//                    directoryList.setParent(elem.getStringValue());
//                } else if (elemName.equals("inode")) {
//                    inodeIds.add(elem.getStringValue());
//                }
//            }
//            directoryList.setInodes(inodeIds);
//            directories.add(directoryList);
//            directoryList = null;
//            inodeIds = null;
//        }
//        return directories;
//    }

    public ArrayList<Directory> getINodeDirectorySection (Element element) {
        ArrayList<Directory> directories = new ArrayList<Directory>();
        ArrayList<String> inodeIds = null;
        Directory directory = null;
        String parent = null;
        Iterator iterator = element.elementIterator();
        while (iterator.hasNext()) {
            Element elm = (Element) iterator.next();
            Iterator iter = elm.elementIterator();
            while (iter.hasNext()) {
                Element elem = (Element) iter.next();
                String elemName = elem.getName();
                if (elemName.equals("parent")) {
                    parent = elem.getStringValue();
                    continue;
                }
//                System.out.println(parent);
                if (elemName.equals("inode")) {
                    inodeIds = new ArrayList<String>();
                    inodeIds.add(elem.getStringValue());
                    for (int i = 0; i < inodeIds.size(); i++) {
                        directory = new Directory();
                        directory.setParent(parent);
                        directory.setInodes(inodeIds.get(i));
                        directories.add(directory);
                        directory = null;
                    }
                    inodeIds = null;
                }
            }
            parent = null;
        }
        return directories;
    }

    public ArrayList getINodeSection (Element element) {
        Iterator iterator = element.elementIterator();
        ArrayList<Inode> inodes = new ArrayList<Inode>();
        ArrayList<Block> blocks = null;
        Inode inode = null;
        Block block = null;
        while (iterator.hasNext()) {
            Element elm = (Element) iterator.next();
            if (elm.getName().equals("lastInodeId")) {

            } else {
                Iterator iter = elm.elementIterator();
                inode = new Inode();
                while (iter.hasNext()) {
                    Element elem = (Element) iter.next();
//                    System.out.println(elem.getName());
                    if (elem.getName().equals("blocks")) {
                        Iterator itera = elem.elementIterator();
                        blocks = new ArrayList<Block>();
                        block = new Block();
                        while (itera.hasNext()) {
                            Element elemen = (Element) itera.next();
                            Iterator iterat = elemen.elementIterator();
                            while (iterat.hasNext()) {
                                Element element1= (Element) iterat.next();
                                if (element1.getName().equals("id")) {
                                    block.setId(element1.getStringValue());
//                                System.out.println(block.getId());
                                } else if (element1.getName().equals("genstamp")) {
                                    block.setGenstamp(element1.getStringValue());
                                } else if (element1.getName().equals("numBytes")) {
                                    block.setNumBytes(element1.getStringValue());
                                }
                            }
                        }
                        blocks.add(block);
                        block = null;
                        inode.setBlocks(blocks);
                        blocks = null;
                    } else {
//                        System.out.println(elem.getStringValue());
                        if (elem.getName().equals("id")) {
                            inode.setId(elem.getStringValue());
                        } else if (elem.getName().equals("type")) {
                            inode.setType(elem.getStringValue());
                        } else if (elem.getName().equals("name")) {
                            inode.setName(elem.getStringValue());
                        } else if (elem.getName().equals("replication")) {
                            inode.setReplication(Integer.parseInt(elem.getStringValue()));
                        } else if (elem.getName().equals("mtime")) {
                            inode.setMtime(elem.getStringValue());
                        } else if (elem.getName().equals("atime")) {
                            inode.setAtime(elem.getStringValue());
                        } else if (elem.getName().equals("perferredBlockSize")) {
                            inode.setPerferredBlockSize(elem.getStringValue());
                        } else if (elem.getName().equals("permission")) {
                            inode.setPermission(elem.getStringValue());
                        } else if (elem.getName().equals("nsquota")) {
                            inode.setNsquota(elem.getStringValue());
                        } else if (elem.getName().equals("dsquota")) {
                            inode.setDsquota(elem.getStringValue());
                        }
                    }
                }
                inodes.add(inode);
                inode = null;
            }
        }
        return inodes;
    }
}
