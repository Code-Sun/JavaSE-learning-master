package com.edu.sunyifeng.pasArrToBST;


/**
 * 节点类
 *
 * @author sunyifeng
 * @Date 2020/04/16
 */
public class Node {

    // private int data;
    public int data;
    // private Node left;
    // 改成public是为了TreeOperation.show(node)能打印树
    public Node left;
    // private Node right;
    public Node right;

    public Node(int data) {
        this.data = data;
    }


    public void setLChild(Node left){
        this.left = left;
    }

    public void setRChild(Node right){
        this.right = right;
    }

    public void setData(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }
    public Node getLChild(){
        return this.left;
    }
    public Node getRChild(){
        return this.right;
    }

}
