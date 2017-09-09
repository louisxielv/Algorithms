package edu.nyu.lx463.questions.DFS;

/**
 * Created by LyuXie on 4/20/17.
 */
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (Character.isDigit(curr)) {
                // the parameters need to pass into the recursion function
                String beingRepeated = "";
                // the number (because it maybe have multiple digits)
                int newKBegin = i;
                int newStringBegin = 0;
                int newK = 0;

                // find 最外面的[]
                int count = 0;

                // find the newK and the start index of the beingRepeated
                while (i < s.length()) {
                    i++;
                    if (s.charAt(i) == '[') {
                        newK = Integer.valueOf(s.substring(newKBegin, i));
                        newStringBegin = i + 1;
                        count++;
                        break;
                    }
                }

                while (i < s.length()) {
                    i++;
                    if (s.charAt(i) == '[') {
                        count++;
                    }
                    else if (s.charAt(i) == ']') {
                        count--;
                        if (count == 0) {
                            beingRepeated = decodeString(s.substring(newStringBegin, i));
                            break;
                        }
                    }
                }

                for (int a = 0; a < newK; a++) {
                    sb.append(beingRepeated);
                }

            }

            else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

}
