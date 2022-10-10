#!/bin/bash

REPOSITORY_DIR=~/onionJavaLevel2

BRANCHES=("leenr")
COMMIT_REVISION=a33b298

rm -rf $REPOSITORY_DIR

git clone https://github.com/gragnad/onionSpringLevel2

cd $REPOSITORY_DIR
pwd

for BRANCH_NAME in "leenr"; do
    echo $BRANCH_NAME
    git checkout -b $BRANCH_NAME origin/$BRANCH_NAME
    git cherry-pick $COMMIT_REVISION 
done

echo "Finished."