Welcome to PPL!

If you aren't used to working with project folders, this type of file (typically just called a 'readme') are pretty common for documenting the ins and outs of a repository that may or may not be self explanatory.  We're going to be using the .sbt style Scala project for our problemsets and projects, so I'd suggest getting comfortable with this format (if you aren't already).

If you're already a whiz with this sort of stuff, then by all means, feel free to start poking around.

But if you're not, I'll say a few things:
- The important pieces of this (and future) repos live in the src folder.  There's going to be a src/main/ folder where your classes live, and a src/test/ folder where your tests live.
- If you're in VSCode, the .bloop/, .metals/, and target/ folders contain the compiled versions of your code.  Don't worry about them
- The build.sbt file contains details for what libraries this repository is accessing.  We won't be messing with it, but if you're ever working in Scala and you were importing some sort of open source module to work with, this is where you'd specify the module version.

So from the above, your main takeaway should be the following: anytime you're given a repo to work in (in this class, or life in general), take a look at src folder, and look for a readme file.

This particular repo is pretty straightforward.  We've a scala worksheet (my_worksheet.sc) in the src/ folder that contains some very basic scala syntax, and we've got a scala file (Main.scala) file with an associated test file (MainTest.scala) that should give you a sense of project structure, function syntax, and testing.  If we have time, we'll start to get into the nitty-gritty of pattern matching as well.

A note on these types of files: you can view a pretty version of a .md file in VSCode via CMD+Shift+V (or CTRL+Shift+V if you're on Windows).