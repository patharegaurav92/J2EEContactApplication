package com.webapp.register;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.MongoClient;

public class LoginRegisterService {
	public static MongoClient mongo;
	public static DB db;
	DBCollection table;
	public LoginRegisterService() {
		try {
			mongo =new MongoClient( "localhost" , 27017 );
			db = mongo.getDB("firstapplication");
			table = db.getCollection("todo");
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void registerUser() {
		
	}
}
