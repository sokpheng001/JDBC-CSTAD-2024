git add .
# - n means not in new line
 echo -n "Commit message: "
 # shellcheck disable=SC2162
 read commit_message

# commit
 git commit -m "$commit_message"
 git push -u origin master