package com.application;

public class AndroidNative implements NativePlatform{

	public WifiController controller;
	
	@Override
	public WifiInterface getWifiController() {
		
		controller=new WifiController();
		return controller;
	}

}
