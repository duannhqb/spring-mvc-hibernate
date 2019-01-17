package edu.poly.service;

import java.util.List;

import edu.poly.model.UserDTO;

public interface UserService {
	public void addUser(UserDTO userDTO);
	
	public void updateUser(UserDTO userDTO);
	
	public void deleteUser(int id);
	
	public UserDTO getUserById(int id);
	
	public List<UserDTO> getAllUsers();
	
}
