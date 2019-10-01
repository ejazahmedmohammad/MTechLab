echo -e "\nEdit:"
sh ./DisplayAll.sh
echo -n "Press 1 for name search, 2 for else for number: "
read method
echo -n "Enter key to be searched"
read key

isFound=$(cat contacts | awk -F, -v k="$key" -v m="$method" '{
if( (m == 1 && tolower($1) == tolower(k)) ||
 (m != 1 && tolower($2) == tolower(k)) )
	{
		print $0
	}
}')
if [ -n "$isFound" ]; then
	echo -e "\nprinting $isFound\n"
	echo "enter new name"
	read new_name
	echo "enter new number"
	read new_number
	sed -i "s/$isFound/$new_name,$new_number/g" contacts
else
	echo "Sorry, $key not found."
fi
echo "Press Enter to continue..."
read something