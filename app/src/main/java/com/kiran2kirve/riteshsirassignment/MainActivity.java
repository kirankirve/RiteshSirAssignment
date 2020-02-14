package com.kiran2kirve.riteshsirassignment;


import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.kiran2kirve.riteshsirassignment.adapter.RecyclerAdapter;
import com.kiran2kirve.riteshsirassignment.models.Result;

import com.kiran2kirve.riteshsirassignment.viewmodels.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private RecyclerView mRecyclerView;
    private RecyclerAdapter mAdapter;
    private ProgressBar mProgressBar;

    private MainActivityViewModel mMainActivityViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = findViewById(R.id.recyclerView);
        mProgressBar = findViewById(R.id.progress_bar);
        mMainActivityViewModel = ViewModelProviders.of(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init(getApplicationContext());

        showProgressBar();
        initRecyclerView();

        mMainActivityViewModel.getUserResultList().observe(this, new Observer<List<Result>>() {
            @Override
            public void onChanged(@Nullable List<Result> resultList) {
               //
                // mAdapter.renderList(resultList);
                mAdapter.renderList(mMainActivityViewModel.getUserResultList().getValue());
                mAdapter.notifyDataSetChanged();

                hideProgressBar();
            }
        });

        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(@Nullable Boolean aBoolean) {
                if (aBoolean) {
                    showProgressBar();
                } else {
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mMainActivityViewModel.getUserResultList().getValue().size() - 1);
                }
            }
        });
    }

    private void initRecyclerView() {
       //mAdapter = new RecyclerAdapter(this,mMainActivityViewModel.getUserResultList().getValue());
        mAdapter = new RecyclerAdapter(this);
        RecyclerView.LayoutManager linearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void showProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}