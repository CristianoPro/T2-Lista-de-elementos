/**
 * 
 * @author Cristiano Souza de Oliveira
 * tia 41612590
 *
 */

public class Ponto3D extends Ponto {
	private int z;

	public Ponto3D(int x, int y, int z) {
		// chamar o construtor do pai, ou seja, da classe Ponto
		super(x, y);
		this.z = z;
	}

	// Polimorfismo de inclusao ( sobrescrita)
	@Override
	public boolean equals(Object o) {
		Ponto3D p = (Ponto3D) o;
		// super.equals(o)=chama o metodo equals da classe pai (Ponto)
		return super.equals(o) && this.z == p.z;
	}
	// Polimorfismo de overloding (sobrecarga)
	// public double distancia( Ponto3D p){
	// Como acessar o x e y da classe pai
	// }
}
