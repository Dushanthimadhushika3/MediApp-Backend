package com.example.mediapp.clinicalEvent;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.example.mediapp.Notification.NotificationController;


@EnableScheduling
@Service
public class ClinicalEventService{
	
	@Autowired
	ClinicalEventRepository clinicalEventRepository;
	
	@Autowired
	NotificationController notificationController;
	
	public List<ClinicalEvent> getEvents() {
		
		Iterable<ClinicalEvent> u = clinicalEventRepository.findAll();
		
			return (List<ClinicalEvent>) u;
		
	}
	public List<ClinicalEvent> getEventName(ClinicalEvent clinicalevent) {
		// TODO Auto-generated method stub
	
		List<ClinicalEvent> e = clinicalEventRepository.findByDate(clinicalevent.date);
		
		return  e;
	}
	

	
	@Scheduled(fixedRate = 600000)//86400000
	public void scheduleTaskWithFixedRate() {
		LocalDate currentDate = LocalDate.now();
		LocalDate weekDate = currentDate.plusDays(3);
		LocalDate tomorrow = currentDate.plusDays(1);
		System.out.println(currentDate.toString());
		
		    	      
	List<ClinicalEvent> eventDate = clinicalEventRepository.getAllByDate(weekDate);
	if(!eventDate.isEmpty()) {
		for(ClinicalEvent clinical:eventDate) {
			System.out.println(clinical.targetAudi);
			notificationController.sendUpcomingEvent(clinical.targetAudi,clinical.eventName,clinical.venue,weekDate);
		}
		
	}
	
	List<ClinicalEvent> tomorrowEvent = clinicalEventRepository.getAllByDate(tomorrow);
	if(!tomorrowEvent.isEmpty()) {
		for(ClinicalEvent clinicalTomorrow:tomorrowEvent) {
			System.out.println(clinicalTomorrow.targetAudi);
			notificationController.sendUpcomingEvent(clinicalTomorrow.targetAudi,clinicalTomorrow.eventName,clinicalTomorrow.venue,tomorrow);
		}
		
	}
	System.out.println(eventDate.toString());
	}
	

}
