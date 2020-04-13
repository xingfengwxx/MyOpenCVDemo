package com.wangxingxing.myopencvdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import org.opencv.android.BaseLoaderCallback;
import org.opencv.android.OpenCVLoader;
import org.opencv.android.Utils;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private ImageView mImageView;

    private Bitmap mSrcBitmap;
    private Bitmap mGrayBitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mImageView = findViewById(R.id.imageView);
    }

    @Override
    protected void onResume() {
        super.onResume();
        OpenCVLoader.initAsync(OpenCVLoader.OPENCV_VERSION_3_2_0, getApplicationContext(), mLoaderCallback);
    }

    private BaseLoaderCallback mLoaderCallback = new BaseLoaderCallback(this) {
        @Override
        public void onManagerConnected(int status) {
            switch (status) {
                case BaseLoaderCallback.SUCCESS:
                    Log.i(TAG, "加载OpenCV成功");
                    break;
                default:
                    super.onManagerConnected(status);
                    Log.e(TAG, "加载OpenCV失败");
                    break;
            }
        }
    };

    public void toGray(View view) {
        Mat rgbMat = new Mat();
        Mat grayMat = new Mat();
        mSrcBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.pic_bizhi_1);
        mGrayBitmap = Bitmap.createBitmap(mSrcBitmap.getWidth(), mSrcBitmap.getHeight(), Bitmap.Config.RGB_565);
        //convert original bitmap to Mat, R G B.
        Utils.bitmapToMat(mSrcBitmap, rgbMat);
        Imgproc.cvtColor(rgbMat, grayMat, Imgproc.COLOR_RGB2GRAY);
        Utils.matToBitmap(grayMat, mGrayBitmap);
        Log.i(TAG, "转成灰度图成功");

        mImageView.setImageBitmap(mGrayBitmap);
    }

    public void toReset(View view) {
        mImageView.setImageBitmap(mSrcBitmap);
    }
}
