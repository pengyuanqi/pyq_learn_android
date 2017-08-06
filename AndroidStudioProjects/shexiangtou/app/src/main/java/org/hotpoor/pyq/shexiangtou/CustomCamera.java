package org.hotpoor.pyq.shexiangtou;

import android.app.Activity;
import android.content.Intent;
import android.graphics.ImageFormat;
import android.hardware.Camera;
import android.os.Bundle;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class CustomCamera extends Activity implements SurfaceHolder.Callback{

    private Camera mCamera;
    private SurfaceView mPreview;
    private SurfaceHolder mHolder;
    private Camera.PictureCallback mPictureCallback = new Camera.PictureCallback() {
        @Override
        public void onPictureTaken(byte[] data, Camera camera) {
            Long time_now = new Date().getTime();
            File tempFile = new File("/sdcard/pyq_dev/"+time_now+".png");
            try {
                FileOutputStream fos = new FileOutputStream(tempFile);
                fos.write(data);
                fos.close();
                Intent intent = new Intent(CustomCamera.this,ResultAty.class);
                intent.putExtra("picPath",tempFile.getAbsolutePath());
                System.out.println(tempFile.getAbsolutePath());
                startActivity(intent);
                CustomCamera.this.finish();
                System.out.println("picPath");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("error1");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("error2");
            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom);
        mPreview=(SurfaceView)findViewById(R.id.preview);
        mHolder=mPreview.getHolder();
        mHolder.addCallback(this);
    }
    public void  capture(View view){
        Camera.Parameters parameters = mCamera.getParameters();
        parameters.setPictureFormat(ImageFormat.JPEG);
        parameters.setPreviewSize(1920,1080);
        parameters.setFocusMode(Camera.Parameters.FOCUS_MODE_AUTO);
        mCamera.autoFocus(new Camera.AutoFocusCallback() {
            @Override
            public void onAutoFocus(boolean success, Camera camera) {
                if (success){
                    mCamera.takePicture(null,null,mPictureCallback);
                }
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        if(mCamera==null){
            mCamera=getCamera();
            if(mHolder !=null){
                setStartPreview(mCamera,mHolder);
            }
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        releaseCamera();
    }

    private Camera getCamera(){
        Camera camera;
        try {
            camera = Camera.open();
        }catch (Exception e) {
            camera=null;
            e.printStackTrace();
        }
        return camera;
    }

    private void setStartPreview(Camera camera,SurfaceHolder holder){
        try {
            camera.setPreviewDisplay(holder);
            camera.setDisplayOrientation(90);
            camera.startPreview();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void releaseCamera(){
        if (mCamera !=null){
            mCamera.setPreviewCallback(null);
            mCamera.startPreview();
            mCamera.release();
            mCamera=null;
        }
    }

    @Override
    public  void surfaceCreated(SurfaceHolder holder){
        setStartPreview(mCamera,mHolder);
    }

    @Override
    public  void  surfaceChanged(SurfaceHolder holder,int format,int width,int height){
        mCamera.stopPreview();
        setStartPreview(mCamera,mHolder);
    }

    @Override
    public  void  surfaceDestroyed(SurfaceHolder holder){
        releaseCamera();
    }
}
