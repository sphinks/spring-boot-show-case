package com.not4j;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.not4j.dao.TripDao;
import com.not4j.dao.UserDao;
import com.not4j.model.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.TestRestTemplate;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @Author: ivan
 * Date: 28.05.16
 * Time: 20:23
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = DbTripApplication.class)
@WebIntegrationTest("server.port:8888")
public class UserControllerLongIntegrationTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    //Test RestTemplate to invoke the APIs.
    private RestTemplate restTemplate = new TestRestTemplate();

    @Value("${local.server.port}")
    int port;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    private User user;

    @Autowired
    private UserDao userDao;

    @Autowired
    private TripDao tripDao;

    //Required to Generate JSON content from Java objects
    public static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    @Before
    public void setup() throws Exception {

        this.tripDao.deleteAllInBatch();
        this.userDao.deleteAllInBatch();

        this.user = userDao.save(new User("Login", "qwerty", "Name", 30));
    }

    @Test
    public void testCreateBookApi() throws JsonProcessingException {

        //Invoking the API
        ResponseEntity<List<User>> apiResponse =
                restTemplate.exchange("http://localhost:8888/v1/user",
                        HttpMethod.GET, null, new ParameterizedTypeReference<List<User>>() {
                        });

        assertNotNull(apiResponse);
        assertThat( apiResponse.getStatusCode() , equalTo(HttpStatus.OK));
        assertThat(apiResponse.getBody().size(), is(1));
        User actualUser = apiResponse.getBody().get(0);
        assertEquals(user.getUserId(), actualUser.getUserId());
        assertEquals(user.getLogin(), actualUser.getLogin());
        assertEquals(user.getUserId(), actualUser.getUserId());
    }
}
