package com.thota.mongo.service;

import java.util.List;

import com.thota.mongo.model.Metrics;

public interface MetricsService {
	
	public List<Metrics> getMetrics();
	public Metrics createMetrics(Metrics metrics);
	public List<Metrics> getMetricsByTimeRange(long startTime, long endTime);

}
