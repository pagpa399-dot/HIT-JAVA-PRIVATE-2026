import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Thongkediem {
    static final List<Double> scores = new ArrayList<>();
    static void addScore(double score){
        scores.add(score);
    }
    static void printScores(){
        if(scores.isEmpty()){
            System.out.println("Danh sach trong!");
            return;
        }
        for(int i = 0; i< scores.size(); i++){
            System.out.println((i + 1) + "Diem: " + scores.get(i));
        }
    }
    static double calculateAverage(){
        double t = 0;
        for(int i = 0; i < scores.size(); i++){
            t += scores.get(i);
        }
        return t / scores.size();
    }
    static int countPassed(){
        int count = 0;
        for(int i = 0; i < scores.size(); i++){
            if(scores.get(i) >= 5){
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        for(int i = 0; i <= 5; i++) {
            System.out.print("Nhap diem thu " + i + " ");
            double score = sc.nextDouble();
            if (score < 0 || score > 10) {
                System.out.println("Diem khong hop le!");
                continue;
            }
            addScore(score);
        }

        System.out.println("Danh sach diem: ");
        printScores();
        System.out.println("Diem trung binh: " + calculateAverage());
        System.out.println("So diem dat: " + countPassed() );
    }
}
