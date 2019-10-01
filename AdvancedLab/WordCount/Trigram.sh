tr -sc '[a-z][A-Z]' '\n' < Data.txt > one.txt
tail -n +2 one.txt > two.txt
tail -n +2 two.txt > three.txt
paste one.txt two.txt three.txt > trigram.txt
sort trigram.txt | uniq -c| sort -nr|head -5
