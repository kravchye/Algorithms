package algorithm.lafore.chapter8;
//Chapter 8, Exercise 4

import java.io.IOException;
import java.util.Stack;

/* Write a program that transforms a postfix expression into a tree such as that
shown in Figure 8.11 in this chapter. You’ll need to modify the Tree class from
the tree.java program (Listing 8.1) and the ParsePost class from the
postfix.java program (Listing 4.8) in Chapter 4. There are more details in the
discussion of Figure 8.11.
After the tree is generated, traversals of the tree will yield the prefix, infix, and
postfix equivalents of the algebraic expression. The infix version will need
parentheses to avoid generating ambiguous expressions. In the inOrder()
method, display an opening parenthesis before the first recursive call and a
closing parenthesis after the second recursive call.
*/
public class PostFixTree extends StringTree {
    PostFixTree(String input) {
        Stack<StringNode> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            char ch = input.charAt(i);
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                StringNode node = new StringNode(ch);
                node.left = stack.pop();
                node.right = stack.pop();
                stack.push(node);
            } else {
                stack.push(new StringNode(ch));
            }
        }
        root = stack.pop();
    }

    public static void main(String[] args) throws IOException
    {
        int value;
        String initString = "ABCDEF+/-*+";
        PostFixTree theTree = new PostFixTree(initString);

        while(true)
        {
            System.out.print("Enter first letter of show"
                    + " or traverse: ");
            int choice = getChar();
            switch(choice)
            {
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
}
