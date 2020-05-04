package stringAndArray;

import java.util.ArrayList;
import java.util.List;

public class DiagnoalArray {

    public static void main(String[] args){
        arr a = new arr();
        System.out.println(a.print(3,2));
    }


}
class arr{
    /*
    * 6 10 14 17
    * 3 7  11 15 18
    * 1 4  8  12 16 19
    * 0 2  5  9  13    20
    *
    * //
    * 3 5
    * 1 4
    * 0 2
    * //
    *
    * */

    List<List<Integer>> print(int row, int col){
        List<List<Integer>> res = new ArrayList<>();
        int index = 0;
        for(int i = 0; i < row; i++)
            res.add(new ArrayList<>());
        for(int i = row - 1; i >= 0; i--){
            for(int j = i; j < row && res.get(j).size() < col; j++){
                res.get(j).add(index++);
            }
        }
        for(int i = 1; i < col; i++){
            for(int j = 0; j < row && res.get(j).size() < col; j++){
                res.get(j).add(index++);
            }
        }
        return res;

    }


}
