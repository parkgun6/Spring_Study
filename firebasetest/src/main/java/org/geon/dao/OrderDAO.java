package org.geon.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.geon.domain.Order;
import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.Query;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class OrderDAO {

	private Firestore db;
	
		@PostConstruct
	    public void initialize() {
	        try {
	    	    FirebaseOptions options = FirebaseOptions.builder()
	    				.setCredentials(GoogleCredentials.getApplicationDefault())
	    				.setDatabaseUrl("https://parkgeon-portfolio-default-rtdb.firebaseio.com")
	    				.build();


	    	    FirebaseApp.initializeApp(options);
	    	    db = FirestoreClient.getFirestore();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }
	  	
	    public static final String COL_NAME="Tests";
	   
	    public String insertOrder(Order order) throws InterruptedException, ExecutionException {
	        
	        			log.info("--------------dao----------------------");
	        
	         			
			// Add document data  with id "alovelace" using a hashmap
	       // Firestore db = FirestoreClient.getFirestore();
			Map<String, Object> data = new HashMap<>();
			data.put("store", order.getStore());
			data.put("menu", order.getMenu());
			data.put("idx", order.getIdx());
			data.put("time", order.getTime());
			//asynchronously write data
			DocumentReference docRef = db.collection("Tests").document();
			ApiFuture<WriteResult> result = docRef.set(data);
			// ...
			// result.get() blocks on response
			log.info("Update time : " + result.get().getUpdateTime());
		    return result.get().getUpdateTime().toString();
	    }

	    public List<Order> getOrder(String store) throws InterruptedException, ExecutionException {
	    	
	    	List<Order> orderList = new ArrayList<>();
	    	log.info(store);
	        CollectionReference docRef = db.collection(COL_NAME);
	        
	        Query query = docRef.whereEqualTo("store", store);
	        ApiFuture<QuerySnapshot> querySnapshot = query.get();
//	        log.info("querySnapshot");
//	        log.info(querySnapshot);
	        //Gson객체 GsonArray 
//	        
//	        querySnapshot.get().forEach(sp -> {
//	        	Map<String, Object> dataMap = sp.getData();
//	        	Gson gson = new GsonBuilder().create();
//	        	String json = gson.toJson(dataMap);
//	        	
//	        	//log.info("----------------------------");
//	        	
//	        	//log.info(json);
//	        	
//	        	orderList.add(json);
//	        });      
//	        querySnapshot.get().forEach(sp -> {
//	        //log.info(sp.getData());
//	        orderList.add();
//	        });
	        for(DocumentSnapshot document : querySnapshot.get().getDocuments()) {
	        
	        //log.info(document.getData());
	        	
	        log.info(document.toObject(Order.class));
	        orderList.add(document.toObject(Order.class));
	        log.info(orderList);
	       // log.info(orderList);
	        }
	        

	        return orderList;
	       
		}

		public String updateOrder(Order order) throws InterruptedException, ExecutionException {

			log.info("--------------dao----------------------");

			// Add document data  with id "alovelace" using a hashmap
			//Firestore db = FirestoreClient.getFirestore();
			Map<String, Object> data = new HashMap<>();
			data.put("store", order.getStore());
			data.put("menu", order.getMenu());
			data.put("idx", order.getIdx());
			data.put("time", order.getTime());
			//asynchronously write data
			DocumentReference docRef = db.collection("Tests").document();
			ApiFuture<WriteResult> result = docRef.set(data);
			// ...
			// result.get() blocks on response
			log.info("Update time : " + result.get().getUpdateTime());
			return result.get().getUpdateTime().toString();
		}

		public String deleteOrder(String name) {
			//Firestore db = FirestoreClient.getFirestore();
			ApiFuture<WriteResult> writeResult = db.collection(COL_NAME).document(name).delete();
			log.info("--------------dao----------------------");
			return "Document with Patient ID " + name + " has been deleted";
		}

}
