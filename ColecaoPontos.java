import java.util.Scanner;

/**
 * 
 * @author Cristiano Souza de Oliveira
 * tia 41612590
 *
 */

public class ColecaoPontos {

	public static void main(String[] args) {
		ListaPonto colecao = CriarColecao(); 
		
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		int opcao;
		
		do {
			
			montaMenu();
			System.out.print("Digite sua opcao: ");
			opcao = teclado.nextInt();
			System.out.println("==========================================================\n");
			
			switch (opcao) {
			case 1:
				AdicionarNoFinal(colecao);
				break;
			case 2:
				AdicionarNaPosicao(colecao);
				break;
			case 3:
				RetornarIndex(colecao);
				break;
			case 4:
				RemoverNaPosicao(colecao);
				break;
			case 5:
				CalcularDistancia(colecao);
				break;
			case 6:
				MostrarPontosNoCirculo(colecao);
				break;
			case 0:
				System.out.println("Saindo...");
				break;
			default:
				System.out.println("Opção Inválida!");
				break;
			}
			
		}while (opcao !=0 );
	}
	
	
	
	private static ListaPonto AdicionarNoFinal(ListaPonto colecao) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
			
		int tamanhoColecao = colecao.getPontos().length;
		
		for(int i = 0; i < tamanhoColecao; i++) {
			int x,y;
			
			System.out.print("Informe a coordenada x do ponto: ");
			x = teclado.nextInt();
			
			System.out.print("Informe a coordenada y do ponto: ");
			y = teclado.nextInt();
			
			Ponto p = new Ponto(x,y);
			
			if(colecao.AdicionarNoFinal(p)) {
				System.out.println("Ponto adicionado a Colecao!");
				
			}else{
				System.out.println("Nao foi possivel adicionar o ponto a colecao pois a colecao já está cheia");
				break;
			};
			
			System.out.println("===========================================================");	
			
			if( i < tamanhoColecao-1) {
				System.out.print("Adicionar mais algum ponto no final da colecao? 1 = sim, 0 = nao: ");
				int controle = 1;
				controle = teclado.nextInt();
				System.out.println("===========================================================");
				if(controle == 0) {
					break;
				}
			}
		
		}
		
		System.out.println("Colecao de Pontos");
		colecao.ShowPontosLista();
		System.out.println("===========================================================");
		return colecao;
	}
		



	private static void AdicionarNaPosicao(ListaPonto colecao) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		
		int x,y,index;
		
		System.out.print("Informe a coordenada x do ponto: ");
		x = teclado.nextInt();
		System.out.print("Informe a coordenada y do ponto: ");
		y = teclado.nextInt();
		
		Ponto p = new Ponto(x,y);
		
		System.out.print("Informe  a posicao onde o ponto deve ser inserido: ");
		index = teclado.nextInt();
		
		colecao.AdicionarNaPosicao(index, p);
		//System.out.println("Ponto adicionado na posicao " + index );
		colecao.ShowPontosLista();
		
		
		
	}



	private static void RetornarIndex(ListaPonto colecao) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
				
		System.out.println("Informe a coordenada x do ponto a ser encontrado: ");
		int x = teclado.nextInt();
		
		System.out.println("Informe a coordenada y do ponto a ser encontrado: ");
		int y = teclado.nextInt();
		
		Ponto p = new Ponto(x,y);
		
		System.out.println(colecao.RetornaIndex(p));
		
	}



	private static void RemoverNaPosicao(ListaPonto colecao) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe a posicao do ponto que deseja remover: ");
		int posicao = teclado.nextInt();
		colecao.RemoveElemento(posicao);
		
		colecao.ShowPontosLista();
		
	}



	private static void CalcularDistancia(ListaPonto colecao) {
		System.out.println(colecao.MaiorDistanciaEntrePontos());
		
	}

	private static void MostrarPontosNoCirculo(ListaPonto colecao) {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		System.out.println("Informe o raio da circunferencia: ");
		double raio = teclado.nextInt();
		System.out.println("======Informe as coordenadas cetro da circunferencia======");
		System.out.println("Digite a coordenada x: ");
		int x = teclado.nextInt();
		System.out.println("Digite a coordenada y: ");
		int y = teclado.nextInt();
		Ponto p = new Ponto(x,y);
		
		ListaPonto colecaoPontosNoCirculo = colecao.PontosDentroDoCirculo(raio, p);
		
		colecaoPontosNoCirculo.ShowPontosLista();		
		
		
	}
	
	private static ListaPonto CriarColecao() {
		@SuppressWarnings("resource")
		Scanner teclado = new Scanner(System.in);
		int n;
		System.out.println("==========================================================\n");
		System.out.print("Informe o tamanho da colecao de pontos: ");
		n = teclado.nextInt();
		System.out.println("");	
		System.out.println("==========================================================\n");
		
		ListaPonto colecao = new ListaPonto(n);
		return colecao;
	}



	static void montaMenu() {
		System.out.println("\n                             ### Colecao de Pontos ###");
		System.out.println("\n                   ========================================================");
		System.out.println("                  |  1 - Adicionar um elemento no final da colecao           |");
		System.out.println("                  |  2 - Adicionar um elemento em uma posicao da colecao     |");
		System.out.println("                  |  3 - Indice da primeira ocorrencia de um elemento        |");
		System.out.println("                  |  4 - Remover um elemento em uma posicao na colecao       |");
		System.out.println("                  |  5 - Distancia dos dois pontos mais distantes na colecao |");
		System.out.println("                  |  6 - Colecao de pontos dentro do circulo                 |");
		System.out.println("                  |  0 - Sair                                                |");
		System.out.println("                   =======================================================\n");
	}

}
