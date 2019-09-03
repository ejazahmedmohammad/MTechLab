#!/bin/bash
echo "enter name"
read name
grep -i "$name" addressBook
