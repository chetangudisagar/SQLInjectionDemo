package com.example.demo;

import com.example.demo.connector.ConnectionHelper;
import com.example.demo.dao.User;
import com.example.demo.service.QueryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

@SpringBootApplication
@Slf4j
public class DemoApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(DemoApplication.class, args);

        while (true) {

            Scanner versionScanner = new Scanner(System.in);
            System.out.println("Enter the service version (1=Normal Query, 2=PreparedStatements):");
            int version = versionScanner.nextInt();

            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the username:");
            String username = scanner.nextLine();

            System.out.println("Enter the Password:");
            String Password = scanner.nextLine();
            // anything' or '1=1
            String query = "SELECT username, Password from login " +
                    "where username = '" + username + "' and Password='" + Password + "'";
            String preparedStatementQuery = "SELECT username, Password from login " +
                    "where username = ? and Password= ?";
            Connection con = ConnectionHelper.getDefaultConnection();
            ArrayList<User> users;
            if (version==1){
                users = QueryService.getUsers(con, query);
            }else{
                users = QueryService.getUsersSecurely(con, preparedStatementQuery,
                        User.builder().username(username).Password(Password).build());
            }

            if(users.size()==0){
                log.warn("Wrong Username or Password");
            }
            else{
                log.warn("Login Successful!");
            }

            for (User user : users) {
                log.info(user.toString());
            }
        }
    }
}
