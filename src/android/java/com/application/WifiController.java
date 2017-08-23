package com.application;

import android.content.Context;
import android.net.wifi.WifiManager;
import android.os.Parcel;
import android.os.Parcelable;
import javafxports.android.FXActivity;

// Referenced classes of package com.sample:
//            WifiInterface
@SuppressWarnings("serial")
public class WifiController  implements WifiInterface, Parcelable { 
	 private WifiManager wifiManager;


	   
	   public  WifiController()
   {
        wifiManager = (WifiManager)FXActivity.getInstance().getSystemService(Context.WIFI_SERVICE);
        
    }

   public  WifiManager getWifimanager()
    {
        return wifiManager;
    }

    public boolean isTurnedOn()
    {
        return wifiManager.isWifiEnabled();
    }

    public boolean turnOn()
    {
    	
       return wifiManager.setWifiEnabled(true);
        //return true;
    }

    public boolean turnOff()
    {
        return wifiManager.setWifiEnabled(false);
       // return true;
    }

   public  void checkPermission()
    {
    	new AndroidPlatform().checkPermissions();
    }


    protected WifiController(Parcel in) {
        wifiManager = (WifiManager) in.readValue(WifiManager.class.getClassLoader());
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(wifiManager);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<WifiController> CREATOR = new Parcelable.Creator<WifiController>() {
        @Override
        public WifiController createFromParcel(Parcel in) {
            return new WifiController(in);
        }

        @Override
        public WifiController[] newArray(int size) {
            return new WifiController[size];
        }
    };
}