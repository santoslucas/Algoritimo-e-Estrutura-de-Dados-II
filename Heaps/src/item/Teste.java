package item;
import java.util.*;

public class Teste {
	public static void main (String[] args) {
		int tamHeap[] = {10000, 20000, 30000, 40000, 50000,
					60000, 70000, 80000, 90000, 100000};
		
		// Exercicio 4)a) ELEMENTOS ORDENADOS EM ORDEM CRESCENTE
		System.out.println("Ordem crescente:");
		for(int i = 0; i<10; i++) {
			Item[] itens = new Item[tamHeap[i]];
			int chaves[] = new int[tamHeap[i]];
		
			for (int j = 0; j < tamHeap[i]; j++) // chaves crescentes
			  chaves[j] = j;
			
			for (int j = 0; j < tamHeap[i]; j++) { // cria vetor crescente
			  itens[j] = new Item (chaves[j]);
			}
			
		  	HeapSort heap = new HeapSort (itens); // insere vetor
		  	heap.heapSort(tamHeap[i]-1); // heapsort
			
			System.out.println("Heap[" + tamHeap[i] + "]: " + "Comparacoes: " + heap.getHeapCriado().getComparacoes());
		}
		System.out.println();
		
		// Exercicio 4)b) ELEMENTOS ORDENADOS EM ORDEM DECRESCENTE
		System.out.println("Ordem decrescente:");
		for(int i = 0; i<10; i++) {
			Item[] itens = new Item[tamHeap[i]];
			int chaves[] = new int[tamHeap[i]];
		
			for (int j = 0, k = (tamHeap[i]-1); j < tamHeap[i]; j++, k--) // chaves decrescentes
			  chaves[j] = k;
			
			for (int j = 0; j < tamHeap[i]; j++) { // cria vetor decrescente
			  itens[j] = new Item (chaves[j]);
			}
			
		  	HeapSort heap = new HeapSort (itens); // insere vetor
		  	heap.heapSort(tamHeap[i]-1); // heapsort
			
			System.out.println("Heap[" + tamHeap[i] + "]: " + "Comparacoes: " + heap.getHeapCriado().getComparacoes());
		}
		System.out.println();
		
		// Exercicio 4)c) ELEMENTOS ALEATORIOS
		System.out.println("Aleatorios:");
		for(int i = 0; i<10; i++) {
			Random rand = new Random();
			Item[] itens = new Item[tamHeap[i]];
			int chaves[] = new int[tamHeap[i]];
		
			for (int j = (tamHeap[i]-1); j >= 0; j--)
			  chaves[j] = rand.nextInt(); // chaves aleatorios
			
			for (int j = 0; j < tamHeap[i]; j++) {// cria vetor aleatorio
			  itens[j] = new Item (chaves[j]);
			}
			
		  	HeapSort heap = new HeapSort (itens); // insere vetor
		  	heap.heapSort(tamHeap[i]-1);  // heapsort
			
			System.out.println("Heap[" + tamHeap[i] + "]: " + "Comparacoes: " + heap.getHeapCriado().getComparacoes());
		}
		System.out.println();
	}
}
