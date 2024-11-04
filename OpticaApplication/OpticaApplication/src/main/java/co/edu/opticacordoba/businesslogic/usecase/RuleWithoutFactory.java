package co.edu.opticacordoba.businesslogic.usecase;

public interface RuleWithoutFactory<T> {

	void execute(T data);
}
