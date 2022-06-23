package com.newton.code;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class HashMapSort {


  // function to sort hashmap by values
  public static HashMap<String, String>
  sortByValue(HashMap<String, String> hm) {
    // Create a list from elements of HashMap
    List<Map.Entry<String, String>> list = new LinkedList<>(hm.entrySet());

    // Sort the list using lambda expression
    Collections.sort(list, (i1, i2) -> i1.getValue().compareTo(i2.getValue()));

    // put data from sorted list to hashmap
    HashMap<String, String> temp = new LinkedHashMap<>();
    for (Map.Entry<String, String> aa : list) {
      temp.put(aa.getKey(), aa.getValue());
    }
    return temp;
  }

  // Driver Code
  public static void main(String[] args) {

    HashMap<String, String> hm = new HashMap<String, String>();

    // enter data into hashmap
    hm.put("id1", "98");
    hm.put("id7", "85");
    hm.put("id3", "Null Pointer");
    hm.put("id6", "Null Pointer");
    hm.put("id8", "Check");
    hm.put("id10", "Back");
    Map<String, String> hm1 = sortByValue(hm);

    // print the sorted hashmap
    for (Map.Entry<String, String> en : hm1.entrySet()) {
      System.out.println("Key = " + en.getKey() + ", Value = " + en.getValue());
    }
  }
}
