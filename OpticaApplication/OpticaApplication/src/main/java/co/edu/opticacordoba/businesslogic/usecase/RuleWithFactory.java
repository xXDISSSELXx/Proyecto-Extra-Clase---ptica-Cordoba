package co.edu.opticacordoba.businesslogic.usecase;

import co.edu.opticacordoba.data.dao.DAOFactory;

public interface RuleWithFactory<T> {

	void execute(T data, DAOFactory factory);
	
	void executeUpdate(T data, DAOFactory factory);
}
