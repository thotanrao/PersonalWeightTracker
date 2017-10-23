package com.thota.mongo.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.thota.mongo.dao.MetricsDAO;
import com.thota.mongo.model.Metrics;
import com.thota.mongo.service.MetricsService;
@Service
public class MerticsServiceImpl implements MetricsService{

	@Autowired
	private MetricsDAO metricsDAO;
	@Override
	public List<Metrics> getMetrics() {
		// TODO Auto-generated method stub
		return metricsDAO.getAllMetrics();
		
	}

	@Override
	public Metrics createMetrics(Metrics metrics) {
		// TODO Auto-generated method stub
		return metricsDAO.createMetrics(metrics);
	}

	@Override
	public List<Metrics> getMetricsByTimeRange(long startTime, long endTime) {
		return metricsDAO.getMetricsByTimeRange( startTime,  endTime);
	}

}
