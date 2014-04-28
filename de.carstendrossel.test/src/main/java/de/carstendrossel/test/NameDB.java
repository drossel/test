package de.carstendrossel.test;

import java.util.ArrayList;
import java.util.List;

public class NameDB {

	private static List<String> names = new ArrayList<String>();

	public static void addName(String name) {
		names.add(name);
	}

	public static List<String> getNames() {
		return new ArrayList<String>(names);
	}
}
