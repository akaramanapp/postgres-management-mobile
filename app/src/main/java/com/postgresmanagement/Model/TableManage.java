package com.postgresmanagement.Model;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableManage {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("tablename")
    @Expose
    private String tablename;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

}