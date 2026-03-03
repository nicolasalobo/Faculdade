import java.util.Arrays;

public class QuickSortDemo {
    private static int callCount = 0; // contador de chamadas

    public static void main(String[] args) {
        int[] anos = {1993, 1845, 2008, 1514, 1291, 1507, 1822, 1553, 1974, 1402};

        System.out.println("Vetor inicial: " + Arrays.toString(anos));
        quickSort(anos, 0, anos.length - 1);
        System.out.println("Vetor ordenado: " + Arrays.toString(anos));
    }

    // quicksort com pivô no primeiro elemento
    private static void quickSort(int[] a, int left, int right) {
        if (left >= right) return;

        int pivot = a[left];
        callCount++;
        System.out.printf("Chamada recursiva #%d | intervalo=[%d,%d] | pivo=%d | vetor=%s%n",
                callCount, left, right, pivot, Arrays.toString(a));

        int p = partitionHoarePivotFirst(a, left, right, pivot);

        quickSort(a, left, p);
        quickSort(a, p + 1, right);
    }

    // partição de Hoare usando pivô informado
    private static int partitionHoarePivotFirst(int[] a, int left, int right, int pivot) {
        int i = left - 1;
        int j = right + 1;
        while (true) {
            do { i++; } while (a[i] < pivot);
            do { j--; } while (a[j] > pivot);
            if (i >= j) return j;
            swap(a, i, j);
        }
    }

    // troca dois elementos do vetor
    private static void swap(int[] a, int i, int j) {
        int tmp = a[i];
        a[i] = a[j];
        a[j] = tmp;
    }
}
