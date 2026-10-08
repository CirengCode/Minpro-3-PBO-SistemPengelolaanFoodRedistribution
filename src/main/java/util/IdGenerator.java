/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.util.HashMap;
import java.util.Map;

public class IdGenerator {

    private static final Map<String, Integer> counters = new HashMap<>();

    public static String generateId(String prefix) {
        int nomor = counters.getOrDefault(prefix, 1);
        counters.put(prefix, nomor + 1);

        return prefix + nomor;
    }
}
