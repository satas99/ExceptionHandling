package eTicaret.dataAccess.concretes;

import java.util.ArrayList;

import eTicaret.core.concretes.BusinessException;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserJdbcDao implements UserDao {
	ArrayList<User> users = new ArrayList<User>();

	@Override
	public void add(User user) {
		System.out.println("Jdbc ile eklendi");
		users.add(user);
	}

	@Override
	public void update(User updateUser) {
		for (User user : users) {
			if (user.getId() == updateUser.getId()) {
				users.set(users.indexOf(user), updateUser);
			}
		}

	}

	@Override
	public void delete(User user) {
		users.remove(user);

	}

	@Override
	public ArrayList<User> getAll() {
		// TODO Auto-generated method stub
		return users;
	}

}
