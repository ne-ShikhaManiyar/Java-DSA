/*
  Question : LRU cache

  https://leetcode.com/problems/lru-cache/description/

LRU cache notes 

https://takeuforward.org/data-structure/implement-lru-cache/
 */

import java.util.*;
public class LRUCache {
    
    class Node
    {
        int key;
        int value;
        Node next;
        Node prev;  //using doubly LL 

        public Node(int key, int value)
        {
            this.key=key;
            this.value = value;

        }
    }

    Node head = new Node(0,0);//creating dummy head node
    Node tail = new Node(0,0); //creating tail head node

    HashMap<Integer,Node> hmap = new HashMap<>(); // creating hashmap for storing node key(value) & its address
    int capacity;

    public LRUCache(int capacity)
    {
        this.capacity = capacity; // intialising the capacity in constructor 
        head.next=tail;  // intially doubly LL is blank
        tail.prev=head;  // intially doubly LL is blank
 
    }

    public int get(int key)
    {
        if(hmap.containsKey(key))  // checking in map key is present or not
        {
            Node node = hmap.get(key);
            remove(node);  // remove the node from just before tail as is least recently use
            insert(node);// insert the node from just  after head as is  recently use
            return node.value;
        }
        else
        {
            return -1; //if not present in hmap or in the list
        }
    }

    public void put(int key, int value)
    {
       if(hmap.containsKey(key)) // as cache is already present remove from map & doubly LL as new entry 
                                      //is going to happen
       {
           remove(hmap.get(key));
       }
       if(hmap.size()==capacity) // if map & cache capacity is full then 
                                   // always remove last node 1 before tail which is lru
       {
            remove(tail.prev);
       }
       insert(new Node(key,value));
    }

     private void remove(Node node)
     {
           hmap.remove(node.key); // if previously existed we need to remove it from map
           node.prev.next= node.next; // connection is cut from head and pointed to tail if 1 node
           node.next.prev= node.prev; // connection is cut from tail and pointed to head if 1 node
     }

     public void insert(Node node)
     {
        hmap.put(node.key,node);  //map stores new node address with refrence to key
        Node headNext =head.next; // storing head next in a temp variable
        head.next=node;  // cutting the link with tail and creating with new node
        node.prev=head;// cutting the link with head and creating with new node
        headNext.prev=node;  // and maintaining new node connection of next with new node or tail
        node.next = headNext; // and maintaining new node connection of next with new node or tail
     }




    public static void main(String[] args)
    {

    }
}
/*
TC: o(1)
all operations in hashmap are o(1) and n doubly ll to o(1)

 Pseudocode for above code 

 LRU cache its like a data structure has methods like get & put 
 -> methods like remove & insert is created by us 
 
 -> Class Node is created by us which is a doubly LL
 
 1) we are using hashmap to store(node value & address) 

 2)we create 2 dummy nodes head & tail intialisint them with 0,0;
 3)Declaring a hashmap to store(node value & address) 
 -> and declaring a capacity to store (size of lru cache)
 4) theirs constructor of lru cache class we intialise it
 and maintain a doubly LL inside constructor as it is empty for now

 5) in get method we check in hashmap is cache present if yes then get its key
 and remove it from a node before tail and insert it into head's next
 and return the value , else not present return -1;

 6) in put method we check if cache is already present or not in map & doubly LL
 if yes then remove it from map as new guy is taking entry

 ii) if map size is full then always remove least recently used guy node before the tail

 -> now insert the new guy

 7) in the remove method(we create it)
 -> if its previously existed remove from map
 -> cut connection from head's next to tail or next node(if 1 node or new node)
-> cut connection from tails prev to head or to previous node(if 1 node or new node)

8) in insert method always store the new node refrence (key) and adrres in map
-> store head next in temp variable
-> cutting the link for both next & prev pointers with node (if 1 node then head& tail)else
joing connection with new node or tail

9) we create a Node class(1step basically) like doubly LL to perform all operations
 

*/