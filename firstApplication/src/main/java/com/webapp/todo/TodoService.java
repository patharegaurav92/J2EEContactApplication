package com.webapp.todo;

import java.net.UnknownHostException;
import java.util.*;

import org.bson.BSONObject;

import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.webapp.register.LoginRegisterService;

public class TodoService {
	public static List<Todo> todos = new ArrayList<>();
	/*static {
		todos.add(new Todo("Gaurav",1));
		todos.add(new Todo("Suyash",2));
		todos.add(new Todo("Deepesh",3));
	}*/

	DBCollection table;
	public TodoService() {
		try {
			LoginRegisterService.mongo =new MongoClient( "localhost" , 27017 );
			LoginRegisterService.db = LoginRegisterService.mongo.getDB("firstapplication");
			table = LoginRegisterService.db.getCollection("users");
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public List<Todo> retreiveTodos(){
		DBCursor cursor = table.find();
		todos.clear();
		while(cursor.hasNext()) {
			BasicDBObject document =new BasicDBObject();
			document = (BasicDBObject) cursor.next();
			int id =document.getInt("id");
			String name = document.getString("name");
			Todo t = new Todo(name,id);
				todos.add(t);
		}
		return todos;
	}
	public void addTodo(Todo todo) {
		BasicDBObject document =new BasicDBObject();
		document.put("id",todo.getId());
		document.put("name",todo.getName());
		table.insert(document);
		//todos.add(todo);
	}
	public void deleteTodo(Todo todo) {
		BasicDBObject document = new BasicDBObject();
		System.out.println("THe delete id is "+todo.getId());
		document.put("id",todo.getId());
		table.remove(document);
		//todos.remove(todo);
	}
	public int getSize() {
		int count = (int) table.count();
		//return todos.size();
		return count;
	}
	public Todo getTodoById(int id) {
		Todo s=null;
		BasicDBObject document = new BasicDBObject();
		document.put("id",id);
		DBCursor cursor = table.find(document);
		while(cursor.hasNext()) {
			BasicDBObject d = (BasicDBObject) cursor.next();
			s = new Todo(d.getString("name"),d.getInt("id"));
		}
		return s;
		/*for(Todo t : todos) {
			if(id == t.getId()) {
				return t;
			}
		}
		return null;*/
	}
	public void setTodoById(String name, int id) {
		//Todo s=null;
		BasicDBObject document = new BasicDBObject();
		document.put("id",id);
		DBCursor cursor = table.find(document);
		while(cursor.hasNext()) {
			BasicDBObject d = (BasicDBObject) cursor.next();
			d.put("id", id);
			d.put("name",name);
			BasicDBObject document2 = new BasicDBObject();
			document2.put("$set",d);
			table.update(document, document2);
			//s = new Todo(d.getString("name"),d.getInt("id"));
		}
		
		
		/*for(Todo t : todos) {
			if(id == t.getId()) {
				t.setName(name);
			}
		}*/
		
	}
	
	
}
