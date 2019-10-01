while [ 1 ]; do
	echo -e "\nWELCOMWE TO PHONE BOOK APPLICATION"
	

	echo -e "Enter an option from the following: \
	         \n1) DISPLAY All\n2) Insert\n3) Search\n4) Edit \n5) Delete\n6) Exit\n"
	echo "Enter your choice: "
	read choice

	case $choice in
		1)
			sh ./DisplayAll.sh;;
		2)
			sh ./insert.sh;;
		3)
			sh ./Search.sh;;
        4)
		    sh ./Edit.sh;;
		5)
			sh ./Delete.sh;;

		6)	exit;;

		*)
			echo "Invalid choice.";;
	esac
done