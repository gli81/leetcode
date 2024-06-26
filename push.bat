@echo off
rm ./*.class
git add .
git commit -m %1
git push -u leetcode master