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


public class AddMenu extends AppCompatActivity implements View.OnClickListener{

    ImageView tb;
    ImageView nb;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    Button subbpic1;
    ImageView addmp1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        ImageView tb = (ImageView) findViewById(R.id.turnback);
        tb.setOnClickListener(this);
        ImageView nb = (ImageView) findViewById(R.id.nextbutton);
        nb.setOnClickListener(this);

        Button subbpic1 = (Button) findViewById(R.id.submitbuttonpic1);
        subbpic1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.submitbuttonpic1:
                openGallery();
                break;

            case R.id.turnback:
                Intent intent = new Intent(this, CookingMenuHomePage.class);
                startActivity(intent);
                break;
            case R.id.nextbutton:
                Intent intent2 = new Intent(this, AddMenu2.class);
                startActivity(intent2);
                break;

            default:
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

                    ImageView addmp1 = (ImageView) findViewById(R.id.addmenupic1);
                    Bitmap bmp = null;
                    try {
                        bmp = getBitmapFromUri(uri);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    addmp1.setImageBitmap(bmp);
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
