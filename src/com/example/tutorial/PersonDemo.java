package com.example.tutorial;

import com.example.tutorial.adapter.PersonAdapter;
import com.example.tutorial.proto.PersonProtos.Person;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * The demo class.
 * 
 * @author moijes12
 *
 */
public class PersonDemo {
	public static void main(String[] args) {
		// Create a Person object
		Person.Builder personBuilder = Person.newBuilder();
		personBuilder.setName("John");
		personBuilder.setEmail("john@doe.com");
		personBuilder.setAge(24);
		Person p = personBuilder.build();
		
		// Create a Gson object by registering a Gson Builder with the PersonAdapter
		GsonBuilder gsonBuilder = new GsonBuilder();
		Gson gson = gsonBuilder.registerTypeAdapter(Person.class, new PersonAdapter()).create();
		
		// Print the Person proto string
		System.out.println(p);    // Output:
		                          // name: "John"
			                      // email: "john@doe.com"
			                      // age: 24

		// Print the Json equivalent of the string
		String personJson = gson.toJson(p);
		System.out.println(personJson);  // Output:
				                             // {
					                         //   "name": "John",
					                         //   "email": "john@doe.com",
					                         //   "age": 24
					                         // }
		
		// Get the proto data from it's equivalent Json
		Person personReconvertedFromJson = gson.fromJson(personJson, Person.class);
		System.out.println(personReconvertedFromJson.toString());
		                                     // Output : 
		                                     // name: "John"
                                             // email: "john@doe.com"
                                             // age: 24
	}
}
