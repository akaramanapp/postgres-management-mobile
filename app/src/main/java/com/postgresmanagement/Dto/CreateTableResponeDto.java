package com.postgresmanagement.Dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CreateTableResponeDto {
    @SerializedName("isSuccess")
    @Expose
    private Boolean isSuccess;

    @SerializedName("errorMessage")
    @Expose
    private String errorMessage;

    public Boolean getSuccess() {
        return isSuccess;
    }

    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
