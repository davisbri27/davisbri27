#!/bin/bash

# Student GitHub push script
#   Include this script in the base directory for the project 
#   with executable permissions.  This script will:
#
#     1. Add/stage all new/modified/removed files in the project
#     2. Commit staged changes with comment including user/date
#     3. Push head branch to GitHub
#          Asks for username/password first time if not set in git
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

# NOTE: These variables allow this script to do
# either a normal push or a force push.
if [[ $# -eq 0 ]];
then 
  LOGFILE=./.push.log
  PUSHFLAG=""
else
  if [[ $# -eq 1 && $1 = "force" ]];
  then 
    LOGFILE=./.forcepush.log
    PUSHFLAG="-f"
  else 
    echo "Illegal argument passed to push.bash"
    echo "May have no arguments or 'force'."
    exit -1
  fi    
fi

USER=$(whoami)
DATE=$(date "+%m/%d/%y %H:%M:%S")

echo $DATE > $LOGFILE
echo $USER >> $LOGFILE
echo "" >> $LOGFILE

# Add/stage any modified files.
echo "**** Staging Modifications ****" >> $LOGFILE
echo "git add -A" >> $LOGFILE
echo "" >> $LOGFILE

if git add -A >> $LOGFILE 2>&1 ; then
  echo "" >> $LOGFILE
  echo -e "\tSuccessfully added files." >> $LOGFILE
  echo "" >> $LOGFILE
  echo "git status" >> $LOGFILE
  echo "" >> $LOGFILE
  git status >> $LOGFILE 2>&1
  echo "" >> $LOGFILE
else 
  echo "Problem staging files as part of push."
  echo "See "$LOGFILE" for more information."
  exit -1
fi

# Make the commit.
MSG="Committed by "$(whoami)" @ "$(date "+%m/%d/%y %H:%M:%S")
echo "**** Committing to local Repo ****" >> $LOGFILE
echo "git commit -m "$MSG" --allow-empty" >> $LOGFILE
echo "" >> $LOGFILE

if git commit -m "$MSG" --allow-empty >> $LOGFILE 2>&1 ; then
  echo "" >> $LOGFILE
  echo -e "\tSuccessfully committed to local repo" >> $LOGFILE
  echo "" >> $LOGFILE
  echo "git status" >> $LOGFILE
  echo "" >> $LOGFILE
  git status >> $LOGFILE 2>&1
  echo "" >> $LOGFILE
else
  echo "Problem making the commit as part of push."
  echo "See "$LOGFILE" for more information."
  exit -1
fi

# Push to github.
echo "**** " $1"pushing to GitHub **** " >> $LOGFILE
echo "git push -u "$PUSHFLAG" origin master" >> $LOGFILE
echo "" >> $LOGFILE

if git push -u $PUSHFLAG origin master >> $LOGFILE 2>&1 ; then
  echo "" >> $LOGFILE
  echo -e "\tSuccessfully "$1"pushed to GitHub repo" >> $LOGFILE
  echo "" >> $LOGFILE
  echo "git status" >> $LOGFILE
  echo "" >> $LOGFILE
  git status >> $LOGFILE 2>&1
  echo "" >> $LOGFILE
  echo "Successfully "$1"pushed to GitHub all changes in:" >> $LOGFILE
  echo -e '\t'$PWD >> $LOGFILE

  echo ""
  echo "Successfully "$1"pushed to GitHub all changes in:"
  echo -e '\t'$PWD
  echo "You can log into GitHub to check your repository on-line."
  echo ""

  exit
else
  echo "Problem "$1"pushing files to GitHub."
  echo "Try running ./push.bash and then run ./pull.bash again."
  echo "See "$LOGFILE" for more information."
  exit -1
fi


