# ParkingLot

shell:>create_parking_lot 4
Created a parking lot with 4 slots
shell:>park KA-01-HH-123 White
Allocated slot number: 1
shell:>park KA-01-HH-124 White
Allocated slot number: 2
shell:>park KA-01-HH-125 Black
Allocated slot number: 3
shell:>park KA-01-HH-127 Black
Allocated slot number: 4
shell:>park KA-01-HH-127 White
Sorry parking lot is full
shell:>leave 1
Slot number 1 is free
shell:>status
[CarDto(slot=2, carNo=KA-01-HH-124, colour=White), CarDto(slot=3, carNo=KA-01-HH-125, colour=Black), CarDto(slot=4, carNo=KA-01-HH-127, colour=Black)]
shell:>park KA-01-HH-1237 White
Allocated slot number: 1
shell:>registrations_numbers_for_car_with_colour Black
[KA-01-HH-125, KA-01-HH-127]
shell:>registrations_numbers_for_car_with_colour White
[KA-01-HH-124, KA-01-HH-1237]
shell:>


I have used java + spring framework to build the same.
I have used singleton design pattern to create a parking lot. As it is not mention in requirement.
