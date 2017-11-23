package com.company;




public class Main {
    static Node root, current;
    static int identFlag = 0;
    public static void addNode(int value) {
        if (root != null) {
            if (root.value > value) {
                if (root.left != null) {
                    addNode(value, root.left);
                } else {
                    root.left = new Node(value);
                }
            } else {
                if (root.right != null) {
                    addNode(value, root.right);
                } else {
                    root.right = new Node(value);
                }
            }
        } else {
            root = new Node(value);
        }
    }

    public static void addNode(int value, Node node) {
        if (node.value > value) {
            if (node.left != null) {
                addNode(value, node.left);
            } else {
                node.left = new Node(value);
            }
        } else {
            if (node.right != null) {
                addNode(value, node.right);
            } else {
                node.right = new Node(value);
            }
        }
    }


    static boolean countaint(int num) {
        if (root != null) {
            if (root.value == num) {
                return true;
            } else countaint(num, root);
        } else {
            return false;
        }
        if (identFlag != 0) return true;
        else{
            return false;
        }
    }

    static void countaint(int num, Node node) {
        if (node.left != null) {
            countaint(num, node.left);
        }
        if (node.right != null) {
            countaint(num, node.right);
        }
        if(num == node.value) {
            identFlag++;
        }
    }
    static int count(int num){
        identFlag = 0;
        countaint(num);
        return identFlag;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 3, 234, 7, 45, 21, 1, 6, 78, 34, 56, 76, 3, 1, 5, 8, 10, 15, 5, 16, 5};
        for (int i : arr) {
            addNode(i);
        }
        System.out.println(countaint(22));
        System.out.println(countaint(234));
        System.out.println(countaint(76));
        System.out.println(count(3));
        System.out.println(count(5));
    }
}
