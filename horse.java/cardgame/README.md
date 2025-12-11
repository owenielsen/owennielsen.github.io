# CardGame

Simple Java console project that deals hands to players and determines a winner based on sum of card values.

## Files
- `src/CardGame.java` — main source file containing all classes (Card, Deck, Player, Game) and `main`.

## Requirements
- JDK 8+ installed and on your PATH.

## Compile (PowerShell)
```powershell
# From the project root (where README.md lives)
javac -d out\classes src\CardGame.java
```

## Run (PowerShell)
```powershell
# Run from project root
java -cp out\classes CardGame
```

## Quick script (optional)
You can compile & run both steps with this PowerShell snippet:
```powershell
javac -d out\classes src\CardGame.java ; if ($?) { java -cp out\classes CardGame }
```
