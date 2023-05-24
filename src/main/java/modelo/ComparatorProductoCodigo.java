package modelo;

import java.util.Comparator;

public class ComparatorProductoCodigo implements Comparator<Producto>{

	@Override
	public int compare(Producto p1, Producto p2) {
			return p1.getCodigo().compareTo(p2.getCodigo());
				
	}

}
