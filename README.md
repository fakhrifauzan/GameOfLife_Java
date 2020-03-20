# Game Of Life

## Description

This program can simulating the Conway's Game of Life.

## Environment Setup
- Java 11 (OpenJDK)
- Gradle 5.2.1
- JUnit 4

## Build Instruction

To build this project, run this command
```bash
./gradlew build
```

## Run Test
To run test, please run this command
```bash
./gradlew check
```

## Run Instruction
To run application, please run this command
```
./gradlew run --console plain run --args='./pattern/<PATTERN>.txt'
```
For example to run `gosper-glider-gun` pattern
```
./gradlew run --console plain run --args='./pattern/gosper-glider-gun.txt'
```

### List of Supported Pattern
1. Still Alive Pattern: `block`, `boat`, `loaf`
2. Oscillator Pattern: `toad`, `pulsar`, `pentadechatlon`
3. Spaceship Pattern: `glider`, `lightweight-spaceship`
4. Custom Pattern: `gosper-glider-gun`

### Create A New Custom Pattern
If you want to create a new custom pattern.
You need create new file pattern under `pattern` folder.

Alive cell defined as `X` and dead cell defined as `_`.
For Example:
```text
_____
__X__
_X_X_
_XXX_
_X_X_
__X__
_____
```
And save the pattern file as `.txt` file.
