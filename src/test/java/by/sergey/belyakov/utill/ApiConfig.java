package by.sergey.belyakov.utill;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ApiConfig {

	private static final Properties properties = new Properties();

	static {
		try (InputStream input = ApiConfig.class.getClassLoader()
				.getResourceAsStream("api-config.properties")) {
			if (input == null) {
				throw new RuntimeException("Файл api-config.properties не найден!");
			}
			properties.load(input);
		} catch (IOException e) {
			throw new RuntimeException("Ошибка загрузки конфигурационного файла", e);
		}
	}

	public static String getBaseUrl() {
		return properties.getProperty("api.base.url");
	}

	public static String getAuthToken() {
		return properties.getProperty("api.auth.token");
	}
}
