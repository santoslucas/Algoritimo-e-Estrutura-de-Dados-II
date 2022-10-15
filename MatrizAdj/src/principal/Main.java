package principal;

public class Main {
    public static void main (String[] args){

        //--------------------------------- EXEMPLO 1 ------------------------------------
        xGrafo grafo1 = new xGrafo(8);

        grafo1.insereAresta(0, 1, 1);
        grafo1.insereAresta(0, 3, 1);
        grafo1.insereAresta(0, 4, 1);

        grafo1.insereAresta(1, 0, 1);
        grafo1.insereAresta(1, 2, 1);
        grafo1.insereAresta(1, 5, 1);

        grafo1.insereAresta(2, 1, 1);
        grafo1.insereAresta(2, 3, 1);
        grafo1.insereAresta(2, 6, 1);

        grafo1.insereAresta(3, 0, 1);
        grafo1.insereAresta(3, 2, 1);
        grafo1.insereAresta(3, 7, 1);

        grafo1.insereAresta(4, 0, 1);
        grafo1.insereAresta(4, 5, 1);
        grafo1.insereAresta(4, 7, 1);

        grafo1.insereAresta(5, 1, 1);
        grafo1.insereAresta(5, 4, 1);
        grafo1.insereAresta(5, 6, 1);

        grafo1.insereAresta(6, 2, 1);
        grafo1.insereAresta(6, 5, 1);
        grafo1.insereAresta(6, 7, 1);

        grafo1.insereAresta(7, 3, 1);
        grafo1.insereAresta(7, 4, 1);
        grafo1.insereAresta(7, 6, 1);

        System.out.println("GRAFO 1");
        grafo1.imprime();
        System.out.println();

        xCiclo grafo1_Ciclo = new xCiclo(grafo1);
        if(grafo1_Ciclo.possuiCiclos()) // Verifica a existencia de arestas de retorno, ou seja, ciclos
            System.out.println("O grafo 1 possui ciclos.\n"+"Ele possui: "+grafo1_Ciclo.numArestasRetorno+" arestas de retorno.\n");
        else
            System.out.println("O grafo 1 NÃO possui ciclos.\n");

        //--------------------------------- EXEMPLO 2 ------------------------------------
        xGrafo grafo2 = new xGrafo(10);

        grafo2.insereAresta(0, 1, 1);
        grafo2.insereAresta(0, 2, 1);
        grafo2.insereAresta(0, 3, 1);
        grafo2.insereAresta(0, 5, 1);

        grafo2.insereAresta(1, 2, 1);

        grafo2.insereAresta(2, 3, 1);
        grafo2.insereAresta(2, 4, 1);

        grafo2.insereAresta(4, 6, 1);

        grafo2.insereAresta(5, 4, 1);
        grafo2.insereAresta(5, 6, 1);

        grafo2.insereAresta(6, 7, 1);
        grafo2.insereAresta(6, 8, 1);

        grafo2.insereAresta(7, 8, 1);

        grafo2.insereAresta(9, 6, 1);

        System.out.println("GRAFO 2");
        grafo2.imprime();
        System.out.println();

        xCiclo grafo2_Ciclo = new xCiclo(grafo2); 
        if(grafo2_Ciclo.possuiCiclos()) // Verifica a existencia de arestas de retorno, ou seja, ciclos
            System.out.println("O grafo 2 possui ciclos.");
        else
            System.out.println("O grafo 2 NÃO possui ciclos.");
    }
}
