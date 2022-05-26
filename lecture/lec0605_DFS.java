package lecture;

import java.util.Scanner;

class Node {
    int data;//부모
    Node lt, rt;

    public Node(int val) {
        data = val;
        lt=rt=null;
    }
}


public class lec0605_DFS {
    Node root;
    public void DFS(Node root){
        if(root==null) return;
        else{
            DFS(root.lt);
            System.out.print(root.data + " ");
            DFS(root.rt);
        }
    }

    public static void main(String[] args) {
        lec0605_DFS tree = new lec0605_DFS();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.DFS(tree.root);
    }
}
