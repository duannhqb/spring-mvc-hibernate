package edu.poly.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.poly.dao.UserDao;
import edu.poly.entity.User;
import edu.poly.model.UserDTO;
import edu.poly.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;

	@Override
	public void addUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = new User();
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());

		userDao.addUser(user);

	}

	@Override
	public void updateUser(UserDTO userDTO) {
		// TODO Auto-generated method stub
		User user = userDao.getUserById(userDTO.getId());
		if (user != null) {
			user.setId(userDTO.getId());
			user.setPassword(userDTO.getPassword());
			user.setUsername(userDTO.getUsername());

			userDao.updateUser(user);
		}

	}

	@Override
	public void deleteUser(int id) {
		// TODO Auto-generated method stub
		User user = userDao.getUserById(id);
		if (user != null) {
			userDao.deleteUser(id);
		}
	}

	@Override
	public UserDTO getUserById(int id) {
		// TODO Auto-generated method stub
		User user = userDao.getUserById(id);
		UserDTO userDTO = new UserDTO();
		if (user != null) {
			userDTO.setId(user.getId());
			userDTO.setPassword(user.getPassword());
			userDTO.setUsername(user.getUsername());
		}

		return userDTO;
	}

	@Override
	public List<UserDTO> getAllUsers() {
		// TODO Auto-generated method stub
		List<User> listUsers = userDao.getAllUsers();
		List<UserDTO> listUserDTOs = new ArrayList<UserDTO>();

		for (User user : listUsers) {
			UserDTO userDTO = new UserDTO();
			userDTO.setId(user.getId());
			userDTO.setPassword(user.getPassword());
			userDTO.setUsername(user.getUsername());
			listUserDTOs.add(userDTO);
		}

		return listUserDTOs;
	}

}
