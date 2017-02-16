package com.fredericboisguerin.google.hashcode;

import java.util.Collection;
import java.util.Map;

public class StringUtils {

    private static final String HORIZONTAL_BORDER = "-";
    private static final String VERTICAL_BORDER = "|";
    private static final String SPACE = " ";
    private static final String LINE_SEPARATOR = System.lineSeparator();

    public static <K, V> String getTable(Map<K, V> map, String keyHeader, String valueHeader) {
        int columnKeySize = Math.max(getStringMaxSize(map.keySet()), keyHeader.length());
        int columnValueSize = Math.max(getStringMaxSize(map.values()), valueHeader.length());
        String table = getRowSeparator(columnKeySize, columnValueSize);
        table += getLine(keyHeader, valueHeader, columnKeySize, columnValueSize, SPACE);
        table += getRowSeparator(columnKeySize, columnValueSize);
        for (Map.Entry<K, V> entry : map.entrySet()) {
            table += getLine(entry.getKey(), entry.getValue(), columnKeySize, columnValueSize,
                    SPACE);
            table += getRowSeparator(columnKeySize, columnValueSize);
        }
        return table;
    }

    private static <K, V> String getLine(K key, V value, int columnKeySize, int columnValueSize,
            String character) {
        String result = VERTICAL_BORDER;
        result += character;
        result += completeWithCharacter(key.toString(), columnKeySize, character);
        result += character;
        result += VERTICAL_BORDER;
        result += character;
        result += completeWithCharacter(value.toString(), columnValueSize, character);
        result += character;
        result += VERTICAL_BORDER;
        result += LINE_SEPARATOR;
        return result;
    }

    private static String completeWithCharacter(String s, int columnKeySize, String character) {
        String withSpaces = s;
        for (int i = 0; i < columnKeySize - s.length(); i++) {
            withSpaces += character;
        }
        return withSpaces;
    }

    private static String getRowSeparator(int columnKeySize, int columnValueSize) {
        return getLine("", "", columnKeySize, columnValueSize, HORIZONTAL_BORDER);
    }

    private static String addString(String str, int iter) {
        String result = "";
        for (int i = 0; i < iter; i++) {
            result += str;
        }
        return result;
    }

    private static <T> Integer getStringMaxSize(Collection<T> keys) {
        return keys.stream()
                   .map(Object::toString)
                   .map(String::length)
                   .max(Integer::compareTo)
                   .orElse(0);
    }

}
