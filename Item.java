package item;

public class Item {
	private int chave;
	
	public Item(int chave) {
		this.chave = chave;
	}
	
	public int compara(Item it) {
		Item item = it;
		if (this.chave < item.chave)
			return -1;
		else if (this.chave > item.chave)
			return 1;
		return 0;
	}
	
	// Recupera chave
	public int getChave() { 
		return chave;
	}

	// Altera chave
	public void setChave(int chave) { // novo metodo -> altera a chave
		this.chave = chave;
	}
}