package com.edu.sunyifeng.pasArrToBST;

/**
 * 方法二
 * @author sunyifeng
 * @Date 2020/04/18
 */
public class PosArrayToBST2 {

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

    /**
     * 二分查找算法
     *
     * @param key
     * @param array
     * @return
     */
    public static int binSearch(int key,int[] array){
        int low = 0; //第一个下标
        int high = array.length - 1;//最后一个下标
        int middle = 0;
        //防越界
        if (key < array[low] || key > array[high] || low > high) {
            return -1;
        }
        while (low <= high) {
            middle = (low + high) / 2;
            if (array[middle] == key) {
                return array[middle];
            } else if (array[middle] < key) {
                low = middle + 1;
            } else {
                high = middle - 1;
            }
        }
        return -1;
    }

    public static int binSearch1(int key,int[] array){
        int low = 0; //第一个下标
        int high = array.length - 2;//最后一个下标
        int middle = 0;
        //防越界


        while (low <= high) {

            middle = (low + high) / 2;

            if(low == high){
                return middle;
            }
            if (array[middle] < key) {
                low=middle;
            } else  {
                high=middle;
            }
        }
        return -1;
    }



    public static void main(String[] args) {

        // 既有左子树，又有右子树
        int[] posArr = new int[]{2,4,3,6,8,7,5};

        // 只有左子树
        // int[] posArr = new int[]{1,2,3,4,5,6};

        //只有右子树
        // int[] posArr = new int[]{6,5,4,3,2,1};



        // 执行算法
        // int i = binSearch(4, posArr);
        // System.out.println(i);


        System.out.println("end");
    }

}
