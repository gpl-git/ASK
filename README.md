# java-webdriver-cucumber

Practical SQA

## How to push your changes to **GitHub**

Cut your own branch from master locally, typing: `git checkout -b name_of_your_branch`
and create remote copy `git push --set-upstream origin name_of_your_branch`
The name of your local branch must match the name of your remote branch. Example (You can see in
terminal): `* [new branch] nik -> nik`

Type git branch to verify that you created the branch (your currently branch will appear in green)

Make your changes

Run git status - your changes will appear in red

Add ALL your changes to staging by typing `git add .`

OR

To add some of the changes, instead `git add .` you can assign path to the file you want to commit after adding  
Example:
`git add /Users/sofia/IdeaProjects/AssessmentControl/src/test/resources/features/1.ObjectsPropertiesMethods/firstTest.feature`

OR

Use the interactive mode: `git add -i`

Type git status to check that you added all the changes (they will be shown in green)

To add your changes from stage to your branch, type
`git commit -m "[ADDED] your_message_explaining_what_you_modified"`
Use different labels `[ADDED]` `[CHANGED]` `[IMPROVED]` `[FIXED]` `[DELETED]`
to better understand what you did on branch

Switch to master to update code on master branch Type: `git checkout master` And then: `git pull -r`

Switch to your branch again Type `git checkout name_of_your_branch`

Type `git merge master` to make sure there won't be any conflicts in your future PR.

Run project to double-check if it is not broken

If there is no conflicts, you can push to GitHub. Being on your branch, type `git push`

Once you collected all the changes on your remote branch, you can go ahead and create Pull request on GitHub.

Repeat steps 3-13 for each complete task
