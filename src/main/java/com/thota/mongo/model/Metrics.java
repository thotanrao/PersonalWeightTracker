package com.thota.mongo.model;

import org.bson.types.ObjectId;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

@Entity("metrics")
public class Metrics {
	@Id
    private ObjectId id;
	public Metrics(){}
    private long timeStamp;
	private int value;
    
    public Metrics(long timeStamp, int value) {
		 this.timeStamp = timeStamp;
		 this.value = value;
	}
	public long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}

	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}

}
