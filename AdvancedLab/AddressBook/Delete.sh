echo -e "\nDELETE:"
sh ./DisplayAll.sh
echo -n "Enter the name: "
read key
if [ -e contacts_tmp ]; then
rm contacts_tmp
fi
cat contacts |  awk -F, -v k="$key"  '{
if(tolower($1) != tolower(k)) {
					print $0
				}
			}' > contacts_tmp
mv contacts_tmp contacts