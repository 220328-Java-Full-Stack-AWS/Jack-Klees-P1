package com.revature.repositories;

import com.revature.models.User;
import com.revature.util.ConnectionFactory;

import java.sql.*;
import java.util.Optional;

public class UserDAO {

    /**
     * Should retrieve a User from the DB with the corresponding username or an empty optional if there is no match.
     */
    public Optional<User> getByUsername(String username) {
        return Optional.empty();
    }

    /**
     * <ul>
     *     <li>Should Insert a new User record into the DB with the provided information.</li>
     *     <li>Should throw an exception if the creation is unsuccessful.</li>
     *     <li>Should return a User object with an updated ID.</li>
     * </ul>
     */
    public User create(User userToBeRegistered) {
        String sql = "INSERT INTO users (username,password,first_name,last_name) VALUES (?,?,?,?)";
        try {
            PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1,userToBeRegistered.getUsername());
            pstmt.setString(2,userToBeRegistered.getPassword());
            pstmt.setString(3, userToBeRegistered.getRole().name());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if(keys.next()){
                int key = keys.getInt(1);
                userToBeRegistered.setId(key);
            }
        } catch (SQLException e) { e.printStackTrace();}
        return userToBeRegistered;
    }
}
