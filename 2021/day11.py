def generateArray(source):
    with open(source, "r") as file:
        lines = file.readlines()
        arr = [[int(x) for x in line.strip()] for line in lines]
        return arr

arr = generateArray("input11.txt")
print(arr)
