package com.example.android.emailimagep;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import static android.R.attr.src;
import static android.R.id.message;
import static android.R.id.primary;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void OnClick(View v) {
        Intent i = new Intent(Intent.ACTION_SEND);

        int imageURI=R.drawable.bluebg;


        i.setType("image/jpg");
        i.putExtra(Intent.EXTRA_STREAM, R.drawable.bluebg);
        i.putExtra(Intent.EXTRA_STREAM, Uri.parse("android.resource://"+getPackageName()+"/"+imageURI));


        try {
            startActivity(Intent.createChooser(i, "Send mail..."));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
        }

    }

}
