package business.abstracts;

import core.exceptions.BusinessException;
import entities.concrete.User;

public interface UserService {

	void add(User users) throws BusinessException;
	void update(User users);
	void delete(User users);
}
