import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Rope> AllRopes = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            String[] splited = line.split(" ", 3);

            switch (splited[1]) {
                case "new":
                    Rope rope = new Rope(splited[2]);
                    AllRopes.add(rope);
                    break;
                case "status":
                    int count = 1;
                    for (Rope tempRope : AllRopes) {
                        System.out.print((count++) + ". ");
                        tempRope.printRope(tempRope.headNode);
                        System.out.println();
                    }
                    break;
                case "concat":
                    Rope s1 = null;
                    Rope s2 = null;
                    int firstIndex=splited[2].charAt(0)-49;
                    int secondIndex=splited[2].charAt(2)-49;
                    if (AllRopes.size()>=secondIndex) {
                        for (int i = 0; i < AllRopes.size(); i++) {
                            if (i == firstIndex) {
                                s1 = AllRopes.get(i);
                            }
                            if (i == secondIndex) {
                                s2 = AllRopes.get(i);
                            }
                        }
                        AllRopes.remove(firstIndex);
                        AllRopes.add(firstIndex, Rope.concat(s1, s2));
                        AllRopes.remove(secondIndex);
                    }
            }
        }
    }
}
