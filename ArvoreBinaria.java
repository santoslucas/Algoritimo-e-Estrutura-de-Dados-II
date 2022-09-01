package item;

public class ArvoreBinaria {
	private static class No {
		Item reg;
		No esq, dir;
	}

	private No raiz;
	private int comparacoes = 0;
	
	public ArvoreBinaria() {
		this.raiz = null; // instancia uma arvore com No nulo
	}
	
	private No insere(Item reg, No p) {
		if (p == null) { // p nulo => No externo, insere um novo item na arvore
			p = new No();
			p.reg = reg;
			p.esq = null;
			p.dir = null;
		} else if (reg.compara(p.reg) < 0) //se a chave do item for menor, caminhamos a esquerda do No atual
			p.esq = insere(reg, p.esq);
		else if (reg.compara(p.reg) > 0) //se a chave do item for maior, caminhamos a direira do No atual
			p.dir = insere(reg, p.dir);
		else
			System.out.println("Erro: Registro ja existente"); //item ja existente
		return p;
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
	
	public int getComparacoes() {
		return comparacoes;
	}

	public void insere(Item reg) {
		this.raiz = this.insere(reg, this.raiz);
	}
	
	public Item pesquisa(Item reg) {
		return this.pesquisa(reg, this.raiz);
	}
}