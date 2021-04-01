package com.example.softexpertjava.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.softexpertjava.R;
import com.example.softexpertjava.adapator.CarAdaptor;
import com.example.softexpertjava.databinding.ActivityMainBinding;
import com.example.softexpertjava.model.CarModel;
import com.example.softexpertjava.model.Data;

import java.util.List;

public class MainActivity extends AppCompatActivity   {
ActivityMainBinding activityMainBinding;
CarViewModel carViewModel;
    CarAdaptor myAdapter;
    Boolean isLoading = false;
    Boolean isLastPage = false;
    Boolean isScrolling = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

        activityMainBinding =  DataBindingUtil.setContentView(this,R.layout.activity_main);
        activityMainBinding.progressBar.setVisibility(View.VISIBLE);
        carViewModel =new ViewModelProvider(MainActivity.this).get(CarViewModel.class);
        carViewModel.getPosts();
        carViewModel.posListMutableLiveData.observe(this, new Observer<List<Data>>() {
            @Override
            public void onChanged(List<Data> data) {
                activityMainBinding.progressBar.setVisibility(View.INVISIBLE);

                Log.d("TAGGGGG", "onChanged: "+ data.get(0).getBrand());
                myAdapter = new CarAdaptor(MainActivity.this,data);
                activityMainBinding.carRV.setAdapter(myAdapter);
                activityMainBinding.carRV.addOnScrollListener(new RecyclerView.OnScrollListener() {
                    @Override
                    public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                        super.onScrollStateChanged(recyclerView, newState);
                      LinearLayoutManager layoutMAnager = (LinearLayoutManager) recyclerView.getLayoutManager() ;
                        int lastVisibleItemPosition = layoutMAnager.findLastVisibleItemPosition();
                        int listSize = carViewModel.posListMutableLiveData.getValue().size();
                        if (lastVisibleItemPosition >= (listSize - 6)) {
                            showProgressBar();
                            carViewModel.getPosts();
                            isScrolling = false;
                        }
                    }
                });
            }
        });


    }

    private void showProgressBar() {
        activityMainBinding.progressBar.setVisibility(View.VISIBLE);
        isLoading = true;
    }

    private void hideProgressBar() {
        activityMainBinding.progressBar.setVisibility(View.INVISIBLE);
        isLoading = false;
    }


}
