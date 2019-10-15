tr -sc '[a-z][A-Z]' '\n' < Data.txt > one.txt
tail -n +2 one.txt > two.txt
paste one.txt two.txt > three.txt
head -n -1 three.txt > bigram.txt
cat  bigram.txt | while read line; do
a=`echo $line | grep 'ing$'|cut -d' ' -f1|grep 'ing$'|wc -l`
if (( a == 1)); then
echo $line
fi
done
