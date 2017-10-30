package com.yaoyao.testall.ucrop;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.yalantis.ucrop.UCrop;
import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

import java.io.File;
import java.io.IOException;

/**
 * Created by Administrator on 2017/9/18.
 */

public class UcropActivity extends BaseActivity {
    ImageView imageView;


    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_ucrop);
    }

    @Override
    public void iniview() {
        imageView = (ImageView) findViewById(R.id.ucrop_img);
        imageView.setImageResource(R.mipmap.uc4);
    }

    @Override
    public void setview() {
        findViewById(R.id.ucrop_bu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openKK();
            }
        });
    }

    private void openKK() {
        Intent intent = new Intent(Intent.ACTION_PICK, null);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        startActivityForResult(intent,111);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode==111){
            if (data.getData()==null){
                return;
            }
            Log.e(TAG, "onActivityResult:相册 " + data.getData().toString());
            ContentResolver resolver = getContentResolver();

            try {
//                InputStream inputStream = resolver.openInputStream(data.getData());
//
//                Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
//
//                imageView.setImageBitmap(bitmap);
                Uri uri = Uri.parse(data.getData().toString());
                Uri destinationUri = Uri.fromFile(new File(getCacheDir(), "SampleCropImage.jpeg"));
                UCrop.of(uri,destinationUri)
                        .withAspectRatio(4,3)
                        .withMaxResultSize(800,800)
                        .start(UcropActivity.this);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (requestCode == UCrop.REQUEST_CROP){
            final Uri resultUri = UCrop.getOutput(data);
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), resultUri);
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
