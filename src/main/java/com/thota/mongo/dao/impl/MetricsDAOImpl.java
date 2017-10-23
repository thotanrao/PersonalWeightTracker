package com.thota.mongo.dao.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.thota.mongo.dao.MetricsDAO;
import com.thota.mongo.model.Metrics;
@Repository
public class MetricsDAOImpl implements MetricsDAO{
	
	final Morphia morphia = new Morphia();

	//morphia.mapPackage("org.mongodb.morphia.model");

	// create the Datastore connecting to the default port on the local host
	final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
	//datastore.ensureIndexes();

	@Override
	public List<Metrics> getAllMetrics() {
		morphia.mapPackage("com.thota.mongo.model");
		datastore.ensureIndexes();
		final Query<Metrics> query = datastore.createQuery(Metrics.class);
		final List<Metrics> metrics = query.asList();
		// TODO Auto-generated method stub
		return metrics;
	}

	@Override
	public Metrics createMetrics(Metrics metrics) {
		morphia.mapPackage("com.thota.mongo.model");
		datastore.ensureIndexes();
		
		datastore.save(metrics);
		// TODO Auto-generated method stub
		return metrics;
	}

	@Override
	public List<Metrics> getMetricsByTimeRange(long startTime, long endTime) {
		morphia.mapPackage("com.thota.mongo.model");
		datastore.ensureIndexes();
		final Query<Metrics> query = datastore.createQuery(Metrics.class).filter("timeStamp >", startTime).filter("timeStamp <",
				endTime);
		final List<Metrics> metrics = query.asList();
		return metrics;
	}

}
