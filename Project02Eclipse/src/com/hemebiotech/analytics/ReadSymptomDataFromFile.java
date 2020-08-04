package com.hemebiotech.analytics;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Simple brute force implementation
 *
 */
public class ReadSymptomDataFromFile implements ISymptomReader {

	private String filepath;

	/**
	 * 
	 * @param filepath a full or partial path to file with symptom strings in it,
	 *                 one per line
	 */
	public ReadSymptomDataFromFile(String filepath) {
		this.setFilepath(filepath);
	}

	/**
	 * test if file exists and if it's a text type file; if not, throw exception
	 * 
	 * @param filepath
	 */
	public void setFilepath(String filepath) {
		Path path = Paths.get(filepath);
		if (!Files.exists(path)) {
			throw new RuntimeException("This data source file does not exist or is not accessible");
		} else if (!(filepath.endsWith(".text") | filepath.endsWith(".txt"))) {
			throw new RuntimeException("Tha data source must be text type file (.txt or .text)");
		} else {
			this.filepath = filepath;
		}
	}

	@Override
	public List<String> getSymptoms() {
		ArrayList<String> result = new ArrayList<String>();

		if (filepath != null) {
			try {
				BufferedReader reader = new BufferedReader(new FileReader(filepath));
				String line = reader.readLine();

				while (line != null) {
					result.add(line);
					line = reader.readLine();
				}
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return result;
	}

}
