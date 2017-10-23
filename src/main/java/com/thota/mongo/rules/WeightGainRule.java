package com.thota.mongo.rules;



import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import com.thota.mongo.dao.impl.AlertsDAOImpl;
import com.thota.mongo.model.Alerts;
import com.thota.mongo.model.Metrics;

@Rule(name = "weight gain rule", description = "if the person gains the weight" )
public class WeightGainRule {
	
	private Alerts alerts = new Alerts();
	private int baseValue = 150;
	private int presentValue;
	
	private AlertsDAOImpl alertsDAOImpl= new AlertsDAOImpl();
	
	public WeightGainRule(){}
	
	public WeightGainRule(Metrics val){
		this.presentValue = val.getValue();
		this.alerts.setTimeStamp(val.getTimeStamp());
		this.alerts.setValue(presentValue);
		this.alerts.setAlertMessage("gained weight more than 10% ");
	}
	
    @Condition
    public boolean when() {
        return presentValue > ((1.1)*baseValue);
    }
    
    @Action
    public void then() {
       alertsDAOImpl.createAlerts(alerts);
    }
}
