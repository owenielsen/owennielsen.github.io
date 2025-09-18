//This is my third or fourth program for 2.1
//Enjoy!
//By the way this is still by Owen Nielsen
//He's a really cool guy




public class evenodd {
    public static void main(String[] args) {

        // Create an array of size 100
        int[] numbers = new int[100];

        // Fill the array with numbers from 1 to 100
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i + 1;
        }

        // Variable to hold the sum of all numbers
        int sum = 0;

        // Loop through the array and check if each number is even or odd
        for (int i = 0; i < numbers.length; i++) {
            int number = numbers[i];

            if (number % 2 == 0) {
                System.out.println(number + " is even");
            } else {
                System.out.println(number + " is odd");
            }

            // Add the number to the sum
            sum += number;
        }

        // Print the total sum after the loop
        System.out.println("The total sum is: " + sum);
    }
}