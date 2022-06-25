package com.newton.code.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringJoiner;

public class JavaObjectToJson {

    public static void main(String[] args) {
        System.out.println(convert(true));
        System.out.println(convert(null));
        System.out.println(convert(1));
        System.out.println(convert(1.1d));
        System.out.println(convert(1L));
        System.out.println(convert("this is string"));
        System.out.println(convert(1L));

        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);

        System.out.println(convert(arrayList));
        HashMap<Object, Object> hashMap = new HashMap<>();

        hashMap.put("Key", "value");

        hashMap.put("Nested", arrayList);

        System.out.println(convert(hashMap));

    }

    private static String convert(Object object) {
        String result = "";
        if (object == null)
            return "null";

        else if (object instanceof Boolean) {
            Boolean bool = (Boolean) object;
            result = encodeWithDoubleQuotes(String.valueOf(bool));
        } else if (object instanceof Integer) {
            Integer val = (Integer) object;
            result = encodeWithDoubleQuotes(String.valueOf(val));
        } else if (object instanceof Double) {
            Double val = (Double) object;
            result = encodeWithDoubleQuotes(String.valueOf(val));
        } else if (object instanceof Long) {
            Long val = (Long) object;
            result = encodeWithDoubleQuotes(String.valueOf(val));
        } else if (object instanceof String) {
            String val = (String) object;
            result = encodeWithDoubleQuotes(String.valueOf(val));
        } else if (object instanceof ArrayList) {
            ArrayList val = (ArrayList) object;
            result = convertArrayListToJson(val);
        } else if (object instanceof HashMap) {
            HashMap val = (HashMap) object;
            result = convertHashMapToJson(val);
        }
        return result;
    }

    private static String convertHashMapToJson(HashMap val) {
        StringBuilder res = new StringBuilder();
        res.append("{");
        StringJoiner joiner = new StringJoiner(",");

        val.forEach((k, v) -> {
            joiner.add(convert(k) + ":" + convert(v));
        });
        return res.append(joiner.toString()).append("}").toString();
    }

    private static String convertArrayListToJson(ArrayList val) {
        StringBuilder res = new StringBuilder();
        res.append("{");
        StringJoiner joiner = new StringJoiner(",");
        for (Object o : val) {
            joiner.add(convert(o));
        }
        return res.append(joiner.toString()).append("}").toString();
    }

    private static String encodeWithDoubleQuotes(String value) {
        return "\"" + value + "\"";
    }
}
