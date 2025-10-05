import java.util.Scanner;

public class Main {

    public static boolean parenthesesCheck(String parentheses) {
        int equal = 0;

        for (int i = 0; i < parentheses.length(); i++) {
            char c = parentheses.charAt(i);

            if (c == '(') {
                equal++;
            } else if (c == ')') {
                equal--;
            }
        }

        return equal == 0;
    }


    public static String reverseInteger(int n) {
        if (n == 0) return "0";

        String reversed = "";
        int num = Math.abs(n); // Handle negative numbers

        while (num > 0) {
            int lastDigit = num % 10;
            reversed += lastDigit;
            num /= 10;
        }

        if (n < 0) {
            reversed = "-" + reversed;
        }

        return reversed;
    }


    public static String encryptThis(String input) {
        String[] words = input.split(" ");
        String result = "";

        for (int i = 0; i < words.length; i++) {
            result += encryptWord(words[i]);

            // Add space between words (but not after last word)
            if (i < words.length - 1) {
                result += " ";
            }
        }

        return result;
    }

    public static String encryptWord(String word) {
        if (word.length() <= 2) {
            if (word.isEmpty()) return "";
            if (word.length() == 1) return String.valueOf((int) word.charAt(0));
            return (int) word.charAt(0) + word.substring(1);
        }

        int d0 = word.charAt(0);
        String d1 = word.substring(1, 2);
        String dLast = word.substring(word.length() - 1);

        String dMiddle = "";
        if (word.length() > 3) {
            dMiddle = word.substring(2, word.length() - 1);
        }

        return d0 + dLast + dMiddle + d1;
    }


    public static String decipherThis(String message) {
        String[] words = message.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            result.append(decipherWord(words[i]));
            if (i < words.length - 1) {
                result.append(" ");
            }
        }

        return result.toString();
    }

    public static String decipherWord(String encryptedWord) {
        if (encryptedWord.length() <= 2 ) {
            return encryptedWord;
        }

        int i = 0;
        while (i < encryptedWord.length() && Character.isDigit(encryptedWord.charAt(i))) {
            i++;
        }

        String numberStr = encryptedWord.substring(0, i);
        String letters = encryptedWord.substring(i);

        char c1 = (char) Integer.parseInt(numberStr);

        if (letters.length() <= 1) {
            return c1 + letters;
        }

        String l1 = letters.substring(0, 1);
        String lLast = letters.substring(letters.length() - 1);
        String lMiddle = letters.substring(1, letters.length() - 1);

        return c1 + lLast + lMiddle + l1;
    }
}

