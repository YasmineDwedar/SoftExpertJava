package com.example.softexpertjava.network;

import com.example.softexpertjava.model.CarModel;
import com.example.softexpertjava.model.ErrorResponse;
import com.example.softexpertjava.utils.Constants;
import com.haroldadmin.cnradapter.NetworkResponse;

import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private CarAPI carAPI ;
    private static RetrofitClient INSTANCE ;

    public RetrofitClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Retrofit implements the interface APII
        carAPI = retrofit.create(CarAPI.class);


    }

    public static RetrofitClient getINSTANCE() {
        if(INSTANCE == null){

            INSTANCE = new RetrofitClient();
        }
        return INSTANCE;
    }

    public Call<CarModel> getPosts(int page ){
        return carAPI.getPost(page);
    }

}