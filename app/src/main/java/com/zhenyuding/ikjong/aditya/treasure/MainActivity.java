package com.zhenyuding.ikjong.aditya.treasure;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

/*
Camera code from: https://developer.android.com/training/camera/photobasics.html
 */

public class MainActivity extends AppCompatActivity {

    static final int REQUEST_IMAGE_CAPTURE = 1;

    TessOCR mOcr;

    static {
        //System.loadLibrary("png");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "onCreate called");
        mOcr = new TessOCR(this, "eng");

        Button button = findViewById(R.id.button_takepic);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* //TODO: reactivate camera
                //activate camera here
                Intent takePhotoIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(takePhotoIntent.resolveActivity(getPackageManager()) != null)
                {
                    startActivityForResult(takePhotoIntent, REQUEST_IMAGE_CAPTURE);
                }
                */
                Log.d("MainActivity", "Clicked!");
                Bitmap pncCard = ((BitmapDrawable)(getResources().getDrawable(R.drawable.pnc_bizcard))).getBitmap();
                String ocrOutput = mOcr.getOCRResult(pncCard);
                Log.i("MainActivity", ocrOutput);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK)
        {
            //runs after image is taken
            Bundle extras = data.getExtras();
            Bitmap photo = (Bitmap)extras.get("data"); //TODO: support photo cropping
            //OCR testing code lies ahead:
            String ocrOutput = mOcr.getOCRResult(photo);
            System.out.println(ocrOutput);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mOcr.onDestroy();
    }
}
