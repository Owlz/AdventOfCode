def generateInput(source):
    with open(source, "r") as file:
        lines = file.readlines()
        parsingFolds = False
        folds = []
        points = []
        for line in lines:
            if line == "\n":
                parsingFolds = True
                continue
            if parsingFolds:
                _, _, fold = line.split(" ")
                axis, value = map(lambda x: x.strip(), fold.split("="))
                folds.append((axis, int(value)))
            else:
                x, y = line.split(",")
                points.append((int(x), int(y)))
        return points, folds

points, folds = generateInput("input13.txt")

pointsAfterOneFold = 0
setOfPoints = set(points)
toBePrinted = []

for index, (axis, value) in enumerate(folds):
    newSetOfPoints = set()
    for x, y in setOfPoints:
        newX = x
        newY = y
        if axis == "y":
            if y > value:
                newY = (value*2) - y
        else:
            if x > value:
                newX = (value*2) - x
        newSetOfPoints.add((newX, newY))
    if index == 0:
        pointsAfterOneFold = len(newSetOfPoints)
    setOfPoints = newSetOfPoints
    
    toBePrinted = [["8" if (i, j) in newSetOfPoints else " " for i in range(60)] for j in range(6)]
    
print("#1", pointsAfterOneFold)
print("#2", )

for row, line in enumerate(toBePrinted):
    for col, value in enumerate(line):
        print(value, end="")
    print()