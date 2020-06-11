package by.epamtc.bobkov.StringTask;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringTask {
    public static void main(String[] args) {
        System.out.println(oddAndEvenChar("testing"));
        System.out.println(uppercaseOrLowercaseLetter("AAAAAAAAAaaaaaaa"));
        System.out.println(deleteDuplicateChar("EEppaaMM"));
        System.out.println(findQuantityOfChar("astana", 'a'));
        System.out.println(reverseString("ReverseString"));
        System.out.println(insertOfSubstring("Hello", "world!", 2));
        System.out.println(deleteOfSubstring("java avaj", "java"));
        System.out.println(copySubstring("Copy sub string", 5,9));
        System.out.println(lengthOfString("Java"));
        System.out.println(quantitySubstring("abc abc abc", "abc"));
        System.out.println(reverseWords("Belarus Minsk 123"));
        System.out.println(repalceSpace("Replace all   "));
        System.out.println(replaceAonB("java aba apple"));
        System.out.println(lengthLongestWord("One two three four fiiveee !!!!!!!!!"));
        System.out.println(countWordsInString("one two tgreeree 34234324 //.,mcmbcm 243242 "));
        System.out.println(swapWords("swap words to index", 1, 3));
        System.out.println(deleteLastWord("delete last word"));
        System.out.println(addSpaceToString("ADD SPACE TO STRING"));
        System.out.println(isPalindrome("Was it a car or a cat I saw"));
        System.out.println(replaceSubstring("Repalce substring", "sub", "sup"));
        System.out.println(deleteWordsByLength("а аб ба вар дар пара", 2));
        System.out.println(sumOfLargeNumbers("1200000000000000000", "2400000"));
        System.out.println(deleteExtraSpace(" Java   java  java "));
        System.out.println(chooseWordsFromString("123 Java !#K$K$ hello"));


    }

    // Четные и нечетные символы разделить по разным строкам;
    public static String oddAndEvenChar(String str) {
        String oddString = "";
        String evenString = "";
        char[] charOfString = str.toCharArray();
        for (int i = 0; i < charOfString.length; i++) {
            if (i%2 == 0) {
                evenString +=charOfString[i];
            }
            else {
                oddString += charOfString[i];
            }
        }
        return evenString + " " + oddString;
    }

    // Процентное соотношение строчных и прописных букв;
    public static String uppercaseOrLowercaseLetter(String str) {
        int lowerCase = 0;
        int upperCase = 0;

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isUpperCase(ch)) {
                upperCase++;
            }
            if (Character.isLowerCase(ch)) {
                lowerCase++;
            }
        }
        int sum = lowerCase + upperCase;
        return "Cтрочных букв " + (double)(upperCase*100) /(sum) +
                "%, прописных - " + (double)(lowerCase*100)/(sum) +"%";
    }

    // Удаление одинаковых символов;
    public static String deleteDuplicateChar(String str) {
        StringBuilder sb = new StringBuilder();
        int index;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            index = str.indexOf(c, i + 1);
            if (index == -1) {
                sb.append(c);
            }
        }
        String result = sb.toString();
        return result;
    }

    //Частота встречаемости символа в строке;
    public static int findQuantityOfChar(String testString, char choosenChar) {
        int numberOfIteration = 0;
        String s = testString.replace(new Character(choosenChar).toString(), "");
        numberOfIteration = testString.length() - s.length();
        return numberOfIteration;
    }

    //Переворот строки;
    public static String reverseString(String str) {
        StringBuilder stringReverse = new StringBuilder(str).reverse();
        return stringReverse.toString();
    }

    // Вставка подстроки;
    public static String insertOfSubstring(String str, String subString, int position ) {
        StringBuilder addSubstring = new StringBuilder(str).insert(position, subString);
        return addSubstring.toString();
    }

    // Удаление подстроки;
    public static String deleteOfSubstring(String str, String subString) {
        String result = str.replaceAll(subString, "");
        return result;
    }

    // Копирование части строки;
    public static String copySubstring(String str, int begin, int end) {
        String result = str.substring(begin, end);
        return result;
    }

    // Определение длины строки;
    public static int lengthOfString(String str) {
        return str.length();
    }

    // Количество вхождений подстроки в строку;
    public static int quantitySubstring(String str, String subString) {
        int quantity = 0;
        Pattern pattern = Pattern.compile(subString);
        Matcher matcher = pattern.matcher(str);
        while(matcher.find()) {
            quantity++;
        }
        return quantity;
    }

    // Вывести слова строки в обратном порядке;
    public static String reverseWords(String str) {
        String[] arrayOfWords = str.split("\\s+");
        StringBuilder reverseOfWords = new StringBuilder();
        for (int i = arrayOfWords.length - 1; i >=0; i -- ) {
            reverseOfWords.append(arrayOfWords[i] + " ");
        }
        return reverseOfWords.toString();
    }

    // Заменить пробел и группы пробелов символом "*" ;
    public static String repalceSpace(String str) {
       return str.replaceAll("\\s", "*");
    }

    // Заменить в самом длинном слове строки буквы 'a' на 'b' ;
    public static String replaceAonB(String str) {
        String[] arrayOfWords = str.split("\\s+");
        String result = "";
        for(int i = 0; i < arrayOfWords.length; i++) {
           if (arrayOfWords[i].length() > result.length()) {
               result = arrayOfWords[i];
           }
        }
        return result.replaceAll("a", "b");
    }

    // Определить длину самого короткого слова в строке;
    public static int lengthLongestWord(String str) {
        String deletePunct = str.replaceAll("\\p{Punct}", "");
        String[] arrayOfWords = deletePunct.split("\\s+");
        int longestLength = 0;
        for (int i = 0; i < arrayOfWords.length; i++) {
            if (arrayOfWords[i].length() > longestLength) {
                longestLength = arrayOfWords[i].length();
            }
        }
        return longestLength;
    }

    // Подсчет количества слов в строке;
    public static int countWordsInString(String str) {
        String result = str.replaceAll("\\p{Punct}+", "").replaceAll("\\d+", "");
        String[] arrayOfWords = result.split("\\s+");
        return arrayOfWords.length;
    }

    // Поменять слова местами;
    public static String swapWords(String str, int fromIndex, int toIndex) {
        String[] arrayOfWords = str.split("\\s+");
        String tempString = arrayOfWords[toIndex];
        arrayOfWords[toIndex] = arrayOfWords[fromIndex];
        arrayOfWords[fromIndex] = tempString;
        return Arrays.toString(arrayOfWords);
    }

    // Удалене последнего слова в строке;
    public static String deleteLastWord(String str) {
        String result = str.replaceAll("\\p{Punct}+", "").replaceAll("\\d+", "");
        String[] arrayOfWords = result.split("\\s+");
        StringBuilder resultWords = new StringBuilder();
        for (int i = 0; i < arrayOfWords.length - 1; i++) {
            resultWords.append(arrayOfWords[i] + " ");
        }
        return resultWords.toString();
    }

    // Добавление пробелов в строку;
    public static String addSpaceToString(String str) {
        return str.replaceAll("", " ").trim();
    }

    // Является ли строка палиндром?
    public static boolean isPalindrome(String str) {
        str = str.replaceAll("\\s", "");
        StringBuilder reversedString = new StringBuilder(str).reverse();
        return str.equalsIgnoreCase(reversedString.toString());
    }

    // Замена подстроки в строке;
    public static String replaceSubstring(String str, String replaceString, String replacement) {
        return str.replaceAll(replaceString, replacement);
    }

    // Сложение очень длинных целых чисел;
    public static BigInteger sumOfLargeNumbers(String fristNumber, String secondNumber) {
        BigInteger firstBigInt = new BigInteger(fristNumber);
        BigInteger secondBigInt = new BigInteger(secondNumber);
        BigInteger sumOfNums = firstBigInt.add(secondBigInt);
        return sumOfNums;

    }

    // Удаление из строки слов заданной длины;
    public static String deleteWordsByLength(String str, int lengthOfWord)  {
        String[] arrayOfWords = str.split("\\s+");
        StringBuilder appendWords = new StringBuilder();
        for (int i = 0; i < arrayOfWords.length; i++) {
            if (arrayOfWords[i].length() != lengthOfWord) {
                appendWords.append(arrayOfWords[i] + " ");
            }
        }
        return appendWords.toString();
    }

    // Удаление лишних пробелов;
    public static String deleteExtraSpace(String str) {
        return str.replaceAll("\\s{2,}", " ").trim();
    }

    // Выделение слов из строки;
    public static String chooseWordsFromString(String str) {
        String[] words = str.split("[^A-Za-zА-Яа-я]+");
        StringBuilder resultWords = new StringBuilder();
        for (String word : words) {
            resultWords.append(word + " ");
        }
        return resultWords.toString().trim();
    }
}
