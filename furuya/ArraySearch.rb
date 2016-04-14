a=Dir.glob('./sample/*.java')


a.each { |x|

File.open(x) do |file|

a=file.read.scan(/\[\d+\]/)

puts File.basename(x)
puts a.length
  end

}
