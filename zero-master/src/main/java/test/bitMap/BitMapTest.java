package test.bitMap;

import java.util.BitSet;

public class BitMapTest {
    public static void main(String[] args) {
        BitSet bitSet = new BitSet();
        bitSet.set(1,1);
        bitSet.set(3);
        bitSet.set(5);

        for (int i = 0;i<bitSet.length();i++){
            System.out.println(bitSet.get(i));
        }
    }
}
