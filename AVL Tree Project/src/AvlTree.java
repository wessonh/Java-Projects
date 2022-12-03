// Henry Wesson
// CS 145
// November, 27, 2022
// Assignment 3 - AVL tree


// start of the AvlTree class. This class contains the methods for conducting the operations of the AVL tree.
// it also includes methods for balancing the tree if any of the subtree become unbalanced.
// This was pretty tricky. I had to do a lot of research to get this working. I will
// go back and add to this because it was actually pretty interesting.

import java.util.LinkedList;
import java.util.Queue;

// start of AvlTree class
class AvlTree
{
// variables
    private AvlNode root;

// constructor for AvlTree
    public AvlTree()
    {
        this.root = null;
    }

// public add method calls private method
    public void add(int memberNum, String name)
    {
        this.root = add(this.root, memberNum, name);
    }

// private method for add. add new node to AvlTree
    private AvlNode add(AvlNode memberInfo, int memberNum, String name)
    {
        if(memberInfo == null)  // if the node is empty, add a new Node
        {
            return new AvlNode(memberNum, name);
        }

        if(memberNum >= memberInfo.getMemberNum()) // if memberNum is greater or equal to searched member num
        // then move it to the right
        {
            memberInfo.setRight(add(memberInfo.getRight(), memberNum, name)); // recursive call
        }

        else // otherwise move it to left subtree
        {
            memberInfo.setLeft(add(memberInfo.getLeft(), memberNum, name));
        }

        memberInfo.setLevel();
        return balanceTree(memberInfo);
    }

//  public delete method, calls private delete method
    public void delete(int memberNum)
    {
        this.root = delete(this.root, memberNum);
    }

// private delete method. Removes searched node from AVl tree.
    private AvlNode delete(AvlNode memberInfo, int memberNum)
    {

        if(memberInfo == null) // if memberInfo is null
        {
            return null;
        }

        if(memberNum > memberInfo.getMemberNum()) // if searched member info is greater than node member num
        {
            memberInfo.setRight(delete(memberInfo.getRight(), memberNum)); // recursive call. deletes right node
        }

        else if(memberNum < memberInfo.getMemberNum()) // otherwise if less than node member num
        {
            memberInfo.setLeft(delete(memberInfo.getLeft(), memberNum)); // delete left node
        }

        else // otherwise...
        {

            if(memberInfo.getRight() == null && memberInfo.getLeft() == null) // if both left and right are null
            {
                return null; // return null
            }

            if(memberInfo.getRight() == null) // if right is null
            {
                return memberInfo.getLeft(); // return left
            }

            if(memberInfo.getLeft() == null) // if left is null
            {
                return memberInfo.getRight(); // return right node
            }

            else // otherwise
            {
                AvlNode temp = findNext(memberInfo.getRight()); // make temp node
                memberInfo.setRight(delete(memberInfo.getRight(), temp.getMemberNum()));

                temp.setLeft(memberInfo.getLeft());
                temp.setRight(memberInfo.getRight());

                memberInfo = temp; // set node to temp
            }
        }

        memberInfo.setLevel(); // sets height of the node in tree
        return balanceTree(memberInfo); // balances the tree
    }

// public search method calls private method
    public AvlNode search(int memberNum)
    {
        return search(this.root, memberNum);
    }

// private search method
    private AvlNode search(AvlNode memberInfo, int memberNum)
    {
        AvlNode temp = memberInfo;

        while(temp != null && memberNum != temp.getMemberNum())  // temp isn't null and searched num isn't temp num
        {
            if (memberNum > memberInfo.getMemberNum())  // if searched num greater than info num
            {
                temp = temp.getRight(); // temp is right node
            }
            else // otherwise
            {
                temp = temp.getLeft(); // temp is left node
            }
        }
        return temp; // returns temp
    }

// public preOrder method calls private method
    public void preOrder(int memberNum)
    {
        preOrder(this.root);
    }

// private preOrder method
    private static void preOrder(AvlNode root)
    {
        if(root == null)  // if root is empty
        {
            return;
        }

        System.out.print(root.getMemberNum() + root.getName() + "\n"); // prints root
        preOrder(root.getLeft());
        preOrder(root.getRight());
    }

// public inOrder method calls private
    public void inOrder(int memberNum)
    {
        inOrder(this.root);
    }

// private inOrder method
    private void inOrder(AvlNode root)
    {
        if(root == null) // if root is null
        {
            return;
        }

        inOrder(root.getLeft()); // left
        System.out.print(root.getMemberNum() + root.getName() + "\n"); // print root
        inOrder(root.getRight()); // right
    }

// public postOrder method calls private method
    public void postOrder(int memberNum)
    {
        postOrder(this.root);
    }

// private post order method.
    private void postOrder(AvlNode root)
    {
        if (root == null) // if root is null
        {
            return; // return
        }

        postOrder(root.getLeft()); // left
        postOrder(root.getRight()); // right
        System.out.print(root.getMemberNum() + root.getName() + "\n"); // print root
    }

// public levelOrder method calls private method
    public void levelOrder(int memberNum)
    {
        levelOrder(this.root);
    }

// private levelOrder method, pulls nodes from queue to keep tree organized. took awhile to figure this out.
    private void levelOrder(AvlNode root)
    {
        Queue<AvlNode> queue = new LinkedList<>(); // makes queue for AvlNode
        queue.add(root);

        while(!queue.isEmpty()) // while node queue isn't empty
        {
            AvlNode qNode = queue.remove();
            System.out.print(qNode.getMemberNum()  + root.getName() + "\n"); // prints qNode from queue

            if(qNode.getLeft() != null)  // if left isn't empty
            {
                queue.add(qNode.getLeft()); // add left node to queue
            }

            if(qNode.getRight() != null) // if right isn't empty
            {
                queue.add(qNode.getRight()); // add right node to queue
            }
        }
    }

// boolean used for balancing Avl tree
    private boolean balance(AvlNode memberInfo)
    {
        return(Math.abs(memberInfo.getLevel(memberInfo.getLeft()) - memberInfo.getLevel(memberInfo.getRight())) <= 1);
    }

// private method to balance the avl tree if the subtree are unbalanced
    private AvlNode balanceTree(AvlNode memberInfo)
    {

        if(balance(memberInfo))  // balancing member info node
        {
            return memberInfo; // return member info node
        }

        if((memberInfo.getLevel(memberInfo.getRight()) > memberInfo.getLevel(memberInfo.getLeft())))
        // if height on right node is greater than height of left node
        {

            if (memberInfo.getLevel(memberInfo.getRight().getRight()) <= memberInfo.getLevel(memberInfo.getRight().getLeft())) {
                memberInfo.setRight(rotateRight(memberInfo.getRight()));
            }
            return rotateLeft(memberInfo);
        }

        else if(memberInfo.getLevel(memberInfo.getLeft().getLeft()) > memberInfo.getLevel(memberInfo.getLeft().getRight()))
        // otherwise if node is in left subtree of left subtree, rotate right
        {
            return rotateRight(memberInfo);
        }

        else // otherwise left rotation of left subtree and then rotate right
        {
            memberInfo.setLeft(rotateLeft(memberInfo.getLeft()));
            return rotateRight(memberInfo);
        }
    }

// private method to rotateLeft. used in balancing the tree.
    private AvlNode rotateLeft(AvlNode memberInfo)
    {
        AvlNode rotateL = memberInfo.getRight();
        AvlNode temp = rotateL.getLeft();
        rotateL.setLeft(memberInfo);
        memberInfo.setRight(temp);
        memberInfo.setLevel();
        rotateL.setLevel();
        return rotateL;
    }
// private method to rotateRight. used in balancing the tree.
    private AvlNode rotateRight(AvlNode memberInfo)
    {
        AvlNode rotateR = memberInfo.getLeft();
        AvlNode temp = rotateR.getRight();
        rotateR.setRight(memberInfo);
        memberInfo.setLeft(temp);
        memberInfo.setLevel();
        rotateR.setLevel();
        return rotateR;
    }

// private findNext method
    private AvlNode findNext(AvlNode memberInfo)
    {
        AvlNode next = memberInfo;

        while(next.getLeft() != null)  // next left isn't null
        {
            next = next.getLeft(); // next is the next left
        }
        return next; // return next
    }
} // end of AvlTree class