tr -sc '[a-z][A-Z]' '\n' < Data.txt > words
while read -e word ; do
    v=$(echo $word | tr -cd 'aeiou' | wc -c)
    [[ ! $v -eq "2" ]] || echo $word
done <  words
