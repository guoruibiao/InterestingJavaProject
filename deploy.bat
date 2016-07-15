echo "Begin to Deploy this repository"
pause
D:\Software\Git\bin\git init
echo "Git inited"

D:\Software\Git\bin\git add .

D:\Software\Git\bin\git commit -m "Update this Repositpry"

# D:\Software\Git\bin\git remote add origin git@github.com:guoruibiao/InterestingJavaProject.git

D:\Software\Git\bin\git push origin master -f 

echo "Deploy Succeed!"

pause

exit