# Magical Arena

## Introduction
Magical Arena is a Java application that simulates battles between players in a magical arena. Each player has attributes such as health, strength, and attack, and they take turns attacking each other using dice rolls to determine the outcome.

## Features
- Simulates battles between players in a magical arena.
- Players have attributes: health, strength, and attack.
- Attacks are determined by dice rolls.
- The game ends when any player's health reaches 0.

## How to Run
1. Make sure you have Java and maven installed on your system.
2. Clone or download this repository.
3. Run the command in your terminal: `mvn clean install`
4. Run the application using the command: `java -jar target/magicalArena-0.0.1-SNAPSHOT.jar`

## Testing
The project includes comprehensive unit tests to verify the functionality of the Player and MagicalArena classes.

### Test Cases
1. **testPlayerInitialization**: Verifies that player attributes are initialized correctly.
2. **testPlayerAttack**: Simulates a player attack and checks if the opponent's health decreases accordingly.
3. **testPlayerDefend**: Simulates a player defending against an attack and checks if the player's health decreases accordingly.
4. **testArenaMatch**: Simulates a match between two players in the arena and checks if at least one player is not alive after the match.
