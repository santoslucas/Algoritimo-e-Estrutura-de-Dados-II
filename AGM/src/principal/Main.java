package principal;

public class Main {
	public static void main(String[] args) throws Exception {
		//--------------------- GRAFO 1 -----------------------
		XGrafo grafo1 = new XGrafo(9);
		grafo1.insereAresta(0, 1, 5);
		grafo1.insereAresta(0, 3, 10);
		grafo1.insereAresta(0, 4, 5);
		grafo1.insereAresta(0, 6, 10);
		grafo1.insereAresta(0, 7, 20);

		grafo1.insereAresta(1, 0, 5);
		grafo1.insereAresta(1, 5, 5);
		grafo1.insereAresta(1, 7, 5);
		grafo1.insereAresta(1, 8, 10);

		grafo1.insereAresta(2, 3, 5);
		grafo1.insereAresta(2, 4, 10);
		grafo1.insereAresta(2, 6, 5);

		grafo1.insereAresta(3, 0, 10);
		grafo1.insereAresta(3, 2, 5);
		grafo1.insereAresta(3, 4, 5);
		grafo1.insereAresta(3, 6, 10);

		grafo1.insereAresta(4, 0, 5);
		grafo1.insereAresta(4, 2, 10);
		grafo1.insereAresta(4, 3, 5);
		grafo1.insereAresta(4, 8, 10);

		grafo1.insereAresta(5, 1, 5);
		grafo1.insereAresta(5, 6, 15);

		grafo1.insereAresta(6, 0, 10);
		grafo1.insereAresta(6, 2, 5);
		grafo1.insereAresta(6, 3, 10);
		grafo1.insereAresta(6, 5, 15);

		grafo1.insereAresta(7, 0, 10);
 		grafo1.insereAresta(7, 1, 5);
		grafo1.insereAresta(7, 8, 20);

		grafo1.insereAresta(8, 1, 10);
		grafo1.insereAresta(8, 4, 10);
		grafo1.insereAresta(8, 7, 20);

		System.out.println("GRAFO 1:");
		System.out.println("0-A, 1-B, 2-C, 3-D, 4-E, 5-F, 6-G, 7-H, 8-K\n");
        grafo1.imprime();
        System.out.println();

		XAGM agm1 = new XAGM(grafo1);
		agm1.obterAgm(5);
		System.out.println("Peso da Árvore Geradora Mínima: " + agm1.pesoTotal());
		System.out.println("AGM 1:");
		agm1.imprime();
		System.out.println();

		//--------------------- GRAFO 2 -----------------------
		XGrafo grafo2 = new XGrafo(8);
		grafo2.insereAresta(0, 1, 8);
		grafo2.insereAresta(0, 2, 2);
		grafo2.insereAresta(0, 6, 9);

		grafo2.insereAresta(1, 0, 8);
		grafo2.insereAresta(1, 2, 3);
		grafo2.insereAresta(1, 3, 2);
		grafo2.insereAresta(1, 4, 7);
		grafo2.insereAresta(1, 5, 5);
		grafo2.insereAresta(1, 7, 6);

		grafo2.insereAresta(2, 0, 2);
		grafo2.insereAresta(2, 1, 3);
		grafo2.insereAresta(2, 3, 9);
		grafo2.insereAresta(2, 6, 6);

		grafo2.insereAresta(3, 1, 2);
		grafo2.insereAresta(3, 2, 9);
		grafo2.insereAresta(3, 4, 6);
		grafo2.insereAresta(3, 6, 2);

		grafo2.insereAresta(4, 1, 7);
		grafo2.insereAresta(4, 3, 6);
		grafo2.insereAresta(4, 5, 5);
		grafo2.insereAresta(4, 6, 4);

		grafo2.insereAresta(5, 1, 5);
		grafo2.insereAresta(5, 4, 5);
		grafo2.insereAresta(5, 6, 6);
		grafo2.insereAresta(5, 7, 4);

		grafo2.insereAresta(6, 0, 9);
		grafo2.insereAresta(6, 2, 6);
		grafo2.insereAresta(6, 3, 2);
		grafo2.insereAresta(6, 4, 4);
		grafo2.insereAresta(6, 5, 6);
		grafo2.insereAresta(6, 7, 3);

		grafo2.insereAresta(7, 1, 6);
		grafo2.insereAresta(7, 5, 4);
		grafo2.insereAresta(7, 6, 3);

		System.out.println("GRAFO 2:");
		System.out.println("0 (1), 1 (2), 2 (3), 3 (4), 4 (5), 5 (6), 6 (7), 7 (8)\n");
		grafo2.imprime();
		System.out.println();

		XAGM agm2 = new XAGM(grafo2);
		agm2.obterAgm(1);
		System.out.println("Peso da Árvore Geradora Mínima: " + agm2.pesoTotal());
		System.out.println("AGM 2:");
		agm2.imprime();
		System.out.println();
	}
}
