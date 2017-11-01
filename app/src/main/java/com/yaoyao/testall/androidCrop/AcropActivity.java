package com.yaoyao.testall.androidCrop;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.soundcloud.android.crop.Crop;
import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

import java.io.File;

/**
 * Created by Administrator on 2017/10/31.
 */

public class AcropActivity extends BaseActivity{
    ImageView showimg;

    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_acrop);
    }

    @Override
    public void iniview() {
        showimg = (ImageView) findViewById(R.id.acrop_img);
    }

    @Override
    public void setview() {
        findViewById(R.id.acrop_one).setOnClickListener(new View.OnClickListener() {
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
                Crop.of(uri,destinationUri).asSquare().start(AcropActivity.this);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if (requestCode == Crop.REQUEST_CROP){
            Log.e(TAG, "onActivityResult: 裁剪成功" );
            handleCrop(resultCode, data);
        }
    }

    private void handleCrop(int resultCode, Intent result) {
        if (resultCode == RESULT_OK) {
            showimg.setImageURI(Crop.getOutput(result));
        } else if (resultCode == Crop.RESULT_ERROR) {
            Toast.makeText(this, Crop.getError(result).getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}
