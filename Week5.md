# 신문배달
```java
public class Study {
    public static void main(String[] args) {
        for(int i = 1;i<=4;i++)
        {
        	System.out.println("배달기사가 "+i+"층에 도착했습니다.");
        	for(int j = 1;j<=4;j++)
        		System.out.println(i*100+j + "호에 신문배달을 했습니다.");
        }
    }
}
```

# 구구단
```java
public class Study {
    public static void main(String[] args) {
        for(int i = 2;i<=9;i++)
        {
        	System.out.println(i+"단");
        	for(int j = 1;j<=9;j++)
        		System.out.print(i+"*"+j+" = "+i*j+" ");
        	System.out.println();
        }
    }
}
```
