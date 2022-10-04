/*
 * Lucas Santos Rodrigues
 * Marcela Camarano Caram Peito
 * 
 * Laboratorio de Algoritmos e Estruturas de Dados II
 */
package principal;
import java.util.StringTokenizer;
import java.io.*;

public class ExtraiPalavra {
  private BufferedReader arqTxt;
  private StringTokenizer palavras;
  private int coluna=0;
  private int linha=0;

  public ExtraiPalavra (String nomeArqTxt) 
  throws Exception {
    this.arqTxt = new BufferedReader (new FileReader (nomeArqTxt));
    this.palavras = null;
  }  
  
  public String proximaPalavra () throws Exception{  
    if (palavras == null || !palavras.hasMoreTokens()) {
      this.linha++; // proxima linha
      this.coluna=0; // inicio da coluna
      
      String linha = arqTxt.readLine();
      if (linha == null) return null; // acabou a palavra, retorna null
      this.palavras = new StringTokenizer (linha, " /()-,.&*%;:<>?1234567890	");
      if (!palavras.hasMoreTokens()) return ""; // ignora delimitadores
    }

    String aux = this.palavras.nextToken();
    this.coluna++; // proxima coluna ( palavra )
    String palavraFinal;
    char[] caracteres = {'0','0','0','0','0','0','0','0','0','0','0','0','0','0','0','0'};
    int tamanho = aux.length();

    /*Caso a palavra tenha menos de 16 caracteres, esta será completada com '0', e,
    caso seja maior que 16 caracteres, esta será cortada em 16. */
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
    palavraFinal = new String (caracteres);
    return palavraFinal;
  }  
  
  public void fecharArquivos () throws Exception {
    this.arqTxt.close();
  }

  public int getColuna() {
	return coluna;
  }
	
  public int getLinha() {
	return linha;
  }
  
  
}
