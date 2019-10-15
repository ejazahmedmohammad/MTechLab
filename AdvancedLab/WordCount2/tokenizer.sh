while read line; do
  for word in $line; do
    printf  "$word "
    printf  $word | tr -cd 'bcdfghjklmnpqrstvwxyz'
    printf " "
    printf  $word | tr -cd 'bcdfghjklmnpqrstvwxyz' | wc -c

  done
done < Data.txt
