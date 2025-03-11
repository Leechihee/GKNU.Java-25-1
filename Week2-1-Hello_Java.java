/*java는 c++와 달리 기본적으로 Client의 기기 성능이 어느정도 좋다라는 것을 가정하에 코딩하므로
 몇몇 코드들이 기본적으로 포함되어있다. ex) String
 프로그래머 친화적인 언어이다.*/
public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a, b;
		int c;
		a = 301;
		b = 25;
		c = a+b;
		String name = "Leechihee"; // c++는 string 헤더를 넣어야하지만 java는 필요없다.
		System.out.println(name + " : " + a + " + " + b + " = "+ c); // cout << ~~ << endl == System.out.println(); ln<< 라인바꾸기 / System.out << 이 부분이 표준입출력과 같은 의미이다.
		
		c = a-b;
		System.out.println(name + " : " + a + " - " + b + " = "+ c);
		
		c = a*b;
		System.out.println(name + " : " + a + " * " + b + " = "+ c);
		
		c = a/b;
		System.out.println(name + " : a / b = " + c);
		
		c = a%b;
		System.out.println(name + " : a % b = " + c);
		
	}
}
