#include <iostream>
using namespace std;

// 하노이탑 알고리즘 함수
int hanoi(int n, char from, char to, char aux) {
    if (n == 1) {
        cout << "Move disk 1 from " << from << " to " << to << endl;
        return 1; // 재귀 호출 카운트
    }
    int steps = 0;
    steps += hanoi(n - 1, from, aux, to); // 원반 n-1개를 보조 기둥(aux)으로 이동
    cout << "Move disk " << n << " from " << from << " to " << to << endl;
    steps += 1;
    steps += hanoi(n - 1, aux, to, from); // 원반 n-1개를 목적 기둥(to)으로 이동
    return steps; // 총 재귀 호출 횟수 반환
}

int main() {
    int n;
    cout << "Enter the number of disks: ";
    cin >> n;

    // 입력값 검증
    if (n <= 0) {
        cout << "The number of disks must be greater than 0." << endl;
        return 1;
    }

    cout << "\nHanoi Tower solution for " << n << " disks:\n" << endl;
    int totalSteps = hanoi(n, 'A', 'C', 'B'); // A: 시작, C: 목적지, B: 보조
    cout << "\nTotal steps: " << totalSteps << endl;

    return 0;
}
