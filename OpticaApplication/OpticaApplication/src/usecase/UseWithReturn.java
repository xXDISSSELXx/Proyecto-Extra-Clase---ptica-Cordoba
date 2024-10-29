package co.edu.opticacordoba.businesslogic.usecase;

public interface UseWithReturn<D, R> {

	R execute(D data);
}
