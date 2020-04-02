package algorithm.lafore.chapter8;
//Chapter 8, Exercise 5

/* Write a program to implement Huffman coding and decoding. It should do the
following:
Accept a text message, possibly of more than one line.
Create a Huffman tree for this message.
Create a code table.
Encode the message into binary.
Decode the message from binary back to text.
If the message is short, the program should be able to display the Huffman tree
after creating it. The ideas in Programming Projects 8.1, 8.2, and 8.3 might
prove helpful. You can use String variables to store binary numbers as arrangements
of the characters 1 and 0. Don’t worry about doing actual bit manipulation
unless you really want to.
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class HuffmanNode implements Comparable<HuffmanNode> {
    String sData;
    int frequency; // frequency of the character
    HuffmanNode leftChild;
    HuffmanNode rightChild;

    HuffmanNode(int frequency) {
        this.frequency = frequency;
    }

    HuffmanNode(String sData, int frequency) {
        this(frequency);
        this.sData = sData;
    }

    public void displayNode() {
        System.out.print(toString());
    }

    @Override
    public int compareTo(HuffmanNode other) {
        return this.frequency - other.frequency;
    }

    @Override
    public String toString() {
        return "{" + sData + ", " + frequency + "}";
    }
}

public class HuffmanTree {
    private HuffmanNode root;            //first node of tree
    private String[] codeTable;
    private String huffmanCode;            //used to generate table with "0"s and "1"s

    public HuffmanTree(String initString) {
        huffmanCode = new String();
        codeTable = new String[128]; //only ASCII for simplicity
        System.out.print("Initializing Huffman tree...");

        // find frequency for each character
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < initString.length(); i++) {
            Character ch = initString.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        //Insert each character into a node and fill a priority queue with nodes
        Queue<HuffmanNode> queue = new PriorityQueue<>();
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey().toString(), entry.getValue()));
        }

        //keep combining nodes until there is only one left (root of Huffman Tree)
        while (queue.size() > 1) {
            HuffmanNode first = queue.remove();
            HuffmanNode second = queue.remove();
            HuffmanNode newNode = new HuffmanNode(first.frequency + second.frequency);
            newNode.leftChild = first;
            newNode.rightChild = second;
            queue.add(newNode);
        }

        //get 1 remaining node as root of entire tree
        root = queue.remove();
        createTable(root);
    }

    void createTable(HuffmanNode localRoot) {

        if (localRoot.sData != null) {
            char temp = localRoot.sData.charAt(0);
            int index = (int) temp;
            codeTable[index] = huffmanCode;
            System.out.println("Generated (" + codeTable[index] + ") at index " + index);
            return;
        } else {
            huffmanCode += "0";
            createTable(localRoot.leftChild);
            huffmanCode = huffmanCode.substring(0, huffmanCode.length() - 1);

            huffmanCode += "1";
            createTable(localRoot.rightChild);
            huffmanCode = huffmanCode.substring(0, huffmanCode.length() - 1);
        }
    }

    public String encode(String message)
    {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < message.length(); i++) {
            char ch = message.charAt(i);
            int index = ch;
            sb.append(codeTable[index]);
        }
        return sb.toString();
    }

    public String decode(String codedMessage)
    {
        String result = new String();
        HuffmanNode temp = root;
        int i = 0;
        while(i < codedMessage.length())
        {
            if(temp.sData == null)
            {
                if(codedMessage.charAt(i) == '0') {temp = temp.leftChild;}
                else if(codedMessage.charAt(i) == '1') {temp = temp.rightChild;}
                i++;
            }
            else
            {
                result += temp.sData;
                temp = root;
            }
        }
        result += temp.sData;	//parse the last character


        return result;
    }

    public void traverse(int traverseType)
    {
        switch(traverseType)
        {
            case 1: System.out.print("\nPreorder traversal: ");
                preOrder(root);
                break;
            case 2: System.out.print("\nInorder traversal: ");
                inOrder(root);
                break;
            case 3: System.out.print("\nPostorder traversal: ");
                postOrder(root);
                break;
        }
        System.out.println("");
    }

    private void preOrder(HuffmanNode localRoot)
    {
        if(localRoot != null)
        {
            System.out.print(localRoot.sData + " ");
            preOrder(localRoot.leftChild);
            preOrder(localRoot.rightChild);
        }
    }

    private void inOrder(HuffmanNode localRoot)
    {
        if(localRoot != null)
        {
            System.out.print("(");
            inOrder(localRoot.leftChild);
            System.out.print(localRoot.sData + " ");
            inOrder(localRoot.rightChild);
            System.out.print(")");
        }
    }

    private void postOrder(HuffmanNode localRoot)
    {
        if(localRoot != null)
        {
            postOrder(localRoot.leftChild);
            postOrder(localRoot.rightChild);
            System.out.print(localRoot.sData + " ");
        }
    }

    public void displayTree()
    {
        Stack<HuffmanNode> globalStack = new Stack<HuffmanNode>();
        globalStack.push(root);
        int nBlanks = 32;
        boolean isRowEmpty = false;
        System.out.println(
                ".......................................................");
        while(isRowEmpty==false)
        {
            Stack<HuffmanNode> localStack = new Stack<HuffmanNode>();
            isRowEmpty = true;

            for(int j = 0; j < nBlanks; j++)
                System.out.print(" ");

            while(globalStack.isEmpty() == false)
            {
                HuffmanNode temp = globalStack.pop();
                if(temp != null)
                {
                    System.out.print(temp.sData);
                    localStack.push(temp.leftChild);
                    localStack.push(temp.rightChild);

                    if(temp.leftChild != null ||
                            temp.rightChild != null)
                        isRowEmpty = false;
                }
                else
                {
                    System.out.print("--");
                    localStack.push(null);
                    localStack.push(null);
                }
                for(int j = 0; j < nBlanks*2 - 2; j++)
                    System.out.print(" ");
            } //end while globalStack not empty
            System.out.println();
            nBlanks /= 2;
            while(localStack.isEmpty() == false)
                globalStack.push( localStack.pop() );
        } //end while isRowEmpty is false
        System.out.println(
                ".......................................................");
    } //end displayTree()

    public static void main(String[] args) throws IOException
    {
        int value;
        String initString = "Alleluia, praise the LORD!!!";
        String encoded = new String();
        String decoded;
        HuffmanTree theTree = new HuffmanTree(initString);

        while(true)
        {
            System.out.print("Enter first letter of decode, encode, show,"
                    + " or traverse: ");
            int choice = getChar();
            switch(choice)
            {
                case 'e':
                    encoded = theTree.encode(initString);
                    System.out.println(encoded);
                    break;
                case 'd':
                    decoded = theTree.decode(encoded);
                    System.out.println(decoded);
                    break;
                case 's':
                    theTree.displayTree();
                    break;
                case 't':
                    System.out.print("Enter type 1, 2, or 3: ");
                    value = getInt();
                    theTree.traverse(value);
                    break;
                default:
                    System.out.print("Invalid entry!\n");
            } // end switch
        } // end while
    } // end main()

    public static String getString() throws IOException
    {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }

    public static char getChar() throws IOException
    {
        String s = getString();
        return s.charAt(0);
    }

    public static int getInt() throws IOException
    {
        String s = getString();
        return Integer.parseInt(s);
    }

}
