package com.flavanoids.API.Repository;

import com.flavanoids.API.Domain.Message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MessageRepositoryImpl implements MessageRepository {

    private final Connection connection;

    public MessageRepositoryImpl(Connection conn) {
        connection = conn;
    }

    @Override
    public boolean sendMessage(Message message) {
        String sql = "INSERT INTO \"public\".\"messages\" (user_id, conversation_id, message_content) VALUES (?, ?, ?)";
        boolean wasExecuteSuccess = false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, message.getUser_id());
            statement.setInt(2, message.getConversation_id());
            statement.setString(3, message.getMessage_content());

            if (statement.executeUpdate() != 0) {
                wasExecuteSuccess = true;
            }

            connection.close();
        } catch (SQLException e) {

        }

        return wasExecuteSuccess;
    }

    @Override
    public boolean deleteMessage(Message message) {
        String sql = "DELETE FROM \"public\".\"messages\" WHERE message_id = ?";
        boolean wasExecuteSuccess = false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, message.getMessage_id());

            if (statement.executeUpdate() != 0) {
                wasExecuteSuccess = true;
            }

            connection.close();
        } catch (SQLException e) {

        }

        return wasExecuteSuccess;
    }

    @Override
    public boolean editMessage(Message message) {
        String sql = "UPDATE \"public\".\"messages\" SET message_content = ? WHERE message_id = ?";
        boolean wasExecuteSuccess = false;

        try {
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, message.getMessage_content());
            statement.setInt(2, message.getMessage_id());

            if (statement.executeUpdate() != 0) {
                wasExecuteSuccess = true;
            }

            connection.close();
        } catch (SQLException e) {

        }

        return wasExecuteSuccess;
    }
}
