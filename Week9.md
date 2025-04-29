# Calculrator / Abstract Class
```java
public class Main {
    public static void main(String[] args) {
        Calculation cc = new calculator(); // 추상 클래스인 Calculation으로 서브 클래스인 calculator 안에 있는 override된 함수 호출하기
        int a = 3, b = 5;
        System.out.println(cc.add(a,b));
        System.out.println(cc.sub(a,b));
        int numList[] = new int[5];
        for(int i = 0; i < numList.length; i++)
            numList[i] = i+1;
        System.out.println(cc.aver(numList));
    }
}

abstract class Calculation { // 함수 중에 abstract 키워드가 포함된 함수가 하나라도 있으면 클래스에도 abstract 키워드를 포함해야한다.
    public abstract int add(int a, int b); // abstract 키워드로 추상 클래스 선언
    public abstract int sub(int a, int b);
    public abstract double aver(int[] list);
  // 추상 함수가 되면 상속받는 서브 클래스들은 추상 함수를 무조권 정의해줘야한다. 정의하지 않으면 컴파일 에러가 발생
}

class calculator extends Calculation {
    public int add(int a, int b) { // add 함수가 추상 함수기 때문에 무조권 정의 다른 함수도 동일
        return a + b;
    }
    public int sub(int a, int b)
    {
        return a * b;
    }
    public double aver(int[] list)
    {
        double sum = 0;
        for(int i = 0;i<list.length;i++)
        {
            sum += list[i];
        }
        return sum / list.length;
    }
}
```
