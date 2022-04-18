package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ReimbursementDAO {

    /**
     * Should retrieve a Reimbursement from the DB with the corresponding id or an empty optional if there is no match.
     */
    public Optional<Reimbursement> getById(int id) {
        return Optional.empty();
    }

    /**
     * Should retrieve a List of Reimbursements from the DB with the corresponding Status or an empty List if there are no matches.
     */
    public List<Reimbursement> getByStatus(Status status) {
        return Collections.emptyList();
    }

    /**
     * <ul>
     *     <li>Should Update an existing Reimbursement record in the DB with the provided information.</li>
     *     <li>Should throw an exception if the update is unsuccessful.</li>
     *     <li>Should return a Reimbursement object with updated information.</li>
     * </ul>
     */
    public Reimbursement update(Reimbursement unprocessedReimbursement) {
    	return null;
    }

    public Reimbursement create(Reimbursement newReimb) {
        String sql = "INSERT INTO reimburstments (author,status,resolver,amount,user_id) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, newReimb.getAuthor().getUsername());
            pstmt.setString(2, newReimb.getStatus().toString());
            pstmt.setString(3, newReimb.getResolver().getUsername());
            pstmt.setDouble(4, newReimb.getAmount());
            pstmt.setInt(5, newReimb.getAuthor().getId());
            pstmt.executeUpdate();

            ResultSet keys = pstmt.getGeneratedKeys();
            if (keys.next()) {
                int key = keys.getInt(1);
                newReimb.setId(key);
            }
        } catch(SQLException e) {e.printStackTrace();}
        return newReimb;
    }

}
