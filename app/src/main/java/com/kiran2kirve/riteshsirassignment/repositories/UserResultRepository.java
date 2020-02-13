package com.kiran2kirve.riteshsirassignment.repositories;


import android.content.Context;

import androidx.lifecycle.MutableLiveData;

import com.kiran2kirve.riteshsirassignment.models.Result;

import com.kiran2kirve.riteshsirassignment.models.UserResult;
import com.kiran2kirve.riteshsirassignment.network.NetworkClient;
import com.kiran2kirve.riteshsirassignment.network.NetworkInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//Singletone Pattern
public class UserResultRepository {
    private static UserResultRepository instance;
    private ArrayList<Result> dataSet = new ArrayList<>();
    private NetworkInterface userResultApi;

    public static UserResultRepository getInstance(Context cxt) {
        if (instance == null) {
            instance = new UserResultRepository();
        }
        return instance;
    }

    public UserResultRepository() {
        userResultApi = NetworkClient.createService(NetworkInterface.class);
    }

    public MutableLiveData<List<Result>> getUserResultList() {
        MutableLiveData<List<Result>> userResultsData = new MutableLiveData<>();
        userResultApi.fetchUserListRequestApi().enqueue(new Callback<UserResult>() {
            @Override
            public void onResponse(Call<UserResult> call,
                                   Response<UserResult> response) {
                if (response.isSuccessful()) {
                    UserResult userResult = (UserResult) response.body();
                    dataSet = (ArrayList<Result>) userResult.getResults();
                    userResultsData.setValue(dataSet);
                }
            }

            @Override
            public void onFailure(Call<UserResult> call, Throwable t) {
                userResultsData.setValue(null);

            }
        });
        return userResultsData;
    }
}
