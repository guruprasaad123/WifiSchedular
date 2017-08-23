package com.application;

import java.util.ArrayList;
import java.util.List;
import android.Manifest;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.ContextCompat;
import android.util.Log;
import javafxports.android.FXActivity;

public class AndroidPlatform implements WifiPermission
{

    private static final String KEY_PERMISSIONS              = "permissions";
    private static final String KEY_REQUEST_CODE             = "requestCode";
    private static final int    REQUEST_CODE_ASK_PERMISSIONS = 246;
    private static final int    REQUEST_CODE                 = 123;

    private final FXActivity    activity;

    public AndroidPlatform() 
    {
        activity = FXActivity.getInstance();
    }

    public void checkPermissions() {
        if (Build.VERSION.SDK_INT >= 23) {

            List<String> requiredPermissions = new ArrayList<>();
            addPermission(activity, requiredPermissions , Manifest.permission.CHANGE_WIFI_STATE);
           addPermission(activity, requiredPermissions , Manifest.permission.ACCESS_COARSE_LOCATION);
            //addPermission(activity, requiredPermissions , Manifest.permission.ACCESS_NETWORK_STATE);
            // additional required permissions

            if (!requiredPermissions.isEmpty())
            {
                Intent permIntent = new Intent(activity, PermissionRequestActivity.class);
                permIntent.putExtra(KEY_PERMISSIONS, requiredPermissions.toArray(new String[requiredPermissions .size()]));
                permIntent.putExtra(KEY_REQUEST_CODE, REQUEST_CODE);
                activity.startActivityForResult(permIntent, REQUEST_CODE_ASK_PERMISSIONS);
            }
        }
   
    
    }

    private void addPermission(Activity activity, List<String> permissionsList, String permission) {
        if (ContextCompat.checkSelfPermission(activity, permission) != PackageManager.PERMISSION_GRANTED) {
            permissionsList.add(permission);
        }
    }
    
    public static class PermissionRequestActivity extends Activity {

        @Override
        public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) 
        {
 
        	for(String x :permissions)
        	Log.d(x, " ^^^ permissions  ^^^ ");	
        	
        	FXActivity.getInstance().onRequestPermissionsResult(requestCode, permissions, grantResults);
            
        	finish();
        	
        }

        @Override
        protected void onStart() {
            
        	super.onStart();
            
            String[] permissions = this.getIntent().getStringArrayExtra(KEY_PERMISSIONS);
            
            int requestCode = this.getIntent().getIntExtra(KEY_REQUEST_CODE, 0);

            
            ActivityCompat.requestPermissions(this, permissions, requestCode);
        }
    }

}