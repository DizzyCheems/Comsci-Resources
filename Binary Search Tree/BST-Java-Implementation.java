import java.util.*;
import java.util.LinkedList;
import java.util.Queue;

class Node {
  int item;
  Node left, right;

  public Node(int key) {
  item = key;
  left = right = null;
  }
}

public class Main 
{
    public static boolean choice;
  // Root of Binary Tree
  Node root;
  Main() {
  root = null;
  }

  public static int menu()
    {
        Scanner input = new Scanner(System.in);
        /***************************************************/
        System.out.println("Choose from these choices");
        System.out.println("++++++++++++++++++++++++\n");
        System.out.println("1 - Enter Elements");
        System.out.println("2 - InOrder Traversal");
        System.out.println("3 - Pre-Order Traversal");
        System.out.println("4 - Post-Order Traversal");
        System.out.println("5 - Find Max Value");
        System.out.println("6 - Find Min Value");
        System.out.println("7 - Level-Order Traversal");
        System.out.println("8 - Terminate program");
        int choice = input.nextInt();
        return choice;    
    }



  public static void postorder(Node node) {
  if (node == null)
    return;

  // Traverse left
  postorder(node.left);
  // Traverse right
  postorder(node.right);
  // Traverse root
  System.out.print(node.item + "->");
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

  	// This method mainly calls InorderRec()
	void inorder() { inorderRec(root); }

	// A utility function to
	// do inorder traversal of BST
	void inorderRec(Node root)
	{
		if (root != null) {
			inorderRec(root.left);
			System.out.print(root.item + "->");
			inorderRec(root.right);
		}
	}

  public static void preorder(Node node) {
  if (node == null)
    return;

  // Traverse root
  System.out.print(node.item + "->");
  // Traverse left
  preorder(node.left);
  // Traverse right
  preorder(node.right);
  }
 
  	void insert(int item) { root = insertRec(root, item); }

	/* A recursive function to
	insert a new key in BST */
	Node insertRec(Node root, int item)
	{

		/* If the tree is empty,
		return a new node */
		if (root == null) {
			root = new Node(item);
			return root;
		}

		/* Otherwise, recur down the tree */
		else if (item < root.item)
			root.left = insertRec(root.left, item);
		else if (item > root.item)
			root.right = insertRec(root.right, item);

		/* return the (unchanged) node pointer */
		return root;
	}
 
public void printLevelOrder()
	{
		Queue<Node> queue = new LinkedList<Node>();
		queue.add(root);
		while (!queue.isEmpty()) {

			Node node = queue.poll();
			System.out.print(node.item + " ");

			/*Enqueue left child */
			if (node.left != null) {
				queue.add(node.left);
			}

			/*Enqueue right child */
			if (node.right != null) {
				queue.add(node.right);
			}
		}
	}


  public static void main(String[] args) {
  Main tree = new Main();
      
        Scanner input = new Scanner(System.in);
       // System.out.print("Enter Root Node: ");
      //  int element = input.nextInt();
      //  tree.root = new Node(element);
  
  
   while (choice != true)
    {   
        int select = tree.menu();
        switch(select)
        {
        case 1:
        System.out.println("Enter Elements of your BST");
           for(int i=0; i<5; i++)
	    {
	    int el = input.nextInt();
		tree.insert(el);
		}
        break;
        case 2:
        System.out.println("Inorder traversal");
        tree.inorder();
        break;
        case 3:
        System.out.println("\nPreorder traversal ");
        tree.preorder(tree.root);
        break;
        case 4:
        System.out.println("\nPostorder traversal");
        tree.postorder(tree.root);
        break;
        case 5:
        System.out.println("Maximum element is " + tree.findMax(tree.root));
        break;
        case 6:
        System.out.println("Maximum element is " + tree.findMin(tree.root));
        break;
        case 7:
        System.out.println("Level order traversal of binary tree is - ");
		tree.printLevelOrder();   
        break;        
        case 8:
        System.out.println("Terminating Program...");        
        System.exit(1);
        }
     }
  
  
  }
}
