def generateArray(source):
    with open(source, "r") as file:
        lines = file.readlines()
        arr = [line.strip() for line in lines]
        return arr

arr = generateArray("input10.txt")

openings = ["(", "[", "{", "<"]
closings = [")", "]", "}", ">"]
points1  = [3, 57, 1197, 25137]
points2  = [1, 2 , 3, 4] # potentially, we could just use openings.index(parenthesis) + 1



# pt1 - corrupted lines
total1  = 0
totals2 = []
incompleteLines = []
for line in arr:
    stack = []
    isCorruptedLine = False
    for char in line:
        if char in openings:
            stack.append(char)
        else:
            indexClosing = closings.index(char)
            indexOpening= openings.index(stack[-1])
            if indexClosing == indexOpening:
                stack.pop()
            else:
                total1 += points1[indexClosing]
                isCorruptedLine = True
                break
    
    if not isCorruptedLine and len(stack) != 0:
        currentTotal2 = 0
        for parenthesis in list(reversed(stack)):
            currentTotal2 *= 5
            currentTotal2 += points2[openings.index(parenthesis)]
        totals2.append(currentTotal2)

print("#1:", total1)
print("#2:", list(sorted(totals2))[int(len(totals2) / 2)])
