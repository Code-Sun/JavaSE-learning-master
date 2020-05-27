package com.edu.sunyifeng.pasArrToBST;

public class PosArrayToBST3 {

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
       /*for (int i = l; i < r ; i++) {
           if(posArr[i]<posArr[r]){
               m=i;
           }
       }*/
        int flag = binSearch(posArr,l,r);
        if(flag!=-1){
            m = flag;
        }

        Node lChild = process(posArr, l, m);
        head.setLChild(lChild);
        Node rChild = process(posArr, m+1, r-1);
        head.setRChild(rChild);

        return head;
    }

    public static void main(String[] args) {
        //int[] posArr = new int[]{2,4,3,6,8,7,5};
        int [] posArr = new int[]{4,3,2,1};
        Node node = posArrayToBST(posArr);
        TreeOperation.show(node);
        //System.out.println(binSearch(posArr,0,posArr.length-1));
    }

    public static int binSearch(int[] array,int start,int end){
        int low = start; //第一个下标
        int high = end-1;//最后一个下标
        int middle = 0;
        int root = array[end];
        //防越界
        if (low > high) {
            return -1;
        }
        while (low < high) {
            middle = (low + high) / 2;
            //middle比根节点小，并且middle下个值比根节点大，那么middle就是根节点左子树和右子树的分界点
            if (array[middle] < root && array[middle+1] > root) {
                return middle;
            } else if (array[middle] < root && array[middle+1] < root) {
                low = middle + 1;
            } else if(array[middle] > root && array[middle+1] > root){
                high = middle - 1;
            }else if(array[middle] > root && array[middle+1] < root){
                low =  middle + 1;
            }
        }
        if(array[low] < root && array[high] < root){
            return high;
        }
        return -1;
    }
}

