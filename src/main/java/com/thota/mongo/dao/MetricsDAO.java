package com.thota.mongo.dao;

import java.util.List;

import com.thota.mongo.model.Metrics;

public interface MetricsDAO {
	
	public List<Metrics> getAllMetrics();
	
	public Metrics createMetrics(Metrics metrics);
	
	public List<Metrics> getMetricsByTimeRange(long startTime, long endTime);

	
	

}
