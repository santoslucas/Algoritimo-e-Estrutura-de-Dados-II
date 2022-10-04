package item;

public class ArvoreSBB {
  private static class No { 
    Item reg; 
    No esq, dir;
    byte incE, incD;
  }
  
  private static final byte Horizontal = 0; 
  private static final byte Vertical = 1; 
  private No raiz;
  private boolean propSBB;
  private int comparacoes = 0;
  
  public ArvoreSBB () {
	    this.raiz = null; // instancia uma arvore com No nulo
	    this.propSBB = true; // define inicialmente que a arvore esta quase balanceada
	  }
  
  // Transformacoes-inicio ->
  private No ee (No ap) {
	// No do meio se torna o No ascendente dos dois outros Nos
    No ap1 = ap.esq; 
    ap.esq = ap1.dir; 
    ap1.dir = ap;
    
    // as ligacoes sao verticalizadas
    ap1.incE = Vertical; 
    ap.incE = Vertical; 
    ap = ap1;
    return ap; 
  }
  
  private No ed (No ap) {
    No ap1 = ap.esq; 
    No ap2 = ap1.dir; 
    
    // as ligacoes sao verticalizadas
    ap1.incD = Vertical;
    ap.incE = Vertical;
    
    // trocam-se os Nos, para que o No extremo seja o No ascendente dos outros dois
    ap1.dir = ap2.esq; 
    ap2.esq = ap1;
    ap.esq = ap2.dir; 
    ap2.dir = ap; 
    ap = ap2;    
    return ap; 
  }

  private No dd (No ap) { // semelhante ao No ee
    No ap1 = ap.dir; 
    ap.dir = ap1.esq; 
    ap1.esq = ap;
    ap1.incD = Vertical; 
    ap.incD = Vertical; 
    ap = ap1;
    return ap; 
  }

  private No de (No ap) { // semelhante ao No ed
    No ap1 = ap.dir; 
    No ap2 = ap1.esq; 
    ap1.incE = Vertical;
    ap.incD = Vertical; 
    ap1.esq = ap2.dir; 
    ap2.dir = ap1;
    ap.dir = ap2.esq; 
    ap2.esq = ap; ap = ap2;    
    return ap; 
  } // <- Trasnformacoes-fim

  private No insere (Item reg, No pai, No filho, boolean filhoEsq) {
    if (filho == null) {// filho nulo => No externo => insere um novo item na arvore
      filho = new No (); 
      filho.reg = reg; 
      //iniciamente as ligacoes sao verticais e nulas
      filho.incE = Vertical;
      filho.incD = Vertical;
      filho.esq = null; 
      filho.dir = null;
      if (pai != null) //nao eh o primeiro item da arvore
    	/* se o descendente for a esquerda do ascendente, ele vai para horizontal esquerda
    	 * caso contratio, para horizontal direita*/
        if (filhoEsq) pai.incE = Horizontal; 
        else pai.incD = Horizontal;
      
      this.propSBB = false;
    }
    
    else if (reg.compara (filho.reg) < 0) { //se a chave do item for menor, caminhamos a esquerda do No atual
      filho.esq = insere (reg, filho, filho.esq, true);
      if (!this.propSBB) // se a propriedade da arvore SBB nao eh satisfeita, sao feitas tranformacoes
        if (filho.incE == Horizontal) { 
          if (filho.esq.incE == Horizontal) {
            filho = this.ee (filho); // corrige-se o erro de terem dois Nos horizontais a esquerda
            if (pai != null)
              if (filhoEsq) pai.incE=Horizontal; // se filhoEsq for true, o No-descendente se torna horizontal
              else pai.incD=Horizontal;
          }
          else if (filho.esq.incD == Horizontal) {
            filho = this.ed (filho); // corrige-se o erro de terem dois Nos horizontais esquerda-direita
            if (pai != null) 
              if (filhoEsq) pai.incE=Horizontal; 
              else pai.incD=Horizontal;            
          }
        }
        else this.propSBB = true; // a arvore volta a ser quase-balanceada
    }
    
    else if (reg.compara (filho.reg) > 0) { //se a chave do item for maior, caminhamos a direira do No atual
      filho.dir = insere (reg, filho, filho.dir, false);
      if (!this.propSBB) 
        if (filho.incD == Horizontal) {
          if (filho.dir.incD == Horizontal) {
            filho = this.dd (filho); // corrige-se o erro de terem dois Nos horizontais a esquerda
            if (pai != null)
              if (filhoEsq) pai.incE=Horizontal; 
              else pai.incD=Horizontal;
          }
          else if (filho.dir.incE == Horizontal) {
            filho = this.de (filho); // corrige-se o erro de terem dois Nos horizontais direita-esquerda
            if (pai != null)
              if (filhoEsq) pai.incE=Horizontal; 
              else pai.incD=Horizontal;            
          }
        }
        else this.propSBB = true;
    }
    
    else {      
      //item ja existente
      this.propSBB = true;
    }
    return filho; 
  }
  
  private Item pesquisa(Item reg, No p) {
	comparacoes++; //a cada pesquisa o contador de comparacoes eh incrementado
	if (p == null) { //chegou no No exteno e nao encontrou o item
		return null;
	}
	else if (reg.compara(p.reg) < 0) //se a chave do item for menor, procuramos a esquerda do No atual
		return pesquisa(reg, p.esq);
	else if (reg.compara(p.reg) > 0) //se a chave do item for maior, procuramos a direita do No atual
		return pesquisa(reg, p.dir);
	else { //encontrou item
		return p.reg;
	}
  }
  
  public Item pesquisa (Item reg) {
    return this.pesquisa (reg, this.raiz);
  }

  public void insere (Item reg) {
    this.raiz = insere (reg, null, this.raiz, true);
  }
  
  public int getComparacoes() {
		return comparacoes;
	}
}
