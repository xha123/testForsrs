package com.yaoyao.testall.zxing;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

import com.yaoyao.testall.R;
import com.yaoyao.testall.base.BaseActivity;

import java.io.File;

/**
 * Created by Administrator on 2017/9/29.
 */

public class ShengCodeActivity extends BaseActivity{



    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {
        setContentView(R.layout.activity_sheng);
    }

    @Override
    public void iniview() {
//内容
        final EditText contentET = (EditText) findViewById(R.id.sheng_ed);
        //显示二维码图片
        final ImageView imageView = (ImageView) findViewById(R.id.sheng_iv);
        //是否添加Logo
        final CheckBox addLogoCB = (CheckBox) findViewById(R.id.sheng_check);
        Button createQrBtn = (Button) findViewById(R.id.sheng_button);

        createQrBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final String filePath = getFileRoot(ShengCodeActivity.this) + File.separator
                        + "qr_" + System.currentTimeMillis() + ".jpg";

                //二维码图片较大时，生成图片、保存文件的时间可能较长，因此放在新线程中
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        boolean success = QRCodeUtil.createQRImage(contentET.getText().toString().trim(), 800, 800,
                                addLogoCB.isChecked() ? BitmapFactory.decodeResource(getResources(), R.mipmap.qr_logo) : null,
                                filePath);

                        if (success) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    imageView.setImageBitmap(BitmapFactory.decodeFile(filePath));
                                }
                            });
                        }
                    }
                }).start();

            }
        });
    }

    //文件存储根目录
    private String getFileRoot(Context context) {
        if (Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED)) {
            File external = context.getExternalFilesDir(null);
            if (external != null) {
                return external.getAbsolutePath();
            }
        }

        return context.getFilesDir().getAbsolutePath();
    }

    @Override
    public void setview() {

    }
}
