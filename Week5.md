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
# 배열 실습
```java
public class Study {
    public static void main(String[] args) {
    	int array[] = new int[5];
    	array[0] = 5;
    	array[1] = 3;
    	array[2] = -10;
    	array[3] = 113;
    	array[4] = -130;
    	
    	System.out.println(array[4]);
    	
    	int sum = 0;
    	for(int i = 0;i<5;i++)
    	{
    		System.out.println(array[i]);
    		sum += array[i];
    	}
    	System.out.println("Sum : " + sum);
    	int max = 0;
    	for(int i = 0;i<5;i++)
    	{
    		if(array[i]>max)
    			max = array[i];
    	}
    	System.out.println("Max : " + max);
    	System.out.println("Arg : " + sum/5);
    }
}
```
# 최대값 찾기
```java
public class Study {
    public static void main(String[] args) {
    	int intArray[] = {7,3,10,2,6};
    	int max = 0;
    	for(int i = 0;i<5;i++)
    	{
    		if(intArray[i]>max)
    			max = intArray[i];
    	}
    	System.out.println(max);
    }
}
```
# 
```java

```
