import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
 
import static org.hamcrest.MatcherAssert.assertThat;
class Tests {

	@Test
	void test() {
		int i=123;
		assertEquals(first(i), 1);
		assertEquals(two(i), 2);
		assertEquals(third(i), 3);
	}
    public int first(int i) {
    	return (i-i%100)/100;
    }
    public int two(int i) {
    	return (i%100-i%10)/10;
    }
    public int third(int i) {
    	return i%10;
    }
    
    @Test
    void getBitValueTest() {
    	long number = 0x3ab7f5; //001110101011011111_1_10101
    	assertEquals(1,BitOperation.getBitValue(number, 5));
    	assertEquals(0,BitOperation.getBitValue(number, 11));
    	assertEquals(0,BitOperation.getBitValue(number, 1));
    	assertEquals(1,BitOperation.getBitValue(number, 2));
    }
    
  
    @Test
    void setBitValueTest() {
    	long number = 0x3ab7f5; //001110101011011111_1_10101
    	assertEquals(0x3ab7d5,BitOperation.setBitValue(number, 5,false));
    	assertEquals(0x3ab7f5,BitOperation.setBitValue(number, 5,true));
    }
    
    @Test
    void revertBitValueTest() {
    	long number = 0x3ab7f5; //001110101011011111_1_10101
    	assertEquals(0x3ab7d5,BitOperation.revertBitValue(number, 5));
    	assertEquals(0x3ab7f4,BitOperation.revertBitValue(number, 0));
    }
}
