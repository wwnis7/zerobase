import java.util.Scanner;

public class JavaStudy02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("[캐시백 계산]");
        System.out.print("결제 금액을 입력해 주세요.(금액):");
        int cash = sc.nextInt();
        int reducedValue = (int) ((cash * 0.1) / 100);
        int cashBack = (int) Math.min(reducedValue * 100, 300);
        System.out.print(String.format("결제 금액은 %d원이고, 캐시백은 %d원 입니다.", cash, cashBack));
    }
}
