package edu.calpoly.csc305;

import java.util.ArrayList;
import java.util.List;

public class IssueTwo <E> {
  /**
   * Method to illustrate common issue with generics.
   *
   * @param items list to copy
   * @return duplicate of input list
   */
  public List<E> duplicate(List<E> items) {
    List<E> copy = new ArrayList<>();

    for (E item : items) {
      copy.add(item);
    }

    return copy;
  }
}
