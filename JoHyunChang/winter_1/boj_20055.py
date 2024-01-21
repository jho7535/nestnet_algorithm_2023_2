# 로봇이 있는 것을 나타내는 is_robot bool 배열 (True = 로봇있음, False = 로봇 없음)
# 내구도를 나타내는 durability int 배열
# 시뮬레이션으로 구현
# https://www.acmicpc.net/board/view/67581
# 문제 애매모호한 부분이 있을 경우 참고할 것
import sys
from collections import deque


def rotate(is_robot: deque, durability: deque):
    down_seat = int(len(durability) / 2) - 1
    is_robot[down_seat] = False
    durability.appendleft(durability.pop())
    is_robot.appendleft(is_robot.pop())
    is_robot[down_seat] = False


def main():
    n, life_cnt = map(int, sys.stdin.readline().split())
    durability = deque(map(int, sys.stdin.readline().split()))
    is_robot = deque([False for i in range(len(durability))])
    down_seat = int(len(durability) / 2) - 1
    cnt = 0
    turn = 1
    while cnt < life_cnt:
        rotate(is_robot, durability)
        for i in range(down_seat - 1, -1, -1):
            if not is_robot[i] or is_robot[i + 1] or durability[i + 1] == 0:
                continue
            durability[i + 1] -= 1
            is_robot[i + 1] = True
            if durability[i + 1] == 0:
                cnt += 1
                if cnt >= life_cnt:
                    return turn
            is_robot[i] = False
            is_robot[down_seat] = False
        if not is_robot[0] and not durability[0] == 0:
            is_robot[0] = True
            durability[0] -= 1
            if durability[0] == 0:
                cnt += 1
                if cnt >= life_cnt:
                    return turn
        turn += 1
    return turn


if __name__ == "__main__":
    print(main())
