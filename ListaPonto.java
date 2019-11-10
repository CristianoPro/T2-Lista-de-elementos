/**
 * 
 * @author Cristiano Souza de Oliveira
 * tia 41612590
 *
 */

public class ListaPonto {
	private Ponto pontos[];
	private int validos;
	
	public ListaPonto (int n) {
		this.pontos = new Ponto[n];
		this.validos = 0;
	}
	
	public boolean AdicionarNoFinal(Ponto x) {
		int valido = this.validos;
		if(valido < this.pontos.length) {
			this.pontos[valido] = x;
			this.validos += 1;
			return true;
		}else 
			return false;
		
	}
	
	public boolean AdicionarNaPosicao(int index, Ponto x) {
		int posicao = index-1;
		int valido = this.validos;
		
		if(posicao < this.pontos.length && posicao >= 0) {
			for(int i = valido-1; i >= posicao; i-= 1) {
				this.pontos[i+1] = this.pontos[i];
				
			}			
			this.pontos[posicao] = x;
			this.validos ++;
			
			//System.out.println(this.pontos[posicao]);
			return true;
		}
		return false;
	}
		
	public int RetornaIndex(Ponto x) {
		int index = -1;
		for(int i=0; i <= this.validos-1; i++) {
			if(this.pontos[i].igual(x)) {
				index = i;
				return index;
			}			
		}
		return index;
	}
	
	public boolean RemoveElemento(int index) {
		int posicao = index-1; 
		if(posicao <= this.validos) {
			for(int i = posicao; i < this.validos; i++) {
				this.pontos[i] = this.pontos[i+1];
			}
			this.validos--;
			return true;
		}
		return false;
	}
	
	public double MaiorDistanciaEntrePontos() {
		double maiorDistancia=0;
		for(int i = 0; i < this.validos-1; i++) {
			for(int j=i; j < this.validos-1; j++) {
				double distancia = this.pontos[i].distancia(this.pontos[j+1]);
				if(distancia > maiorDistancia) {
					maiorDistancia = distancia;
				}
			}			
		}
		return maiorDistancia;		
	}	
	
	public ListaPonto PontosDentroDoCirculo(double r, Ponto x) {
		Circulo c = new Circulo(r,x);
		ListaPonto pontosNoCirculo = new ListaPonto(this.validos);
		for(int i = 0; i < this.validos; i++) {
			if(c.estaDentro(this.pontos[i])) {
				pontosNoCirculo.AdicionarNoFinal(this.pontos[i]);
			}
		}
		return pontosNoCirculo;
		
	}
	
	
	
	
	public void ShowPontosLista() {
		for(int i=0; i < this.validos; i++) {
			System.out.println(this.pontos[i]);
		}
	}

	public Ponto[] getPontos() {
		return pontos;
	}

	public void setPontos(Ponto[] pontos) {
		this.pontos = pontos;
	}

	public int getValidos() {
		return validos;
	}

	public void setValidos(int validos) {
		this.validos = validos;
	}
	
	
}
