package co.edu.opticacordoba.businesslogic.facade;

public interface FacadeWithReturn<T, R> {

	R execute(T data);
}
