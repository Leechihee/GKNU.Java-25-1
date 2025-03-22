# 합격 유무 찾기
```java
import java.util.Scanner; // c++에서는 입력이 쉽지만 java에서는 다소 어렵다.
// c++에서도 헤더를 사용하여 입출력을 하는 것과 비슷하듯 java에서도 util 안에 있는 Scanner라는 클래스를 이용하여 입력을 받는다.
// c++과 다른 점은 "java는 기본적으로 출력을 할 수 있다"가 다르다.

public class Hello {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in); // util 안에 있는 Scanner 라는 클래스 객체를 선언 후에 입력을 받을 수 있다. c++ 또한 istrean헤더의 클래스 객체인 cin를 사용하는 것과 비슷한 결이다.
		// Scanner == cin

		System.out.print("점수를 입력하시오 : ");
		int score = scanner.nextInt(); // Scanner 클래스 안에 있는 nextInt() 라는 메서드 함수를 이용하여 정수를 입력받는다.
		if(score >= 80) // c++에 있는 if와 같다.
		{
			System.out.println("합격점 80점을 넘겨 합격입니다!");
		}
		else
			System.out.println("함격점 80점을 넘지 못해 불합격입니다!");
		
		scanner.close(); // 입력을 사용하지 않을 때 close() 함수를 이용하여 리소스를 풀어줘야하지만, 한번 닫은 System.in은 다시 열 수 없다는 것을 알고 있어야한다.
	}
}

```

# 3의 배수 유무 찾기
```java
import java.util.Scanner;

public class Study {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요 : ");
		int num = scanner.nextInt();
		
		if(num%3 == 0)
			System.out.println(num + "은(는) 3의 배수입니다!");
		else
			System.out.println(num + "은(는) 3의 배수가 아닙니다!");
		
		scanner.close();
	}
}
```

# 등급 나누기
```java
import java.util.Scanner;

public class Study{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("성적를 입력하세요 : ");
		char grade;
		int score = scanner.nextInt();
		
		if(score>=90)
			grade = 'A';
		else if(score < 90 && score >= 80)
			grade = 'B';
		else if (score < 80 && score >= 70)
			grade = 'C';
		else if(score <70 && score >= 60)
			grade = 'D';
		else
			grade = 'F';
		System.out.println("학점은 " + grade + "입니다!");
		
		scanner.close();
	}
}
```
# 주민등록번호 검사기
```java
import java.util.Scanner;

public class Study {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("주민등록번호를 입력하세요 : ");
		String id = scanner.nextLine(); // 메서드 함수를 이용해서 문자열을 입력받는다.
		
		char genderCode = id.charAt(7); // charAt(n)은 문자열에서 n번째 문자를 가져오는 메서드함수이다.
		
		if(genderCode > '5' || genderCode < '1') // 연산 횟수를 줄이기 위해 오류부터 제거 후에 성별비교하기
			System.out.println("잘못된 주민등록번호입니다.");
		else if(genderCode == '2' || genderCode == '4')
			System.out.println("여자입니다.");
		else
			System.out.println("남자입니다.");
		
		scanner.close();
	}
}

```
# 합격 유무 찾기 ver.2 / 중첩 조건문문
```java
import java.util.Scanner;

public class Study{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("성적를 입력하세요 : ");
		int score = scanner.nextInt();
		
		System.out.print("학년를 입력하세요 : ");
		int year = scanner.nextInt();
		
		if(score < 60)
			System.out.println("불합격입니다!");
		else
		{
			if(year != 4)
				System.out.println("합격입니다!");
			else if(score >= 70)
				System.out.println("합격입니다!");
			else
				System.out.println("불합격입니다!");
		}
		
		scanner.close();
	}
}
```
# 학점매기기 ver2 / switch
```java
import java.util.Scanner;

public class Study{

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("성적를 입력하세요 : ");
		char grade;
		int score = scanner.nextInt();
		
		switch(score/10) // 잘 쓰이지는 않지만 조건문의 또 다른 형태이며 if/elseif/else 구문과 똑같은 의미를 지녔다.
		{
			case 10:
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
		}
		
		System.out.println("학점은 " + grade + "입니다!");
		
		scanner.close();
	}
}
```
