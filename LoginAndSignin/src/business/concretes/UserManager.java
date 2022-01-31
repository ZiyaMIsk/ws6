package business.concretes;

import java.util.ArrayList;

import business.abstracts.UserService;
import core.exceptions.BusinessException;
import dataAccess.abstracts.UserDao;
import entities.concrete.User;

public class UserManager implements UserService {

	ArrayList<User> userList = new ArrayList<User>();
	private UserDao userDao;

	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public void add(User users) throws BusinessException {

		if (!users.geteMail().contains("@")) {
			throw new BusinessException("Geçersiz Maille deneniyor.");
		}
		if (users.getPassword().length() < 6) {
			throw new BusinessException("Paralo yetersizdir.");
		}
		if (users.getFirstName().length() < 2 || users.getLastName().length() < 2) {
			throw new BusinessException("İsim/soyisim cok kısadır.");

		}

		else {

			for (User user : userList) {
				if (user.geteMail().equals(users.geteMail())) {
					throw new BusinessException("Aynı eposta kullanılmamalıdır");

				}

			}
			
			userDao.add(users);
			userList.add(users);

		}

	}

	@Override
	public void update(User users) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(User users) {
		// TODO Auto-generated method stub

	}

}
