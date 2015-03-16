package com.vizuri.insurance.rest;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//import org.jboss.logging.Logger;


import org.jboss.logging.Logger;

import com.vizuri.insurance.domain.Applicant;
import com.vizuri.insurance.domain.Property;
//@Stateless
//@Stateless
@Path("/insurance")
@RequestScoped
public class InsuranceRestService {
	  

	   private static final Logger log = Logger.getLogger(InsuranceRestService.class);
	    @Inject
	   private Validator validator;
	    
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/createApplicant")
	    public Applicant createApplicant(Applicant applicant) {
	    	
	    	
	    	
	    	
	    	
	    	log.infov("inside createApplicant : {0}",applicant);
	        return applicant;
	        
	        
	        
	    	
	    	
	    }
	    
	    
	    @POST
	    @Consumes(MediaType.APPLICATION_JSON)
	    @Produces(MediaType.APPLICATION_JSON)
	    @Path("/createProperty")
	    public Property createProperty(Property property) {
	    	
	    	
	    	
	    	
	    	
	    	log.infov("inside createProperty {0}",property);
	        return property;
	        
	        
	        
	    	
	    	
	    }
}
