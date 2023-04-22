x = -10:1:100
y = 2*x+1
for i = 1:length(y)
  y2(i) = y(i)+randi(100)-50
endfor

for n = 1:length(y)
  count1 = 0
  count2 = 0
  copy = n;
  calc = 0

  while(((copy-count1)>=1)&(count1<=3))
  calc = calc + y(copy-count1)
  count1 = count1+1
endwhile

while(((copy+count2)<length(y)-1)&(count2<3))
count2 = count2+1
calc = calc + y(copy+count2)
endwhile

  calc = calc/(count1+count2)
  y3(n) = calc
  endfor
