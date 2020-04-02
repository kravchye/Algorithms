package algorithm.lafore.chapter6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShowTeam {

//    public static void main(String[] args)
//    {
//        String sequence = "";
//        int teamSize = 5;
//        int groupSize = 3;
//        showTeams(teamSize, groupSize, sequence, 'A', groupSize-1);
//    }
//
//
//
//    public static void showTeams(int teamSize, int groupSize, String sequence, char letter, int evalSize)
//    {
//        if(groupSize > teamSize || teamSize < 0 || groupSize < 0) return;
//
//        sequence += Character.toString(letter);
//        letter++;
//        showTeams(teamSize-1, groupSize-1, sequence, letter, evalSize); //Left call
//        sequence = sequence.substring(0, sequence.length()-1);
//
//        if(sequence.length() == evalSize) System.out.println(sequence + (char)(letter-1));
//        showTeams(teamSize-1, groupSize, sequence, letter, evalSize); //Right call
//        letter--;
//    }

    static char[] group;


    static void showTeam(String sequence, char start, int groupSIze, int teamSize) {
        if (groupSIze == 0 || teamSize == 0 || teamSize > groupSIze) {
            if (teamSize==0) {
                System.out.println(sequence);
            }
            return;
        }
        showTeam(sequence + start, (char) (start + 1), groupSIze - 1, teamSize - 1);
        showTeam(sequence, (char) (start + 1), groupSIze - 1, teamSize);

    }

    public static void main(String[] args) throws IOException {
//        System.out.println("Enter group size from 0 to 26 :=");
//        int groupSize = getInt();
//        if (groupSize < 1 || groupSize > 26) {
//            System.err.println("group size should be from 0 to 26");
//        }
//        System.out.println("Enter team size=");
//        int teamSize = getInt();
//        if (groupSize <= teamSize) {
//            System.err.println("Group size should be bigger than team size");
//        }
//
//        group = new char[groupSize];
//        System.out.println("Generating group size:=");
//        for (int i = 0; i < groupSize; i++) {
//            group[i] = (char) (i + 97);
//            System.out.println("Group member is + " + group[i]);
//        }
        showTeam("", 'A', 5, 3);

    }
//    static int getInt() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        return Integer.parseInt(input);
//    }
}
