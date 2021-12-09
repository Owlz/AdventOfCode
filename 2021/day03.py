with open("input03.txt") as file:
    lines = file.readlines()
    
    # pt 1
    ones = [0 for x in range(len(lines[0]) - 1)]
    for line in lines:
        for index, char in enumerate(line):
            if char == "1":
                ones[index] = ones[index] + 1
    
    gamma = []
    epsilon = []
    for elem in ones:
        if elem > (len(lines) / 2):
            gamma.append("1")
            epsilon.append("0")
        else:
            gamma.append("0")
            epsilon.append("1")

    intGamma = int("".join(gamma), 2)
    intEpsilon = int("".join(epsilon), 2)
    print(intGamma * intEpsilon)

    # pt 2

    def countOnes(arr, position, mostCommon=True):
        ones = 0
        for line in arr:
            if line[position] == "1":
                    ones += 1
        if mostCommon:
            if ones >= len(arr) / 2:
                return 1
            else:
                return 0
        else:
            if ones >= len(arr) / 2:
                return 0
            else:
                return 1

    filtered = lines[:]
    prefix = ""
    position = 0
    while len(filtered) > 1:
        prefix += str(countOnes(filtered, position))
        filtered = list(filter(lambda value: value.startswith(prefix), filtered))
        position += 1
    oxy = int(filtered[0], 2)

    filtered = lines[:]
    prefix = ""
    position = 0
    while len(filtered) > 1:
        prefix += str(countOnes(filtered, position, False))
        filtered = list(filter(lambda value: value.startswith(prefix), filtered))
        position += 1
    co2 = int(filtered[0], 2)

    print(oxy * co2)
