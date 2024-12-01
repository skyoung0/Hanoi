using System;

class HanoiTower
{
    static void Main(string[] args)
    {
        int n = 3; // 원판의 개수
        Hanoi(n, "A", "C", "B", (from, to) => 
            Console.WriteLine($"Move disk from {from} to {to}"));
    }

    /// <summary>
    /// 하노이 탑 함수
    /// </summary>
    /// <param name="n">원판의 개수</param>
    /// <param name="from">시작 기둥</param>
    /// <param name="to">목표 기둥</param>
    /// <param name="aux">보조 기둥</param>
    /// <param name="moveAction">디스크 이동 시 실행할 동작</param>
    static void Hanoi(int n, string from, string to, string aux, Action<string, string> moveAction)
    {
        if (n == 0) return;

        // Step 1: n-1개의 원판을 보조 기둥으로 이동
        Hanoi(n - 1, from, aux, to, moveAction);

        // Step 2: 가장 큰 원판을 목표 기둥으로 이동
        moveAction(from, to);

        // Step 3: 보조 기둥의 n-1개의 원판을 목표 기둥으로 이동
        Hanoi(n - 1, aux, to, from, moveAction);
    }
}
