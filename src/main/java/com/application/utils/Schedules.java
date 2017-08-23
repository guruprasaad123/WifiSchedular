package com.application.utils;

import java.time.LocalDate;
import java.time.LocalTime;

public class Schedules {
	
	public enum State{
		ON,OFF
	}

	LocalTime start;
	LocalTime end;
	State state;
	
	
	public Schedules(LocalTime start,LocalTime end,State state)
	{
	this.start=start;
	this.end=end;
	this.state=state;
	
	}
	
	public LocalTime getStart() {
		return start;
	}
	public void setStart(LocalTime start) {
		this.start = start;
	}
	public LocalTime getEnd() {
		return end;
	}
	public void setEnd(LocalTime end) {
		this.end = end;
	}
	public State getState() {
		return state;
	}
	public void setState(State state) {
		this.state = state;
	}
	
	public String getStartTime()
	{
		return start.getHour()+":"+start.getMinute();
	}
	
	public String getEndTime()
	{
		return end.getHour()+":"+end.getMinute();
	}
	
	
}
