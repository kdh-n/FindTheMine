import java.util.Random;
public class FindTheMine {
    private static final String Mine = " M ";
    private static final String Space = " x ";
    private static final int Hor = 15;
    private static final int Ver = 15;
    private static final int Mine_cnt = 20;
    private String mineArr[][] = null;

    public FindTheMine(){
        mineArr = new String[Hor][Ver];
    }
    private void set(){
        for(int i=0; i< Hor ; i++){
            for (int j=0; j< Ver ; j++){
                mineArr[i][j] = Space;
            }
        }
    }
    private void setRan(int mineCnt){
        Random ran = new Random();

        while (mineCnt-- > 0){
            int h = ran.nextInt(Hor);
            int v = ran.nextInt(Ver);

            if(mineArr[h][v].equals(Mine)){
                mineCnt++;
            }
            if(mineArr[h][v].equals(Space)){
                mineArr[h][v] = Mine;
            }
        }
    }
    private boolean ExistMine(int h, int v){
        if(h< 0 || h>= Hor || v< 0 || v>= Ver)   return false;
        return mineArr[h][v].equals(Mine);
    }
    private int getMineNumber(int h, int v){
        int mineCnt = 0;
        if(ExistMine(h-1, v-1))mineCnt++;
        if(ExistMine(h-1, v))mineCnt++;
        if(ExistMine(h-1, v+1))mineCnt++;
        if(ExistMine(h, v-1))mineCnt++;
        if(ExistMine(h, v+1))mineCnt++;
        if(ExistMine(h+1, v-1))mineCnt++;
        if(ExistMine(h+1, v))mineCnt++;
        if(ExistMine(h+1, v+1))mineCnt++;
        return mineCnt;
    }
    private void setNumber(int h, int v){
        if(mineArr[h][v].equals(Space) && getMineNumber(h,v)!=0){
            mineArr[h][v] = " "+getMineNumber(h,v)+" ";
        }
    }
    private void setPrint(){

        for(int i=0; i<Hor ; i++){
            for (int j=0; j<Ver ; j++){
                setNumber(i, j);
                System.out.print(mineArr[i][j]);
            }
            System.out.println();
        }
    }
    
    public static void main(String[] args) {
        FindTheMine ftm = new FindTheMine();
        ftm.set();
        ftm.setRan(Mine_cnt);
        ftm.setPrint();
    }

}
