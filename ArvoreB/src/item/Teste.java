package item;

public class Teste {
	public static void main (String[] args) {
		int tamArvore[] = {10000, 20000, 30000, 40000, 50000,
					60000, 70000, 80000, 90000, 100000};
		int ordemArvore[] = {2, 4, 6};
		
		// Exercicio 3)a)
		// Cria Arvores SBB de N elementos
		System.out.println("Arvores SBB");
		for(int i = 0; i<10; i++) {
		  	ArvoreSBB arvoreTeste = new ArvoreSBB ();
			Item item;
			int chaves[] = new int[tamArvore[i]];
			
			for (int j = 0; j < tamArvore[i]; j++)
			  chaves[j] = j;
			
			for (int j = 0; j < tamArvore[i]; j++) { 
			  item = new Item (chaves[j]);
			  arvoreTeste.insere (item); // insere itens ordenados
			}
			
			Item itemNaoExist = new Item(tamArvore[i]);
			arvoreTeste.pesquisa(itemNaoExist);	// procura itemNaoExistente
			
			System.out.println("ArvoreSBB[" + tamArvore[i] + "]: " + "Comparacoes: " + arvoreTeste.getComparacoes());
		}
		System.out.println();
		
		// Exercicio 3)b) c) e d)
		// Cria Arvores B de ordem 2, 4 e 6
		for(int k=0; k<3; k++) {
			System.out.println("Arvore B de ordem " + ordemArvore[k] + ": ");
			// Cria as 10 arvores com o tamanho (max[i]) variando de 1000 a 9000
			for(int i = 0; i<10; i++) {
			  	ArvoreB arvoreTeste = new ArvoreB (ordemArvore[k]);
				Item item;
				int chaves[] = new int[tamArvore[i]];
				
				for (int j = 0; j < tamArvore[i]; j++)
				  chaves[j] = j;
				
				for (int j = 0; j < tamArvore[i]; j++) { 
				  item = new Item (chaves[j]);
				  arvoreTeste.insere (item); // insere itens ordenados
				}
				
				Item itemNaoExist = new Item(tamArvore[i]);
				arvoreTeste.pesquisa(itemNaoExist);	// procura itemNaoExistente
				
				System.out.println("ArvoreB[" + tamArvore[i] + "]: " + "Comparacoes: " + arvoreTeste.getComparacoes());
			}
			System.out.println();
		}
	}
}