package principal;

public class XAGM {
  private int antecessor[];
  private double p[];
  private XGrafo grafo;

  public XAGM (XGrafo grafo) { this.grafo = grafo; }  

  public void obterAgm (int raiz) throws Exception {
    int n = this.grafo.numVertices();
    this.p = new double[n]; // peso dos vertices
    int vs[] = new int[n+1]; // vertices
    boolean itensHeap[] = new boolean[n]; this.antecessor = new int[n];

    for (int u = 0; u < n; u ++) {
      this.antecessor[u] = -1;
      p[u] = Double.MAX_VALUE; // peso infinito
      vs[u+1] = u; // Heap indireto a ser construido
      itensHeap[u] = true;
    }

    p[raiz] = 0; //o peso da raiz eh zerado
    HeapMinIndireto heap = new HeapMinIndireto (p, vs); 
    heap.constroi ();

    while (!heap.vazio ()) { //percorre todo o heap
      int u = heap.retiraMin (); itensHeap[u] = false; //menor valor no heap

      if (!this.grafo.listaAdjVazia (u)) {
        XGrafo.Aresta adj = grafo.primeiroListaAdj (u); // Retorna a primeira aresta que o vertice u participa
        while (adj != null) {
          int v = adj.v2 (); // vai para o outro vertice
          if (itensHeap[v] && (adj.peso () < this.peso (v))) { //se o peso do vertice v for menor
            antecessor[v] = u; heap.diminuiChave (v, adj.peso ()); // antecessor recebe vertice u e sua chave eh diminuida
          }
          adj = grafo.proxAdj (u); //vai para proxima adjacencia 
        }
      }
    }
  }

  public int antecessor (int u) { return this.antecessor[u]; } // vertice antecessor
  public double peso (int u) { return this.p[u]; }

  public double pesoTotal(){ // retorna o peso da AGM
    int n = this.grafo.numVertices();
    double soma = 0;
    for(int i=0; i<n; i++){
        soma += this.p[i];
    }
    return soma;
  }

  public void imprime () {
    for (int u = 0; u < this.p.length; u++)
      if (this.antecessor[u] != -1) 
        System.out.println ("(" +antecessor[u]+ "," +u+ ") -- p:" +
                            peso (u));
  }
}
