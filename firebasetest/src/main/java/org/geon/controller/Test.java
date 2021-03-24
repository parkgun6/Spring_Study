package org.geon.controller;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.google.api.core.ApiFuture;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Test {
	
	private static final String TAG = "ReadAndWriteSnippets";

	public static void main(String[] args) throws IOException {
	    DatabaseReference mDatabase;

	    FirebaseOptions options = FirebaseOptions.builder()
				.setCredentials(GoogleCredentials.getApplicationDefault())
				.setDatabaseUrl("https://parkgeon-portfolio-default-rtdb.firebaseio.com/")
				.build();

		FirebaseApp.initializeApp(options);
		
		mDatabase = FirebaseDatabase.getInstance().getReference();
		
		
		System.out.println(options);
		System.out.println(mDatabase.child("Tests").child("0"));
		
		Map<String,Object> map = new HashMap<>();
		map.put("name", "홍길동");
		map.put("store", "중국집");
		
		mDatabase.child("Tests").child("0").getKey();
		mDatabase.child("Tests").child("0").setValueAsync(map);
		mDatabase.push().child("Tests").child("0").setValueAsync(map);
		 Firestore dbFirestore = FirestoreClient.getFirestore();
		 System.out.println(dbFirestore);
//	        ApiFuture<WriteResult> collectionsApiFuture = dbFirestore.collection().document(store.getName()).set(store);
//	       collectionsApiFuture.get().getUpdateTime().toString();
	}
}
