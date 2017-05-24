# Lab01: Loops and Strings

The goal of this laboratory exercise is to learn more about the workflow involving IntelliJ for code editing and running and Git/GitHub for version control management. In addition, this lab also includes the concepts of loops and strings.

## Step 1. Cloning this laboratory

First, we need to get this project onto your computer. We do this using the `git clone` command. In the Terminal app type the following command

```bash
git clone https://github.com/groovy-training-logicmonitor/lab01
```

This command creates a copy of all the files in this project onto your computer. Once this operation is complete, we can then move onto opening the project in IntelliJ. First, go to IntelliJ and go to the Welcome screen by either launching the app or closing all project windows. Next, select *Checkout from Version Control*. In the dropdown, select *GitHub* and select *Password* in the *Auth Type* drop down menu. Enter your login and password credentials using the GitHub user account you gave me at the beginning of this training. Once you have logged in, copy the above URL into the *Git Repository URL* field. Then click *Clone*. You should now have the project cloned to your computer and opened in IntelliJ. You can skip to **Step 3** if you used this alternative method.

**Alternative** If you wish, you can also clone this project using IntelliJ. 

## Step 2. Opening the project in IntelliJ

Opening the project is simple. Select *Open* from the Welcome screen. Next, navigate to the location of the project on your computer and select the directory *lab01*. This should open the project in IntelliJ and you should be ready to run it.

## Step 3. Running the project in IntelliJ

When you cloned the project from GitHub, it should already contain a run configuration to run the script. In the upper right hand of IntelliJ, it should say *main* and have a play icon next to it. Press this icon and the program should run. Give it a few seconds, it make take a bit to run. When it does run you should see output similar to the following: 

```bash
...
"jpw1939@gmail.com","1495484003734"
"s.mcguffie@yahoo.com","1495494305759"
"all2071071@maricopa.edu","1495501391079"
"bntpromos@verizon.net","1495517473555"
"bntpromos@verizon.net","1495517737797"
"chicorn1@gmail.com","1495530111677"
"jacobbackhausen@me.com","1495530768448"
"eberson_usa@hotmail.com","1495567081782"
"wboatright@atlantapaving.com","1495576464544"
"marcioyo@gmail.com","1495581134740"
"theskullreaper0@gmail.com","1495597041994"


Process finished with exit code 0
```

If you see output similar to the above, then you're ready to parse the response body as a string and use looping to process each line of it.

## Step 4. Splitting the response body

Add the following code to the bottom of `main.groovy`. The puprose of this code is to break the response body up into individual lines and put those lines into an array. The `split()` method does this by splitting the string on each carriage return. 

```groovy
def body = response.body().string()
def lines = body.split(/\s+/)
```

You can see the result of this split by adding:

```groovy
println(lines)
```

## Step 5. Looping through each line

Next, we want to loop through each line of the response. The code above broke the lines into individual strings and stored them into an array named `lines `. The code below uses an enhanced for loop to *visit* each line. Inside of this loop we can further process these lines.

```groovy
for (line in lines) {
    println(line)
}
```

## Step 6. Processing each line

Finally, let's reformat each line to something more like what LogicMonitor consumes. The following code splits each line into it's individual fields. Replace `println(line)` with the following code. The write some code, based on what we learned in the lecture, that prints out each field separated by `##`. Extra respect if you can remove the double quotes around each field.

```groovy
def fields = line.split(/,/)
```

And that's it as far as the coding is concerned. Now it's time to submit our solutions, and create a pull request.

## Step 7. Committing the code

Now it's time to commit our code. But first we need to create our own branches. We do this because we want to push our code up to GitHub, but without affecting the *master* branch. That's the branch we'll create our pull request again. To create your own branch in IntelliJ, right click on the project *lab01* -> *Git* -> *Repository* -> *Branches...*. Then click on *New Branch*. Under *New branch name* create a branch name. The name needs to be unique for each of you. The best way is to use your user name. For example `profknight-submission`. Press *OK* and that's it. The branch is created.

The next step is to commit our changes made to `main.groovy`. Before you commit, be sure to remove the token in `API_KEY` the URL in the `.baseUrl` call. This protects our project against other GitHub users since these projects are public. Next, right click on `main.groovy` in the project list and select *Git* -> *Commit File...*. Then under *Commit message* enter some text. It doesn't matter what you enter as long as it's not white space alone. Then press commit and we're ready to push the branch up to GitHub.

## Step 8. Pushing your changes

We can now push the commit from the last step up to GitHub. Right click on the project and select *Git* -> *Repository* -> *Push...*. On the subsequent dialog select *Push*. Once the push is done, if successful, you should see a message indicating the status of the push. The final step is creating the pull request.

## Step 9. Creating the pull request

Go to the lab repository on GitHub at https://github.com/groovy-training-logicmonitor/lab01. Your branch should be visible just above the the file listing. If you don't, ask me, and I'll point you where to go. If you do see your branch, click on the *Compare & Pull request*. You'll be taken to the next screen and you just need to click the *Create pull request* button and your done. 

## Step 10. Profiting

That's it you're done. We'll go through all the pull requests, leave some comments and then pick our favorite to merge into the `master` branch.

