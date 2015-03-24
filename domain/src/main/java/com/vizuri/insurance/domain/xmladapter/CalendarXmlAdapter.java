package com.vizuri.insurance.domain.xmladapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class CalendarXmlAdapter extends XmlAdapter<String,Calendar>{
	SimpleDateFormat form = new SimpleDateFormat("MM/dd/yyyy");
	@Override
	public Calendar unmarshal(String v) throws Exception {
		if(v == null || v.trim().isEmpty()){
			return null;
		}
		
		Calendar cal = null;
		
		try {
			
			Date dt = form.parse(v);
			cal = Calendar.getInstance();
			cal.setTime(dt);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cal;
	}

	@Override
	public String marshal(Calendar v) throws Exception {
		if(v != null){
			return form.format(v.getTime());
		}
		
		return null;
	}

}
