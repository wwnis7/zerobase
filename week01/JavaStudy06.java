import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;

public class JavaStudy06 {
    public static void main(String[] args) {
        String[] candidates = {"이재명", "윤석열", "심상정", "안철수"};
        String winner = voteSimulation(candidates);
        System.out.printf("[투표결과] 당선인: %s%n", winner);

    }

    private static String voteSimulation(String[] candidates) {
        int numOfCandidates = candidates.length;
        int[] voteCounts = new int[numOfCandidates];
        Random rnd = new Random();
        int vote;
        int voteCount;

        for (int total = 1; total <= 10_000; total++) {
            vote = rnd.nextInt(4);
            String candid = candidates[vote];
            voteCounts[vote] += 1;
            System.out.printf("\n[투표진행: %05.2f%%, %d명 투표 => %s]%n",  (float) total/10_000 * 100 , total, candid);
            for (int i = 0; i < candidates.length; i++) {
                voteCount = voteCounts[i];
                System.out.printf("[기호:%d] %s: %05.2f%%, (투표수: %d)%n", i+1, candidates[i], (float) voteCount/10_000 * 100, voteCount);
            }

            if (total % 1000 == 0) { // 보기 편하게 속도 조절
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

        HashSet<String> winners = new HashSet<>();
        int maxCount = -1;
        int count;
        for (int i = 0; i < candidates.length; i++) {
            count = voteCounts[i];
            if (count > maxCount) {
                maxCount = count;
                winners = new HashSet<>();
                winners.add(candidates[i]);
            } else if (count == maxCount) {
                winners.add(candidates[i]);
            }
        }

        if (winners.size() == 1) {
            Iterator<String> iter = winners.iterator();
            return iter.next();
        } else {
            if (winners.size() > 1) {
                System.out.println("당선자 동율 -> 5초 뒤에 재투표를 진행합니다.");
            } else { // winners.size() <= 0
                System.out.println("당선자 없음 -> 5초 뒤에 재투표를 진행합니다.");
            }
            try {
                Thread.sleep(5000);
                System.out.println("\n재투표를 시작합니다.");
                return voteSimulation(candidates);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
