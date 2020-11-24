package testIntrospection;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JacksonTest {
	
	public JsonToObject sut = new JsonToObject();

	@Test
	public void testJackson() throws Exception {
		String json = "{\"firstName\":\"Arnaud\", \"birthDate\": 1974 }";

		ObjectMapper jackson = new ObjectMapper();
		
		JsonNode jacksonNode = jackson.readTree(json);

		Assert.assertNotNull(jacksonNode);
	}
	
	@Test
	public void testJacksonToUser() throws Exception {
		String json = "{\"firstName\":\"Arnaud\", \"birthDate\": 1974 }";

		ObjectMapper jackson = new ObjectMapper();
		
		User u = jackson.readValue(json, User.class);

		Assert.assertNotNull(u);
		Assert.assertEquals("Arnaud", u.firstName);
		Assert.assertEquals(1974, u.birthDate);
	}
	
	@Test
	public void testJacksonToInt() throws Exception {
		String json = "{\"horsePower\":\"truc\"};"; 
		String json2= "{ \"color\" : \"Black\"}";
		ObjectMapper jackson = new ObjectMapper();
		JsonNode jsonNode = jackson.readTree(json2);
		
		Object object = sut.dumpObjectToJson(jsonNode, String.class);
		
		//int val = jackson.readValue(json, int.class);

		Assert.assertNotNull(object);
		Assert.assertEquals("Black",object);
	}
	
	
}

