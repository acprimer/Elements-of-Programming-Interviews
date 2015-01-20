package chap06;

/**
 * Created by yaodh on 2015/1/20.
 * <p/>
 * Problem 6.1
 * Write a function that takes an array A and an index i into A, and rearranges the elements
 * such that all elements less than A[i] appear first, followed by elements equal to A[i],
 * followed by elements greater than A[i].
 * You algorithm should have O(1) space complexity and O(|A|) time complexity.
 * <p/>
 * Variant 6.1.1
 * Assuming that keys take one of three values, reorder the array so that all objects of the same key
 * appear in the same subarray. The order of the subarrays is not import.
 * Use O(1) additional space and O(|A|) time.
 * <p/>
 * Variant 6.1.2
 * Given an array A of objects with keys that takes one of four values,
 * reorder the array so that all objects of the same key appear in the same subarray.
 * Use O(1) additional space and O(|A|) time.
 * <p/>
 * Variant 6.1.3
 * Given an array A of objects with boolean-valued keys,
 * reorder the array so that all objects of the same key appear in the same subarray.
 * Use O(1) additional space and O(|A|) time.
 */
public class Problem06_01 {
    /**
     * 3-way partition
     *
     * @param A
     * @param index pivot index
     */
    void dutchFlagPartition(int[] A, int index) {
        int pivot = A[index];
        int smaller = 0, equal = 0, larger = A.length - 1;
        while (equal <= larger) {
            if (A[equal] < pivot) {
                swap(A, smaller++, equal++);
            } else if (A[equal] == pivot) {
                equal++;
            } else {
                swap(A, equal, larger--);
            }
        }
    }

    /**
     * 数组A中包含0，1，2，对A进行排序,
     * 0,1,2的最终顺序无所谓。
     *
     * @param A [1 0 2 0 2 1] -> [0 0 1 1 2 2]
     */
    void sort3values(int[] A) {
        int pivot = A[0];
        int delta = 0;
        int smaller = 0, equal = 0, larger = A.length - 1;
        while (equal <= larger) {
            if (delta == 0 && A[equal] - pivot != 0) {
                delta = A[equal] - pivot;
            }
            if (A[equal] == pivot) {
                equal++;
            } else if (A[equal] - pivot == delta) {
                swap(A, smaller++, equal++);
            } else {
                swap(A, equal, larger--);
            }
        }
    }

    void sort4values(int[] A) {
        int pivot = A[0];
        int d1 = 0, d2 = 0;
        int smaller1 = 0, smaller2 = 0, equal = 0, larger = A.length - 1;
        while (equal <= larger) {
            if (A[equal] - pivot != 0) {
                if (d1 == 0) {
                    d1 = A[equal] - pivot;
                } else if (d2 == 0) {
                    d2 = A[equal] - pivot;
                }
            }
            if (A[equal] == pivot) {
                equal++;
            } else if (A[equal] - pivot == d1) {
                swap(A, smaller2, equal++);
                swap(A, smaller1++, smaller2++);
            } else if (A[equal] - pivot == d2) {
                swap(A, smaller2++, equal++);
            } else {
                swap(A, equal, larger--);
            }
        }
    }

    void sort2values(int[] A) {
        int pivot = A[0];
        int smaller = 0, larger = A.length - 1;
        while (smaller <= larger) {
            if (A[smaller] == pivot) {
                smaller++;
            } else {
                swap(A, smaller, larger--);
            }
        }
    }

    private void swap(int[] a, int x, int y) {
        int tmp = a[x];
        a[x] = a[y];
        a[y] = tmp;
    }

    public static void main(String[] args) {
        int[] A = new int[]{3, 1, 2, 3, 1, 5};
        new Problem06_01().dutchFlagPartition(A, 0);
        for (int x : A) {
            System.out.println(x);
        }
        System.out.println();

        A = new int[]{0, 1, 0, 2, 0, 2, 1};
        new Problem06_01().sort3values(A);
        for (int x : A) {
            System.out.println(x);
        }
        System.out.println();

        A = new int[]{3, 1, 0, 3, 0, 2, 1, 3, 2, 0, 1, 3, 2, 2, 2, 1};
        new Problem06_01().sort4values(A);
        for (int x : A) {
            System.out.println(x);
        }
        System.out.println();

        A = new int[]{0, 1, 1, 0, 0, 1};
        new Problem06_01().sort2values(A);
        for (int x : A) {
            System.out.println(x);
        }
    }
}
