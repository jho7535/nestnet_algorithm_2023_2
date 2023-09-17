board = input()

board_A = board.replace('XXXX', 'AAAA')
board_AB = board_A.replace('XX', 'BB')

if 'X' in board_AB:
    print(-1)
else:
    print(board_AB)
