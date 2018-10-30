package org.example.lambda;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

public class JsonUtil {

	public static List<Person> readJsonFile() {
		Gson gson = new GsonBuilder().create();
		Type collectionType = new TypeToken<List<Person>>(){}.getType();
		InputStream persons = Exercise1.class.getResourceAsStream("persons.json");
		return gson.fromJson(new InputStreamReader(persons), collectionType);
	}
}
