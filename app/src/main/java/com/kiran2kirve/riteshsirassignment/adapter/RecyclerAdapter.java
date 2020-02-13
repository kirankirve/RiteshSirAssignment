package com.kiran2kirve.riteshsirassignment.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.kiran2kirve.riteshsirassignment.R;
import com.kiran2kirve.riteshsirassignment.models.Result;


import java.util.ArrayList;
import java.util.List;


public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<Result> mResultList = new ArrayList<Result>();
    private Context mContext;


    public RecyclerAdapter(Context context,List<Result> resultList) {
        mResultList=resultList;
        mContext = context;
    }


    public RecyclerAdapter(Context context) {

        mContext = context;
    }

    public void renderList(List<Result> resultList) {
        mResultList.clear();
        mResultList.addAll(resultList);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_listitem, viewGroup, false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((ViewHolder) viewHolder).mTextName.setText(
                mResultList.get(i).getName().getTitle()+". "+
                mResultList.get(i).getName().getFirst()+" "+
                mResultList.get(i).getName().getLast()+"");
        ((ViewHolder) viewHolder).mTextAge.setText(mResultList.get(i).getDob().getAge()+" Years");
        ((ViewHolder) viewHolder).mTextEmail.setText(mResultList.get(i).getEmail()+"");
        ((ViewHolder) viewHolder).mTextPhoneNo.setText(mResultList.get(i).getPhone()+"");
        ((ViewHolder) viewHolder).mTextAddress.setText(
                mResultList.get(i).getLocation().getCity()+", "+
                mResultList.get(i).getLocation().getState()+", "+
                mResultList.get(i).getLocation().getCountry()+", "+
                mResultList.get(i).getLocation().getPostcode()+".");


        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Object strImage=mResultList.get(i).getPicture().getLarge();
        Log.e(""+strImage,"");
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mResultList.get(i).getPicture().getLarge())
                .into(((ViewHolder) viewHolder).mImagePicture);
    }

    @NonNull
    @Override
    public int getItemCount() {
       if (mResultList!= null) {
            return mResultList.size();

        }else
        {
            return 0;
        }

        //return mResultList.size();
    }


    private class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView mImagePicture;
        private TextView mTextName, mTextAge,mTextEmail,mTextPhoneNo,mTextAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mImagePicture = (ImageView) itemView.findViewById(R.id.imagePicture);
            mTextName = (TextView) itemView.findViewById(R.id.textName);
            mTextAge = (TextView) itemView.findViewById(R.id.textAge);
            mTextEmail = (TextView) itemView.findViewById(R.id.textEmail);
            mTextPhoneNo = (TextView) itemView.findViewById(R.id.textPhoneNo);
            mTextAddress = (TextView) itemView.findViewById(R.id.textAddress);

        }
    }
}

