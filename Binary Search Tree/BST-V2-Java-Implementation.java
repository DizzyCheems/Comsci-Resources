/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;
import java.util.*;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Favia-Ju
 */

/**
 *
 * @author Favia-Ju
 */
class Node {
  int item;
  Node left, right;

  public Node(int key) {
  item = key;
  left = right = null;
  }
}

public class Test 
{
  public static boolean choice;
  public static Node root;
  Test() {
  root = null;
  }

  public static int menu()
    {
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("1-Insert a new item into the BST");
        System.out.println("2-Display the Preorder Traversal of BST");
        System.out.println("3-Display the Inorder Traversal of BST");
        System.out.println("4-Display the Postorder Traversal of BST");
        System.out.println("5-Display the Level-order Traversal of BST");
        System.out.println("6-Display all of the BST's leaves");
        System.out.println("7-Delete an item from the BST");
        System.out.println("8-Return the BST's minimum node");
        System.out.println("9-Return the BST's maximum node");
        System.out.println("10-Exit");
        System.out.print("Select menu choice: ");
        int choice = input.nextInt();
        System.out.println("");
        return choice;    
    } 
    public static int countLeaf(Node node) {
    if(node == null) {
      return 0;
    }

    if (node.left == null && node.right == null) {
      return 1;
    }
    else {
      return countLeaf(node.left) + countLeaf(node.right);
    }
  }
  public static void postorder(Node node) {
  if (node == null)
    return;
  postorder(node.left);
  postorder(node.right);
  System.out.print(node.item + " ");
  }

public static int findMin(Node node)
{
	if (node == null)
		return Integer.MAX_VALUE;

	int res = node.item;
	int lres = findMin(node.left);
	int rres = findMin(node.right);

	if (lres < res)
		res = lres;
	if (rres < res)
		res = rres;
	return res;
}
	void deleteKey(int key) { root = deleteRec(root, key); }
	Node deleteRec(Node root, int key)
	{
		if (root == null)
			return root;
		if (key < root.item)
			root.left = deleteRec(root.left, key);
		else if (key > root.item)
			root.right = deleteRec(root.right, key);
		else {
			
			if (root.left == null)
				return root.right;
			else if (root.right == null)
				return root.left;
			root.item = minValue(root.right);

		
			root.right = deleteRec(root.right, root.item);
		}

		return root;
	}

	int minValue(Node root)
	{
		int minv = root.item;
		while (root.left != null)
		{
			minv = root.left.item;
			root = root.left;
		}
		return minv;
	}
 public static int findMax(Node node)
	{
		if (node == null)
			return Integer.MIN_VALUE;

		int res = node.item;
		int lres = findMax(node.left);
		int rres = findMax(node.right);

		if (lres > res)
			res = lres;
		if (rres > res)
			res = rres;
		return res;
	}

  	
	void inorder() { inorderRec(root); }

	
	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.item + " ");
			inorderRec(root.right);
		}
	}

  public static void preorder(Node node) {
  if (node == null)
    return;

 
  System.out.print(node.item + " " );
  preorder(node.left);
  preorder(node.right);
  }
 
  	void insert(int item) { root = insertRec(root, item); }
	Node insertRec(Node root, int item)
	{

		if (root == null) {
			root = new Node(item);
			return root;
		}

		else if (item < root.item)
			root.left = insertRec(root.left, item);
		else if (item > root.item)
			root.right = insertRec(root.right, item);
		return root;
	}
 
 
public static boolean ifNodeExists( Node node, int key)
{
	if (node == null)
		return false;
	if (node.item == key)
		return true;
	boolean res1 = ifNodeExists(node.left, key);
	if(res1) return true;
	boolean res2 = ifNodeExists(node.right, key);
	return res2;
}

 
public void printLevelOrder()
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			Node node = queue.poll();
			System.out.print(node.item + " ");
			if (node.left != null) {
				queue.add(node.left);
			}
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}


  public static void main(String[] args) {
   Test tree = new Test();
   Scanner input = new Scanner(System.in);
   while (choice != true)
    {   
        int select = tree.menu();
        switch(select)
        {
        case 1:
        System.out.print("Enter a new item to be added to the BST: ");  
	    int el = input.nextInt();
		tree.insert(el);
		break;
        case 2:  
         tree.preorder(tree.root);
         System.out.println(" ");       
        break;
        case 3:
        tree.inorder();
        System.out.println(" ");
        break;
        case 4:
        tree.postorder(tree.root);
        System.out.println(" ");
        break;
        case 5:
		tree.printLevelOrder();   
        System.out.println(" ");
        break;
        case 6:
        int leafNodes = countLeaf(tree.root);
        System.out.println("Total Leaf Nodes = " + leafNodes);
        break;
        case 7:
        System.out.print("Enter an item to be removed from the BST: ");
        int del = input.nextInt();
        if (ifNodeExists(root, del))
        {
		tree.deleteKey(del);
        System.out.println(del + " " + "was deleted from the binary search tree.");
        System.out.println(" ");         
        }
    	else
        {
        //If conditional statement fails
        System.out.println(del + " " + "Was not found from the binary search tree.");
        System.out.println(" ");    
        }
        break;
        case 8:
        System.out.println("The mimimum value of the given BST is equal to " + tree.findMin(tree.root));
        break;
        case 9:
        System.out.println("The maximum value of the given BST is equal to " + tree.findMax(tree.root));
        break;
        case 10:           
        System.out.println("Thank you for running the Binary Search Tree Program");        
        System.exit(1);
        }
     }
  }
}