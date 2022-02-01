package eTicaret;

import java.util.ArrayList;

import eTicaret.business.abstracts.UserService;
import eTicaret.business.concretes.UserManager;
import eTicaret.core.concretes.BusinessException;
import eTicaret.dataAccess.concretes.UserJdbcDao;
import eTicaret.entities.concretes.User;

public class Main {

	public static void main(String[] args) throws BusinessException {
		User user = new User(1, "Serhat", "Ataþ", "71312544", "serhatats@gmail.com");
		UserService userManager = new UserManager(new UserJdbcDao());
		try {

			userManager.add(user);

		} catch (BusinessException e) {

			System.out.println(e.getMessage());
		}
		ArrayList<User> users = userManager.getAll();
		for (User user4 : users) {
			System.out.println(user4.getFirstName());
		}
	}

}
