package algorithm.lafore.chapter8;

//Chapter 8, Exercise 3

/* Again, start with the tree.java program and make a tree from characters typed
by the user. This time, make a complete tree—one that is completely full
except possibly on the right end of the bottom row. The characters should be
ordered from the top down and from left to right along each row, as if writing
a letter on a pyramid. (This arrangement does not correspond to any of the
three traversals we discussed in this chapter.)
*/
public class FullTree extends StringTree {


    FullTree(String input) {
        root = fillNode(input, 1);
    }

    StringNode fillNode(String input, int location) {
        if (location > input.length()) {
            return null;
        }
        StringNode sn = new StringNode(input.charAt(location - 1));
        sn.left = fillNode(input, 2 * location);
        sn.right = fillNode(input, 2 * location + 1);
        return sn;
    }

    public static void main(String[] args) {
        new FullTree("abcdefghijklmo").displayTree();
    }
}
