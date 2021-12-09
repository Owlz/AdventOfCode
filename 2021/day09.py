def generateArray(source):
    with open(source, "r") as file:
        lines = file.readlines()
        arr = [[int(x) for x in line.strip()] for line in lines]
        return arr

arr = generateArray("input09.txt")

# border check
def get(arr, r, c):
    if 0 <= r < len(arr) and 0 <= c < len(arr[r]):
        return arr[r][c]
    else:
        return 9999

# pt 1
total = 0
lowPoints = []
for rowNum, row in enumerate(arr):
    for colNum, value in enumerate(row):
        if (value < get(arr, rowNum, colNum + 1)
        and value < get(arr, rowNum, colNum - 1)
        and value < get(arr, rowNum + 1, colNum)
        and value < get(arr, rowNum - 1, colNum)):
            lowPoints.append((rowNum, colNum))
            total += (value + 1)

print("#1:", total)

# pt 2
basinList = []
def dfs(point, visited):
    row, col = point
    if row < 0 or col < 0 or row >= len(arr) or col >= len(arr[0]):
        return    
    if arr[row][col] != 9 and point not in visited:
        visited.add(point)
        
        neighbours = []
        neighbours.append((row, col + 1))
        neighbours.append((row, col - 1))
        neighbours.append((row + 1, col))
        neighbours.append((row - 1, col))
        for neighbour in neighbours:
            dfs(neighbour, visited)

for row, col in lowPoints:
    visited = set()
    dfs((row, col), visited)
    visited.add((row, col))
    basinList.append(visited)

# take the 3 biggest basins
sizes = list(reversed(sorted([len(x) for x in basinList])))
total = 1
for el in range(3):
    total = total * sizes[el]

print("#2:", total)