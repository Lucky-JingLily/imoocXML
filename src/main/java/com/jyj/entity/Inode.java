package com.jyj.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @Classname Inode
 * @Description TODO
 * @Date 2019/2/28 16:01
 * @Created by lipeijing
 */
public class Inode {
    private String id;
    private String type;
    private String name;
    private int replication;
    private String mtime;
    private String atime;
    private String perferredBlockSize;
    private String permission;
    private String nsquota;
    private String dsquota;
    private String blockId;
    private String genstamp;
    private String numBytes;


    public String getAtime() {
        return atime;
    }

    public void setAtime(String atime) {
        this.atime = atime;
    }

    public int getReplication() {
        return replication;
    }

    public void setReplication(int replication) {
        this.replication = replication;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMtime() {
        return mtime;
    }

    public void setMtime(String mtime) {
        this.mtime = mtime;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getNsquota() {
        return nsquota;
    }

    public void setNsquota(String nsquota) {
        this.nsquota = nsquota;
    }

    public String getDsquota() {
        return dsquota;
    }

    public void setDsquota(String dsquota) {
        this.dsquota = dsquota;
    }

    public String getPerferredBlockSize() {
        return perferredBlockSize;
    }

    public void setPerferredBlockSize(String perferredBlockSize) {
        this.perferredBlockSize = perferredBlockSize;
    }

    public String getBlockId() {
        return blockId;
    }

    public void setBlockId(String blockId) {
        this.blockId = blockId;
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
