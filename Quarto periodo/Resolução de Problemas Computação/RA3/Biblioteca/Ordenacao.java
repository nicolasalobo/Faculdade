import java.util.Comparator;

public class Ordenacao {

public static void bubbleSort(Jogo[] arr, Comparator<Jogo> cmp) {
	if (arr == null || cmp == null) return;
	int n = arr.length;
	boolean trocou;
	for (int i = 0; i < n - 1; i++) {
		trocou = false;
		for (int j = 0; j < n - 1 - i; j++) {
			if (cmp.compare(arr[j], arr[j + 1]) > 0) {
				Jogo tmp = arr[j];
				arr[j] = arr[j + 1];
				arr[j + 1] = tmp;
				trocou = true;
			}
		}
		if (!trocou) break;
	}
}

public static void insertionSort(Jogo[] arr, Comparator<Jogo> cmp) {
	if (arr == null || cmp == null) return;
	int n = arr.length;
	for (int i = 1; i < n; i++) {
		Jogo key = arr[i];
		int j = i - 1;
		while (j >= 0 && cmp.compare(arr[j], key) > 0) {
			arr[j + 1] = arr[j];
			j--;
		}
		arr[j + 1] = key;
	}
}

public static void quickSort(Jogo[] arr, Comparator<Jogo> cmp) {
	if (arr == null || cmp == null) return;
	quickSortRec(arr, 0, arr.length - 1, cmp);
}


private static void quickSortRec(Jogo[] arr, int low, int high, Comparator<Jogo> cmp) {
	if (low >= high) return;
	int p = partition(arr, low, high, cmp);
	quickSortRec(arr, low, p - 1, cmp);
	quickSortRec(arr, p + 1, high, cmp);
}


private static int partition(Jogo[] arr, int low, int high, Comparator<Jogo> cmp) {
	Jogo pivot = arr[high];
	int i = low - 1;
	for (int j = low; j < high; j++) {
		if (cmp.compare(arr[j], pivot) <= 0) {
			i++;
			Jogo tmp = arr[i];
			arr[i] = arr[j];
			arr[j] = tmp;
		}
	}
	Jogo tmp = arr[i + 1];
	arr[i + 1] = arr[high];
	arr[high] = tmp;
	return i + 1;
}
}