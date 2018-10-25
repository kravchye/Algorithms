package algorithm.lafore.chapter5;
// Programing project 5.5
public class JosephusProblem {
    private CircularList circularList;

    JosephusProblem(CircularList list) {
        this.circularList = list;
    }

    public LinkD eliminate(int peopleNum, int countOffNum, int start) {
        if (peopleNum < 2 || countOffNum < 1 || start < 1) {
            throw new IllegalArgumentException();
        }
        circularList.moveForward(start - 1);
        circularList.dislay();
        while(! circularList.isLast()) {
            circularList.moveForward(countOffNum - 1);
            System.out.println(" eliminated # " + circularList.deleteCurrent());
            circularList.dislay();
        }
        return circularList.getCurrent();
    }

    public static void main(String[] args) {
        CircularList circularList = new CircularList();
        circularList.insertLast(1);
        circularList.insertLast(2);
        circularList.insertLast(3);
        circularList.insertLast(4);
        circularList.insertLast(5);
        circularList.insertLast(6);
        circularList.insertLast(7);

        JosephusProblem josephusProblem = new JosephusProblem(circularList);
        long surviver = josephusProblem.eliminate(7, 4, 1).dData;
        System.out.println("Congratulation to #" + surviver);
    }

}
