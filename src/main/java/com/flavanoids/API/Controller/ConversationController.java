package com.flavanoids.API.Controller;

import com.flavanoids.API.Domain.Conversation;

import com.flavanoids.API.Repository.ConnectionFactory;
import com.flavanoids.API.Repository.ConversationRepository;
import com.flavanoids.API.Repository.ConversationRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

@RestController
@RequestMapping("/conversation")
public class ConversationController {

    private ConversationRepository conversationRepository;

    @PostMapping
    @RequestMapping(value="createConversation")
    public @ResponseBody ResponseEntity<String> createConversation(@RequestBody Conversation conversation) {
        conversationRepository = new ConversationRepositoryImpl(ConnectionFactory.createConnection());

        if (conversationRepository.createConversation(conversation))
            return new ResponseEntity<String>("Conversation created.", HttpStatus.OK);


        return new ResponseEntity<String>("Conversation cannot be created.", HttpStatus.BAD_REQUEST);
    }

    @GetMapping
    @RequestMapping(value="getConversation")
    public @ResponseBody ResponseEntity<String> getConversation(@RequestBody Conversation conversation) {
        conversationRepository = new ConversationRepositoryImpl(ConnectionFactory.createConnection());
        String result = conversationRepository.getConversation(conversation);

        if (result != "") {
            return new ResponseEntity<String>(result, HttpStatus.OK);
        }

        return new ResponseEntity<String>("Conversation canncot be found.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    @RequestMapping(value="deleteConversation")
    public @ResponseBody ResponseEntity<String> deleteConversation(@RequestBody Conversation conversation) {
        conversationRepository = new ConversationRepositoryImpl(ConnectionFactory.createConnection());

        if (conversationRepository.deleteConversation(conversation))
            return new ResponseEntity<String>("Conversation deleted.", HttpStatus.OK);

        return new ResponseEntity<String>("Conversation cannot be deleted.", HttpStatus.BAD_REQUEST);
    }
}
