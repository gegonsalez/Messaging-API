# Messaging API

Date: August 12, 2019

# Summary

This is a simple messaging API that allows you to post/update/delete message conversations. 

# Specification

* JDK 8
* Spring Boot
* PostgreSQL

# VM Options (Not required)

```
-javaagent:/Users/ggonsalez/Documents/newrelic-5.4.0/newrelic-build.jar
-agentlib:jdwp=transport=dt_socket,server=y,suspend=n,address=8080
```

# Message Endpoints

  ```
  {
    "user_id": 1,
    "message_id": 1,
    "conversation_id": 1,
    "message_content": "This is a test message from User 1."
  }
  ```

* `/message/sendMessage`

  Given a valid *Message* (`user_id`, `conversation_id`, `message_content`), send message and persist it in the DB. Returns a text confirmation. 
  
  **Expects :** application/json
    
  **Returns :** text/plain

* `/message/deleteMessage`

  Given a valid *Message* (`message_id`), deletes the Message from the DB. Returns a text confirmation.
    
  **Expects :** application/json

  **Returns :** text/plain

* `/message/editMessage`

  Given a valid *Message* (`message_id`, `message_content`), edit message and persist it in the DB. Returns a text confirmation. 
      
  **Expects :** application/json
  
  **Returns :** text/plain

# Conversation Endpoints

  ``` 
  {
    "conversation_id": 1,
    "user_one": 1,
    "user_two": 2
  }
  ```

* `/conversation//getConversation`

  Given a *Conversation* with a valid `conversation_id`, returns a **JSON** response with all the *Messages* tied to the *Conversation*.
  
  **Expects :** application/json
  
  **Returns :** application/json
  
* `/conversation/createConversation`
  
    Given a *Conversation* with a valid `user_one` and `user_two`, create a new Conversation. Returns a text confirmation.
    
    **Expects :** application/json
      
    **Returns :** text/plain

* `/conversation//deleteConversation`

  Given a *Conversation* with a valid `conversation_id`, deletes the conversation and associated messages from the DB. Returns a text confirmation.
  
  **Expects :** application/json
    
  **Returns :** text/plain
