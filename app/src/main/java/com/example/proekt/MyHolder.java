package com.example.proekt;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    static ImageView mImageView;
    static TextView mTitle;
    static TextView mDes;
    private static ItemClickListener itemClickListener;



    MyHolder(@NonNull View itemView) {
        super(itemView);

        this.mImageView = itemView.findViewById(R.id.ImageIv);
        this.mTitle = itemView.findViewById(R.id.titleIv);
        this.mDes = itemView.findViewById(R.id.descriptionIv);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        this.itemClickListener.onItemClickListener(view, getLayoutPosition());

    }
         public static void setItemClickListener(ItemClickListener ic){

     itemClickListener = ic;
    }
}
