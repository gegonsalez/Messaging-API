package com.flavanoids.API.Controller;

import com.flavanoids.API.Repository.ConnectionFactory;
import com.flavanoids.API.Domain.Message;
import com.flavanoids.API.Repository.MessageRepository;
import com.flavanoids.API.Repository.MessageRepositoryImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/message")
public class MessageController {

    private MessageRepository messageRepository;

    @PostMapping
    @RequestMapping(value="sendMessage")
    public @ResponseBody ResponseEntity<String> sendMessage(@RequestBody final Message message) {
        messageRepository = new MessageRepositoryImpl(ConnectionFactory.createConnection());

        if (messageRepository.sendMessage(message))
            return new ResponseEntity<String>("Message posted.", HttpStatus.OK);

        return new ResponseEntity<String>("Message was unable to post.", HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping
    @RequestMapping(value="deleteMessage")
    public @ResponseBody ResponseEntity<String> deleteMessage(@RequestBody final Message message) {
        messageRepository = new MessageRepositoryImpl(ConnectionFactory.createConnection());

        if (messageRepository.deleteMessage(message))
            return new ResponseEntity<String>("Message was deleted.", HttpStatus.OK);

        return new ResponseEntity<String>("Message was unable to delete.", HttpStatus.BAD_REQUEST);
    }

    @PutMapping
    @RequestMapping(value="editMessage")
    public @ResponseBody ResponseEntity<String> editMessage(@RequestBody final Message message) {
        messageRepository = new MessageRepositoryImpl(ConnectionFactory.createConnection());

        if (messageRepository.editMessage(message))
            return new ResponseEntity<String>("Message was updated.", HttpStatus.OK);

        return new ResponseEntity<String>("Message was unable to update.", HttpStatus.BAD_REQUEST);
    }
}
