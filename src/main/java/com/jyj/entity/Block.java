package com.jyj.entity;

/**
 * @Classname Block
 * @Description TODO
 * @Date 2019/2/28 11:51
 * @Created by lipeijing
 */
public class Block {
    private String id;
    private String genstamp;
    private String numBytes;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGenstamp() {
        return genstamp;
    }

    public void setGenstamp(String genstamp) {
        this.genstamp = genstamp;
    }

    public String getNumBytes() {
        return numBytes;
    }

    public void setNumBytes(String numBytes) {
        this.numBytes = numBytes;
    }
}
