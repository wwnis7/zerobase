import java.util.Scanner;

public class JavaStudy08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[과세금액 계산 프로그램]");
        System.out.print("연소득을 입력해 주세요.:");
        int income = sc.nextInt();
        int[] taxBase = {12_000_000, 46_000_000, 88_000_000, 150_000_000, 300_000_000, 500_000_000, 1_000_000_000};
        int[] tariff = {6, 15, 24, 35, 38, 40, 42, 45};
        int[] progressiveDeduction = {0, 1_080_000, 5_220_000, 14_900_000, 19_400_000, 25_400_000, 35_400_000, 65_400_000};
        int lower = 0;
        int upper = taxBase[0];
        int tar = tariff[0];
        int progDedct = progressiveDeduction[0];
        int totalByTariff = 0;
        int totalByProgDedct;
        System.out.println();
        for (int i = 0; i < taxBase.length; i++) {
            if (income > upper) {
                System.out.printf("%10d * %2d%% = %10d%n", (upper-lower), tar, ((upper-lower) / 100 * tar));
                totalByTariff += (upper-lower) / 100 * tar;
            } else {
                System.out.printf("%10d * %2d%% = %10d%n", (income-lower), tar, ((income-lower) / 100 * tar));
                totalByTariff += (income-lower) / 100 * tar;
                break;
            }
            lower = upper;
            upper = taxBase[i + 1];
            tar = tariff[i + 1];
            progDedct = progressiveDeduction[i + 1];
        }
        System.out.println();
        System.out.printf("[세율에 의한 세금]:        %10d%n", totalByTariff);

        totalByProgDedct = income / 100 * tar  - progDedct;
        System.out.printf("[누진공제 계산에 의한 세금]: %10d%n", totalByProgDedct);
    }
}
