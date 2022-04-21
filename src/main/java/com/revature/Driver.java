package com.revature;

import com.revature.models.Reimbursement;
import com.revature.models.Role;
import com.revature.models.Status;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.UserDAO;
import com.revature.util.ConnectionFactory;

import java.util.Scanner;
import java.util.UUID;

public class Driver {

    public static void main(String[] args) {
        UserDAO myUserDAO = new UserDAO();
        ReimbursementDAO myReimDAO = new ReimbursementDAO();

    // Created 3 Users and Read works
       /**User myUser = new User(1,"admin","password", Role.FINANCE_MANAGER);
       myUser = myUserDAO.create(myUser);
       System.out.println("create test: " + myUser);
       User myJack = new User(2,"Jack","mojo",Role.FINANCE_MANAGER);
       myJack = myUserDAO.create(myJack);
       User myKenny = new User(3,"Kenny","bentley",Role.EMPLOYEE);
       myKenny = myUserDAO.create(myKenny);*/
        // User myUser = myUserDAO.read(1);
        // User myJack = myUserDAO.read(2);
        // User myKenny = myUserDAO.read("Kenny");
    //Creating a Reimbursement
       /**Reimbursement myReim = new Reimbursement(myUser.getId(), Status.DENIED,myUser,myUser,2000);
       myReim = myReimDAO.create(myReim);
       System.out.println("Create Test Reimbursements: " + myReim);*/
    // Reading for a reimbursement by ID and updating one
       /**Reimbursement findReim = myReimDAO.read(3);
       System.out.println(findReim);
       findReim.setStatus(Status.APPROVED);
       findReim = myReimDAO.update(findReim);
       System.out.println(findReim);*/

       UUID myUuid = UUID.randomUUID();
       ConnectionFactory.close();
    }
}
