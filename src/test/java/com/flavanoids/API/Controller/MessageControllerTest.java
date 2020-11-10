package com.flavanoids.API.Controller;

import com.flavanoids.API.Domain.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.bind.annotation.RequestBody;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testSuccessfulSendMessage() throws Exception {
        String json =
                "{" +
                    "\"user_id\": 1," +
                    "\"message_id\": 3," +
                    "\"conversation_id\": 1," +
                    "\"message_content\": \"This is another test message from User 1.\"" +
                "}";

        mvc.perform(MockMvcRequestBuilders.post("/message/sendMessage").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Message posted."));
    }

    @Test
    public void testFailedSendMessage() throws Exception {
        String json =
                "{" +
                    "\"user_id\": 1," +
                    "\"message_id\": 4," +
                    "\"conversation_id\": 1" +
                "}";

        mvc.perform(MockMvcRequestBuilders.post("/message/sendMessage").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Message was unable to post."));
    }

    @Test
    public void testSuccessfulDeleteMessage() throws Exception {
        String json =
                "{" +
                    "\"userId\": 1," +
                    "\"message_id\": 9," +
                    "\"conversation_id\": 1" +
                "}";

        mvc.perform(MockMvcRequestBuilders.delete("/message/deleteMessage").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Message was deleted."));
    }

    @Test
    public void testFailedDeleteMessage() throws Exception {
        String json =
                "{" +
                    "\"userId\": 1," +
                    "\"message_id\": 4," +
                    "\"conversation_id\": 1" +
                "}";

        mvc.perform(MockMvcRequestBuilders.delete("/message/deleteMessage").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Message was unable to delete."));
    }

    @Test
    public void testSuccessfulEditMessage() throws Exception {
        String json =
                "{" +
                    "\"userId\": 1," +
                    "\"message_id\": 1," +
                    "\"conversation_id\": 1," +
                    "\"message_content\": \"This is an update message 2019-08-22\"" +
                "}";

        mvc.perform(MockMvcRequestBuilders.put("/message/editMessage").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Message was updated."));
    }

    @Test
    public void testFailedEditMessage() throws Exception {
        String json =
                "{" +
                    "\"userId\": 1," +
                    "\"message_id\": 4," +
                    "\"conversation_id\": 1" +
                "}";

        mvc.perform(MockMvcRequestBuilders.put("/message/editMessage").contentType(MediaType.APPLICATION_JSON).content(json))
                .andExpect(status().isBadRequest())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))
                .andExpect(content().string("Message was unable to update."));
    }
}
