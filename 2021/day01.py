with open("input1_1.txt") as file:
    lines = file.readlines()
    
    # pt 1
    count = 0
    oldLine = "9999999"
    for index, line in enumerate(lines):
        if int(oldLine) < int(line):
            count += 1
        oldLine = line
    
    # pt 2
    i = 0
    sumLines = []
    count = 0
    oldLine = 9999999
    while(len(lines) > i + 2):
        sumLines.append(int(lines[i]) + int(lines[i + 1]) + int(lines[i + 2]))
        i += 1
    
    for index, line in enumerate(sumLines):
        if oldLine < line:
            count += 1
        oldLine = line
    
    print(count)


