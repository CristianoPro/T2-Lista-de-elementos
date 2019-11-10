/**
 * 
 * @author Cristiano Souza de Oliveira
 * tia 41612590
 *
 */

public class Circulo {
	private double raio;
	private Ponto centro; // associacao Classe A possui B (=Ponto)
	// construtor

	public Circulo(double raio, Ponto centro) {
		this.raio = raio;
		this.centro = centro;
	}

	/*
	 * metodo decide se um ponto est� dentro do c�rculo.
	 */
	public boolean estaDentro(Ponto p) {
		return centro.distancia(p) <= raio;
	}
}
