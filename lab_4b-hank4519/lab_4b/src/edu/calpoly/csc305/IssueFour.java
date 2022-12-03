package edu.calpoly.csc305;

import java.util.List;

public class IssueFour <E> {
  /*
    You will need to update these methods to accomplish the intended task (there
    are a few ways to do this) and update the tests based on your solution.
   */
  public String buildString(List<E> inputs) {
    StringBuilder builder = new StringBuilder();

    for (E element: inputs) {
      builder.append(String.format("element: %s\n", element));
    }

    return builder.toString();
  }
}

//  public String buildString(List<Integer> integers) {
//    StringBuilder builder = new StringBuilder();
//
//    for (Integer integer : integers) {
//      builder.append(String.format("integer: %d\n", integer));
//    }
//
//    return builder.toString();
//  }
//}
