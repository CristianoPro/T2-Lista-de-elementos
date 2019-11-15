package Model;
/**
 * 
 * @author Cristiano Souza de Oliveira
 * tia 41612590
 *
 */

public class Ponto3D extends Ponto {
	private int z;

	public Ponto3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}

	@Override
	public boolean equals(Object o) {
		Ponto3D p = (Ponto3D) o;
		return super.equals(o) && this.z == p.z;
	}

}
