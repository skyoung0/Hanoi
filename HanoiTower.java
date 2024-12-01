import java.util.ArrayList;
import java.util.List;

public class HanoiTower {

    // 이동 기록 저장 리스트
    private final List<String> moves;

    public HanoiTower() {
        this.moves = new ArrayList<>();
    }

    public static void main(String[] args) {
        int numDisks = 3; // 원판의 개수
        HanoiTower hanoi = new HanoiTower();

        hanoi.solve(numDisks, "A", "C", "B");
        hanoi.printMoves();
    }

    /**
     * 하노이 탑 문제를 해결합니다.
     * @param n 원판의 개수
     * @param from 시작 기둥
     * @param to 목표 기둥
     * @param aux 보조 기둥
     */
    public void solve(int n, String from, String to, String aux) {
        if (n == 0) {
            return;
        }

        // Step 1: n-1개의 원판을 보조 기둥으로 이동
        solve(n - 1, from, aux, to);

        // Step 2: 가장 큰 원판을 목표 기둥으로 이동
        recordMove(from, to);

        // Step 3: 보조 기둥의 n-1개의 원판을 목표 기둥으로 이동
        solve(n - 1, aux, to, from);
    }

    /**
     * 디스크 이동 기록 저장
     * @param from 시작 기둥
     * @param to 목표 기둥
     */
    private void recordMove(String from, String to) {
        moves.add("Move disk from " + from + " to " + to);
    }

    /**
     * 모든 이동 기록을 출력합니다.
     */
    public void printMoves() {
        System.out.println("Hanoi Tower Solution:");
        for (String move : moves) {
            System.out.println(move);
        }
    }
}
