package com.thota.mongo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.thota.mongo.model.Alerts;
import com.thota.mongo.service.AlertsService;

@RestController
public class AlertsController {
	
	@Autowired
	private AlertsService  alertsService;
	
	@GetMapping("/alerts/read")
	public List<Alerts> getAlerts (){
		List<Alerts> list = alertsService.getAlerts();
		return list;
	}

	@GetMapping("/alerts/readByRange/{startTime}/{endTime}")
	public List<Alerts>  getMetricsByTimeRange(@PathVariable long startTime, @PathVariable long endTime){
		return alertsService.getAlertsByTimeRange(startTime, endTime);
	}
}
