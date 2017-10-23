package com.thota.mongo.dao;

import java.util.List;

import com.thota.mongo.model.Alerts;


public interface AlertsDAO {
	
public List<Alerts> getAllAlerts();
	
	public Alerts createAlerts(Alerts alerts);
	
	public List<Alerts> getAlertsByTimeRange(long startTime, long endTime);
	
	

}
