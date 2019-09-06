#!/bin/bash
echo "Address Book"
grep -n . addressBook

echo "Enter Opertion"
read op
case $op in
   1) 
echo enter line number
read line_num
echo enter new name
read new_name
echo enter new number
read new_num
echo sed -i  "$1"   addressBook|bash
sed -i s/$old_name/$new_name/g addressBook ;;
  2) 
  
;;
  *)
   echo "Inavalid Op"
esac


