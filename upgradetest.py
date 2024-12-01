def move_hanoi_tower(source, target, auxiliary, n):
    if n == 1:
        # 기저 사례: 한 개의 디스크만 이동
        return [(source, target)]
    else:
        # 하위 문제 해결: 재귀적으로 디스크 이동 경로 계산
        return (move_hanoi_tower(source, auxiliary, target, n - 1) +
                [(source, target)] +
                move_hanoi_tower(auxiliary, target, source, n - 1))

def solve_hanoi():
    # 3개의 원판이 A에서 C로 이동하도록 시뮬레이션
    moves = move_hanoi_tower("A", "C", "B", 3)
    for move in moves:
        print(f"Move disk from {move[0]} to {move[1]}")

solve_hanoi()
