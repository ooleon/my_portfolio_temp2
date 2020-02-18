package main;

public interface Criterio<T, G> {
	G perteneceA(T miObjeto);
}
