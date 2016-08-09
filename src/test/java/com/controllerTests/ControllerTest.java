package com.controllerTests;

import com.AbstractTest;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertNotNull;


@Transactional
public class ControllerTest extends AbstractTest {
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    private RestTemplate restTemplate = new TestRestTemplate();


    @Test
    public void testController() throws JsonProcessingException {

        //Building the Request body data
        Map<String, Object> requestBody = new HashMap<String, Object>();
        requestBody.put("username", "user1");
        requestBody.put("password", "user1");
//        requestBody.put("author", "Author 1");
//        requestBody.put("pages", 302);
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity<String> httpEntity =
                new HttpEntity<String>(OBJECT_MAPPER.writeValueAsString(requestBody), requestHeaders);

        //Invoking the API
        Map<String, Object> apiResponse =    restTemplate.postForObject("http://localhost:8080/login", httpEntity, Map.class, Collections.EMPTY_MAP);

        System.out.println(apiResponse);

//        assertNotNull(apiResponse);




    }

}
