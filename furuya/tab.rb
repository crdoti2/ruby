a=Dir.glob('C:/Users/R-N-010/Documents/ruby/furuya/sample/*.java')

p'123456789'.rjust(10)

c=0

a.each { |x|

File.open(x) do |file|

c=c+file.read.count("	")
   
  end

puts File.basename(x).ljust(35) + c.to_s.rjust(10) 
c=0
}
