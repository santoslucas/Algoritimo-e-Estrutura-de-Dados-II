/*
 * Lucas Santos Rodrigues
 * Marcela Camarano Caram Peito
 * 
 * Laboratorio de Algoritmos e Estruturas de Dados II
 */
package principal;

public class TesteArvorePatricia {
	public static void main (String[] args) {
		try{
			ExtraiPalavra exemplo1 = new ExtraiPalavra("exemplo1.txt");
			ExtraiPalavra exemplo2 = new ExtraiPalavra("exemplo2.txt");
			ArvorePatricia arvore1 = new ArvorePatricia(128);
			ArvorePatricia arvore2 = new ArvorePatricia(128);
			
			
			System.out.println("EXEMPLO 1");
			String palavra = null;
			while ((palavra = exemplo1.proximaPalavra())!=null) { // executa enquanto nao retorna null -> acabou o arquivo txt
				if(palavra != "") { // ignora linhas em branco
					arvore1.insere(palavra, exemplo1.getLinha(), exemplo1.getColuna());
				}
			}

			//Palavras que serão buscadas na árvore 1
			exemplo1.fecharArquivos();
			arvore1.pesquisa("trabalho");
			arvore1.pesquisa("computacao");
			arvore1.pesquisa("governo");
			arvore1.pesquisa("educacao");
			arvore1.pesquisa("tecnologia");
			arvore1.pesquisa("formacao");
			arvore1.pesquisa("desenvolvimento");
			arvore1.pesquisa("que");
			arvore1.pesquisa("informatica");
			arvore1.pesquisa("em");
			arvore1.pesquisa("crise");
			System.out.println();
			
			System.out.println("EXEMPLO 2");
			palavra = null;
			while ((palavra = exemplo2.proximaPalavra())!=null) {
				if(palavra != "") {
					arvore2.insere(palavra, exemplo2.getLinha(), exemplo2.getColuna());
				}
			}

			//Palavras que serão buscadas na árvore 2
			exemplo2.fecharArquivos();
			arvore2.pesquisa("sociedade");
			arvore2.pesquisa("software");
			arvore2.pesquisa("ideia");
			arvore2.pesquisa("pessoa");
			arvore2.pesquisa("Informatica");
			arvore2.pesquisa("etica");
			arvore2.pesquisa("muito");
			arvore2.pesquisa("ciencia");
			arvore2.pesquisa("computacao");
			arvore2.pesquisa("que");
			arvore2.pesquisa("area");
			arvore2.pesquisa("moral");
		}
		catch (Exception e) {System.out.println (e);}    
	}

}
