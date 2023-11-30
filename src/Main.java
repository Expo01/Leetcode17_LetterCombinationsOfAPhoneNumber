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

// my code beats 80 and 80 and its gorgeous
class Solution {
    List<String> combos = new ArrayList<>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return combos;
        }
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

        StringBuilder temp = new StringBuilder();
        create(numToChars, digits, 0, temp);

        return combos;
    }

    private void create(Map<Integer, ArrayList<Character>> numToChars, String digits, int index, StringBuilder temp) {
        int curNum = Integer.parseInt(String.valueOf(digits.charAt(index)));
        ArrayList<Character> curLetters = numToChars.get(curNum);

        for (Character letter : curLetters) {
            temp.append(letter);
            if (temp.length() == digits.length()) {
                combos.add(temp.toString()); // add converteed strngbuilder
            } else {
                create(numToChars, digits, index + 1, temp);
            }
            temp.deleteCharAt(temp.length() - 1); //deletee final char fror builder****
        }
    }
}


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