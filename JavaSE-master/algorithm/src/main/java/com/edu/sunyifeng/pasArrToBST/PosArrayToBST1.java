package com.edu.sunyifeng.pasArrToBST;

/**
 * 方法一
 * @author sunyifeng
 * @Date 2020/04/16
 */
public class PosArrayToBST1 {

    public static Node posArrayToBST(int[] posArr){
        return process(posArr,0,posArr.length-1);
    }

    public static Node process(int[] posArr,int l,int r){

        if(l>r){
            return null;
        }

        Node head = new Node(posArr[r]);

        if(l==r){
            return head;
        }

        int m=l-1;
        for (int i = l; i < r ; i++) {
            if(posArr[i]<posArr[r]){
                m=i;
            }
        }

        Node lChild = process(posArr, l, m);
        head.setLChild(lChild);
        Node rChild = process(posArr, m+1, r-1);
        head.setRChild(rChild);

        return head;
    }

    public static void main(String[] args) {

        // 既有左子树，又有右子树
        int[] posArr = new int[]{2,4,3,6,8,7,5};

        // 只有左子树
        // int[] posArr = new int[]{1,2,3,4,5,6};

        //只有右子树
        // int[] posArr = new int[]{6,5,4,3,2,1};

        // 执行算法
        Node node = posArrayToBST(posArr);

        // 打印树
        TreeOperation.show(node);

        System.out.println("end");
    }
}
