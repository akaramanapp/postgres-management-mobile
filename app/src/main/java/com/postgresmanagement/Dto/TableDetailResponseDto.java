package com.postgresmanagement.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TableDetailResponseDto {
    @SerializedName("columnname")
    @Expose
    private String columnname;

    @SerializedName("columntype")
    @Expose
    private String columntype;

    public String getColumnname() {
        return columnname;
    }

    public void setColumnname(String columnname) {
        this.columnname = columnname;
    }

    public String getColumntype() {
        return columntype;
    }

    public void setColumntype(String columntype) {
        this.columntype = columntype;
    }
}
