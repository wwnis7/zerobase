import java.util.Random;
import java.util.Scanner;

public class JavaStudy04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[주민등록번호 계산]");
        System.out.print("출생년도를 입력해주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("출생월을 입력해주세요.(mm):");
        int month = sc.nextInt();
        System.out.print("출생일을 입력해주세요.(dd):");
        int day = sc.nextInt();
        System.out.print("성별를 입력해주세요.(m/f):");
        String sex = sc.next();
        int sexValue = 0;
        if (year >= 2000) {
            sexValue += 2;
        }

        if (sex.equals("m")) {
            sexValue += 1;
        } else if (sex.equals("f")) {
            sexValue += 2;
        }



        String first = String.format("%02d%02d%02d", year % 100, month, day);
        Random rnd = new Random();
        int last = rnd.nextInt((int) 1e6);
        String second = String.format("%d%06d", sexValue, last);

        System.out.print(first + "-" + second);
    }
}
