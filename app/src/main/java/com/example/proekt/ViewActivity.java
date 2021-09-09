package com.example.proekt;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewActivity extends AppCompatActivity {

    TextView mTitleView, mDescView;
    ImageView mImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);


        ActionBar actionBar = getSupportActionBar();

        mTitleView = findViewById(R.id.titleView);
        mDescView = findViewById(R.id.descriptionView);
        mImageView = findViewById(R.id.ImageView);


        Intent intent = getIntent();

        String mTitle = intent.getStringExtra("iTitle");
        String mDescription = intent.getStringExtra("iDesc");

        byte [] mBytes = getIntent().getByteArrayExtra("iImage");

        Bitmap bitmap = BitmapFactory.decodeByteArray(mBytes, 0, mBytes.length);

        actionBar.setTitle(mTitle);

        mTitleView.setText(mTitle);
        mDescView.setText(mDescription);
        mImageView.setImageBitmap(bitmap);



    }
}