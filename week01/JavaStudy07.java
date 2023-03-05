import java.util.*;

public class JavaStudy07 {
    public static void main(String[] args) {
        Random rnd = new Random();
        System.out.println("[로또 당첨 프로그램]");
        Scanner sc = new Scanner(System.in);
        System.out.print("로또 개수를 입력해 주세요.(숫자 1 ~ 10):");
        int count = sc.nextInt();
        String result;

        String id;
        HashMap<String, Set> idToNumbers = new HashMap<>();
        for (int i = 1; i <= count; i++) {
            id = String.valueOf((char) (i + 64));

            Set<Integer> numbers = new HashSet<>();
            while (numbers.size() < 6) {
                numbers.add(rnd.nextInt(45) + 1);
            }
            result = showNumbers(numbers);
            System.out.println(id + "\t" + result);
            idToNumbers.put(id, numbers);
        }

        System.out.println("\n[로또 발표]");
        Set<Integer> winNumbers = new HashSet<>();
        while (winNumbers.size() < 6) {
            winNumbers.add(rnd.nextInt(45) + 1);
        }
        result = showNumbers(winNumbers);
        System.out.println("\t" + result);

        System.out.println("\n[내 로또 결과]");

        for (int i = 1; i <= count; i++) {
            id = String.valueOf((char) (i + 64));

            Set<Integer> numbers = idToNumbers.get(id);
            result = showNumbers(numbers);
            Set<Integer> intersection = new HashSet<>(numbers);
            intersection.retainAll(winNumbers);

            System.out.println(id + "\t" + result + String.format(" => %d개 일치", intersection.size()));
        }

    }

    private static String showNumbers(Set numbers) {
        ArrayList numbersList = new ArrayList(numbers);
        Collections.sort(numbersList);
        String result = "";
        for (int i = 0; i < numbersList.size(); i++) {
            Object number = numbersList.get(i);
            if (i == 0) {
                result = result + String.format("%02d", number);
            } else {
                result = result + ", " + String.format("%02d", number);
            }

        }
        return result;

    }
}
