package com.yaoyao.testall.zxing;

import android.Manifest;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v4.app.ActivityCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.yaoyao.testall.R;
import com.yaoyao.testall.activity.ShowActivity;
import com.yaoyao.testall.activity.WebActivity;
import com.yaoyao.testall.app.AppManager;
import com.yaoyao.testall.base.BaseActivity;

import cn.bingoogolapple.qrcode.core.QRCodeView;
import cn.bingoogolapple.qrcode.zxing.ZXingView;
import permissions.dispatcher.NeedsPermission;

/**
 * 扫码
 * Created by zst on 2017/6/6.
 */

public class ScanCodeActivity extends BaseActivity implements QRCodeView.Delegate {
    private static final int REQUEST_CODE_CAMERA = 999;
    private static final String TAG = "msg";

    private QRCodeView mQRCodeView;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scan_code);

        mQRCodeView = (ZXingView) findViewById(R.id.zxingview);
        mQRCodeView.setDelegate(this);

        Log.e(TAG, "扫码:01");
    }

    @Override
    public void inidata() {

    }

    @Override
    public void setCon() {

    }

    @Override
    public void iniview() {

    }

    @Override
    public void setview() {

    }

    @NeedsPermission(Manifest.permission.CAMERA)
    @Override
    protected void onStart() {
        super.onStart();
        mQRCodeView.startCamera();
//        mQRCodeView.startCamera(Camera.CameraInfo.CAMERA_FACING_FRONT);
        mQRCodeView.startSpot();

        Log.e(TAG, "扫码:02");
    }

    @Override
    protected void onStop() {
        mQRCodeView.stopCamera();
        super.onStop();

        Log.e(TAG, "扫码:03");
    }

    @Override
    protected void onDestroy() {
        mQRCodeView.onDestroy();
        super.onDestroy();
        Log.e(TAG, "扫码:04");
    }

    //震动器
    private void vibrate() {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        vibrator.vibrate(100);

        Log.e(TAG, "扫码:05");
    }

    @Override
    public void onScanQRCodeSuccess(String result) {
        Log.i(TAG, "result:" + result);
        //Toast.makeText(this, result, Toast.LENGTH_SHORT).show();
        vibrate();//震动
        mQRCodeView.stopSpot();

        if (!TextUtils.isEmpty(result)) {
            mQRCodeView.stopCamera();
            mQRCodeView.onDestroy();
            Log.e(TAG, "onScanQRCodeSuccess: 转跳"+result );
            Bundle bundle = new Bundle();
            bundle.putString("url",result);
            bundle.putString("title","扫描结果");
            if (result.contains("http:")||result.contains("https:")){

                AppManager.getAppManager().ToOtherActivity(WebActivity.class,bundle);
                AppManager.getAppManager().finishActivity();
            }else {
                AppManager.getAppManager().ToOtherActivity(ShowActivity.class,bundle);
                AppManager.getAppManager().finishActivity();
            }

//            Intent intent = new Intent(ScanCodeActivity.this, ServiceManagerDianZhuNewActivity.class);
//            intent.putExtra("url", result);
//            //intent.setData(Uri.parse(result));
//            startActivity(intent);
//            finish();
        } else {
            Toast.makeText(this, "链接无效,请重新扫描", Toast.LENGTH_SHORT).show();
            mQRCodeView.startSpot();
        }
        Log.e(TAG, "扫码:06");
    }

    @Override
    public void onScanQRCodeOpenCameraError() {
        Log.e(TAG, "无相机权限,打开相机出错");

        ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CAMERA}, REQUEST_CODE_CAMERA);
        Log.e(TAG, "扫码:07");
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.start_spot:
                mQRCodeView.startSpot();
                break;
            case R.id.stop_spot:
                mQRCodeView.stopSpot();
                break;
            case R.id.open_flashlight:
                mQRCodeView.openFlashlight();
                break;
            case R.id.close_flashlight:
                mQRCodeView.closeFlashlight();
                break;
            case R.id.rl_back:
                //onDestroy();
                mQRCodeView.stopCamera();
                mQRCodeView.onDestroy();
                finish();
                break;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == REQUEST_CODE_CAMERA) {
            mQRCodeView.startCamera();
            mQRCodeView.startSpot();
        }
    }
}