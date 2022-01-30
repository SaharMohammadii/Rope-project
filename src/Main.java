import java.util.ArrayList;
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
                default:
            }
        }
    }
}
