#!/bin/bash

# Student GitHub force pull script
#   Include this script in the base directory for the project 
#   with executable permissions.  This script will:
#
#     1. Give a warning and ask if you are sure...
#     2. Replace the local repo with the current GitHub repo.
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

echo $DATE > ./.forcepull.log
echo $USER >> ./.forcepull.log
echo "" >> ./.forcepull.log

echo ""
echo "Doing a forcepull discards all local changes and makes"
echo "your local repository look exactly like the one on GitHub."
echo ""
echo "It is suggested that you carefully review the contents of your"
echo "GitHub repository and consult with the instructor before"
echo "performing a forcepull."
echo ""
echo "Are you sure you want to perform a forcepull?"

select resp in "Yes" "No"; do
  case $resp in
    Yes ) echo "**** Performing git fetch from origin ****" >> ./.forcepull.log;
          echo "git fetch origin" >> ./.forcepull.log;
          echo "" >> ./.forcepull.log;      

          if git fetch origin >> ./.forcepull.log 2>&1; then
            echo "" >> ./.forcepull.log;
            echo -e "\tSuccessfully fetched origin" >> ./.forcepull.log;
            echo "" >> ./.forcepull.log;
            echo "git status" >> ./.forcepull.log
            echo "" >> ./.forcepull.log
            git status >> ./.forcepull.log 2>&1
            echo "" >> ./.forcepull.log
          else
            echo "Problem performing git fetch origin as part of forcepull."
            echo "See .forcepull.log for more information."
            exit -1
          fi
  
          echo "**** Performing git reset ****" >> ./.forcepull.log;
          echo "git reset --hard origin/master" >> ./.forcepull.log;
          echo "" >> ./.forcepull.log;  

          if git reset --hard origin/master >> ./.forcepull.log 2>&1; then
            echo "" >> ./.forcepull.log;
            echo -e "\tSuccessfully reset to master" >> ./.forcepull.log;
            echo "" >> ./.forcepull.log;
            echo "git status" >> ./.forcepull.log
            echo "" >> ./.forcepull.log
            git status >> ./.forcepull.log 2>&1
            echo "" >> ./.forcepull.log
          else
            echo "Problem performing git reset as part of forcepull."
            echo "See .forcepull.log for more information."
            exit -1
          fi

          echo "**** Performing git clean ****" >> ./.forcepull.log;
          echo "git clean -fdx" >> ./.forcepull.log;
          echo "" >> ./.forcepull.log;  

          if git clean -fdx >> ./.forcepull.log 2>&1; then
            echo "" >> ./.forcepull.log;
            echo -e "\tSuccessfully cleaned local repo." >> ./.forcepull.log;
            echo "" >> ./.forcepull.log;
            echo "git status" >> ./.forcepull.log
            echo "" >> ./.forcepull.log
            git status >> ./.forcepull.log 2>&1
            echo "" >> ./.forcepull.log
          else
            echo "Problem performing git clean as part of forcepull."
            echo "See .forcepull.log for more information."
            exit -1
          fi

          echo "" >> ./.forcepull.log
          echo "Successfully forcepulled changes from GitHub to:" >> ./.forcepull.log
          echo -e '\t'$PWD >> ./.forcepull.log

          echo ""
          echo "Successfully forcepulled changes from GitHub to:"
          echo -e '\t'$PWD
          echo ""

          exit;;

    No )  echo "Canceled.  Fine choice." >> ./.forcepull.log 2>&1;
          exit;;
  esac
done

