package com.newton.code.interview;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class JSONGenerator {

  /**
   * Online: https://codecollab.io/@proj/MarketGeesePlate
   *
   * @param object
   */

  public static String convert(Object object) {

    String result = "";

    if (object == null) {
      result = "null";
    }

    //Integers
    else if (object instanceof Integer) {
      int value = (Integer) object;

      result = surroundDoubleQuotes(String.valueOf(value));

    }

    //Long
    else if (object instanceof Long) {
      Long value = (Long) object;

      result = surroundDoubleQuotes(String.valueOf(value));

    }

    //Double
    else if (object instanceof Double) {
      Double value = (Double) object;

      result = surroundDoubleQuotes(String.valueOf(value));

    }

    //float
    else if (object instanceof Float) {
      Float value = (Float) object;

      result = surroundDoubleQuotes(String.valueOf(value));

    }

    //String
    else if (object instanceof String) {
      String value = (String) object;

      result = surroundDoubleQuotes(value);

    }

    //Boolean
    else if (object instanceof Boolean) {
      Boolean value = (Boolean) object;

      result = surroundDoubleQuotes(String.valueOf(value));

    }

    //Character
    else if (object instanceof Character) {
      Character value = (Character) object;

      result = surroundDoubleQuotes(String.valueOf(value));

    }

    //HashMap
    else if (object instanceof HashMap) {
      Map<Object, Object> map = (Map<Object, Object>) object;

      result = generateMapresult(map);
    }

    //Arrays

    else if (object instanceof Object[]) {

      result = generateArrayResult((Object[]) object);
    } else {
      throw new RuntimeException("received invalid data type");
    }

    return result;
  }

  private static String generateArrayResult(Object[] object) {

    String result = "\"[";
    StringJoiner joiner = new StringJoiner(",");
    for (Object element : object) {
      joiner.add(convert(element));
    }

    result += joiner + "]\"";

    return result;

  }

  private static String generateMapresult(Map<Object, Object> map) {
    String result = "\"{";

    StringJoiner joiner = new StringJoiner(",");

    for (Map.Entry<Object, Object> entry : map.entrySet()) {
      joiner.add(convert(entry.getKey()) + ":" + convert(entry.getValue()));

    }

    result += joiner + "}\"";

    return result;

  }

  private static String surroundDoubleQuotes(String value) {

    return "\"" + value + "\"";

  }


  public static void main(String[] args) {

    System.out.println(convert(true));
    System.out.println(convert(false));
    System.out.println(convert(1));
    System.out.println(convert(1.1));
    System.out.println(convert(null));
    System.out.println(convert("Iam String"));
    System.out.println(convert("I"));
    System.out.println(convert('c'));

    Map<Object, Object> map = new HashMap<>();

    map.put("hi", 123);
    map.put(1, "hello");

    Map<Object, Object> child = new HashMap<>();

    child.put("Hey", "Im child");
    map.put("nested", child);

    System.out.println(convert(map));


    Object[] array = new Object[10];
    array[0] = 1;
    array[1] = 2;
    System.out.println(convert(array));


  }

}
