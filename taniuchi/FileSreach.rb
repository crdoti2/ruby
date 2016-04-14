a=Dir.glob("/edu/sample/*.java")
b=a.length-1
for i in 0..b do
	c = File.read(a[i])
	d = c.count("\s")
	print a[i].split("/")[3].ljust(35," "),d,"\n"
end