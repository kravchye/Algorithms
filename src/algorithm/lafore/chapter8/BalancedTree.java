package algorithm.lafore.chapter8;

/**
 * Programming project 8.2
 * Start with the tree.java program (Listing 8.1) and modify it to create a binary
 * tree from a string of letters (like A, B, and so on) entered by the user. Each
 * letter will be displayed in its own node. Construct the tree so that all the nodes
 * that contain letters are leaves. Parent nodes can contain some non-letter
 * symbol like +. Make sure that every parent node has exactly two children.
 * Don’t worry if the tree is unbalanced.
 */
public class BalancedTree extends StringTree {

    BalancedTree(String initString) {
        root = null;
        int nElems = 0; //# of elements in the "forest"/node-array

        //Parse the input string into an array of single-letter trees
        StringNode[] nodeArray = new StringNode[initString.length()];
        for(int i = 0; i < initString.length(); i++)
        {
            nodeArray[i] = new StringNode(initString.charAt(i));
            nElems++;
        }

        //Keep combining nodes into trees until there is only one left
        while(nElems > 1)
        {
            int fillCounter = 0;
            for(int j = 0; j < nElems; j++)
            {
                if(j%2 == 1)
                {
                    StringNode tempNode = new StringNode('+');
                    tempNode.left = nodeArray[j-1];
                    tempNode.right = nodeArray[j];
                    nodeArray[fillCounter] = tempNode;
                    fillCounter++;
                }
                if(j%2 == 0 && j == nElems-1) //if there's a leftover node
                {
                    nodeArray[fillCounter] = nodeArray[j];
                }
            }
            //account for combined items
            nElems -= fillCounter;
        }
        root = nodeArray[0];
    }

    public static void main(String[] args) {
        BalancedTree sn = new BalancedTree("ABCDE");
        sn.displayTree();
    }
    
}
