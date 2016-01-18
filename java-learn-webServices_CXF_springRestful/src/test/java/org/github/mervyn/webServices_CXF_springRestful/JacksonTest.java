package org.github.mervyn.webServices_CXF_springRestful;
import static org.junit.Assert.*;

import java.io.IOException;
import java.io.StringWriter;


import org.junit.Test;

import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	private JsonGenerator jsonGenerator = null;
	 private ObjectMapper objectMapper = null;
	@Test
	public void test() throws JsonProcessingException, IOException {
		
		 ObjectMapper mapper = new ObjectMapper();  
		 StringWriter sw = new StringWriter();  
		 JsonGenerator gen = new JsonFactory().createJsonGenerator(sw); 
		 
		/* User user = new User();
		 user.setId(1);
		 user.setName("mervyn");*/
		 String name = "mervyn";
		 mapper.writeValue(gen, name);
		 gen.close();
		 System.out.println(sw.toString());
		 
	}

}
