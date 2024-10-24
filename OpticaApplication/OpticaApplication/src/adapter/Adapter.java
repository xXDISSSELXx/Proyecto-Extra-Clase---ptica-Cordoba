package co.edu.opticacordoba.businesslogic.adapter;

public interface Adapter<D, T> {

	D adaptSource(T data);
	
	T adaptTarget(D data);
}