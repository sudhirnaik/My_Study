package practice.controllers;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(HelloController.class)
public class HelloControllerTest extends TestCase {

   /* @Autowired
    MockMvc mvc;

    @Test
    public void controllerTest() throws Exception {

        RequestBuilder req = MockMvcRequestBuilders.get("/hello");
        mvc.perform(req)
                .andExpect(status().isOk());


    }*/
}