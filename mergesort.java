import java.util.*;

class MergeSort {
    static void merge(int a[], int l, int m, int r) {
        int i = l, j = m + 1, k = 0;
        int b[] = new int[r - l + 1];

        while (i <= m && j <= r) {
            if (a[i] <= a[j])
                b[k++] = a[i++];
            else
                b[k++] = a[j++];
        }

        while (i <= m)
            b[k++] = a[i++];

        while (j <= r)
            b[k++] = a[j++];

        for (i = l, k = 0; i <= r; i++, k++)
            a[i] = b[k];
    }

    static void mergeSort(int a[], int l, int r) {
        if (l < r) {
            int m = (l + r) / 2;
            mergeSort(a, l, m);
            mergeSort(a, m + 1, r);
            merge(a, l, m, r);
        }
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String x[] = s.split(" ");

        int a[] = new int[x.length];

        for (int i = 0; i < x.length; i++)
            a[i] = Integer.parseInt(x[i]);

        mergeSort(a, 0, a.length - 1);

        for (int i : a)
            System.out.print(i + " ");
    }
}