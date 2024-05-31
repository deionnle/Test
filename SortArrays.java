import  java.util.Random;

public class SortArrays {
    public static int[] sort(int[] arr) {
        int min, z;
        for(int i = 0; i < arr.length; i++) {
            z = i;
            min = arr[i];
            for(int j = i + 1; j < arr.length; j++) {
                if(arr[j] < min) {
                    min = arr[j];
                    z = j;
                }
            }
            arr[z] = arr[i];
            arr[i] = min;
        }
        return arr;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] arr = new int[n];

        Random rand = new Random();

        for (int i = 0; i < n; i++) {
            arr[i] = rand.nextInt(50) + 1;
        }
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");

        int[] arr1 = SortArrays.sort(arr);
        for (int i = 0; i < n; i++) {
            System.out.print(arr1[i] + " ");
        }
    }
}