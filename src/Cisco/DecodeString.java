import java.util.Stack;

class DecodeString {
    public static String decodeString(String s) {
        // init stack prevstring
        Stack<String> prevstring = new Stack<>();

        // init stack times
        Stack<Integer> times = new Stack<>();

        // init curres
        String curres = "";

        // traverse s
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //     if num: push into nums
            if (Character.isDigit(c)) {
                int num = c - '0';
                // find the total digit
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    num = num * 10 + (s.charAt(i + 1) - '0');
                    i++;
                }
                times.push(num);
            }
            //     else if letter: add to curres
            else if (Character.isLetter(c)) {
                curres = curres + c;
            }
            // push the curres into prevstring (store the prevstring)
            else if (c == '(') {
                prevstring.push(curres);
                curres = "";
            }
            //     else if ]: 
            else if (c == '}') {
                // pop out the prevstring and a time
                String prev = prevstring.pop();
                int num = times.pop();
                // repeat prevstring for num times and that to the end of prevstring to form a new curres
                for (int j = 0; j < num; j++) {
                    prev = prev + curres;
                }
                curres = prev;
            }
        }
        return curres;
    }


    public static void main(String[] args) {
        System.out.println(decodeString("(a(c){2}){3}"));
    }
}


// intuition:
// last-in-first-out to store letter and pop letter when]: stack
// last-in-first-out to store number  and pop when]: stack

// psedo:
// init prevstring stack
// init times stack
// init curres
// traverse through string:
//     if num:
//         get the whole num, push into times
//     if [:
//         push the curres into prevstring (store the prevstring)
//     if letters:
//         add to curres
//     if ]:
//         pop out the prevstring and a time
//         repeat the curres for times time
//         and that to the end of prevstring to form a new curres
// return res


// ex:
// 2[abc]3[cd]ef
// letters ef
// nums 
// res abcabccdcd