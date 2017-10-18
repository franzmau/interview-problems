package com.interview.problems.hard;

public class MirroredBiTrees {

    private static class Node {

        int key;
        Node left;
        Node right;

        public Node(int item) {
            key = item;
            left = right = null;
        }
    }

    /**
     * Given two Binary Trees, A and B, find if the 'B' Binary Tree is a mirror of the A Binary Tree.
     * Print True if its a mirror, print False if it's not.
     *
     * Example of a Mirrored Tree:
     * Tree A:             Tree B:
     *          1       |      1
     *         / \      |     / \
     *        2   3     |    3   2
     *       /     \    |   /     \
     *      4       6   |  6       4
     *     /            |           \
     *    5             |            5
     *
     *
     * @param rootA Root of the first Binary Tree
     * @param rootB Root of the second Binary Tree
     * @return True of False
     */
    private static boolean isMirrored(Node rootA, Node rootB) {
        if (rootA != null && rootB != null) {
            boolean keepRunning = true;

            if (rootA.key != rootB.key) {
                return false;
            }

            if (rootA.left != null || rootB.right != null) {
                keepRunning = isMirrored(rootA.left, rootB.right);
            }

            if (keepRunning) {
                if (rootA.right != null || rootB.left != null) {
                    return isMirrored(rootA.right, rootB.left);
                } else {
                    return true;
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        /*
        Generate Mirrored Trees
        Tree A:             Tree B:
                 1       |      1
                / \      |     / \
               2   3     |    3   2
              /     \    |   /     \
             4       6   |  6       4
            /            |           \
           5             |            5
         ===============================
         */
        Node treeA = new Node(1);
        treeA.left = new Node(2);
        treeA.right = new Node(3);
        treeA.right.right = new Node(6);
        treeA.left.left = new Node(4);
        treeA.left.left.left = new Node(5);

        Node treeB = new Node(1);
        treeB.left = new Node(3);
        treeB.left.left = new Node(6);
        treeB.right = new Node(2);
        treeB.right.right = new Node(4);
        treeB.right.right.right = new Node(5);

        System.out.println(isMirrored(treeA, treeB));


        /*
        Generate Un-Mirrored Trees
        Tree A:             Tree B:
                 1       |      1
                / \      |     / \
               2   3     |    3   2
              /   /      |   /     \
             4   6       |  6       4
            /            |           \
           5             |            5
         ===============================
         */
        Node treeC = new Node(1);
        treeC.left = new Node(2);
        treeC.right = new Node(3);
        treeC.right.left = new Node(6);
        treeC.left.left = new Node(4);
        treeC.left.left.left = new Node(5);

        Node treeD = new Node(1);
        treeD.left = new Node(3);
        treeD.left.left = new Node(6);
        treeD.right = new Node(2);
        treeD.right.right = new Node(4);
        treeD.right.right.right = new Node(5);

        System.out.println(isMirrored(treeC, treeD));
    }
}
