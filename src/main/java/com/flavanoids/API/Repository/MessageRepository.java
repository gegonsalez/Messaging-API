package com.flavanoids.API.Repository;

import com.flavanoids.API.Domain.Message;

public interface MessageRepository {
    boolean sendMessage(Message message);
    boolean deleteMessage(Message message);
    boolean editMessage(Message message);
}
