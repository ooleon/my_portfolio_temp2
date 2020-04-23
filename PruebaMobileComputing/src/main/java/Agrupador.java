import java.util.Collection;
import java.util.Map;

public interface Agrupador<T, G> {
	Map<G, Collection<T>> agruparPor(Collection<T> coleccion, Criterio<T, G> criterio);
}
