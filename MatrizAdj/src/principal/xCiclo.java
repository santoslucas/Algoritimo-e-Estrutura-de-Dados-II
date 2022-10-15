package principal;

public class xCiclo {
  public static final byte branco = 0;
  public static final byte cinza  = 1;
  public static final byte preto  = 2;
  public int numArestasRetorno = 0;
  private int d[], t[], antecessor[];
  private xGrafo grafo;

  public xCiclo (xGrafo grafo) {
    this.grafo = grafo; int n = this.grafo.numVertices();
    d = new int[n]; t = new int[n]; //tempo de visita e termino de cada vertice
    antecessor = new int[n];
  }

  private int visitaDfs (int u, int tempo, int cor[]) {
    cor[u] = cinza; this.d[u] = ++tempo; //aresta vira cinza, tempo de visita

    if (!this.grafo.listaAdjVazia (u)) { //se a lista de adj nao esta vazia
      xGrafo.Aresta a = this.grafo.primeiroListaAdj (u); //pega a primeira adjacencia
      while (a != null) { //percorre rodas adjacencias
        int v = a.v2 ();
        if (cor[v] == branco) { //vertice nao percorrido
          this.antecessor[v] = u;
          tempo = this.visitaDfs (v, tempo, cor);
        }

        else if (cor[v] == cinza){ //vertice ja percorrido
          this.numArestasRetorno++; //entao, temos uma aresta de retorno
        }
        a = this.grafo.proxAdj (u); //proxima adjacencia
      }
    }
    cor[u] = preto; this.t[u] = ++tempo; //tempo de termino

    return tempo;
  }

  public void buscaEmProfundidade () {
    int tempo = 0; int cor[] = new int[this.grafo.numVertices ()]; 
    for (int u = 0; u < grafo.numVertices (); u++) { //seta todos vertices como brancos
      cor[u] = branco; this.antecessor[u] = -1;
    }     
    for (int u = 0; u < grafo.numVertices (); u++) //percorre os vertices e seus adjacentes
      if (cor[u] == branco) tempo = this.visitaDfs (u, tempo, cor);
  }

  public int d (int v) { return this.d[v]; }
  public int t (int v) { return this.t[v]; }
  public int antecessor (int v) { return this.antecessor[v]; }

  public boolean possuiCiclos(){
    buscaEmProfundidade(); // faz a busca em profundida e contabiliza as aretas de retorno

    if (this.numArestasRetorno > 0) // se possui arestas de retorno, possui ciclos
      return true;
    
    else //senao, nao possui ciclos
      return false;
  }
}