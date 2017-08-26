package com.inuker.solution;

import java.util.List;

/**
 * Created by dingjikerbo on 17/1/2.
 */

/**
 * 这题还挺容易错
 */
public class ValidWordSquare {

    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            /**
             * 如果单词长度比单词个数还多肯定是非法，因为横向和纵向长度不同
             */
            if (word.length() > words.size()) {
                return false;
            }
            for (int j = 0; j < word.length(); j++) {
                String s = words.get(j);
                if (i >= s.length() || word.charAt(j) != s.charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }

}
