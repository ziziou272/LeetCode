package bitOperationDuplicate;

public class bitOperationCheckUnique {
    public boolean checkUnique(char[] chars){

        try {
            if(chars == null)
                throw new IllegalArgumentException("msg say sth");
            int size = chars.length;
            int index = 0;
            int bitSet [] = new int[8];
            while(index < size ){
                int i = chars[index] / 32;
                int j = chars[index] % 32;
                if((bitSet[i] & (1 << j)) != 0)
                    return false;
                bitSet[i] |= (1 << j);
            }
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            e.printStackTrace();
            //Logger.log(e);
        }catch (Exception e){
            //do sth
        }
        return true;
    }
}
