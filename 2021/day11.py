def generateArray(source):
    with open(source, "r") as file:
        lines = file.readlines()
        arr = [[int(x) for x in line.strip()] for line in lines]
        return arr

arr = generateArray("input11.txt")

def plusOne(arr, rowNum, colNum):
    if (rowNum, colNum) in exploded:
        return
    else:
        arr[rowNum][colNum] += 1
        if arr[rowNum][colNum] > 9:
            global flashes
            flashes += 1
            exploded.add((rowNum, colNum))
            arr[rowNum][colNum] = 0
            around = [(rowNum + i, colNum + j) for j in range(-1, 1 + 1) for i in range(-1, 1 + 1) if (i, j) != (0,0)]
            for i, j in around:
                if i < 0 or j < 0 or i >= len(arr) or j >= len(arr[i]):
                    continue
                plusOne(arr, i, j)

exploded = set()
step = 0
allFlashed = None
flashesAt100 = 0
flashes = 0

while allFlashed is None:
    step += 1
    exploded = set()
    for rowNum, row in enumerate(arr):
        for colNum, value in enumerate(row):
            plusOne(arr, rowNum, colNum)
    if step == 100:
        flashesAt100 = flashes
    if len(exploded) == len(arr) * len(arr[0]):
        allFlashed = step

print("#1:", flashesAt100)
print("#2:", allFlashed)