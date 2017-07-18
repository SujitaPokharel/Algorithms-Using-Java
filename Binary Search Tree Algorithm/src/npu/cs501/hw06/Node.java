package npu.cs501.hw06;

public class Node {
 int key; // data member to hold key 
 Node parent, left, right; // data members to point respective nodes
 
 public Node(int key){// constructor that takes key value
	 this.key = key;
 }
}
