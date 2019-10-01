tr -sc '[a-z][A-Z]' '\n' < Data.txt | grep -c '^.\{4\}$'
