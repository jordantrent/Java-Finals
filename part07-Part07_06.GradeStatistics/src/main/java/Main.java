import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter point totals, -1 stops: ");
        Points points = new Points();
        while (true) {
            int input = Integer.valueOf(scanner.nextLine());
            if (input == -1) {
                break;
            }
            if (input < 0 || input > 100) {
                continue;
            }
            points.add(input);
        }
        System.out.println(points.pointAvg());
        System.out.println(points.pointAvgPass());
        System.out.println(points.passPercentage());
        System.out.println(points.gradeDist());
    }
}
