def iterOver(arr, days):
    for day in range(days):
        temp = arr[0]
        arr.append(arr.pop(0))
        arr[6] += temp
        arr[8] = temp
    return sum(arr) 

def generateArray(source):
    with open(source, "r") as file:
        lines = file.readlines()

        fishByDays = [0 for x in range(9)]
        for status in lines[0].strip().split(","):
            fishByDays[int(status)] += 1
        return fishByDays

print("#1:", iterOver(generateArray("input06.txt"), 80))
print("#2:", iterOver(generateArray("input06.txt"), 256))