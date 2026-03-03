import java.util.*;

public class TabelaHash {
private List<LinkedList<Jogo>> table;
private int capacity;
private int size;
private int collisions;


public TabelaHash(int capacity) {
this.capacity = Math.max(4, capacity);
table = new ArrayList<>(this.capacity);
for (int i = 0; i < this.capacity; i++) table.add(new LinkedList<>());
size = 0;
collisions = 0;
}


private int hash(String key) {
		if (key == null) return 0;
		// Use lowercased key so hashing is case-insensitive and titles map to the same bucket
		String k = key.toLowerCase();
		// use mask to avoid negative value when hashCode == Integer.MIN_VALUE
		return (k.hashCode() & 0x7fffffff) % capacity;
}


public boolean inserir(Jogo jogo) {
int idx = hash(jogo.getTitulo());
LinkedList<Jogo> bucket = table.get(idx);
// Contabiliza colisão se o bucket já possui elementos, incluindo duplicados
if (!bucket.isEmpty()) {
	collisions++;
}
for (Jogo j : bucket) {
if (j.getTitulo().equalsIgnoreCase(jogo.getTitulo())) {
return false;
}
}
bucket.add(jogo);
size++;
return true;
}


public Jogo buscar(String titulo) {
int idx = hash(titulo);
LinkedList<Jogo> bucket = table.get(idx);
for (Jogo j : bucket) {
if (j.getTitulo().equalsIgnoreCase(titulo)) return j;
}
return null;
}


public boolean remover(String titulo) {
int idx = hash(titulo);
LinkedList<Jogo> bucket = table.get(idx);
Iterator<Jogo> it = bucket.iterator();
while (it.hasNext()) {
Jogo j = it.next();
if (j.getTitulo().equalsIgnoreCase(titulo)) {
it.remove();
size--;
return true;
}
}
return false;
}


public int tamanho() { return size; }

public int colisoes() { return collisions; }

	/**
	 * Exporta todos os jogos para um vetor (ordem: buckets 0..n)
	 */
	public Jogo[] exportarParaVetor() {
		Jogo[] arr = new Jogo[size];
		int idx = 0;
		for (LinkedList<Jogo> bucket : table) {
			for (Jogo j : bucket) {
				arr[idx++] = j;
			}
		}
		return arr;
	}
}