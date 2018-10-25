package algorithm.lafore.chapter5.doubleEnded;

/**
 * Created by Maestro on 03.03.2018.
 */
public class Link {
    int iData;
    Link next;

    public Link(int in) {
        iData = in;
        next = null;
    }

    public void displayLink()      // display ourself
    {
        System.out.print(iData + " ");

    }
}
