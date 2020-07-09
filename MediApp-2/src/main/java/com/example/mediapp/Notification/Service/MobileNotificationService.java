package com.example.mediapp.Notification.Service;
import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;
 
import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MobileNotificationService {

	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	private static final String FIREBASE_SERVER_KEY = "AAAAVtAO4Cg:APA91bFAf_bphj1T82AJayBEXzchUgNyVFPFk6xw7Q_XB8EtUAVdVjFSm73sl2jMrczfcnaYlBzDmssyK1rw-Js65tpIBDbYafjL-pz7thX7jaBD5vyKBlxOiTweFVKIf4dxDHW5heYN";

	@Async
	  public CompletableFuture<String> send(HttpEntity<String> entity) {
	 
	    RestTemplate restTemplate = new RestTemplate();
	 
	    /**
	    https://fcm.googleapis.com/fcm/send
	    Content-Type:application/json
	    Authorization:key=FIREBASE_SERVER_KEY*/
	 
	    ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
	    interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
	    interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
	    restTemplate.setInterceptors(interceptors);
	    
	    
	 
	    String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);
	 
	    return CompletableFuture.completedFuture(firebaseResponse);
	  }
}
