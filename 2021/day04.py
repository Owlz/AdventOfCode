import re as re

class Board:
    def __init__(self):
        self.rows = []
        self.columns = []

    def addRow(self, row):
        self.rows.append(row)
    
    def buildColumns(self):
        self.columns = [list(i) for i in zip(*self.rows)]


flattenArray = lambda xs: [y for ys in xs for y in ys]

with open("input04.txt") as file:
    lines = file.readlines()
    drawns = [int(x) for x in lines[0].strip().split(",")]
    boards = []
    obj = Board()
    pattern = re.compile(" +")
    
    for line in lines[2:]:
        if line == "\n":
            obj.buildColumns()
            boards.append(obj)
            obj = Board()
            continue

        row = [int(x) for x in pattern.split(line.strip())]
        obj.addRow(row)

    for draw in drawns:
        for board in list(boards):
            board.rows = [list(filter(lambda num: num != draw, row)) for row in board.rows]
            board.columns = [list(filter(lambda num: num != draw, column)) for column in board.columns]

            if any(map(lambda el: len(el) == 0, board.rows)) or any(map(lambda el: len(el) == 0, board.columns)):
                print(sum(flattenArray(board.rows)) * draw)
                boards.remove(board)
