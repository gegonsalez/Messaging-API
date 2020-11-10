package com.flavanoids.API.Repository;

import com.flavanoids.API.Domain.Conversation;

public interface ConversationRepository {
    String getConversation(Conversation conversation);
    boolean createConversation(Conversation conversation);
    boolean deleteConversation(Conversation conversation);
}
