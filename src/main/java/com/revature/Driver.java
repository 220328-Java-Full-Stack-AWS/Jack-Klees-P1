package com.revature;

import com.revature.models.Role;
import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.util.ConnectionFactory;

import java.util.Scanner;
import java.util.UUID;

public class Driver {

    public static void main(String[] args) {
        UserDAO myUserDAO = new UserDAO();

       /** User myUser = new User(3,"admin","password", Role.FINANCE_MANAGER);
       myUser = myUserDAO.create(myUser);
       System.out.println("create test: " + myUser); */

        User queryUser = myUserDAO.read(2);
        System.out.println("Read Test ID: "+queryUser);

        UUID myUuid = UUID.randomUUID();

        ConnectionFactory.close();
    }
}
