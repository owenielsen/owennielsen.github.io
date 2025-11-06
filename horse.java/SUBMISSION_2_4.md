2.4 project - Comparable example

Files added/modified:

- `src/Project2_4.java` - new main program that creates a list of Horse objects, prints them, sorts using `Collections.sort`, and prints again.
- `src/Horse.java` - modified to implement `Comparable<Horse>` (natural order: older horses first; ties broken by name).

GitHub links (replace branch if needed):

- Project file: https://github.com/owennielsen/owennielsen.github.io/blob/main/horse.java/src/Project2_4.java
- Horse class: https://github.com/owennielsen/owennielsen.github.io/blob/main/horse.java/src/Horse.java

Sample output (run on system year = 2025):

Before sorting:
Horse{name='Silver', birthYear=2005}, age=20
Horse{name='Thunder', birthYear=2010}, age=15
Horse{name='Bella', birthYear=2012}, age=13
Horse{name='Apollo', birthYear=2000}, age=25
Horse{name='Zephyr', birthYear=2003}, age=22
Horse{name='Misty', birthYear=2015}, age=10
Horse{name='Duke', birthYear=1998}, age=27
Horse{name='Comet', birthYear=2008}, age=17
Horse{name='Aurora', birthYear=2005}, age=20
Horse{name='Beacon', birthYear=2005}, age=20
Horse{name='Nimble', birthYear=1998}, age=27

After sorting (older horses first, tie-break by name):
Horse{name='Duke', birthYear=1998}, age=27
Horse{name='Nimble', birthYear=1998}, age=27
Horse{name='Apollo', birthYear=2000}, age=25
Horse{name='Zephyr', birthYear=2003}, age=22
Horse{name='Aurora', birthYear=2005}, age=20
Horse{name='Beacon', birthYear=2005}, age=20
Horse{name='Silver', birthYear=2005}, age=20
Horse{name='Comet', birthYear=2008}, age=17
Horse{name='Thunder', birthYear=2010}, age=15
Horse{name='Bella', birthYear=2012}, age=13
Horse{name='Misty', birthYear=2015}, age=10
