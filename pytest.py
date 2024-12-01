def move_hanoi_tower(source, target, auxiliary, n):
    if n == 0:  
        return
    move_hanoi_tower(source, auxiliary, target, n - 1)
    print(f"Move disk {n} from {source} to {target}")
    move_hanoi_tower(auxiliary, target, source, n - 1)

move_hanoi_tower("A", "B", "C", 3)  