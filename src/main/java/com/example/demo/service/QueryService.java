package com.example.demo.service;

import com.example.demo.dao.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.*;
import java.util.ArrayList;

@Service
@Slf4j
public class QueryService {

    public static ArrayList<User> getUsers(Connection con, String query) throws SQLException {
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(query);
        ArrayList<User> users= new ArrayList<User>();
        while (rs.next()) {
            User user = User.builder().username(rs.getString("username")).build();

            try {
                user.setPassword(rs.getString("Password"));
            } catch (Exception e){
//                log.warn("");
            }

            users.add(user);
        }
        return users;
    }

    public static ArrayList<User> getUsersSecurely(Connection con, String query, User queryUser) throws SQLException {
        PreparedStatement statement = con.prepareStatement(query);
        statement.setString(1,queryUser.getUsername());
        statement.setString(2,queryUser.getPassword());
        ResultSet rs = statement.executeQuery();
        ArrayList<User> users= new ArrayList<User>();
        while (rs.next()) {
            User user = User.builder().username(rs.getString("username")).build();

            try {
                user.setPassword(rs.getString("Password"));
            } catch (Exception e){
//                log.warn("");
            }

            users.add(user);
        }
        return users;
    }
}
