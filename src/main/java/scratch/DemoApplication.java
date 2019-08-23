package scratch;

import java.io.IOException;
import java.io.InputStream;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	@Bean
	public ObjectMapper mvcObjectMapper() {
		return new ObjectMapper() {

			@Override
			public <T> T readValue(InputStream src, JavaType javaType)
					throws IOException, JsonParseException, JsonMappingException {
				System.err.println("I got used");
				return super.readValue(src, javaType);
			}

		};
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
