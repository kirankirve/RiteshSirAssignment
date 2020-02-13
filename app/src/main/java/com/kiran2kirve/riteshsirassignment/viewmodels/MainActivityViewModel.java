package com.kiran2kirve.riteshsirassignment.viewmodels;


import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.kiran2kirve.riteshsirassignment.models.Result;
import com.kiran2kirve.riteshsirassignment.repositories.UserResultRepository;

import java.util.List;

public class MainActivityViewModel extends ViewModel {
    private MutableLiveData<List<Result>> resultList = new MutableLiveData<>();
    private UserResultRepository mRepo;
    private MutableLiveData<Boolean> mIsUpdating = new MutableLiveData<>();
    private Context context;

    public void init(Context cxt) {
        context = cxt;
        mRepo = UserResultRepository.getInstance(context);
        resultList = mRepo.getUserResultList();
    }

    public LiveData<List<Result>> getUserResultList() {
        if (resultList == null) {
            resultList = new MutableLiveData<>();
        }
        return resultList;
    }

    public LiveData<Boolean> getIsUpdating() {
        return mIsUpdating;
    }


}
