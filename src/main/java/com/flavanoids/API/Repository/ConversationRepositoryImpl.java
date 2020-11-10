package com.flavanoids.API.Repository;

import com.flavanoids.API.Domain.Conversation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConversationRepositoryImpl implements ConversationRepository {

    private final Connection connection;

    public ConversationRepositoryImpl(Connection conn) { connection = conn; }

    @Override
    public String getConversation(Conversation conversation) {
        String sql = "SELECT * FROM \"public\".\"messages\" WHERE conversation_id = ?";
        String getConversationResult = "";

        boolean wasExecuteSuccess = false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, conversation.getConversation_id());

            ResultSet result = statement.executeQuery();

            if (result.next() != false) {
                getConversationResult += "{";

                do {
                    getConversationResult += String.format("{\"userId:\" %d, \"messageId:\" %d, \"conversationId:\" %d, \"messageContent:\" \"%s\"},", result.getInt("user_id"), result.getInt("message_id"), result.getInt("conversation_id"), result.getString("message_content"));
                } while (result.next());

                getConversationResult = getConversationResult.substring(0, getConversationResult.length()-1);
                getConversationResult += "}";
            }

            connection.close();
        } catch (SQLException e) {

        }

        return getConversationResult;
    }

    @Override
    public boolean createConversation(Conversation conversation) {
        String sql = "INSERT INTO \"public\".\"conversation\" (user_one, user_two) VALUES (?, ?)";
        boolean wasExecuteSuccess = false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, conversation.getUser_one());
            statement.setInt(2, conversation.getUser_two());

            if (statement.executeUpdate() != 0) {
                wasExecuteSuccess = true;
            }

            connection.close();
        } catch (SQLException e) {

        }

        return wasExecuteSuccess;
    }

    @Override
    public boolean deleteConversation(Conversation conversation) {
        String sql = "DELETE FROM \"public\".\"conversation\" WHERE conversation_id = ?";
        boolean wasExecuteSuccess = false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, conversation.getConversation_id());

            if (statement.executeUpdate() != 0) {
                wasExecuteSuccess = true;
            }

            connection.close();
        } catch (SQLException e) {

        }

        return wasExecuteSuccess;
    }
}
