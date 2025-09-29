Compile and run (PowerShell):

# Compile
javac -d bin src\*.java

# Run (uses system year):
java -cp bin App

# Run with explicit current year:
java -cp bin App 2025

Description: App creates three Horse objects and prints their ages and their toString() representations. The App accepts an optional first argument to set the current year (integer).
