package PoloNiex;

import java.util.*;

public class HangManGame {

    private int len;
    private int unmatchedLen;
    private int guessCount;
    private int guessCountLimit;
    private char[] guessWord;
    private String targetWord;
    private HashMap<Character, List<Integer>> charMap;
    private HashSet<Character> guessedCharSet;

    private Scanner sc;

    //todo: constructor

    public HangManGame(){
        this.sc = new Scanner(System.in);
    }

    public void startGame(){
        System.out.println("Please enter the word");
        String target = sc.nextLine();
        //todo trim the word to delete unnecessary char like space
        //initialize
        this.len = target.length();
        this.unmatchedLen = this.len;
        this.guessCount = 1;
        this.guessCountLimit = 7;
        this.guessWord = new char[this.len];
        for(int i  = 0; i < len; i++) guessWord[i] = '-';
        this.targetWord = target;
        this.charMap = new HashMap<>();
        //put char to map
        for(int i  = 0; i < target.length(); i++){
            charMap.putIfAbsent(target.charAt(i), new ArrayList<>());
            charMap.get(target.charAt(i)).add(i);
        }
        this.guessedCharSet = new HashSet<>();
        //start guess
        guessGame();
    }

    //perform the game
    public boolean guessGame(){
        while (guessCount <= guessCountLimit){
            System.out.println(Arrays.toString(guessWord));
            System.out.println("Please enter the " + guessCount + "st guess");
            //1.guess char ? 2. guess word
            String input = sc.nextLine();
            String word = input.split("\\s+")[0];
            char guessChar = word.charAt(0);
            //not valid guess
            if(guessedCharSet.contains(guessChar)){
                System.out.println("Guessed");
            }
            //valid guess
            else{
                //guess right
                if(charMap.containsKey(guessChar)){
                    System.out.println("Correct");
                    for(int index : charMap.get(guessChar)){
                        guessWord[index] = guessChar;
                        unmatchedLen--;
                    }
                    if (unmatchedLen == 0){
                        System.out.println("Guessing player win");
                        return true;
                    }
                }else {
                    System.out.println("Wrong");
                    guessCount++;
                }
                guessedCharSet.add(guessChar);
            }
        }
        System.out.println("Guessing player lost");
        return false;
    }

}
/*
1. start game ->
2. terminate game : win/lose/(stop) -> match the word
3. continue game
4. quit game


* "--------"
* len: int 4
* guess: char[]{----}
* target: char[]{game}
*


*
*
* */
