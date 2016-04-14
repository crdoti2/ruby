class NewComer

#コンストラクタ
def initialize(name)
@name  = name
end

def say
puts "My name is " + @name
end

end

class Furuya < NewComer

def say
super
puts "watashi ha #@name desu"
end

def self.say2
puts "****"
 end

end

furu=Furuya.new("Furuya")
furu.say
Furuya.say2