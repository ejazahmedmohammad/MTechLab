tr -sc '[a-z][A-Z]' '\n' < Data.txt > one.txt
tail -n +2 one.txt > two.txt
paste one.txt two.txt > bigram.txt
sort bigram.txt | uniq -c| grep '[[:blank:]]*2[[:blank:]]'
