package com.vizuri.insurance.rest;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.drools.core.common.DefaultFactHandle;
import org.jboss.logging.Logger;

import com.vizuri.insurance.domain.Address;
import com.vizuri.insurance.domain.Applicant;
import com.vizuri.insurance.domain.Claim;
import com.vizuri.insurance.domain.Property;
import com.vizuri.insurance.domain.Question;
import com.vizuri.insurance.rest.brms.RuleProcessor;



@Path("/quoteService")
public class QuotingResourceService {
	private static final Logger log = Logger.getLogger(QuotingResourceService.class);
	public static final String AGENDA_ELIGIBLITY = "eligibility";
	private static final String AGENDA_CALCULATION = "calculation";
	
	private Map<String, Question> buildGroupMap(List<Question> questionLst,String groupss){
		
		Map<String, Question> questMap = new HashMap<String,Question>();
	       
	       for (Question que : questionLst) {
	    	   
	    	  
	    	   String group = que.getGroup();
	    	  /* if(!que.getGroup().equalsIgnoreCase(group)){
	    		   continue;
	    	   }*/
	    	   
	    	   String key = group.substring(0,1).toLowerCase()+"."+que.getMappedProperty();
	    	   questMap.put(key, que);
	       }
	       
	     return questMap; 
	}
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getTransferData() {
		log.info("inside getTransferData");
       TransferWrapper wrap = new TransferWrapper();
       wrap.setApplicant(new Applicant());
       wrap.setProperty(new Property());
       wrap.getProperty().setAddress(new Address());
       wrap.getProperty().setClaims(new ArrayList<Claim>());
       
       RuleProcessor process = new RuleProcessor();
       List<Question> questionLst = process.getAllQuestions();
      
       wrap.setQuestions(questionLst);
       
       
       Map<String, Question> applicantQuestMap = new HashMap<String,Question>();
       applicantQuestMap = buildGroupMap(questionLst, null);
       
       //Map<String, Question> propertyQuestMap = buildGroupMap(questionLst, "Property");
       
     //  wrap.setPropertyQuestMap(propertyQuestMap);
       wrap.setApplicantQuestMap(applicantQuestMap);
       
       
       
   	return Response
            .status(200)
            .header("Access-Control-Allow-Origin", "*")
            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
            .header("Access-Control-Allow-Credentials", "true")
            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
            .header("Access-Control-Max-Age", "1209601")
            .entity(wrap)
            .build();
      
    }
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	
	public Response operate(TransferWrapper wrapper){
		log.info("inside operate");
		///wrapper.getApplicantQuestMap().get("filedForBankruptcy").setEnabled(true);
		 log.infov("parameter wrapper : ",wrapper);
		RuleProcessor rp = new RuleProcessor();
		//List<Question> questionListToSend = new ArrayList<Question>(wrapper.getApplicantQuestMap().values());
		List<Question> questionLst = rp.getAllQuestions();
	
		List sendList = new ArrayList(wrapper.getQuestions());
		sendList.add(wrapper.getApplicant());
		sendList.add(wrapper.getProperty());
		sendList.add(wrapper.getProperty().getAddress());
		
	
		Map mp = rp.fireQuestionRule(RuleProcessor.AGENDA_QUESTION_DISPLAY, sendList);
		
		questionLst =(List) mp.get("questions");
		

	    
	      
	      /* doEligiblity(wrapper);
	       docalculation(wrapper);*/
	       
	       Map<String, Question> applicantQuestMap = new HashMap<String,Question>();
		   applicantQuestMap = buildGroupMap(questionLst, null);
	       wrapper.setApplicantQuestMap(applicantQuestMap);
	       
	       log.infov("retured wrapper : ",wrapper);
	  	return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209601")
	            .entity(wrapper)
	            .build();
	}
	
	
	
	@Path("/eligibility")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response doEligiblity(TransferWrapper wrapper){
		List sendList = new ArrayList(wrapper.getQuestions());
		sendList.add(wrapper.getApplicant());
		sendList.add(wrapper.getProperty());
		sendList.add(wrapper.getProperty().getAddress());
		
		RuleProcessor rp = new RuleProcessor();
		Collection coll  =rp.fireRules(AGENDA_ELIGIBLITY, sendList.toArray());
		
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209601")
	            .entity(wrapper)
	            .build();
	}
	
	@Path("/quoteCalculate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Response docalculation(TransferWrapper wrapper){
		List sendList = new ArrayList(wrapper.getQuestions());
		sendList.add(wrapper.getApplicant());
		sendList.add(wrapper.getProperty());
		sendList.add(wrapper.getProperty().getAddress());
		RuleProcessor rp = new RuleProcessor();
		Collection coll  = rp.fireRules(AGENDA_CALCULATION ,sendList.toArray());
		
		return Response
	            .status(200)
	            .header("Access-Control-Allow-Origin", "*")
	            .header("Access-Control-Allow-Headers", "origin, content-type, accept, authorization")
	            .header("Access-Control-Allow-Credentials", "true")
	            .header("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD")
	            .header("Access-Control-Max-Age", "1209601")
	            .entity(wrapper)
	            .build();
		
	}
	
	public static void main(String[] args) {
		List sendList = new ArrayList();
		Property p = new Property();
		p.setYearBuilt(1920);
		p.setElectrictSystemRenovated(false);
	
		Applicant app = new Applicant();
		app.setFraud(true);
		sendList.add(p);
		sendList.add(app);
		
		RuleProcessor rp = new RuleProcessor();
		Collection coll  =rp.fireRules(AGENDA_ELIGIBLITY, sendList.toArray());
		
		System.out.println("prop : "+p);
		/*for (Object object : coll) {
			DefaultFactHandle fact = (DefaultFactHandle)object;
			System.out.println(fact.getObject());
			
		}*/
		
	}
}
