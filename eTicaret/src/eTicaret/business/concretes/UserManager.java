package eTicaret.business.concretes;

import java.util.ArrayList;
import java.util.Iterator;

import eTicaret.business.abstracts.UserService;
import eTicaret.core.concretes.BusinessException;
import eTicaret.dataAccess.abstracts.UserDao;
import eTicaret.entities.concretes.User;

public class UserManager implements UserService {

	private UserDao userDao;
	boolean name;
	boolean pswrd;
	boolean id;
	boolean em;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	private boolean addUserCheckÝd(User user) throws BusinessException {
		if (this.userDao.getAll().contains(user.getId())) {
			throw new BusinessException("Kullanýcý mevcut");
		} else {
			return true;
		}
	}

	private boolean addUserCheckName(User user) throws BusinessException {
		if (user.getFirstName().length() > 2 && user.getLastName().length() > 2) {
			return true;
		} else {
			throw new BusinessException("Ad veya Soyad 2 harften küçük olamaz");
		}
	}

	private boolean addUserCheckPassword(User user) throws BusinessException {
		if (user.getPassword().length() > 6) {
			return true;
		} else {
			throw new BusinessException("Parola 6 haneden küçük olamaz");
		}
	}

	private boolean addUserCheckEMail(User user) throws BusinessException {

		if (user.geteMail().contains("@")) {
			return true;

		} else {
			throw new BusinessException("Email bilgilerinizi doðru giriniz");

		}

	}

	@Override
	public void add(User user) throws BusinessException {

		if (addUserCheckEMail(user) && addUserCheckÝd(user) && addUserCheckName(user) && addUserCheckPassword(user)) {
			this.userDao.add(user);
		}

	}

	@Override
	public void update(User user) throws BusinessException {
		if (addUserCheckEMail(user) && addUserCheckName(user) && addUserCheckPassword(user)) {
			this.userDao.update(user);
		} else {
			throw new BusinessException("Kullanýcý bilgilerinizi kontrol ediniz");
		}

	}

	@Override
	public void delete(User user) {
		this.userDao.delete(user);
	}

	@Override
	public ArrayList<User> getAll() {
		return this.userDao.getAll();

	}

}
