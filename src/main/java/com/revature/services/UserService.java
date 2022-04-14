package com.revature.services;

import java.util.Optional;

import com.revature.models.User;

/**
 * The UserService should handle the processing and retrieval of Users for the ERS application.
 *
 * {@code getByUsername} is the only method required;
 * however, additional methods can be added.
 *
 * Examples:
 * <ul>
 *     <li>Create User</li>
 *     <li>Update User Information</li>
 *     <li>Get Users by ID</li>
 *     <li>Get Users by Email</li>
 *     <li>Get All Users</li>
 * </ul>
 */
public class UserService {

	/**
	 *     Should retrieve a User with the corresponding username or an empty optional if there is no match.
     */
	public Optional<User> getByUsername(String username) {
		return Optional.empty();
	}

	/* As a user, I can submit a request for reimbursement
	As a user, I can cancel a pending request for reimbursement
	As a user, I can view my pending and completed past requests for reimbursement
	As a user, I can edit my pending requests for reimbursement */
}
