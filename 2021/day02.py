with open("input02.txt") as file:
    lines = file.readlines()
    
    # pt 1
    depth = 0
    horPos = 0
    for line in lines:
        direction, value = line.split(" ")
        if direction == "forward":
            horPos += int(value)
        elif direction == "down":
            depth += int(value)
        elif direction == "up":
            depth -= int(value)
    print(depth * horPos)

    # pt 2
    depth = 0
    horPos = 0
    aim = 0
    for line in lines:
        direction, value = line.split(" ")
        if direction == "forward":
            horPos += int(value)
            depth += (aim * int(value))
        elif direction == "down":
            aim += int(value)
        elif direction == "up":
            aim -= int(value)
    print(depth * horPos)
