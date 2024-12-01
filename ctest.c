#include <stdio.h>

// 하노이탑 알고리즘 함수
void hanoi(int n, char from, char to, char aux) {
    if (n == 1) {
        printf("Move disk 1 from %c to %c\n", from, to);
        return;
    }
    hanoi(n - 1, from, aux, to);            // 원반 n-1개를 보조 기둥(aux)으로 이동
    printf("Move disk %d from %c to %c\n", n, from, to); // 가장 큰 원반 이동
    hanoi(n - 1, aux, to, from);            // 원반 n-1개를 목적 기둥(to)으로 이동
}

int main() {
    int n = 3; // 원반 개수
    printf("Hanoi Tower solution for %d disks:\n", n);
    hanoi(n, 'A', 'C', 'B'); // A: 시작, C: 목적지, B: 보조
    return 0;
}
