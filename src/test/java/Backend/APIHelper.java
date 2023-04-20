package Backend;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.internal.RequestSpecificationImpl;
import io.restassured.specification.RequestSpecification;
import lombok.SneakyThrows;

public class APIHelper {

    public void printRequestInfo(RequestSpecification request){
        System.out.println("=== Request Info ===");
        //Afisam URL ul
        String URL = ((RequestSpecificationImpl)request).getBaseUri()+((RequestSpecificationImpl)request).getBasePath();
        System.out.println("Request URI: " +URL);
        //afisam metoda
        System.out.println("Request METHOD: " + ((RequestSpecificationImpl) request).getMethod());
        //afisam body(daca are)
        System.out.println("Request BODY: \n" + getPrettyBody(request));
    }

    @SneakyThrows(JsonProcessingException.class)
    private String getPrettyBody(RequestSpecification request){
        String stringJson = "";
        var requestBody = ((RequestSpecificationImpl)request).getBody();
        if(requestBody != null){
            ObjectMapper mapper = new ObjectMapper();
            stringJson = mapper.readTree(requestBody.toString()).toPrettyString();
        }
        return stringJson;
    }
}
