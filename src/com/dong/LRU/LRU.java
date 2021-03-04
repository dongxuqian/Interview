package com.dong.LRU;
//实现lru



import org.w3c.dom.Node;

import java.util.HashMap;

/**
 * @author dong
 */
public class LRU {
    public static void main(String[] args) {

    }
    HashMap<Integer, Node> map ;
    int capacity ;
    int size;
    Node head;
    Node tail;

    public  LRU(int capacity){
        this.capacity = capacity;
        map  = new HashMap<>();
        size = 0;
        head = new Node();
        tail = new Node();
        head.last = tail;
        tail.pre = head;
    }
    public void put(int key,int value){
        Node node=  map.get(key);
        if(node!=null){
           node.value = value;
           removeToHead(node);
            return ;
        }else {
            Node res=  new Node(key,value);
            map.put(key,res);
            size++;
            addToHead(res);
            if(size>capacity){
                removeTail();
                size--;
            }
        }
    }
    public  Node removeTail(){
        Node node = tail.pre;
        remove(node);
        return node;
    }
    private void addToHead(Node node){
        node.pre = head;
        node.last = head.last;
        head.last = node;
    }


    public int get(int key){
        Node node  =  map.get(key);
       if(node==null){
           return -1;
       }
       removeToHead(node);
       return node.value;
    }
    private void removeToHead(Node node){
        remove(node);
        addToHead(node);
    }
    private void remove(Node node){
        node.pre.last = node.last;
        node.last.pre = node.pre;
    }

    class Node{
        int key;
        int value;
        Node pre;
        Node last;
        public Node(int key,int value){
            this.key = key;
            this.value =value;
        }
        public Node(){

        }
    }


}
