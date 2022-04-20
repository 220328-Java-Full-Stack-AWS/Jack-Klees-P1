package com.revature.repositories;

import com.revature.models.Reimbursement;
import com.revature.models.Status;
import com.revature.util.ConnectionFactory;

import java.sql.*;
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
        Reimbursement reim = new Reimbursement();
        UserDAO tempA = new UserDAO();
        UserDAO tempR = new UserDAO();
        try {
            String sql = "SELECT * FROM reimburstments WHERE status = ?";
            Connection conn = ConnectionFactory.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1,status.toString());

            ResultSet rs = pstmt.executeQuery();

            while(rs.next()) {
                reim.setId(rs.getInt("item_id"));
                reim.setAuthor(tempA.read(rs.getString("author")));
                reim.setStatus(Status.valueOf(rs.getString("status")));
                reim.setResolver(tempR.read(rs.getString("resolver")));
                reim.setAmount(rs.getDouble("amount"));
                reim.setId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {e.printStackTrace();}
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
        String sql = "UPDATE reimburstments SET author = ?, status = ?, resolver = ?, amount = ?, user_id = ? WHERE item_id = ?";
        try {
            PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement(sql);
            pstmt.setString(1, unprocessedReimbursement.getAuthor().getUsername());
            pstmt.setString(2, unprocessedReimbursement.getStatus().toString());
            pstmt.setString(3, unprocessedReimbursement.getResolver().getUsername());
            pstmt.setDouble(4, unprocessedReimbursement.getAmount());
            pstmt.setInt(5, unprocessedReimbursement.getAuthor().getId());
            pstmt.setInt(6, unprocessedReimbursement.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {e.printStackTrace();}
        return unprocessedReimbursement;
    }
    public Reimbursement create(Reimbursement newReimb) {
        String sql = "INSERT INTO reimburstments (author,status,resolver,amount,user_id) VALUES (?,?,?,?,?)";
        try{
            PreparedStatement pstmt = ConnectionFactory.getConnection().prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            pstmt.setString(1, newReimb.getAuthor().getUsername());
            pstmt.setString(2, "Unresolved");
            pstmt.setString(3, " ");
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
