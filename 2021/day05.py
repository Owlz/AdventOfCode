import re as re
from collections import namedtuple
import pprint
pp = pprint.PrettyPrinter(width=41, compact=True)

flattenArray = lambda xs: [y for ys in xs for y in ys]
Point = namedtuple('Point', ['x', 'y'])

def getMiddlePointsHorVer(lefty, righty, fixedVal, isXfixed=True):
    maxy = max(lefty, righty)
    miny = min(lefty, righty)
    newPoints = []

    for val in range(miny, maxy):
        if isXfixed:
            newPoints.append(Point(x=fixedVal, y=val))
        else:
            newPoints.append(Point(x=val, y=fixedVal))
    return set(newPoints)

def getMiddlePointsDiag(start, end):
    newPoints = set()
    for (x, y) in zip(range(start.x, end.x, -1 if start.x > end.x else 1), range(start.y, end.y, -1 if start.y > end.y else 1)):
        newPoints.add(Point(x, y))

    newPoints.add(start)
    newPoints.add(end)
    
    return newPoints

def parseLine(leftStr, rightStr, diagonalLines=False):
    x1, y1 = leftStr.strip().split(",")
    x2, y2 = rightStr.strip().split(",")
    start = Point(int(x1),int(y1))
    end = Point(int(x2),int(y2))
    
    middlePoints = set()
    middlePoints.add(start)
    middlePoints.add(end)
    if start.x == end.x: # horizontal line
        middlePoints.update(getMiddlePointsHorVer(start.y, end.y, start.x, isXfixed=True))    
    elif start.y == end.y: # vertical line
        middlePoints.update(getMiddlePointsHorVer(start.x, end.x, start.y, isXfixed=False))
    elif diagonalLines:
        middlePoints.update(getMiddlePointsDiag(start, end))
    else:
        return []
    return middlePoints

def countBoard(board):
    count = 0
    for lines in board:
        for elem in lines:
            if elem > 1:
                count += 1
    return count

with open("input05.txt") as file:
    lines = file.readlines()
    
    #pt 1
    board1 = [[0 for x in range(1000)] for y in range(1000)]
    
    for line in lines:
        newPoints = parseLine(*line.strip().split(" -> "))

        for point in list(newPoints):
                board1[point.x][point.y] += 1

    print(countBoard(board1))
      
    board2 = [[0 for x in range(1000)] for y in range(1000)]
    
    for line in lines:
        newPoints = parseLine(*line.strip().split(" -> "), True)

        for point in list(newPoints):
                board2[point.x][point.y] += 1

    print(countBoard(board2))
