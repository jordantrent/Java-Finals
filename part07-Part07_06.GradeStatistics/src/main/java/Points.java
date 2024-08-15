import java.util.ArrayList;

public class Points {
    public ArrayList<Integer> points;
    public int grade;

    public Points() {
        this.points = new ArrayList<>();
    }

    public void add(int score) {
        points.add(score);
    }

    public String pointAvg() {
        double avg = 0.0;
        int sum = 0;
        for (int i = 0; i < points.size(); i++) {
            sum = sum + points.get(i);
            avg = sum / points.size();
        }
        return "Point average (all): " + avg;
    }

    public int totalPass() {
        int totalPass = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) >= 50) {
                totalPass = totalPass + 1;
            }
        }
        return totalPass;
    }

    public String pointAvgPass() {
        double avg = 0.0;
        int sum = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) >= 50) {
                sum = sum + points.get(i);
            }
        }
        if (sum == 0) {
            return "Point average (passing): -";
        }
        avg = sum / totalPass();
        return "Point average (passing): " + avg;
    }

    public String passPercentage() {
        double passPercentage = 100.0 * totalPass() / points.size();
        return "Pass percentage: " + passPercentage;

    }

    public String printStars(int number) {
        String str = "";
        for (int i = 0; i < number; i++) {
            str += "*";
        }
        return str;
    }

    public String gradeDist() {
        int grade0 = 0;
        int grade1 = 0;
        int grade2 = 0;
        int grade3 = 0;
        int grade4 = 0;
        int grade5 = 0;
        for (int i = 0; i < points.size(); i++) {
            if (points.get(i) < 50) {
                grade0 = grade0 + 1;
                continue;
            }
            if (points.get(i) < 60) {
                grade1 = grade1 + 1;
                continue;
            }
            if (points.get(i) < 70) {
                grade2 = grade2 + 1;
                continue;
            }
            if (points.get(i) < 80) {
                grade3 = grade3 + 1;
                continue;
            }
            if (points.get(i) < 90) {
                grade4 = grade4 + 1;
                continue;
            }
            if (points.get(i) >= 90) {
                grade5 = grade5 + 1;
                continue;
            }
        }
        return "5: " + printStars(grade5) + "\n" + "4: " + printStars(grade4) + "\n" + "3: " + printStars(grade3) + "\n"
                + "2: " + printStars(
                        grade2)
                + "\n"
                + "1: " + printStars(grade1) + "\n" + "0: " + printStars(grade0) + "\n";

    }
}