class NewComer
  #コンストラクタ
  def initialize(name)
    @name  = name
  end
  
  def say
    puts "My name is " + @name
  
  end
end


a = NewComer.new("Motozono")
a.say