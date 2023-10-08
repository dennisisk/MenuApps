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
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.FileDescriptor;
import java.io.IOException;

public class AddMenu2 extends AppCompatActivity implements View.OnClickListener {

    Button subbpic2;
    Button subbML;
    Button subbMR;
    ImageView addmp2;
    private static final int PICK_IMAGE = 1;
    Uri imageUri;
    TextView textView;
    private LinearLayout LM1;
    private LinearLayout LM2;
    private EditText et;
    ImageView nb;
    ImageView lb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu2);

        Button subbpic2 = (Button) findViewById(R.id.submitbuttonpic2);
        subbpic2.setOnClickListener(this);
        Button subbML = (Button) findViewById(R.id.submitbuttonMaterialLeft);
        subbML.setOnClickListener(this);
        Button subbMR = (Button) findViewById(R.id.submitbuttonMaterialRight);
        subbMR.setOnClickListener(this);
        ImageView addmp2 = (ImageView) findViewById(R.id.addmenupic2);
        LM1 = (LinearLayout) findViewById(R.id.linearMaterial1);
        LM2 = (LinearLayout) findViewById(R.id.linearMaterial2);
        et = (EditText) findViewById(R.id.argue);

        ImageView lb = (ImageView) findViewById(R.id.lastbutton);
        lb.setOnClickListener(this);
        ImageView nb = (ImageView) findViewById(R.id.nextbutton);
        nb.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.submitbuttonpic2:
                openGallery();
                break;

            case R.id.submitbuttonMaterialLeft:
                LM1.addView(createNewTextView(et.getText().toString()));
                et.setText("");
                break;

            case R.id.submitbuttonMaterialRight:
                LM2.addView(createNewTextView(et.getText().toString()));
                et.setText("");
                break;

            case R.id.lastbutton:
                Intent intent = new Intent(this, AddMenu.class);
                startActivity(intent);
                break;

            case R.id.nextbutton:
                Intent intent2 = new Intent(this, AddMenu3.class);
                startActivity(intent2);
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

                    ImageView addmp1 = (ImageView) findViewById(R.id.addmenupic2);
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

    private TextView createNewTextView(String text) {
        final ViewGroup.LayoutParams lparams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        final TextView textView = new TextView(this);
        textView.setTextSize(25);
        textView.setBackgroundResource(R.drawable.border2);
        textView.setLayoutParams(lparams);
        textView.setText(text);
        return textView;
    }
}
