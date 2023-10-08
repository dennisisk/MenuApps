package com.example.hkcze.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import android.widget.Button;
import android.widget.ImageView;

import java.io.FileDescriptor;
import java.io.IOException;


public class AddMenu3 extends AppCompatActivity implements View.OnClickListener {

    ImageView nb;
    ImageView lb;
    private static final int PICK_IMAGE = 100;
    Uri imageUri;
    Button sbs1;
    Button sbs2;
    Button sbs3;
    Button sbs4;
    Button sbs5;
    Button sbs6;
    Button sbs7;
    Button sbs8;
    Button sbs9;
    Button sbs10;
    int count = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu3);

        ImageView lb = (ImageView) findViewById(R.id.lastbutton);
        lb.setOnClickListener(this);
        ImageView nb = (ImageView) findViewById(R.id.nextbutton);
        nb.setOnClickListener(this);

        Button sbs1 = (Button) findViewById(R.id.submitButtonStep1);
        sbs1.setOnClickListener(this);
        Button sbs2 = (Button) findViewById(R.id.submitButtonStep2);
        sbs2.setOnClickListener(this);
        Button sbs3 = (Button) findViewById(R.id.submitButtonStep3);
        sbs3.setOnClickListener(this);
        Button sbs4 = (Button) findViewById(R.id.submitButtonStep4);
        sbs4.setOnClickListener(this);
        Button sbs5 = (Button) findViewById(R.id.submitButtonStep5);
        sbs5.setOnClickListener(this);
        Button sbs6 = (Button) findViewById(R.id.submitButtonStep6);
        sbs6.setOnClickListener(this);
        Button sbs7 = (Button) findViewById(R.id.submitButtonStep7);
        sbs7.setOnClickListener(this);
        Button sbs8 = (Button) findViewById(R.id.submitButtonStep8);
        sbs8.setOnClickListener(this);
        Button sbs9 = (Button) findViewById(R.id.submitButtonStep9);
        sbs9.setOnClickListener(this);
        Button sbs10 = (Button) findViewById(R.id.submitButtonStep10);
        sbs10.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.lastbutton:
                Intent intent = new Intent(this, AddMenu2.class);
                startActivity(intent);
                break;

            case R.id.nextbutton:
                Intent intent2 = new Intent(this, AddMenu4.class);
                startActivity(intent2);
                break;

            case R.id.submitButtonStep1:
                count = 1;
                openGallery();

                break;

            case R.id.submitButtonStep2:
                count = 2;
                openGallery();
                break;

            case R.id.submitButtonStep3:
                count = 3;
                openGallery();
                break;

            case R.id.submitButtonStep4:
                count = 4;
                openGallery();
                break;

            case R.id.submitButtonStep5:
                count = 5;
                openGallery();
                break;

            case R.id.submitButtonStep6:
                count = 6;
                openGallery();
                break;

            case R.id.submitButtonStep7:
                count = 7;
                openGallery();
                break;

            case R.id.submitButtonStep8:
                count = 8;
                openGallery();
                break;

            case R.id.submitButtonStep9:
                count = 9;
                openGallery();
                break;

            case R.id.submitButtonStep10:
                count = 10;
                openGallery();
                break;
        }
    }

    protected void openGallery() {
        Intent gallery = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case PICK_IMAGE:
                if(resultCode==RESULT_OK){
                    Uri uri = data.getData();
                    String[]projection = {MediaStore.Images.Media.DATA};

                    Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
                    cursor.moveToFirst();

                    int columnIndex = cursor.getColumnIndex(projection[0]);
                    String filePath = cursor.getString(columnIndex);
                    cursor.close();


                    Bitmap bmp = null;
                    try {
                        bmp = getBitmapFromUri(uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    switch (count) {
                        case 1:
                            ImageView addmp1 = (ImageView) findViewById(R.id.imageViewStep1);
                            addmp1.setImageBitmap(bmp);
                            break;

                        case 2:
                            ImageView addmp2 = (ImageView) findViewById(R.id.imageViewStep2);
                            addmp2.setImageBitmap(bmp);
                            break;

                        case 3:
                            ImageView addmp3 = (ImageView) findViewById(R.id.imageViewStep3);
                            addmp3.setImageBitmap(bmp);
                            break;

                        case 4:
                            ImageView addmp4 = (ImageView) findViewById(R.id.imageViewStep4);
                            addmp4.setImageBitmap(bmp);
                            break;

                        case 5:
                            ImageView addmp5 = (ImageView) findViewById(R.id.imageViewStep5);
                            addmp5.setImageBitmap(bmp);
                            break;

                        case 6:
                            ImageView addmp6 = (ImageView) findViewById(R.id.imageViewStep6);
                            addmp6.setImageBitmap(bmp);
                            break;

                        case 7:
                            ImageView addmp7 = (ImageView) findViewById(R.id.imageViewStep7);
                            addmp7.setImageBitmap(bmp);
                            break;

                        case 8:
                            ImageView addmp8 = (ImageView) findViewById(R.id.imageViewStep8);
                            addmp8.setImageBitmap(bmp);
                            break;

                        case 9:
                            ImageView addmp9 = (ImageView) findViewById(R.id.imageViewStep9);
                            addmp9.setImageBitmap(bmp);
                            break;

                        case 10:
                            ImageView addmp10 = (ImageView) findViewById(R.id.imageViewStep10);
                            addmp10.setImageBitmap(bmp);
                            break;
                    }
                }

        }
    }

    private Bitmap getBitmapFromUri(Uri uri) throws IOException {
        ParcelFileDescriptor parcelFileDescriptor =
                getContentResolver().openFileDescriptor(uri, "r");
        FileDescriptor fileDescriptor = parcelFileDescriptor.getFileDescriptor();
        Bitmap image = BitmapFactory.decodeFileDescriptor(fileDescriptor);
        parcelFileDescriptor.close();
        return image;
    }

}
