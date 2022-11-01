
public class BitOperation {
static public int getBitValue(long number, int nBit) {
	int res=-1;
	if(checkNbit(nBit)) {
		long mask = 1 << nBit;
		if((number & mask) == 0) {
		res = 0;	
		}else {
			res=1;
		}
		  //001110101011011111110101
          //                  100000
		
	}
	return res;
}
static public long setBitValue(long number, int nBit, boolean value) {
	int res=-1;
	/*if(checkNbit(nBit)) {
		if(value==true) {
			if(getBitValue(number,nBit)==1)	{
				return number;
			}
			else {
				return revertBitValue(number,nBit);
			}
		}else {
			if(getBitValue(number,nBit)==0)	{
				return number;
			}
			else {
				return revertBitValue(number,nBit);
			}
		}

	}*/
	if(checkNbit(nBit)) {
	if(value==true) {
		return number | 1 << nBit;
	}
	else {
		return number &~(1 << nBit);
	}
	}
	return res;

}

static public long revertBitValue(long number,int nBit) {
	int res=-1;
	if(checkNbit(nBit)) {
		return number ^ 1 << nBit;
		
	}
	return res;
}
private static boolean checkNbit(int nBit) {
	
	return nBit < 64 && nBit > -1;
}
}
