package org.geon.dao;

import java.util.concurrent.ExecutionException;

import javax.annotation.PostConstruct;

import org.geon.domain.Order;
import org.springframework.stereotype.Repository;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;

import lombok.extern.log4j.Log4j;

@Repository
@Log4j
public class OrderDAO {

	  @PostConstruct
	    public void initialize() {
	        try {
	    	    FirebaseOptions options = FirebaseOptions.builder()
	    				.setCredentials(GoogleCredentials.getApplicationDefault())
	    				.setDatabaseUrl("https://parkgeon-portfolio-default-rtdb.firebaseio.com")
	    				.build();


	            FirebaseApp.initializeApp(options);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	    }

	    public static final String COL_NAME="Tests";

	    public String insertOrder(Order order) throws InterruptedException, ExecutionException {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document().set(order);
			log.info("--------------dao----------------------");

	        return collectionsApiFuture.get().getUpdateTime().toString();
	    }

	    public Order getOrder(String store) throws InterruptedException, ExecutionException {
	    	log.info(store);
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        DocumentReference documentReference = dbFirestore.collection(COL_NAME).document(store);
	        ApiFuture<DocumentSnapshot> future = documentReference.get();

	        DocumentSnapshot document = future.get();
	        log.info("--------------dao----------------------");
	        Order order = null;

	        if(document.exists()) {
	            order = document.toObject(Order.class);
	            return order;
	        }else {
	            return null;
	        }
	    }

	    public String updateOrder(Order order) throws InterruptedException, ExecutionException {
	       log.info(order);
	    	Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection(COL_NAME).document().set(order);
	        log.info("--------------dao----------------------");
	        return collectionsApiFuture.get().getUpdateTime().toString();
	    }

	    public String deleteOrder(String name) {
	        Firestore dbFirestore = FirestoreClient.getFirestore();
	        ApiFuture<WriteResult> writeResult = dbFirestore.collection(COL_NAME).document(name).delete();
	        log.info("--------------dao----------------------");
	        return "Document with Patient ID "+name+" has been deleted";
	    }

}
