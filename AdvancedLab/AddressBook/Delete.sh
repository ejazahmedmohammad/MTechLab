echo -e "\nDELETE:"
sh ./DisplayAll.sh
echo -n "Enter the name: "
read key
if [ -e contacts_tmp ]; then
rm contacts_tmp
fi

cat contacts |  awk -F, -v k="$key" '{
if(tolower($1) != tolower(k)) {
					print $0
				}
			}' > contacts_tmp
diff --suppress-common-lines -y contacts contacts_tmp
echo "are you sure to delete above press y to confirm"
read confirm
if [ "$confirm" = "y" ]; then
  mv contacts_tmp contacts
fi
