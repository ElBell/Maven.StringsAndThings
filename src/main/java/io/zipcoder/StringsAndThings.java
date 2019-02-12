package io.zipcoder;


/**
 * @author tariq
 */
public class StringsAndThings {

    /**
     * Given a string, count the number of words ending in 'y' or 'z' -- so the 'y' in "heavy" and the 'z' in "fez" count,
     * but not the 'y' in "yellow" (not case sensitive). We'll say that a y or z is at the end of a word if there is not an alphabetic
     * letter immediately following it. (Note: Character.isLetter(char) tests if a char is an alphabetic letter.)
     * example : countYZ("fez day"); // Should return 2
     * countYZ("day fez"); // Should return 2
     * countYZ("day fyyyz"); // Should return 2
     */
    public Integer countYZ(String input) {
        int yzCount = 0;
        String[] words = input.split(" ");
        for (String word : words) {
            char[] letters = word.toCharArray();
            if (letters[letters.length - 1] >= 'y') {
                yzCount++;
            }
        }
        return yzCount;
    }

    /**
     * Given two strings, base and remove, return a version of the base string where all instances of the remove string have
     * been removed (not case sensitive). You may assume that the remove string is length 1 or more.
     * Remove only non-overlapping instances, so with "xxx" removing "xx" leaves "x".
     * <p>
     * example : removeString("Hello there", "llo") // Should return "He there"
     * removeString("Hello there", "e") //  Should return "Hllo thr"
     * removeString("Hello there", "x") // Should return "Hello there"
     */
    public String removeString(String base, String remove) {
        String shortenedWord = base.replace(remove, "");
        return shortenedWord;
    }

    /**
     * Given a string, return true if the number of appearances of "is" anywhere in the string is equal
     * to the number of appearances of "not" anywhere in the string (case sensitive)
     * <p>
     * example : containsEqualNumberOfIsAndNot("This is not")  // Should return false
     * containsEqualNumberOfIsAndNot("This is notnot") // Should return true
     * containsEqualNumberOfIsAndNot("noisxxnotyynotxisi") // Should return true
     */
    public Boolean containsEqualNumberOfIsAndNot(String input) {
        String countString1 = "is";
        String countString2 = "not";
        int isCount = 0;
        int notCount = 0;

        int indexIs = input.indexOf("is");
        int indexNot = input.indexOf("not");
        while ((indexIs = input.indexOf("is", indexIs)) != -1) {
            isCount++;
            indexIs += "is".length();
        }

        while ((indexNot = input.indexOf("not", indexNot)) != -1) {
            notCount++;
            indexNot += "not".length();
        }

        return isCount == notCount;
    }

    /**
     * We'll say that a lowercase 'g' in a string is "happy" if there is another 'g' immediately to its left or right.
     * Return true if all the g's in the given string are happy.
     * example : gHappy("xxggxx") // Should return  true
     * gHappy("xxgxx") // Should return  false
     * gHappy("xxggyygxx") // Should return  false
     */
    public Boolean gIsHappy(String input) {
        char[] brokenString = input.toCharArray();
        for (int i = 0; i < brokenString.length - 1; i++) {
            if (brokenString[i] == 'g' && i + 1 < brokenString.length) {
                if (brokenString[i + 1] != 'g') {
                    return false;
                } else {
                    while (i + 1 < brokenString.length && brokenString[i] == 'g')
                        i++;
                }
            }
        }
        return true;
    }


    /**
     * We'll say that a "triple" in a string is a char appearing three times in a row.
     * Return the number of triples in the given string. The triples may overlap.
     * example :  countTriple("abcXXXabc") // Should return 1
     * countTriple("xxxabyyyycd") // Should return 3
     * countTriple("a") // Should return 0
     */
    public Integer countTriple(String input) {
        char[] brokenString = input.toCharArray();
        int tripleCount = 0;
        for (int i = 0; i < brokenString.length - 1; i++) {
            char current = brokenString[i];
            if (i + 1 < brokenString.length && current == brokenString[i + 1]) {
                i++;
                if (i + 1 < brokenString.length && current == brokenString[i + 1]) {
                    tripleCount++;
                }
                i--;
            }
        }
        return tripleCount;
    }
}
