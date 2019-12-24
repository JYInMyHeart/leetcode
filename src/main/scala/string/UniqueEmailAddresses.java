package string;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author: xck
 * @File: UniqueEmailAddresses
 * @Time: 10:42 2019/12/24
 */
public class UniqueEmailAddresses {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for(String email:emails){
            set.add(helper(email));
        }
        return set.size();
    }


    public String helper(String email){
        int plus = email.indexOf("+");
        int at = email.indexOf("@");
        String plusStr = email.substring(0,at);
        if(plus > - 1 && plus < at) {
            plusStr = email.substring(0,plus);
        }
        String atStr =  email.substring(at);
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < plusStr.length();i++){
            if(plusStr.charAt(i) != '.')
                sb.append(plusStr.charAt(i));
        }
        sb.append(atStr);
        return sb.toString();
    }
}

