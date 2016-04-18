ans = {}
Dir.glob('./sample/*.java') { |f| ans[f] =  File.open(f).read.count("\t")}
ans.sort_by{|k,v| -v}.each{ |a| puts a[0].split("/")[2].ljust(35) + a[1].to_s.rjust(5) }

