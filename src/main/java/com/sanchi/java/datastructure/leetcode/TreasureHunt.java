package com.sanchi.java.datastructure.leetcode;

import java.util.HashMap;

/**
 *
 * 
 */
public class TreasureHunt {

  private static final HashMap<Direction, Direction> CIRCULAR_DIRECTION = new HashMap<>();
  private static final HashMap<Direction, Direction> ANTI_CIRCULAR_DIRECTION = new HashMap<>();

  private static void doInit() {
    CIRCULAR_DIRECTION.put(Direction.NORTH, Direction.EAST);
    CIRCULAR_DIRECTION.put(Direction.EAST, Direction.SOUTH);
    CIRCULAR_DIRECTION.put(Direction.SOUTH, Direction.WEST);
    CIRCULAR_DIRECTION.put(Direction.WEST, Direction.NORTH);

    ANTI_CIRCULAR_DIRECTION.put(Direction.NORTH, Direction.WEST);
    ANTI_CIRCULAR_DIRECTION.put(Direction.WEST, Direction.SOUTH);
    ANTI_CIRCULAR_DIRECTION.put(Direction.SOUTH, Direction.EAST);
    ANTI_CIRCULAR_DIRECTION.put(Direction.EAST, Direction.NORTH);
  }

  public static void main(String[] args) {
    String[] tokens = {"4", "r", "3", "l", "3"};

    doInit();

    Direction currentDirection = Direction.NORTH;
    int[] currentCoordinates = {0, 0};
    String regex = "[0-9]+";

    for (String token : tokens) {
      // its a value
      if (token.matches(regex)) {
        int steps = Integer.parseInt(token);
        currentCoordinates = move(currentCoordinates, currentDirection, steps);
      } else { // its a direction
        currentDirection =
            "r".equals(token) ? getNextDirection(currentDirection, true)
                : getNextDirection(currentDirection, false);
      }
    }

    System.out.println(
        "X - " + currentCoordinates[0] + ", y - " + currentCoordinates[1]);
  }


  private static int[] move(int[] curr, Direction direction, int value) {

    int currX = curr[0];
    int currY = curr[1];

    switch (direction) {
      case NORTH:
        currY = currY + value;
        break;
      case EAST:
        currX = currX + value;
        break;
      case SOUTH:
        currY = currY - value;
        break;
      case WEST:
        currX = currX - value;
        break;
      default: //doNothing
    }
    return new int[]{currX, currY};
  }

  private static Direction getNextDirection(Direction prevDirecttion,
      boolean turnRight) {

    return turnRight ? CIRCULAR_DIRECTION.get(prevDirecttion)
        : ANTI_CIRCULAR_DIRECTION.get(prevDirecttion);
  }

  enum Direction {
    NORTH,
    EAST,
    WEST,
    SOUTH
  }
}
