#!/bin/bash

# Student GitHub force push script
#   Include this script in the base directory for the project 
#   with executable permissions.
#
# Copyright (c) 2016 Grant Braught. All rights reserved. 
#
#    This program is free software: you can redistribute it and/or modify
#    it under the terms of the GNU General Public License as published by
#    the Free Software Foundation, either version 3 of the License, or
#    (at your option) any later version.
#
#    This program is distributed in the hope that it will be useful,
#    but WITHOUT ANY WARRANTY; without even the implied warranty of
#    MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
#    GNU General Public License for more details.
#
#    You should have received a copy of the GNU General Public License
#    along with this program.  If not, see <http://www.gnu.org/licenses/>.

echo ""
echo "Doing a forcepush replaces the entire contents of your GitHub"
echo "repository with your local repository."
echo ""
echo "It is suggested that you carefully review the contents of your"
echo "GitHub repository and consult with your instructor before"
echo "performing a forcepush."
echo ""
echo "Are you sure you want to perform a forcepush?"

select resp in "Yes" "No"; do
  case $resp in
    Yes ) ./push.bash "force"
          exit;;

    No )  echo "Canceled.  Fine choice."
          exit;;
  esac
done


