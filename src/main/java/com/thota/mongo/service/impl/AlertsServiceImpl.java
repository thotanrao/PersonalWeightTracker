package com.thota.mongo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thota.mongo.dao.AlertsDAO;
import com.thota.mongo.model.Alerts;
import com.thota.mongo.service.AlertsService;

@Service
public class AlertsServiceImpl implements AlertsService{
	
	@Autowired
	private AlertsDAO alertsDAO;
	
	@Override
	public List<Alerts> getAlerts() {
		return alertsDAO.getAllAlerts();
		
	}

	@Override
	public Alerts createAlerts(Alerts alerts) {
		return alertsDAO.createAlerts(alerts);
	}
	@Override
	public List<Alerts> getAlertsByTimeRange(long startTime, long endTime) {
		return alertsDAO.getAlertsByTimeRange( startTime,  endTime);
	}



}
