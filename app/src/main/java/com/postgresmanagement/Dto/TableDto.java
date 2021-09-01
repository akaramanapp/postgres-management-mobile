package com.postgresmanagement.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TableDto {
    @SerializedName("tableName")
    @Expose
    private String tableName;

    @SerializedName("columns")
    @Expose
    private List<ColumnDto> columns;

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public List<ColumnDto> getColumns() {
        return columns;
    }

    public void setColumns(List<ColumnDto> columns) {
        this.columns = columns;
    }
}
