import java.util.Scanner;

public class JavaStudy03 {
    public static void main(String[] args) {
        int free = 0;
        int basic = 10000;
        int specialDiscount = 4000;
        int Discount = 8000;
        int fee;
        
        Scanner sc = new Scanner(System.in);
        System.out.println("[입장권 계산]");
        System.out.print("나이를 입력해주세요.(숫자):");
        int age = sc.nextInt();
        System.out.print("입장시간을 입력해주세요.(숫자입력):");
        int time = sc.nextInt();
        System.out.print("국가유공자 여부를 입력해주세요.(y/n):");
        String nationalMerit = sc.next();
        System.out.print("복지카드 여부를 입력해주세요.(y/n):");
        String welfareCard = sc.next();

        if ( age < 3 ) {
            fee = free;
        } else if ( age < 13 || time > 17 ) {
            fee = specialDiscount;
        } else if ( nationalMerit.equals("y") || welfareCard.equals("y") ) {
            fee = Discount;
        } else {
            fee = basic;
        }

        System.out.print(String.format("입장료: %d", fee));
    }
}
