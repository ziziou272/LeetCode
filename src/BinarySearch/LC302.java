package BinarySearch;

public class LC302 {
    public int minArea(char[][] image, int x, int y) {
        //cc
        if(image == null || image.length == 0 || image[0] == null || image[0].length == 0)
            return 0;
        int row = image.length;
        int col = image[0].length;
        //find leftBoundary
        int left = checkBoundary(image, 0, y, true, true);
        //find rightBoundary
        int right = checkBoundary(image, y, col - 1, true, false);
        //find upBoundary
        int up = checkBoundary(image, 0, x, false, true);
        //find downBoundary
        int down = checkBoundary(image, x, row - 1, false, false);
        return (right - left + 1) * (down - up + 1);
    }

    private int checkBoundary(char[][] image, int left, int right, boolean col, boolean fuck){
        if((col && fuck) || (!col &&fuck)){
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(checkOne(image, mid, col))
                    right = mid - 1;
                else
                    left = mid + 1;
            }
            return left;
        }
        else{
            while(left <= right){
                int mid = left + (right - left) / 2;
                if(checkOne(image, mid, col))
                    left = mid + 1;
                else
                    right = mid - 1;
            }
            return right;
        }
    }

    private boolean checkOne(char[][] image, int index, boolean col){
        if(col){
            for(int i = 0; i < image.length; i++){
                if(image[i][index] == '1')
                    return true;
            }
            return false;
        }
        else{
            for(int i = 0; i < image[0].length; i++){
                if(image[index][i] == '1')
                    return true;
            }
            return false;
        }
    }
}
