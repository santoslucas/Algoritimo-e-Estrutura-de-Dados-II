package item;

public class HeapSort {
	private Heap heapCriado;
	
	public HeapSort(Item v[]) { // cria heap
		this.heapCriado = new Heap (v); // passa vetor para o heap
	    this.heapCriado.constroi ();
	}
	
	public void heapSort(int n) { //realiza heapsort
	    int dir = n; 
	    while (dir > 1) { // percorre todo o heap e troca as posicoes
	      Item x = heapCriado.getItem(1); 
		  heapCriado.setItem(heapCriado.getItem(dir), 1); 
		  heapCriado.setItem(x, dir);
	      dir--; heapCriado.refaz (1, dir);
	    }
	  }

	public Heap getHeapCriado() {
		return heapCriado;
	}

	public void setHeapCriado(Heap heapCriado) {
		this.heapCriado = heapCriado;
	}
}