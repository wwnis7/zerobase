import java.time.LocalDate;
import java.util.Scanner;

public class JavaStudy05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[달력 출력 프로그램]");
        System.out.print("달력의 년도를 입력해주세요.(yyyy):");
        int year = sc.nextInt();
        System.out.print("달력의 월을 입력해주세요.(mm):");
        int month = sc.nextInt();

        LocalDate date = LocalDate.of(year, month, 1);

        int firstDayOfWeek = date.getDayOfWeek().getValue() % 7;
        int dayOfWeek = 0;
        int lastDay = date.lengthOfMonth();

        System.out.println();
        String title = String.format("[%04d년 %02d월]", year, month);
        System.out.println(title);
        System.out.println("일\t월\t화\t수\t목\t금\t토");
        int day = 1;
        while (day <= lastDay) {
            if (dayOfWeek < firstDayOfWeek) {
                System.out.print("");
            } else {
                System.out.printf("%02d", day);
                day += 1;
            }
            dayOfWeek += 1;
            if (dayOfWeek % 7 == 0) {
                System.out.print("\n");
            } else {
                System.out.print("\t");
            }
        }

    }
}
