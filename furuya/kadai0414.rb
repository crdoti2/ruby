class Vehicle

def driver 
puts "driver"
end

def carry 
puts "human"
end

end

class Car < Vehicle

def carry 
super
puts "bag"
end

end

class Track < Car

def driver 
puts "unchan"
end

def carry 
super
puts "cargo"
end

end

a= Vehicle.new
a.driver
a.carry

b=Car.new
b.driver
b.carry

c=Track.new
c.driver
c.carry
