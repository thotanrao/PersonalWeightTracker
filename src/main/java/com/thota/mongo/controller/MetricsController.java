package com.thota.mongo.controller;

import java.util.List;

import org.easyrules.api.RulesEngine;
import org.easyrules.core.RulesEngineBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.thota.mongo.model.Metrics;
import com.thota.mongo.rules.WeightGainRule;
import com.thota.mongo.rules.WeightLossRule;
import com.thota.mongo.service.MetricsService;

@RestController
public class MetricsController {
	
	@Autowired
	private MetricsService  metricsService;
	
	@GetMapping("/metrics/read")
	public List<Metrics> getMetrics (){
		return metricsService.getMetrics();
	}
	@PostMapping("/metrics/create")
	public Metrics createMetrics (@RequestBody Metrics metrics){
		 metricsService.createMetrics(metrics);
		
		RulesEngine rulesEngine = RulesEngineBuilder.aNewRulesEngine().build(); 
		rulesEngine.registerRule(new WeightGainRule(metrics));
		rulesEngine.registerRule(new WeightLossRule(metrics));
		rulesEngine.fireRules();

		return metrics;
	}
	
	
	@GetMapping("/metrics/readByRange/{startTime}/{endTime}")
	public List<Metrics>  getMetricsByTimeRange(@PathVariable long startTime, @PathVariable long endTime){
		return metricsService.getMetricsByTimeRange(startTime, endTime);
	}
	
}
