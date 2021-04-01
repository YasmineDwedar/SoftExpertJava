package com.example.softexpertjava.ui;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.softexpertjava.model.CarModel;
import com.example.softexpertjava.model.Data;
import com.example.softexpertjava.network.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CarViewModel extends ViewModel {
    MutableLiveData<ArrayList<Data>> posListMutableLiveData = new MutableLiveData<>();
    int page=1;
    CarModel carModel;

    public void getPosts(){

        RetrofitClient.getINSTANCE().getPosts(1).enqueue(new Callback<CarModel>() {
            @Override
            public void onResponse(Call<CarModel> call, Response<CarModel> response) {
//                posListMutableLiveData.setValue(response.body().getData());


                page++;
                //first network call
                if (carModel == null) {
                    carModel = response.body();
                    posListMutableLiveData.postValue(response.body().getData());
                } else {
                    ArrayList<Data> oldMovies = carModel.getData();
                    ArrayList<Data> newMovies = response.body().getData();
                    oldMovies.addAll(newMovies);
                    posListMutableLiveData.postValue(oldMovies) ;
                }

            }

            @Override
            public void onFailure(Call<CarModel> call, Throwable t) {

            }
        });


    }

}
