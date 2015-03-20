package com.vizuri.insurance.rest.brms;

import org.jboss.logging.Logger;
import org.kie.api.definition.rule.Rule;
import org.kie.api.event.rule.ObjectDeletedEvent;
import org.kie.api.event.rule.ObjectInsertedEvent;
import org.kie.api.event.rule.ObjectUpdatedEvent;
import org.kie.api.event.rule.RuleRuntimeEventListener;



public class RuleListener implements RuleRuntimeEventListener{
	private static final Logger log = Logger.getLogger(RuleListener.class);
	
	public void objectInserted(ObjectInsertedEvent event) {
		log.info("objectInserted");
		System.out.println("objectInserted");
		Object factObject = event.getObject();
	//	log.info("event.getPropagationContext().getRule(); : "+event.getPropagationContext().getRule());
		Rule ruleFired = event.getPropagationContext().getRule();
	
	}

	public void objectUpdated(ObjectUpdatedEvent event) {
		// TODO Auto-generated method stub
		
	}

	public void objectDeleted(ObjectDeletedEvent event) {
		// TODO Auto-generated method stub
		
	}
	

}
