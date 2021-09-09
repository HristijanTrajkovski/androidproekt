package com.example.proekt;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<MyHolder> {
    Context c;
    ArrayList<model> models;

    public Adapter(Context c, ArrayList<model> models) {
        this.c = c;
        this.models = models;
    }

    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

       View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row,null);
        return new MyHolder(view);



    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
        MyHolder.mTitle.setText((CharSequence) models.get(position).getTitle());
        MyHolder.mDes.setText(models.get(position).getDescription());
        MyHolder.mImageView.setImageResource(models.get(position).getImg());

      MyHolder.setItemClickListener (new ItemClickListener() {
            @Override
            public void onItemClickListener(View v, int position) {
                String gTitle = models.get(position).getTitle();
                String gDesc = models.get(position).getDescription();
                BitmapDrawable bitmapDrawable = (BitmapDrawable) MyHolder.mImageView.getDrawable();

                Bitmap bitmap = bitmapDrawable.getBitmap();

                ByteArrayOutputStream stream = new ByteArrayOutputStream();

                bitmap.compress(Bitmap.CompressFormat.PNG, 100,stream);
                byte [] bytes = stream.toByteArray();

                Intent intent = new Intent(c,ViewActivity.class);
                intent.putExtra("iTitle", gTitle);
                intent.putExtra("iDesc", gDesc);
                intent.putExtra("iImage", bytes);

                c.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return models.size();
    }
}
