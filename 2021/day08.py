def getCurrentAlphabet(strDigits):    
    currAlphabet = [0 for x in range(10)]
    sortedDigits = sorted(strDigits.split(" "), key=len)
    currAlphabet[1] = set(sortedDigits[0])
    currAlphabet[7] = set(sortedDigits[1])
    currAlphabet[4] = set(sortedDigits[2])
    currAlphabet[8] = set(sortedDigits[9])
    fiveSegments = [x for x in strDigits.split(" ") if len(x) == 5]
    sixSegments  = [x for x in strDigits.split(" ") if len(x) == 6]
    
    # I already know 1, 7, 4, 8
    # Code to get the number 3
    for segment in fiveSegments:
        if len(currAlphabet[7].intersection(set(segment))) == 3:
            currAlphabet[3] = set(segment)
            fiveSegments.remove(segment)
            break

    # I get lines in the middle of the 7-segment-display
    centralLines = (currAlphabet[7].difference(currAlphabet[1])).union(currAlphabet[3].difference(currAlphabet[7]))

    # Code to get the number 0
    for segment in sixSegments:
        if len(centralLines.intersection(set(segment))) != 3:
            currAlphabet[0] = set(segment)
            sixSegments.remove(segment)
            break
    
    # Code to get the number 9 
    for segment in sixSegments:
        if len(currAlphabet[1].intersection(set(segment))) == 2:
            currAlphabet[9] = set(segment)
            sixSegments.remove(segment)
            break

    # Code to get the number 6
    currAlphabet[6] = set(sixSegments[0])

    # I get the segment that can help discriminate between 5 and 2
    onlyFiveHasIt = currAlphabet[9].difference(currAlphabet[3])
    
    # Code to get the number 6
    for segment in fiveSegments:
        # print(segment, onlyFiveHasIt < set(segment))
        if onlyFiveHasIt < set(segment):
            currAlphabet[5] = set(segment)
            fiveSegments.remove(segment)
            break
    
    # I get the number 2
    currAlphabet[2] = set(fiveSegments[0])
    
    return currAlphabet
 
def generateArray(source):
    with open(source, "r") as file:
        lines = file.readlines()
        arr = [[x.strip() for x in line.split(" | ")] for line in lines]
        return arr

arr = generateArray("input08.txt")

# pt 1
count = 0
for _, entry in arr:
    for value in entry.split(" "):
        if len(value) == 2 or len(value) == 3 or len(value) == 4 or len(value) == 7:
            count += 1 
print("#1:", count)

# pt 2
total = 0
for strDigits, strNumb in arr:
    alphabet = getCurrentAlphabet(strDigits)
    # all of this is just because i need to map from a list of set
    # to the index of the list itself
    outStr = ""
    for digit in strNumb.split(" "):
        trimmed = digit.strip()
        for index, val in enumerate(alphabet):
            if val == set(trimmed):
                outStr += str(index)
    total += int(outStr)
print("#2:", total)