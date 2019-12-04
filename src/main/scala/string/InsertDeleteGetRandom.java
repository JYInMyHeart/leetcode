package string;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

/**
 * @Author: InsertDeleteGetRandom
 * @File: xck
 * @Time: 11:36 2019/12/4
 */
public class InsertDeleteGetRandom {
    Set<Integer> set;

    /** Initialize your data structure here. */
    public InsertDeleteGetRandom() {
        set = new HashSet<>();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        return set.add(val);
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        return set.remove(val);
    }

    /** Get a random element from the set. */
    public int getRandom() {
        Random random = new Random();
        int index = random.nextInt(set.size());
        Iterator<Integer> it = set.iterator();
        int i = 0;
        while(it.hasNext()){
            int tmp = it.next();
            if(i == index)
                return tmp;
            i++;
        }
        return -1;
    }

    public static void main(String[] args) {
        InsertDeleteGetRandom insertDeleteGetRandom = new InsertDeleteGetRandom();
        insertDeleteGetRandom.insert(1);
        System.out.println(insertDeleteGetRandom.getRandom());
    }
}
