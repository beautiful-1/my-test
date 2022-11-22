package solution;

/**
 * @author LZN
 * @Title WordExist
 * @ProjectName pattern
 * @Description  查找二维矩阵中，是否存在单词
 * @date 2022-10-17 15:13
 **/
public class WordExist {
    public boolean exist(char[][] board,String world){
        for (int i=0;i<board.length;i++){
            for (int k=0;k<board[0].length;k++){
                if (dfs(board,world,0,i,k)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board,String word,int index,int x,int y){
        if (x<0||x>board.length|y<0||board[x][y]=='.'||board[x][y]!=word.charAt(index)){
            return false;
        }
        if (index==word.length()-1){
            return true;
        }else {
            //保存当前的临时的值
            char temp=board[x][y];
            // 将当前值赋值为'.'，然后进行dfs
            board[x][y]='.';
            boolean b=dfs(board,word,index+1,x+1,y)
                    ||dfs(board,word,index+1,x-1,y)
                    ||dfs(board,word,index+1,x,y+1)
                    ||dfs(board,word,index+1,x,y-1);
            board[x][y]=temp;
            return b;
        }
    }
}
