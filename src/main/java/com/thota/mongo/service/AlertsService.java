package com.thota.mongo.service;

import java.util.List;

import com.thota.mongo.model.Alerts;


public interface AlertsService {
	
	public List<Alerts> getAlerts();
	public Alerts createAlerts(Alerts alerts);
	public List<Alerts> getAlertsByTimeRange(long startTime, long endTime);
	

}
