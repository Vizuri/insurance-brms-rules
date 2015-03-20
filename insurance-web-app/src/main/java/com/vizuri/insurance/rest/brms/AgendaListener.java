package com.vizuri.insurance.rest.brms;



import org.jboss.logging.Logger;
import org.kie.api.event.rule.AfterMatchFiredEvent;
import org.kie.api.event.rule.AgendaEventListener;
import org.kie.api.event.rule.AgendaGroupPoppedEvent;
import org.kie.api.event.rule.AgendaGroupPushedEvent;
import org.kie.api.event.rule.BeforeMatchFiredEvent;
import org.kie.api.event.rule.MatchCancelledEvent;
import org.kie.api.event.rule.MatchCreatedEvent;
import org.kie.api.event.rule.RuleFlowGroupActivatedEvent;
import org.kie.api.event.rule.RuleFlowGroupDeactivatedEvent;

public class AgendaListener implements AgendaEventListener {
	private static final Logger log = Logger.getLogger(AgendaListener.class);
	
	
	
	public void matchCreated(MatchCreatedEvent event) {
		//if (log.isInfoEnabled()) {
			
			System.out.println("matchCreated : " + event.getMatch().getRule());
		//}
		
	}
	
	public void matchCancelled(MatchCancelledEvent event) {
		
		//if (log.isInfoEnabled()) {
			System.out.println("matchCancelled : " + event.getMatch().getRule());
	//	}
	}
	
	public void beforeRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		//System.out.println("beforeRuleFlowGroupDeactivated : "+event.getRuleFlowGroup());
		//System.out.println("beforeRuleFlowGroupDeactivated");
	}
	
	public void beforeRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		//System.out.println("beforeRuleFlowGroupDeactivated" +event.getRuleFlowGroup());
		

	}
	
	public void beforeMatchFired(BeforeMatchFiredEvent event) {
		//if (log.isInfoEnabled()) {
			// TODO Auto-generated method stub
			System.out.println("beforeMatchFired" + event.getMatch().getRule());
			//
		//}
	}
	
	public void agendaGroupPushed(AgendaGroupPushedEvent event) {
		// TODO Auto-generated method stub
		//log.info("agendaGroupPushed"+event.getAgendaGroup());
	}
	
	public void agendaGroupPopped(AgendaGroupPoppedEvent event) {
		//// TODO Auto-generated method stub
		//log.info("agendaagendaGroupPoppedGroupPushed "+event.getAgendaGroup());
	}
	
	public void afterRuleFlowGroupDeactivated(
			RuleFlowGroupDeactivatedEvent event) {
		// TODO Auto-generated method stub
	//log.info("afterRuleFlowGroupDeactivated" + event.getRuleFlowGroup());
	}
	
	public void afterRuleFlowGroupActivated(RuleFlowGroupActivatedEvent event) {
		// TODO Auto-generated method stub
		//log.info("afterRuleFlowGroupActivated" + event.getRuleFlowGroup());
	}
	
	//FactHandle handle = new DefaultFactHandle();
	
	public void afterMatchFired(AfterMatchFiredEvent event) {
		//if (log.isInfoEnabled()) {
			// TODO Auto-generated method stub
		System.out.println("afterMatchFired  : " + event.getMatch().getRule());
			log.info("event facts size: " + event.getMatch().getFactHandles().size());
		//}
		
		
		
		
	}

}
