import java.util.*;

public class HanoiTower {

    private final List<String> moves;
    private final Map<String, Stack<Integer>> towers;

    public HanoiTower() {
        this.moves = new ArrayList<>();
        this.towers = new HashMap<>();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the number of disks:");
        int numDisks;
        while (true) {
            try {
                numDisks = Integer.parseInt(scanner.nextLine());
                if (numDisks <= 0) {
                    System.out.println("Please enter a positive integer:");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer:");
            }
        }

        System.out.println("Enter the names of the three towers (e.g., A B C):");
        String[] towerNames = scanner.nextLine().split(" ");
        if (towerNames.length != 3) {
            System.out.println("Invalid input. Default names (A, B, C) will be used.");
            towerNames = new String[]{"A", "B", "C"};
        }

        HanoiTower hanoi = new HanoiTower();
        hanoi.initialize(numDisks, towerNames[0], towerNames[1], towerNames[2]);
        hanoi.solve(numDisks, towerNames[0], towerNames[1], towerNames[2]);
        hanoi.printMoves();
        hanoi.printTowerStates();
    }

    /**
     * 하노이 탑 초기화
     */
    public void initialize(int numDisks, String from, String aux, String to) {
        towers.put(from, new Stack<>());
        towers.put(aux, new Stack<>());
        towers.put(to, new Stack<>());

        for (int i = numDisks; i >= 1; i--) {
            towers.get(from).push(i);
        }
    }

    /**
     * 하노이 탑 문제를 해결합니다.
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
     * 디스크 이동 기록 및 기둥 상태 업데이트
     */
    private void recordMove(String from, String to) {
        if (towers.containsKey(from) && towers.containsKey(to)) {
            int disk = towers.get(from).pop();
            towers.get(to).push(disk);
            moves.add("Move disk " + disk + " from " + from + " to " + to);
        }
    }

    /**
     * 이동 기록을 출력합니다.
     */
    public void printMoves() {
        System.out.println("Hanoi Tower Solution:");
        for (String move : moves) {
            System.out.println(move);
        }
    }

    /**
     * 최종 기둥 상태를 출력합니다.
     */
    public void printTowerStates() {
        System.out.println("\nFinal Tower States:");
        for (Map.Entry<String, Stack<Integer>> entry : towers.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
