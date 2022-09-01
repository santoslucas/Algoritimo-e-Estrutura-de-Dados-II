package item;
import java.util.*;

public class Teste {
	public static void main (String[] args) {
		int tamArvore[] = {1000, 2000, 3000, 4000, 5000,
					6000, 7000, 8000, 9000};
		
		// Exercicio 4)a)
		System.out.println("ORDENADOS:");
		// Cria as 9 arvores com o tamanho (max[i]) variando de 1000 a 9000
		for(int i = 0; i<9; i++) {
		  	ArvoreBinaria arvoreTeste = new ArvoreBinaria ();
			Item item;
			int chaves[] = new int[tamArvore[i]];
			
			for (int j = 0; j < tamArvore[i]; j++)
			  chaves[j] = j;
			
			for (int j = 0; j < tamArvore[i]; j++) { 
			  item = new Item (chaves[j]);
			  arvoreTeste.insere (item); // insere itens ordenados
			}
			
			Item itemNaoExist = new Item(tamArvore[i]);
			
			long tempoAntesPesq = System.nanoTime();
			arvoreTeste.pesquisa(itemNaoExist);	// procura itemNaoExistente
			long tempoDepoisPesq = System.nanoTime();
			long tempoGasto = tempoDepoisPesq - tempoAntesPesq; // calcula o tempo gasto apenas no metodo pesquisa
			
			System.out.println("Arvore[" + tamArvore[i] + "]: " + "Comparacoes: " + arvoreTeste.getComparacoes() +  ", Tempo gasto: " + tempoGasto + "ns");
		}
		
		// Exercicio 4)b)
		System.out.println("\nALEATORIOS:");
		for(int i = 0; i<9; i++) {
			Random rand = new Random();
		  	ArvoreBinaria arvoreTeste = new ArvoreBinaria ();
			Item item;
			int chaves[] = new int[tamArvore[i]];
			
			for (int j = 0; j < tamArvore[i]; j++)
			  chaves[j] = rand.nextInt(); // insere numeros aleatorios
			
			for (int j = 0; j < tamArvore[i]; j++) { 
			  item = new Item (chaves[j]);
			  arvoreTeste.insere (item);
			}
			
			Item itemNaoExist = new Item(tamArvore[i]);
			
			long tempoAntesPesq = System.nanoTime();
			arvoreTeste.pesquisa(itemNaoExist);
			long tempoDepoisPesq = System.nanoTime();
			long tempoGasto = tempoDepoisPesq - tempoAntesPesq;
			
			System.out.println("Arvore[" + tamArvore[i] + "]: " + "Comparacoes: " + arvoreTeste.getComparacoes() +  ", Tempo gasto: " + tempoGasto + "ns");
		}
	}
}
