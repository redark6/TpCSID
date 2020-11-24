package testIntrospection;


import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.JsonNodeType;
import com.fasterxml.jackson.databind.node.NumericNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.node.TextNode;

public class JsonToObject {
	
	public Object dumpObjectToJson(JsonNode jsonNode, Class<?> clss) throws Exception, IllegalAccessException {
		if( int.class.isAssignableFrom(clss) ||  Integer.class.isAssignableFrom(clss)) {
			int valueInt;
			System.out.println(jsonNode.isIntegralNumber());
			if(jsonNode instanceof NumericNode) {
				valueInt= ((NumericNode) jsonNode).asInt();
			}
			else {
				throw new  IllegalArgumentException();
			}
			return valueInt;
		}
		else if(String.class.isAssignableFrom(clss)) {
			String valueText;
			System.out.println(jsonNode.asText());
			if(jsonNode instanceof ObjectNode) {
				valueText= jsonNode.asText();
				return valueText;
			}
			else {
				throw new  IllegalArgumentException();
			}
			
		}
		else {
			return null;
		}

		
	}

	
}
