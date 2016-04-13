a=Dir.glob('C:/Users/R-N-010/Documents/ruby/furuya/sample/*.java')

p'123456789'.rjust(10)

c=0

a.each { |x|

File.open(x) do |file|
file.each_line do |y|
c=c+y.count("	")
    end
  end

puts File.basename(x).ljust(35) + c.to_s.rjust(10) 

c=0
}
