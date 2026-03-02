package by.sergey.belyakov.utill;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {

	public static List<List<String>> getData(String filePath) {

		List<List<String>> allData = new ArrayList<>();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			//TODO Пропускаем заголовок
			br.readLine();

			String line;
			while ((line = br.readLine()) != null) {
				if (!line.trim().isEmpty()) {
					String[] values = line.split(",");
					List<String> row = new ArrayList<>();
					for (String value : values) {
						row.add(value.trim());
					}
					allData.add(row);
				}
			}
		} catch (IOException e) {
			throw new RuntimeException("Ошибка при чтении файла: " + filePath, e);
		}

		return allData;
	}
}
