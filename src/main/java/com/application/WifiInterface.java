package com.application;

public interface WifiInterface
{

    public abstract boolean isTurnedOn();

    public abstract boolean turnOn();

    public abstract boolean turnOff();
    
    public abstract void checkPermission();
}

