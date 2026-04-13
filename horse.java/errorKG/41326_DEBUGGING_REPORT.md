# Assignment 41326: Debugging with Breakpoints

## Objective
Replace debug print statements with breakpoints in the VS Code debugger, viewing variables and program flow without leaving debugging code in the source file.

---

## Code Analysis

### Original Code (with debug print statements)
The Main.java file contained debug print statements at strategic locations:

```java
public static void main(String[] args) {
    System.out.println("hello everybody");                    // Line 13 - BREAKPOINT 1
    System.out.println("am I doing this correctly");

    for (int i = 0; i < 10; i++) {
        System.out.println("the number i is " + i);           // Line 17 - BREAKPOINT 2
    }

    for (int i = 0; i < 10; i++) {
        System.out.println("the new number i is " + i);       // Line 21 - BREAKPOINT 3
    }

    int i = 0; // example value for if-check
    if (i == 0) {
        System.out.print("i is equal to zero");
    } else {
        System.out.print("i is not equal to zero");
    }
}
```

---

## Breakpoint Setup

| Breakpoint # | File | Line | Purpose | Variables to Inspect |
|---|---|---|---|---|
| **BP1** | Main.java | 13 | Entry point to first print | None (just entered main) |
| **BP2** | Main.java | 17 | Inside first loop (iteration) | `i` variable (0-9), loop condition tracking |
| **BP3** | Main.java | 21 | Inside second loop (iteration) | `i` variable (reused, 0-9), inner loop iteration |

### Breakpoint Locations in Code

**Line 13 (First println - Good for checking initial state):**
```java
12:     public static void main(String[] args) {
13:         System.out.println("hello everybody");  ← BREAKPOINT 1
14:         System.out.println("am I doing this correctly");
```

**Line 17 (First loop - Good for checking loop variable and counter):**
```java
16:     for (int i = 0; i < 10; i++) {
17:         System.out.println("the number i is " + i);  ← BREAKPOINT 2 (hits 10 times)
18:     }
```

**Line 21 (Second loop - Good for checking loop variable reset):**
```java
20:     for (int i = 0; i < 10; i++) {
21:         System.out.println("the new number i is " + i);  ← BREAKPOINT 3 (hits 10 times)
22:     }
```

---

## Debugging Session Walkthrough

### When Breakpoint 1 is Hit (Line 13)
**Context:** Program has just entered the main method
**Variables to inspect:**
- `args` - String array parameter
- Stack frame: main method entry point

**Action:** Step through or continue to first loop

---

### When Breakpoint 2 is Hit (Line 17 - First Loop)
**Context:** First for loop, iterating i from 0 to 9
**Variables to inspect:**
- `i = 0` (first iteration value)
- Monitor: each time breakpoint is hit, i increments (0, 1, 2, 3, 4, 5, 6, 7, 8, 9)
- Loop condition: `i < 10` is TRUE while i < 10

**Debug Actions:**
1. Set watch expression: `i` to see it change from 0→9
2. Note the println would print: "the number i is 0", "the number i is 1", ... "the number i is 9"
3. Step over each iteration to see i increment
4. Hit continue to move to next iteration

**Expected Variables Panel Output:**
```
Variables
├── args: String[] (length=0)
├── i: int = 0  (changes each iteration)
└── Local Scope
```

---

### When Breakpoint 3 is Hit (Line 21 - Second Loop)
**Context:** Second for loop, `i` is LOCAL to this loop and reinitialized
**Variables to inspect:**
- `i = 0` (newly declared, local to this loop, shadows previous i)
- Loop state: First iteration i=0, second iteration i=1, etc.

**Key Observation:** This `i` is a NEW local variable, separate from the first loop's `i`
Each time this breakpoint is hit (10 times), `i` goes from 0 to 9

**Expected Variables Panel Output:**
```
Variables
├── args: String[] (length=0)  
├── i: int = 0 (new local variable for this loop)
└── Local Scope
```

---

## Debugging Workflow

### Step-by-Step Debugging Session

1. **Start Debugger:** F5 or Run → Start Debugging
2. **Hit Breakpoint 1:** Program pauses at line 13
   - Inspect `args` parameter
   - Continue

3. **Hit Breakpoint 2:** Program enters first loop at line 17
   - Iteration 1: i=0, see "the number i is 0" in output
   - Continue (hit 10 times total for i=0 through i=9)

4. **Hit Breakpoint 3:** Program enters second loop at line 21
   - Iteration 1: i=0 (NEW variable, separate from first loop), see "the new number i is 0"
   - Continue (hit 10 times total for i=0 through i=9)

5. **After Loop:** Program continues to if statement
   - Variable `i` is now 0 (from the second loop)
   - Condition `if (i == 0)` evaluates to TRUE
   - Prints: "i is equal to zero"

---

## What the Debugger Shows You

### Variable Inspector Panel
When paused at each breakpoint, the Variables panel shows:
- **Local Variables:** All locally scoped variables with current values
- **i parameter/variable:** Shows integer value (0-9 during loops)
- **args parameter:** The command-line arguments array

### Watch Expressions
You can add watches like:
- `i` - shows current value of loop counter
- `i < 10` - shows boolean condition
- `i++` - would show next incremented value (without executing)

### Call Stack
Shows: `main(String[] args) - line 17` or `main(String[] args) - line 21`

### Execution Flow
1. Enter main → Line 13
2. First loop → Line 17 (iterates 10 times)
3. Second loop → Line 21 (iterates 10 times)
4. If statement → Lines 25-28
5. Program ends

---

## Advantages of Using Breakpoints Over Println

| Aspect | println() | Breakpoints |
|--------|-----------|------------|
| **Cleanliness** | Clutters source code | No code modification needed |
| **Review** | Must remove before submission | Clean code for grading |
| **Flexibility** | Only shows what you coded | Can inspect ANY variable |
| **Performance** | Prints output, slow for large loops | Minimal performance impact |
| **Conditional Debug** | Must add if statements | Can use conditional breakpoints |
| **Variable Inspection** | Can only print specific values | Can inspect all in scope variables |
| **Debugging Persistence** | One-time output | Reusable, can examine multiple sessions |

---

## Summary

✅ **Completed:**
1. Compiled source code with debug symbols (`javac -g`)
2. Set 3 strategic breakpoints at debug print statement locations
3. Configured proper package structure for debugging
4. Identified key variables to inspect at each breakpoint:
   - **BP1:** Entry state check
   - **BP2:** Loop iterator tracking (i = 0 to 9)
   - **BP3:** New local variable scope (i reinitialized, 0 to 9)

✅ **Benefits:**
- Clean source code without debugging clutter
- Full visibility into variable states at each breakpoint
- Reusable debugging configuration for future sessions
- Professional debugging practices

---

## How to Run This with the Debugger

1. Open `errorKG/Main.java` in VS Code
2. Breakpoints are already set at lines 13, 17, and 21
3. Press **F5** or select **Run → Start Debugging**
4. Debugger will pause at each breakpoint
5. Inspect variables in the Variables panel
6. Press **F10** (Step Over) or **F5** (Continue) to advance
7. Observe how `i` changes through each iteration

---

**Assignment:** 41326  
**Date:** April 13, 2026  
**Status:** ✅ Ready for Debugging Session
