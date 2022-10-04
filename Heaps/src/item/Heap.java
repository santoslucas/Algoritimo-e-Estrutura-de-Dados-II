package item;

public class Heap {
  private Item v[];
  private int  n;
  private int comparacoes = 0;
  
  public Heap (int maxTam) { 
    this.v = new Item[maxTam + 1]; this.n = 0; //cria um heap vazio
  }
  
  public Heap (Item v[]) { 
    this.v = v; this.n = this.v.length - 1; //cria um heap a partir de um vetor e define seu tamanho
  }
  
  public void refaz (int esq, int dir) { // ajusta a posicao esq
    int j = esq * 2; Item x = this.v[esq]; // j eh o filho à esquerda no heap
    while (j <= dir) { // percorre o heap
      comparacoes++; // incrementa comparacoes
      if ((j < dir) && (this.v[j].compara (this.v[j + 1]) < 0)) // verifica se a posicao eh valida e qual é o menor filho de J
        j++; 
      if (x.compara (this.v[j]) >= 0) // verifica se a posicao atual (item x) eh maior que o maior filho J
        break;
      this.v[esq] = this.v[j]; // senao for maior, trocam se os itens
      esq = j; j = esq * 2;
    }
    this.v[esq] = x;
  }
  
  public void constroi () {
    int esq = n / 2 + 1; // primeiro elemento da esquerda-direita
    while (esq > 1) { // executa o metodo refaz ate o primeiro elemento
      esq--; this.refaz (esq, this.n);
    }
  }
  
  public void aumentaChave (int i, Object chaveNova) throws Exception {
    Item x = this.v[i];
    if (chaveNova == null) // chave invalida
      throw new Exception ("Erro: chaveNova com valor null");
    x.setChave ((int) chaveNova); // se a chave for valida, altera a chave
    while ((i > 1) && (x.compara (this.v[i / 2]) >= 0)) { // verifica se a nova chave eh maior que seu pai no heap
      this.v[i] = this.v[i / 2]; i /= 2; //realiza o ajuste (trocam-se as chaves)
    }
    this.v[i] = x;
  }
  
  public void insere (Item x) throws Exception { // insere um novo item
    this.n++; //aumenta tamanho
    if (this.n == this.v.length) throw new Exception ("Erro: heap cheio");
    Object chaveNova = x.getChave ();
    this.v[this.n] = x; //insere item
    this.v[this.n].setChave (new Integer (Integer.MIN_VALUE)); 
    this.aumentaChave (this.n, chaveNova); // aumenta a chave
  }
  
  public Item getItem(int i) {
	  return this.v[i];
  }
  
  public void setItem(Item item, int i) {
	  this.v[i] = item;
  }

  public int getComparacoes() {
	  return comparacoes;
  }
}
