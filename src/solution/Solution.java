package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Solution{
    static ArrayList<Chain> poolInfo =new ArrayList();
    static HashMap<String,Long> map =new HashMap();
    static {
        Chain chain0 =new Chain("A","B",100);
        Chain chain1=new Chain("A","C",200);
        Chain chain2=new Chain("A","F",100);
        Chain chain3=new Chain("B","D",100);
        Chain chain4=new Chain("D","E",50);
        Chain chain5=new Chain("C","G",300);
        poolInfo.add(chain0);
        poolInfo.add(chain1);
        poolInfo.add(chain2);
        poolInfo.add(chain3);
        poolInfo.add(chain4);
        poolInfo.add(chain5);
    }

    public static void main(String[] args){
        long max=0;
        String maxS="";
        for(char c:"ABCDEF".toCharArray()){
            Tree tree=new Tree(c+"",0,new ArrayList());
            Tree treeInfo=getChain(tree);
            MaxStringAndScore stringAndScore=getMax(tree);
            if(stringAndScore.score>max){
                max=stringAndScore.score;
                maxS=stringAndScore.name;
            }
        }
        System.out.println("result:"+maxS+":"+max);
    }

    private static MaxStringAndScore getMax(Tree tree){
        map.clear();
        map.put(tree.name,tree.score);
        DFS(tree,tree.name);

        HashMap<Long,String> map1=new HashMap();
        for(Map.Entry<String,Long> key: map.entrySet()){
            map1.put(key.getValue(),key.getKey());
        }
        // 找到最大的耗时路线
        long max=0;
        String maxS="";
        for(Map.Entry<Long,String> key:map1.entrySet()){
            if(key.getKey()>max){
                max=key.getKey();
                maxS=key.getValue();
            }
        }
        return new MaxStringAndScore(maxS,max);
    }
    private static void DFS(Tree treeInfo, String curRoute){
        if(treeInfo.sons.isEmpty()){
            return;
        }
        for(Tree tree:treeInfo.sons){
            map.put(curRoute + tree.name,map.get(curRoute)+tree.score);
            DFS(tree, curRoute + tree.name);
        }
    }
    private static Tree getChain(Tree A){
        // 根据poolInfo创建数据结构
        for(Chain chain:poolInfo){
            if(A.name.equals(chain.getSourceName())){
                Tree tree =new Tree(chain.getSourceName(),chain.getCostTime(),new ArrayList<>());
                A.sons.add(tree);
                getChain(tree);
            }
        }
        return A;
    }


    static class Chain{
        private String sourceName;
        private String targetName;
        private long costTime;

        public Chain(String sourceName, String targetName, long costTime) {
            this.sourceName = sourceName;
            this.targetName = targetName;
            this.costTime = costTime;
        }

        public String getSourceName() {
            return sourceName;
        }

        public void setSourceName(String sourceName) {
            this.sourceName = sourceName;
        }

        public String getTargetName() {
            return targetName;
        }

        public void setTargetName(String targetName) {
            this.targetName = targetName;
        }

        public long getCostTime() {
            return costTime;
        }

        public void setCostTime(long costTime) {
            this.costTime = costTime;
        }
    }
    static class Tree{
        private String name;
        private long score;
        private ArrayList<Tree> sons;

        public Tree(String name, long score, ArrayList<Tree> sons) {
            this.name = name;
            this.score = score;
            this.sons = sons;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public long getScore() {
            return score;
        }

        public void setScore(long score) {
            this.score = score;
        }

        public ArrayList<Tree> getSons() {
            return sons;
        }

        public void setSons(ArrayList<Tree> sons) {
            this.sons = sons;
        }
    }
    static class MaxStringAndScore{
        private String name;
        private Long score;

        public MaxStringAndScore(String name, Long score) {
            this.name = name;
            this.score = score;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getScore() {
            return score;
        }

        public void setScore(Long score) {
            this.score = score;
        }
    }
}
