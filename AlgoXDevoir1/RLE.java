
public class RLE {
	public static int longueurRLE(int[] t) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			return 0;
		}
		int ret = 1;
		int prev = t[0];
		for (int b : t) {
			if (b != prev) {
				ret++;
				prev = b;
			}
		}
		return 2*ret;
	}
	
	public static int[] RLE(int[] t) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			return new int[0];
		}
		
		int[] ret = new int[RLE.longueurRLE(t)];
		int prev = t[0];
		int c = 0;
		int i = 0;
		
		for (int b : t) {
			if (b != prev) {
				ret[i] = prev;
				ret[i+1] = c;
				i += 2;
				c = 1;
				prev = b;
			} else {
				c++;
			}
		}
		
		ret[i] = prev;
		ret[i+1] = c;
		
		return ret;
	}
	
	public static int longueurRLEInverse(int[] t) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			return 0;
		}
		
		int ret = 0;
		for (int i = 1; i < t.length; i += 2) {
			ret += t[i];
		}
		return ret;
	}
	
	public static int[] RLEInverse(int[] t) {
		if (t == null) {
			throw new IllegalArgumentException("t is null");
		} else if (t.length == 0) {
			return new int[0];
		}
		
		int[] ret = new int[RLE.longueurRLEInverse(t)];
		int k = 0;
		
		for (int i = 0; i < t.length; i += 2) {
			for (int j = 0; j < t[i+1]; j++) {
				ret[k] = t[i];
				k++;
			}
		}
		
		return ret;
	}
}
