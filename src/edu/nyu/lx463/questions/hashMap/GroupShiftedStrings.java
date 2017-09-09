package edu.nyu.lx463.questions.hashMap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LyuXie on 5/11/17.
 */
public class GroupShiftedStrings {
    public List<List<String>> groupStrings(String[] strings) {
        List<List<String>>  result = new ArrayList<>();
        if (strings == null || strings.length == 0) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strings) {
            int offset = s.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                sb.append((char)(c - offset));
            }

            String current = sb.toString();
            List<String> list = map.get(current);
            if (list == null) {
                List<String> temp = new ArrayList<>();
                temp.add(s);
                map.put(current, temp);
            }else {
                list.add(s);
            }
        }


        return new ArrayList<List<String>>(map.values());
    }
}
