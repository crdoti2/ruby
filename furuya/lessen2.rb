s1 = "*"
s2 = "*"


puts s1
for i in 1..10 do
 s1=s1+s2
  puts s1
end

for i in 1..10 do
 s1.slice!(0)
  puts s1
end




