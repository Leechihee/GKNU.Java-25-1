# Calculrator Class / Abstract Class
```java
public class Main {
    public static void main(String[] args) {
        calculator cc = new calculator();
        int a = 3, b = 5;
        System.out.println(cc.add(a,b));
        System.out.println(cc.sub(a,b));
        int[] numList = new int[5];
        for(int i = 0; i < numList.length; i++)
            numList[i] = i+1;
        System.out.println(cc.aver(numList));
    }
}

abstract class Calculation { // 함수 중에 abstract 키워드가 포함된 함수가 하나라도 있으면 클래스에도 abstract 키워드를 포함해야한다.
    public abstract int add(int a, int b); // abstract 키워드로 추상 클래스 선언
    public abstract int sub(int a, int b);
    public abstract double aver(int[] list);
  // 추상 함수가 되면 상속받는 서브 클래스들은 추상 함수를 무조권 정의해줘야한다. 정의하지 않으면 컴파일 에러 발생
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
# Animal Class / Polymorphism(다형성)
```java
public class Main {
    public static void main(String[] args) {
        Animal[] cc = { new Dog("ppopy"), new Cat("mew")};
        for(Animal c : cc) // 범위기반 for 문
        {
            c.makeSound();
            c.eat();
        }
    }
}

abstract class Animal {
    String name;
    Animal(String name)
    {
        this.name = name;
    }
    void eat()
    {
        System.out.println(name + " is eating");
    }
    abstract void makeSound();
}

class Dog extends Animal {
    public Dog(String name)
    {
        super(name); // 슈퍼 클래스의 생성자 호출
    }

    @Override // 컴파일되지는 않지만 컴파일러에게 해당 코드는 어떤 것을 뜻하는지 알려주는 키워드이다.
    void makeSound() { // abstract function 이기 때문에 무조권 정의
        System.out.println(name + " is wark");
    }
}

class Cat extends Animal {
    public Cat(String name)
    {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " is meow");
    }
}

```
# Interface / 인터페이스
```java
public class Main {
    public static void main(String[] args) {
        SamsungPhone phone = new SamsungPhone();
        phone.printLogo();
        phone.sendCall();
        phone.receiveCall();
        phone.flash();
    }
}

// 기본적으로 상수,추상화함
public interface PhoneInterface {
    int TIMEOUT = 10000; // final이 생략이 되어있음. 상수
    void sendCall(); // abstact public이 생략이 되어있음 추상화
    void receiveCall(); // abstact public이 생략이 되어있음 추상화
    // 디폴트 메서드라 하며 클래스 부분에서 재정의하지 않으면 인터페이스에 구현된 메서드를 호출
    default void printLogo()
    {
        System.out.println("** Phone **");
    }
}

// 상속은 extends, 인터페이스는 implements
class SamsungPhone implements PhoneInterface {
    @Override // 추상화이기 때문
    public void sendCall() {
        System.out.println("띠리리리링");
    }

    @Override // 추상화
    public void receiveCall() {
        System.out.println("전화가 왔습니다.");
    }
    // 인터페이스 기능말고 다른 기능을 추가
    public void flash()
    {
        System.out.println("전화기에 불이 켜졌습니다.");
    }
}
```
**상속은 다중상속이 불가하지만 인터페이스는 다중상속이 가능  
인터페이스끼리는 extends로 상속**
