import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

//        int q = 'a';
//        char p = 98;
//        System.out.println(q);
//        System.out.println(p);
//        p++;
//        System.out.println(p);

        System.out.println(new Solution().letterCombinations("245464"));

    }
}


class Solution {
    List<String> combos = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        Map<Integer, ArrayList<Character>> numToChars = new HashMap<>();

        char letter = 97;

        for (int i = 2; i < 10; i++) {
            ArrayList<Character> letters = new ArrayList<>();
            if (i == 7 || i == 9) {
                for (int j = 0; j < 4; j++) {
                    letters.add(letter++);
                }
            } else {
                for (int j = 0; j < 3; j++) {
                    letters.add(letter++);
                }
            }
            numToChars.put(i, letters);
        }

        ArrayList<String> temp = new ArrayList<>(); // should be stringbuilder*******
        create(numToChars, digits, 0, temp);

        return combos;
    }

    private void create(Map<Integer, ArrayList<Character>> numToChars, String digits, int index, ArrayList<String> temp) {
        System.out.println("broken?");
        System.out.println(index + " index");
        int curNum = Integer.parseInt(String.valueOf(digits.charAt(index)));
        System.out.println(curNum + " curNum");
        ArrayList<Character> curLetters = numToChars.get(curNum);

        for (Character letter : curLetters) {
            System.out.println(letter + " letter");
            temp.add(letter.toString()); // should be stringbuilder*******
            System.out.println(temp.size() + " temp size");
            if (temp.size() == digits.length()) {
                combos.add(String.valueOf(new ArrayList<>(temp))); // add converteed strngbuilder

            } else {
                if(index< digits.length()){
                    System.out.println("reached");
                    create(numToChars, digits, index + 1, temp);
                }

            }
            temp.remove(temp.size() - 1); //deletee final char fror builder****
            System.out.println("remove statement and index of " + index); // this works where supposing '23' is given digits. final
            // combo is cf. deletes f. deletes c. index on '3' digit call is 1. returns to instance of '2' digit call index 0.
            // how is final loop occuring?
        }
    }

} // eveything good at this point (igoring need for SB) except is somehow having one final recursive call after full looping of int/chars



//
//// have temp list. when temp size == digits size add the temp to
// ans and then remove index list.size-1
// will want to map an arraylist containing letters to num key
// kick off recursive method by passing first num and looping
// through its arrraylist of vals. for each letter in the
// arraylist call anothrr recursive instance passing next numberr
// in the string etc but only call recurrsivee instance while
// passed index of string is valid. will avoiod a returrn
// statement forr OOB case