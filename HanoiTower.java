import java.util.function.BiConsumer;

public class HanoiTower {

    public static void main(String[] args) {
        int n = 3; // 원판의 개수
        hanoi(n, "A", "C", "B", (from, to) -> 
            System.out.println("Move disk from " + from + " to " + to));
    }

    /**
     * 하노이 탑 함수
     * @param n 원판의 개수
     * @param from 시작 기둥
     * @param to 목표 기둥
     * @param aux 보조 기둥
     * @param moveAction 디스크 이동 시 실행할 동작
     */
    public static void hanoi(int n, String from, String to, String aux, BiConsumer<String, String> moveAction) {
        if (n == 0) return;

        // Step 1: n-1개의 원판을 보조 기둥으로 이동
        hanoi(n - 1, from, aux, to, moveAction);

        // Step 2: 가장 큰 원판을 목표 기둥으로 이동
        moveAction.accept(from, to);

        // Step 3: 보조 기둥의 n-1개의 원판을 목표 기둥으로 이동
        hanoi(n - 1, aux, to, from, moveAction);
    }
}
