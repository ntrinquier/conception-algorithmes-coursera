
public class Enonce {

	public static void main(String[] args) {
		//test1();
		//test2();
		//test3();
		//test4();
		test5();
	}

	public static void test1() {
		System.out.print("Devoir0Reponse0 ");		
		System.out.print("Hello World ");
		System.out.print("done");
	}
	
	public static void test2() {
		System.out.print("Devoir0Reponse1 ");
		System.out.print(somme(10, 40)+" ");
		System.out.print(somme(2, -3)+" ");
		System.out.print(somme(2001, 4235)+" ");
		System.out.print("done");
	}
	
	public static void test3() {
		System.out.print("Devoir0Reponse2 ");
		System.out.print(u(10)+" ");
		System.out.print(u(1)+" ");
		System.out.print(u(20)+" ");
		System.out.print("done");
	}
	
	public static void test4() {
		System.out.print("Devoir0Reponse3 ");
		System.out.print(rotation('c')+" ");
		System.out.print(rotation('f')+" ");
		System.out.print(rotation('z')+" ");
		System.out.print(rotation(rotation('z'))+" ");
		System.out.print("done");
	}
	
	public static void test5() {
		System.out.print("Devoir0Reponse4 ");
		System.out.print(distance("aaaa", "bbbb")+" ");
		System.out.print(distance("aaaa", "azaz")+" ");
		System.out.print(distance("foo", "bar")+" ");
		System.out.print(distance("azerty", "qwerty")+" ");
		System.out.print("done");
	}

	public static int u(int n) {
		if (n == 0) {
			return 1;
		}
		
		return 2*u(n-1)+4;
	}
	
	public static int somme(int a, int b) {
		return a+b;
	}
	
	public static char rotation(char c) {
		int codeA = (int) 'a';
		return (char) (codeA+((((int) c)-codeA+1)%26));
	}
	
	
	public static int distance(String s1, String s2) {
		int ret = 0;
		int x, y, d;
		
		for (int i = 0; i < s1.length(); i++) {
			x = (int) s1.charAt(i);
			y = (int) s2.charAt(i);
			d = (x > y) ? (x-y) : (y-x);
			ret += (d < 26-d) ? d : 26-d;
		}
		return ret;
	}
}
