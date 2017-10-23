package com.thota.mongo.controller;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.thota.mongo.model.Metrics;
import com.thota.mongo.service.MetricsService;

import junit.framework.Assert;

@SuppressWarnings("deprecation")
@RunWith(SpringRunner.class)
@WebMvcTest(value = MetricsController.class, secure = false)
public class MetricsControllerTest {

	@Autowired
	private MockMvc mockMvc;
	
	@MockBean
	private MetricsService metricsService;
	List<Metrics> metricsList = new ArrayList<Metrics>();

	@Before
	public void setUp(){
		Metrics mockMetrics1 = new Metrics(22, 120);
		Metrics mockMetrics2 = new Metrics(25, 145);
				metricsList.add(mockMetrics1);
		metricsList.add(mockMetrics2);
	}
	
	
	@Test
	public void testGetMetrics() throws Exception {
		
		Mockito.when(
				metricsService.getMetrics()).thenReturn(metricsList);

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/metrics/read").accept(
				MediaType.APPLICATION_JSON);
		
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		String expected = "[{\"id\":null,\"timeStamp\":22,\"value\":120},{\"id\":null,\"timeStamp\":25,\"value\":145}]";
		
		Assert.assertEquals(expected, result.getResponse().getContentAsString());
		
	}

}
