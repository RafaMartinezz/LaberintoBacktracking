# Maze Solver - Recursive Backtracking

This Java program solves a maze using **recursive backtracking**. The program reads multiple maze configurations, represented as grids, from user input. It then attempts to find a path from the starting position (top-left corner) to a target ('Q' for cheese) within each maze, printing the solution path if found.

## Table of Contents

- [Overview](#overview)
- [Purpose](#purpose)
- [Features](#features)
- [Usage](#usage)
- [Example Input and Output](#example-input-and-output)
- [Explanation](#explanation)

---

## Overview

The program reads maze dimensions and layout from standard input, then uses a recursive backtracking algorithm to navigate from the start position to the target. If a solution is found, it prints the path as a series of coordinates; otherwise, it indicates that no solution exists.

## Purpose

This project is a **learning exercise** designed to:
- Demonstrate recursive problem-solving techniques.
- Explore backtracking methods for navigating complex grids.
- Practice handling maze boundaries and detecting obstacles.

## Features

- **Recursive Backtracking**: Uses recursion to explore all possible paths through the maze, backtracking when dead-ends are encountered.
- **Dynamic Input**: Reads multiple maze configurations from input, making it versatile for different maze layouts.
- **Path Visualization**: Outputs the solution path as a sequence of coordinates, showing the steps taken to reach the target.


### Input Format

For each maze:
1. Enter the dimensions of the maze (`F C`), where `F` is the number of rows and `C` is the number of columns.
2. Enter each row of the maze grid:
   - `'0'` represents an open path.
   - `'#'` represents a wall.
   - `'Q'` represents the target (cheese).
   
Example:
```plaintext
5 5
0 0 # 0 0
# # 0 # 0
0 0 0 # Q
0 # 0 0 0
0 0 0 # 0
```

## Example Input and Output

### Input

```plaintext
3 3
0 0 #
0 # Q
0 0 0

4 4
0 0 # 0
# # 0 #
0 0 0 Q
0 # # 0
```

### Output

```plaintext
laberinto 1:
(0,0)(1,0)(2,0)(2,1)(1,2)

laberinto 2:
(0,0)(1,1)(2,3)
```

## Explanation

The maze-solving algorithm follows these steps:
1. **Start at the Top-Left Corner** `(0,0)`.
2. **Recursive Exploration**:
   - Moves to adjacent cells (up, left, right, down) as long as they are within bounds, not walls (`'#'`), and not previously visited.
   - Marks cells as visited to avoid revisiting, backtracking if it encounters dead ends.
3. **Target Detection**: If the cell contains `'Q'`, the solution path is printed.
4. **Backtracking**: If the target is not found, the method backtracks to try alternative paths.