import java.util.Scanner;

public class ReversedString {

    // Method to reverse a string
    public static String reverseString(String str) {
        // Convert the string to a character array
        char[] charArray = str.toCharArray();

        // Initialize variables for swapping characters
        int start = 0;
        int end = charArray.length - 1;

        // Iterate through the character array and swap characters
        while (start < end) {
            // Swap characters at start and end indices
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            // Move start index towards the center
            start++;

            // Move end index towards the center
            end--;
        }

        // Convert the character array back to a string
        return new String(charArray);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Prompt the user to enter a string
        System.out.print("Enter a string: ");
        String input = sc.nextLine();

        // Call the reverseString method and print the reversed string
        String reversedString = reverseString(input);
        System.out.println("Reversed string: " + reversedString);

        sc.close();
    }
}
