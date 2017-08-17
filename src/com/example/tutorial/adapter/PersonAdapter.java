package com.example.tutorial.adapter;
import java.io.IOException;

import com.example.tutorial.proto.PersonProtos.Person;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.google.protobuf.util.JsonFormat;

/**
 * The PersonAdapter class which will provide a {@TypeAdapter} to convert Person proto
 * to a well defined, concise Json and vice-versa.
 *
 * @author moijes12
 *
 */
public class PersonAdapter extends TypeAdapter<Person> {

	/**
	 * Override the read method to return a {@Person} object from it's json representation.
	 */
	@Override
	public Person read(JsonReader jsonReader) throws IOException {
		// Create a builder for the Person message
		Person.Builder personBuilder = Person.newBuilder();
		// Use the JsonFormat class to parse the json string into the builder object
		// The Json string will be parsed fromm the JsonReader object
		JsonParser jsonParser = new JsonParser();
		JsonFormat.parser().merge(jsonParser.parse(jsonReader).toString(), personBuilder);
		// Return the built Person message 
		return personBuilder.build();
	}

	/**
	 * Override the write method and set the json value of the Person message.
	 */
	@Override
	public void write(JsonWriter jsonWriter, Person person) throws IOException {
		// Call the printer of the JsonFormat class to convert the Person proto message to Json
		jsonWriter.jsonValue(JsonFormat.printer().print(person));
	}
}
