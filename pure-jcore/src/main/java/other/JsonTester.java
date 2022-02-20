package other;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import temp.AbstractRequest;
import temp.TypeARequest;
import temp.TypeBRequest;


public class JsonTester {
    public static void main(String[] args) {
        JsonTester demo = new JsonTester();
        demo.entrypoint();
    }
    private void entrypoint() {
        AbstractRequest requestA = new TypeARequest();
        AbstractRequest requestB = new TypeBRequest();

        ObjectMapper mapper = new ObjectMapper();
        try {
            System.out.println(mapper.writeValueAsString(requestA));
            System.out.println(mapper.writeValueAsString(requestB));
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
}
