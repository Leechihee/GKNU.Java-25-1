# 짝수들의 합 구하기
```java
public class Study{

	public static void main(String[] args) {
		int sum = 0;
        for(int i = 1;i<=100;i++)
        {
        	if(i%2==0)
        		sum += i;
        }
        System.out.println(sum);
	}
}
```
# While 실습
```java
public class Main {
    public static void main(String[] args) {
        int i = 0;
        while(i<3)
        {
            System.out.println("Hello");
            i++;
        }
    }
}
```
# Password Mached Program
```java
import java.util.Scanner;

public class Study {
    public static void main(String[] args) {
        String password = "11223344";
        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.print("Enter password: ");
            if(password.equals(scanner.nextLine()))
            {
                System.out.println("Password Match");
                break;
            }
            else
                System.out.println("Password Does Not Match");
        }
        scanner.close();
    }
}
```
# Password Mached Program ver.2
```java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String password = "11223344";
        Scanner scanner = new Scanner(System.in);
        int i = 0;
        while(true)
        {
            System.out.println("에러 카운트: " + i);
            System.out.print("비밀번호를 입력하시오 : ");
            if(password.equals(scanner.nextLine()))
            {
                System.out.println("비밀번호가 일치합니다");
                break;
            }
            else if(i>=4)
            {
                System.out.println("잘못된 접근입니다. 접근을 차단합니다");
                break;
            }
            else
            {
                System.out.println("비밀번호가 맞지않습니다.");
                i++;
            }
        }
        scanner.close();
    }
}
```
