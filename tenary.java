public class tenary {
    public static void main(String[] args) {

        Integer[] a = {};

        int p = r.nextInt(100) + 0;


        for (int i = 0; i < 100; i++) {
            p = r.nextInt(100) + 0;
            a[i] = p;
        }

        System.out.println();
        sort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }


    public static void sort(Comparable[] a) {

        int N = a.length;

        Comparable[] temp = new Comparable[N + 1];

        for (int i = 0; i < N; i++) {
            temp[i + 1] = a[i];
        }

        int size = temp.length - 1;
        for (int i = size / 3; i >= 1; i--) {
            sink(temp, i, size);
        }

        for (int i = temp.length - 1; i >= 1; i--) {
            exch(temp, 1, i);
            sink(temp, 1, i - 1);
        }

        for (int i = 0; i < N; i++)
            a[i] = temp[i + 1];
    }


    private static void sink(Comparable[] a, int k, int size) {
        while (3 * k <= size) {
            int j = 3 * k;

            if (j < size && less(a[j + 1], a[j]) && less(a[j - 1], a[j])) {

                if (less(a[j + 1], a[j - 1])) {
                    j = j + 1;
                } else {
                    j = j - 1;
                }
            } else if (j < size && less(a[j + 1], a[j])) {
                j = j + 1;
            } else if (j < size && less(a[j - 1], a[j])) {
                j = j - 1;
            }

            if (less(a[j], a[k])) {
                exch(a, j, k);
            }
            k = j;
        }
    }

    private static boolean less(Comparable m, Comparable n) {
        if (m.compareTo(n) < 0)
            return true;
        return false;
    }

    private static void exch(Comparable[] a, int m, int n) {
        Comparable temp = a[m];
        a[m] = a[n];
        a[n] = temp;
    }
}
