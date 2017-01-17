#!/bin/bash

# Student GitHub pull script
#   Include this script in the base directory for the project 
#   with executable permissions.  This script will:
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

USER=$(whoami)
DATE=$(date "+%m/%d/%y %H:%M:%S")

echo $DATE > ./.pull.log
echo $USER >> ./.pull.log
echo "" >> ./.pull.log

echo "**** Pulling from GitHub **** " >> ./.pull.log
echo "git pull" >> ./.pull.log
echo "" >> ./.pull.log

if git pull >> ./.pull.log 2>&1 ; then
  echo "" >> ./.pull.log
  echo -e "\tSuccessfully pulled from GitHub." >> ./.pull.log
  echo "" >> ./.pull.log
  echo "git status" >> ./.pull.log
  echo "" >> ./.pull.log
  git status >> ./.pull.log 2>&1
  echo "" >> ./.pull.log
  echo "Successfully pulled changes from GitHub to:" >> ./.pull.log
  echo -e '\t'$PWD >> ./.pull.log

  echo ""
  echo "Successfully pulled changes from GitHub to:"
  echo -e '\t'$PWD
  echo ""

  exit
else
  echo "Problem pulling from GitHub."
  echo "Did you push old changes first?"
  echo "See .pull.log for more information."
  exit -1;
fi


  
