package com.thota.mongo.dao.impl;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Repository;

import com.mongodb.MongoClient;
import com.thota.mongo.dao.AlertsDAO;
import com.thota.mongo.model.Alerts;

@Repository
public class AlertsDAOImpl implements AlertsDAO{
	
	final Morphia morphia = new Morphia();

	//morphia.mapPackage("org.mongodb.morphia.model");

	// create the Datastore connecting to the default port on the local host
	final Datastore datastore = morphia.createDatastore(new MongoClient(), "morphia_example");
	//datastore.ensureIndexes();

	@Override
	public List<Alerts> getAllAlerts() {
		morphia.mapPackage("com.thota.mongo.model");
		datastore.ensureIndexes();
		final Query<Alerts> query = datastore.createQuery(Alerts.class);
		final List<Alerts> alerts = query.asList();
		return alerts;
	}

	@Override
	public Alerts createAlerts(Alerts alerts) {
		
		morphia.mapPackage("com.thota.mongo.model");
		datastore.ensureIndexes();
		
		datastore.save(alerts);
		// TODO Auto-generated method stub
		return alerts;
	}
	
	@Override
	public List<Alerts> getAlertsByTimeRange(long startTime, long endTime) {
		morphia.mapPackage("com.thota.mongo.model");
		datastore.ensureIndexes();
		final Query<Alerts> query = datastore.createQuery(Alerts.class).filter("timeStamp >", startTime).filter("timeStamp <",
				endTime);
		final List<Alerts> alerts = query.asList();
		return alerts;
	}


}
