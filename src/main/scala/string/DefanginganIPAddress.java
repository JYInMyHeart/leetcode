package string;

/**
 * @Author: xck
 * @File: DefanginganIPAddress
 * @Time: 18:20 2020/1/3
 */
public class DefanginganIPAddress {
    public String defangIPaddr(String address) {
        return address.replace(".","[.]");
    }
}
