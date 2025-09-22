// Name: BubbleSort.java
// Owen Nielsen owen.nielsen@malad.us
// For CTE Software Development 1
// Teacher Mr. Gross

public class BubbleSort {

    // Swap function by kimg@techtrepacademy.com
    // This function swaps the elements at lowerIndex and lowerIndex + 1 in the array
    public static int[] swapTwoArrayElements(int[] arrayToSwap, int lowerIndex) {
        int temp;
        temp = arrayToSwap[lowerIndex];
        arrayToSwap[lowerIndex] = arrayToSwap[lowerIndex + 1];
        arrayToSwap[lowerIndex + 1] = temp;
        return arrayToSwap;
    }

    public static void main(String[] args) {

        // Create the array to be sorted
        int[] arrayToSort = {1, 3, 4, 5, 1, 23, 57, 126, 4, 543, 345, 23, 12, 45, 67, 97};

        // Print original array
        System.out.print("Original array: ");
        for (int n : arrayToSort) {
            System.out.print(n + " ");
        }
        System.out.println();

        boolean doSwap = true; // Flag to check if any swaps were made
        int passes = 0;

        // Keep looping until no swaps are made in a full pass
        while (doSwap) {
            doSwap = false; // Assume no swaps at start of this pass
            passes++;

            // Loop through the array and compare adjacent elements
            for (int i = 0; i < arrayToSort.length - 1; i++) {
                if (arrayToSort[i] > arrayToSort[i + 1]) {
                    // Swap if elements are out of order
                    arrayToSort = swapTwoArrayElements(arrayToSort, i);
                    doSwap = true; // A swap was made, so we need another pass
                }
            }
        }

        // Print results
        System.out.println("Sorted array:");
        for (int i = 0; i < arrayToSort.length; i++) {
            System.out.print(arrayToSort[i] + " ");
        }
        System.out.println();
        System.out.println("Passes performed: " + passes);
    }
}
