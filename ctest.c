#include <stdio.h>

// 하노이탑 알고리즘 함수
int hanoi(int n, char from, char to, char aux) {
    if (n == 1) {
        printf("Move disk 1 from %c to %c\n", from, to);
        return 1; // 재귀 호출 카운트
    }
    int steps = 0;
    steps += hanoi(n - 1, from, aux, to); // 원반 n-1개를 보조 기둥(aux)으로 이동
    printf("Move disk %d from %c to %c\n", n, from, to); // 가장 큰 원반 이동
    steps += 1;
    steps += hanoi(n - 1, aux, to, from); // 원반 n-1개를 목적 기둥(to)으로 이동
    return steps; // 총 재귀 호출 횟수 반환
}

int main() {
    int n;
    printf("Enter the number of disks: ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Number of disks must be greater than 0.\n");
        return 1;
    }

    printf("\nHanoi Tower solution for %d disks:\n", n);
    int totalSteps = hanoi(n, 'A', 'C', 'B'); // A: 시작, C: 목적지, B: 보조
    printf("\nTotal steps: %d\n", totalSteps);
    return 0;
}
