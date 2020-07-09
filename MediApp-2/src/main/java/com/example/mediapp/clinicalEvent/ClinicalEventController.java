package com.example.mediapp.clinicalEvent;



//import java.text.ParseException;
//import java.util.Date;
//import java.sql.Date;
import java.util.List;
//import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;




@RestController
@CrossOrigin(origins="*",allowedHeaders="*")
public class ClinicalEventController {
	
	@Autowired
	ClinicalEventService clinicalEventService;
	
	@PostMapping("/clinicalEvent")
	public List<ClinicalEvent> getEvents(){
		return clinicalEventService.getEvents();
	}
	
	@PostMapping("/clinicalEvent/eventName")
	public List<ClinicalEvent> getEventName(@RequestBody ClinicalEvent clinicalevent){
		//body.get("name");
		//System.out.print(body.get("date"));
		return clinicalEventService.getEventName(clinicalevent);
	}
	
}
