package com.example.softexpertjava.network;

import com.example.softexpertjava.model.CarModel;
import com.example.softexpertjava.model.ErrorResponse;
import com.example.softexpertjava.utils.Constants;
import com.haroldadmin.cnradapter.NetworkResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;



    public interface CarAPI {
        @GET(Constants.cars)
         Call<CarModel>getPost(@Query("page") int  page );

    }

