/*
 * Lucas Santos Rodrigues
 * Marcela Camarano Caram Peito
 * 
 * Laboratorio de Algoritmos e Estruturas de Dados II
 */
package principal;
import java.util.ArrayList;

public class ArvorePatricia {
  private static abstract class PatNo { }
  
  private static class PatNoInt extends PatNo {
    int index; PatNo esq, dir;
  }  
  
  private static class PatNoExt extends PatNo {
    String chave; // palavra
    ArrayList<Integer> coluna = new ArrayList<>();
    ArrayList<Integer> linha = new ArrayList<>();
  }
  
  private PatNo raiz;
  private int nbitsChave;
 
  // converte cada caracter da chave em bits e retorna o i-esimo bit da chave
  private int bit (int x, String chave) {
    int[] bits = new int [129];
    for(int i=0; i<16; i++) { // percorre toda a string
      char aux = chave.charAt(i);
      String bitsLetra = Integer.toBinaryString((int) aux); // converte o char para binario
      // extende cada char em formato binario para 8 bits
      String bitsLetraExtendidos = String.format("%8s", bitsLetra).replaceAll(" ", "0"); 
      for(int j=(1+(i*8)), k=0; j<((i*8)+8); j++, k++) {
        bits[j] = (bitsLetraExtendidos.charAt(k) - 48); // em ascii 0 -> 48 e 1 -> 49
      }
    }
	  return bits[x];
  }
  
  // similar ao metodo de ExtraiPalavra
  private char[] preencheZeros(String aux) {
    char[] caracteres = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
    int tamanho = aux.length();

    if(tamanho<16){
      for(int i=0; i<tamanho; i++){
        caracteres[i] = aux.charAt(i);
      }
    }
    else{
      for(int i=0; i<16; i++){
    	  caracteres[i] = aux.charAt(i);
      }
    }
    return caracteres;
  }
  
  // metodo contrario ao anterior
  private char[] removeZeros(String aux) {
	  int i_palavraReal=0;
	  for(int i=0; i<16; i++) {
		  if(aux.charAt(i) == '0') {
			  i_palavraReal = i;
			  break;
		  }
	  }
	  char[] resultado= new char[i_palavraReal];
	  
	  for(int i=0; i<i_palavraReal; i++) {
		  resultado[i] = aux.charAt(i);
	  }
	  
	  return resultado;
  }

  // verifica se p eh no externo
  private boolean eExterno (PatNo p) {    
    Class classe = p.getClass ();
    return classe.getName().equals(PatNoExt.class.getName());
  }

  private PatNo criaNoInt (int i, PatNo esq, PatNo dir) {
    PatNoInt p = new PatNoInt ();
    p.index = i; p.esq = esq; p.dir = dir;
    return p;
  }

  private PatNo criaNoExt (String k, int linha, int coluna) {
    PatNoExt p = new PatNoExt ();
    p.chave = k;
    p.linha.add(linha); //adiciona a linha da primeira ocorrencia
    p.coluna.add(coluna); //adiciona a coluna da primeira ocorrencia
    return p;
  }

  // pesquiva a chave
  private void pesquisa (String k, PatNo t) {
	k = new String(preencheZeros(k)); // preenche com 0's para comparacao
	String chaveReal = new String(removeZeros(k)); // remove os 0's para exibir a palavra no terminal
    if (this.eExterno (t)) { // se for no externo
      PatNoExt aux = (PatNoExt)t;
      if (aux.chave.equals(k)) { //compara a chave
    	  System.out.println ("Elemento encontrado: " + chaveReal);
    	  for(int i = 0; i < aux.linha.size(); i++) //imprime as posicoes de ocorrencia
    	  {
    		  System.out.print(i+1 + ") Linha: " + aux.linha.get(i));
    		  System.out.print(" | Coluna: " + aux.coluna.get(i) + "\n");
    		  
    	  }
    	  System.out.println();
      }
      else System.out.println ("Elemento nao encontrado: " + chaveReal + "\n");
    }
    else { 
      PatNoInt aux = (PatNoInt)t; // no interno, se k=0 esquerda, se k=1 direita
      if (this.bit (aux.index, k) == 0) pesquisa (k, aux.esq);
      else pesquisa (k, aux.dir);
    }
  }

  private PatNo insereEntre (String k, int linha, int coluna, PatNo t, int i) {
    PatNoInt aux = null; 
    if (!this.eExterno (t)) aux = (PatNoInt)t;
    if (this.eExterno (t) || (i < aux.index)) { // Cria um novo no externo
      PatNo p = this.criaNoExt (k, linha, coluna);
      if (this.bit (i, k) == 1) return this.criaNoInt (i, t, p);
      else return this.criaNoInt (i, p, t);
    }
    else {
      if (this.bit (aux.index, k) == 1) 
        aux.dir = this.insereEntre (k, linha, coluna, aux.dir, i);
      else aux.esq = this.insereEntre (k, linha, coluna, aux.esq, i);
      return aux;
    }
  }
  
  private PatNo insere (String k, int linha, int coluna, PatNo t) {
    if (t == null) return this.criaNoExt (k, linha, coluna); //se nao existe um t, cria o no externo
    else {
      PatNo p = t;
      while (!this.eExterno (p)) { //esquanto for no interno
        PatNoInt aux = (PatNoInt)p;
        if (this.bit (aux.index, k) == 1) p = aux.dir; else p = aux.esq; //desce a arvore
      }
      PatNoExt aux = (PatNoExt)p;
      int i = 1; // acha o primeiro bit diferente
      while ((i <= this.nbitsChave)&&
             (this.bit (i, k) == this.bit (i, aux.chave))) i++;
      if (i > this.nbitsChave) { // se a chave ja existir adiciona essa nova ocorrencia
    	  aux.linha.add(linha);
    	  aux.coluna.add(coluna);
        return t;
      }
      else return this.insereEntre (k, linha, coluna, t, i);
    }
  }
  
  // utilizado para imprimir os elementos e suas posicoes
  private void central (PatNo pai, PatNo filho, String msg) {
    if (filho != null) {
      if (!this.eExterno (filho)) {
        PatNoInt aux = (PatNoInt)filho; 
        central (filho, aux.esq, "ESQ");
        if (pai != null)
          System.out.println ("Pai: "+ ((PatNoInt)pai).index + " " + msg+ " Int: " + aux.index);
        else System.out.println ("Pai: "+ pai + " " + msg+ " Int: " + aux.index);
        central (filho, aux.dir, "DIR");
      } else {
        PatNoExt aux = (PatNoExt)filho;
        if (pai != null)
          System.out.println ("Pai: "+ ((PatNoInt)pai).index + " " + msg+ " Ext: " + aux.chave);
        else System.out.println ("Pai: "+ pai + " " + msg+ " Ext: " + aux.chave);
      }
    }
  }

  public void imprime () {
    this.central (null, this.raiz, "RAIZ");
  }

  public ArvorePatricia (int nbitsChave) {
    this.raiz = null; this.nbitsChave = nbitsChave; 
  }
  
  public void pesquisa (String k) { this.pesquisa (k, this.raiz); }
  
  public void insere (String k, int linha, int coluna) { this.raiz = this.insere (k, linha, coluna, this.raiz); } 
}
