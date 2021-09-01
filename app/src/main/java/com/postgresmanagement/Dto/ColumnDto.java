package com.postgresmanagement.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ColumnDto {
    @SerializedName("columnName")
    @Expose
    private String columnName;

    @SerializedName("columnType")
    @Expose
    private String columnType;

    @SerializedName("nullable")
    @Expose
    private Boolean nullable;

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getColumnType() {
        return columnType;
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }

    public Boolean getNullable() {
        return nullable;
    }

    public void setNullable(Boolean nullable) {
        this.nullable = nullable;
    }
}
