package com.dong.IDList;

import java.util.ArrayList;

public class IDList<E> {
    Node<E> tail;
    Node<E> head;
    int size;
    ArrayList<Node<E>> indices;
    IDList(){
        indices = new ArrayList<>();
        tail = new Node<E>();
        head = tail;

    }
    public boolean add(int index,E element){
        Node cur = new Node(element);
        if(index>size){
            return false;
        }else if(size==0){
            head.next = cur;
            cur.next = tail;
            cur.pre= head;
            tail.pre = head;
            size++;
            indices.add(index,cur);
        }else{
            Node pre = indices.get(index);
            cur.pre  = pre.pre;
            cur.next = pre;
            pre.pre = cur;
            indices.add(index,cur);
            size++;
        }
        return true;
    }
    public boolean add(E element){
        Node cur = new Node(element);
        indices.add(cur);
        tail.pre.next = cur;
        cur.pre = tail.pre;
        cur.next = tail;
        return true;
    }
    public boolean removeAt(int index){
        if(index<0&&index>=size){
            return false;
        }
        Node cur = indices.remove(index);
        cur.pre.next = cur.next;
        cur.next.pre = cur.pre;
        return true;
    }





    class Node<E>{
        E data;
        Node<E> pre;
        Node<E> next;
        Node(E date){
            this.data = date;
        }
        Node(){

        }
        Node(E data,Node pre,Node next){
            this.data =data;
            this.next = next;
            this.pre = pre;
        }
    }

}
