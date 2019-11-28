declare -A lcsmat
word1=hel
word2=el
len1=${#word1}
len2=${#word2}
lcsmat[0,0]=0
for ((i = 1 ; i < len1+1 ; i++));
do
lcsmat[$i,0]=0
done
for ((j=1;j<len2+1;j++));
do
lcsmat[0,$j]=0
done
for (( i=1 ; i<len1+1 ; i++));
do
  for(( j=1 ; j<len2+1 ; j++));
  do
    x=${word1:$i-1:1}
    y=${word2:$j-1:1}
  l=`expr $j - 1`
  m=`expr $i - 1`
if [ "$x" == "$y" ]; then
  lcsmat[$i,$j]=`expr ${lcsmat[$m,$l]} + 1`
else
  a=${lcsmat[$i,$l]}
  b=${lcsmat[$m,$j]}
  if [ $a -gt $b ]; then
    x=$a
  else 
    x=$b
  fi
  lcsmat[$i,$j]=`expr $x + 0` 
  fi 
done
done
echo ${lcsmat[$len1,$len2]}


