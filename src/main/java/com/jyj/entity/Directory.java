package com.jyj.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Classname Inode
 * @Description TODO
 * @Date 2019/2/28 11:47
 * @Created by lipeijing
 */
public class Directory {
    private String parent;
    private ArrayList<String> inodes = new ArrayList<String>();

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public List<String> getInodes() {
        return inodes;
    }

    public void setInodes(List<String> inodes) {
        for (int i = 0; i < inodes.size(); i++) {
            this.inodes.add(inodes.get(i));
        }
    }
}
