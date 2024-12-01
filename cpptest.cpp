#include <iostream>

// 하노이탑 알고리즘 함수
void hanoi(int n, char from, char to, char aux) {
    if (n == 1) {
        std::cout << "Move disk 1 from " << from << " to " << to << std::endl;
        return;
    }
    hanoi(n - 1, from, aux, to); // 원반 n-1개를 보조 기둥(aux)으로 이동
    std::cout << "Move disk " << n << " from " << from << " to " << to << std::endl;
    hanoi(n - 1, aux, to, from); // 원반 n-1개를 목적 기둥(to)으로 이동
}

int main() {
    int n = 3; // 원반 개수
    std::cout << "Hanoi Tower solution for " << n << " disks:" << std::endl;
    hanoi(n, 'A', 'C', 'B'); // A: 시작 기둥, C: 목적지 기둥, B: 보조 기둥
    return 0;
}
