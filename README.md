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
For example to run `block` pattern
```
./gradlew run --console plain run --args='./pattern/block.txt'
```

### List of Supported Pattern
1. Still Alive Pattern: `block`, `boat`, `loaf`

### List of Non-Supported Pattern
1. Oscilator Pattern: `toad`, `pulsar`, `pentadechatlon`
2. Spaceship Pattern: `glider`, `lightweight-spaceship`
3. Custom Pattern: `gosper-glider-gun`
