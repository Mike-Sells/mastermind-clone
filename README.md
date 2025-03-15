# SCC.111: Term 2 Assessment Task: Code breaker!

This is the resources for the SCC.111 Term 2 Assessment Task.  This task is designed to test your understanding of object-oriented programming, inheritance, polymorphism, and graphical user interfaces in Java.  You will be required to complete the implementation of a simple game called Mastermind.

## Introduction

Imagine you are part of a software development team developing a Java version of the classic old board game **Mastermind** (see [wikipedia](https://en.wikipedia.org/wiki/Mastermind_(board_game))). You and your colleagues have been contracted to develop a digital version of the game using the *Java Swing* package.

The work was due to be delivered to your customer in the SCC1x1 lab next week. Your team had completed the work, but one of your junior colleagues' laptop was stolen on a train, and they hadn't checked in two of the classes they were working on back into the repo!  Oh no!

Without these two core classes, the project won't be delivered on time.  Are you up for the challenge of coding them up ?

**It is now up to you to complete the project by rewriting these three classes before the deadline in your SCC1x1 lab next week.**

## How mastermind works

![The boardgame from 1970s, photo credit [ZeroOne](https://commons.wikimedia.org/wiki/File:Mastermind.jpg)](https://upload.wikimedia.org/wikipedia/commons/2/2d/Mastermind.jpg){width=50%}

Mastermind is a simple game in principle, but quite fiendish to play.

The rules of the game are explained in the task handout on moodle.  Here you will find:

## Resources

Since SCC.111 is a Software Development course and not a course in computer graphics, we’ve provided some images for you.

The repo contains a subfolder 'icons' containing images you can use. Feel free to make use of these in your program. However, if you prefer to create your own graphics for fun, this is of course just fine too.

**Luckily, a complete version of the most complex of the classes have survived.** Clone the following repo to get all the Java code that is left of the project and the sample images.

```bash
git clone https://scc-source.lancs.ac.uk/scc.Y1/scc.111/Week19
```

## The Task

Your task is to complete the implementation of the Mastermind software, by implementing the missing classes. Once completed, you should have a working game, much like the one we've illustrated.

In the repo you will find a set of classes.  But **two** critically are missing, lost with the developer's laptop.

* **Answer.java** - Picks random digits to make up the code to guess.
* *Code.java* - *missing!*
* **CodeBreaker.java** - The state of the game (attempt count, answer, guesses array etc.)
* **CodeBreakerWindow.java** - the main UI setup and user interaction class.
* **Driver.java** - the main driver, just creates a CodeBreakerWindow.
* **GuessPanel.java** - an ImagePanel that represents the user's guess.
* **Image.java** - a class for loading images from a specific file.
* **ImagePanel.java** - a JPanel subclass with an array of images.
* **ScorePanel.java** - an ImagePanel that represents the score.
* *Scorer.java* - *missing!*

***You may wish to review and analyse these classes to understand how they operate, especially focusing on the user of inheritance, polymorphism and graphical Swing UI elements. No changes are needed to most of these classes, unless you want to change the game's appearance and UI!**

Unfortunately, the **Code** and **Scorer** classes have been lost. You are required to rewrite these to the following specification, such that they combine with the other classes to make the game work.

**Code**

- Create a class called `Code` to represent a target code.  Code will be updated by user guesses and when the initial code to guess is picked.
- One possible solution is to use an attribute (an array of integers) to represent the code sequence; and a further int attribute to represent which digit of the code (position in the array) you're dealing with. *Remember that attributes should not be directly visible from outside the class*.
- Create a *constructor* method that initializes these attributes.  The constructor should take a single integer parameter, the maximum length of the code.
- Create and implement the following methods:

    `setValue(int)` should add a code value to your code and return the position in the code.
	`getPosition()` gets the current position in the numbers array.
	`getLength()` is an accessor for the length of the code (i.e. numbers array).
	`boolean isComplete()` checks whether all the code values have been set
	`getCodeAsString()` Gets the code as a string of numbers.
	 int[] getCode() - Returns the code as an array of integers.

**Scorer**

- Create a class called `Scorer` to represent the score calculation function of the game.
- Implement a method `compareCorrect` that takes two `Code` parameters (the guess and the answer in that order) and calculates how many code digits are correct and in the right place.  It should return this as an integer.
- Implement a further method `comparePartiallyCorrect`, that similarly takes a guess and an answer (Code parameters) and returns the number of digits that are correct but not in the correct places.  This should be returned as an integer.

**Submission**

You will submit your work **during the end of term in-lab quiz in Week 20**. Ensure you keep your work safe until then.  Getting the game working will increase your confidence that `Code` and `Scorer` are behaving correctly.  You will need to submit a complete version of your code.  **The code must be able to compile from the command line on the lab machines**.  You may use any IDE to develop your code, but it must be able to compile and run from the command line.