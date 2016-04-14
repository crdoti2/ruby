i=0
#\[\d+\]
ans = {} 
Dir.glob('./sample/test.java') { |f|  ans[f] =  File.open(f).read.count("\t")}
#a[i] = File.open(f).read.scan(/\[\d+\]/)

ans[0]= File.open(f).read.scan(/\[\d+\]/)
puts ans[0]
ans.sort_by{|k,v| -v}.each{ |a| puts a[0].split("/")[2].ljust(35) + a[1].to_s.rjust(5) } 

