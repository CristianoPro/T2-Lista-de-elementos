/**
 * 
 * @author Cristiano Souza de Oliveira
 * tia 41612590
 *
 */

public class Ponto {
	private int x, y;

	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distancia(Ponto p) {
		double c1 = this.x - p.x;
		double c2 = this.y - p.y;
		return Math.sqrt(c1 * c1 + c2 * c2);
	}

	public boolean igual(Ponto p) {
		return this.x == p.x && this.y == p.y;
	}

	@Override
	public boolean equals(Object o) {
		// Polimorfismo de coercao: converte um objeto de uma classe para outra classe
		Ponto p = (Ponto) o;
		return this.x == p.x && this.y == p.y;
	}

	// reescrever o metodo toString da classe pai da classe Ponto
	// pai da classe Ponto eh a classe Object
	@Override
	public String toString() {
		return "(" + this.x + "," + this.y + ")";
	}
}
