package com.postgresmanagement.Service;

import com.postgresmanagement.Dto.ColumnDto;
import com.postgresmanagement.Dto.CreateTableResponeDto;
import com.postgresmanagement.Dto.TableDetailResponseDto;
import com.postgresmanagement.Dto.TableDto;
import com.postgresmanagement.Model.TableManage;

import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface Services {
    @GET("table")
    Call<List<TableManage>> getTable();

    @POST("table")
    Call<CreateTableResponeDto> postTable(@Body TableDto table);

    @GET("column/{id}")
    Call<ArrayList<TableDetailResponseDto>> getColumn(@Path("id") String id);

    @DELETE("table/{id}")
    Call<Void> deleteTable(@Path("id") String id);
}
