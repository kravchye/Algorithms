package algorithm.lafore.chapter8;


import java.util.Stack;

/**
 * Programming project 8.1
 * Start with the tree.java program (Listing 8.1) and modify it to create a binary
 * tree from a string of letters (like A, B, and so on) entered by the user. Each
 * letter will be displayed in its own node. Construct the tree so that all the nodes
 * that contain letters are leaves. Parent nodes can contain some non-letter
 * symbol like +. Make sure that every parent node has exactly two children.
 * Don’t worry if the tree is unbalanced.
 */
class StringNode {
    Character value;
    StringNode left;
    StringNode right;
    StringNode(Character str) {
        this.value = str;
    }
    StringNode(StringNode left, StringNode right) {
        this.left = left;
        this.right = right;
    }
    StringNode(StringNode left, StringNode right, Character str) {
        this(str);
        this.left = left;
        this.right = right;

    }
    public void displayNode()      // display ourself
    {
        System.out.print('{');
        System.out.print(value);
        System.out.print("} ");
    }
}

class StringTree {
    StringNode root;
    public static final Character PLUS = '+';

    protected StringTree(){}

    public StringTree(String str) {
        if (str == null && str.isEmpty()) {
            root = null;
            return;
        }
        StringNode first = new StringNode(str.charAt(0));
        if (str.length() == 1) {
            StringNode plus = new StringNode(PLUS);
            plus.left = new StringNode(PLUS);
            plus.right = first;
            root = plus;
            return;
        }
        StringNode second = new StringNode(str.charAt(1));
        StringNode plusNode = new StringNode(PLUS);
        plusNode.left = first;
        plusNode.right = second;
        for (int i = 2; i < str.length(); i++) {
            plusNode = new StringNode(plusNode, new StringNode(PLUS), str.charAt(i));
        }
        root = plusNode;
    }

    public static void main(String[] args) {
        StringTree sn = new StringTree("ABCDE");
        sn.displayTree();

    }

    public void displayTree()
    {
        Stack<StringNode> globalStack = new Stack<StringNode>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                "......................................................");
        while(isRowEmpty==false)
        {
            Stack<StringNode> localStack = new Stack<StringNode>();
            isRowEmpty = true;

            for(int j=0; j<nBlanks; j++)
                System.out.print(' ');

            while(globalStack.isEmpty()==false)
            {
                StringNode temp = globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.value);
                    localStack.push(temp.left);
                    localStack.push(temp.right);

                    if(temp.left != null ||
                            temp.right != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j=0; j<nBlanks*2-2; j++)
                    System.out.print(' ');
            }  // end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty()==false)
                globalStack.push( localStack.pop() );
        }  // end while isRowEmpty is false
        System.out.println(
                "......................................................");
    }  // end displayTree()
}

