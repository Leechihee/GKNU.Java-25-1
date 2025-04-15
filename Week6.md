# Circle Class // 클래스 생성 및 데이터, 메소드함수 선언
```java
public class Circle {
	double radius;
	String name;
	
	Circle() // default constructor
	{
		
	}
	
	double getArea()
	{
		return 3.14 * radius * radius;
	}
	public static void main(String[] args) {
		Circle pizza = new Circle(); // 객체 생성, pizza는 reference variable이다.
		pizza.radius = 10.0;
		pizza.name = "반올림피자";
		
		Circle donut = new Circle(); //같은 클래스로 객체를 만들면 서로 다른 객체이다. 이유는 메모리에 저장되는 위치가 다르기 때문
		donut.radius = 4.0;
		donut.name = "도넛";
		System.out.println(donut.name);
		System.out.println(donut.radius);
		System.out.println(donut.getArea());
		
		System.out.println(pizza.name);
		System.out.println(pizza.radius);
		System.out.println(pizza.getArea());
	}

}
```
# Ractangle Class // Private, public 키워드 설명 및 사용하는 이유
```java
import java.util.Scanner;

public class Ractangle {
	// private는 캡슐화 구현을 위한 키워드이다. 클래스 안에 public 키워드로 선언/정의된 메서드함수 외엔 직접 수정/출력할 수 없다.
	private int width;
	private int height;

	// public은 private 데이터 값을 외부에서 수정/출력하기 위한 도구로 쓰이며, 클래스 외부에서 사용할 수 있다.
	public int getWidth() {
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public void setWidth(int inputWidth)
	{
		width = inputWidth; // this 키워드로 객체 데이터를 지정할 수도 있다. this.width = inputWidth;
	}
	
	public void setHeight(int inputHeight)
	{
		height = inputHeight;
	}
	
	public int getArea()
	{
		return width * height;
	}

	public static void main(String[] args) {
		Ractangle r = new Ractangle();
		Scanner sc = new Scanner(System.in);
		
		System.out.print("가로를 입력하시오 : ");
		int inputWid = sc.nextInt();
		System.out.print("세로를 입력하시오 : ");
		int inputHei = sc.nextInt();
		
		r.setWidth(inputWid);
		r.setHeight(inputHei);
		
		System.out.println("넓이는 " + r.getArea());
		
		sc.close();
	}

}
```
# Circle Class / 생성자 선언
```java
public class Circle {
	double radius;
	String name;
	
	public Circle() // default constructor
	{
		radius = 1;
		name = "NONE";
	}
	
	public Circle(double r, String n) // constructor overloading
	{
		radius = r;
		name = n;
	}
	
	public double getArea()
	{
		return 3.14 * radius * radius;
	}

	public static void main(String[] args) {
		Circle pizza = new Circle(10,"반올림피자"); // int, String으로 매개변수를 받는 생성자로 객체 생성
		System.out.println("매개변수로 객체 생성");
		System.out.println(pizza.name);
		System.out.println(pizza.radius);
		System.out.println(pizza.getArea());
		
		Circle donut = new Circle(); // default constructor로 반지름 1, 이름은 NONE인 객체 생성
		System.out.println("default constructor로 객체 생성");
		System.out.println(donut.name);
		System.out.println(donut.radius);
		System.out.println(donut.getArea());

		donut.name = "도넛"; // private 변수가 아니기 때문에 외부에서 수정 가능
		donut.radius = 4;
		System.out.println("객체 정보 수정 후");
		System.out.println(donut.name);
		System.out.println(donut.radius);
		System.out.println(donut.getArea());
	}

}
```
# Book Class / Constructor Overloading, this reference, Garbage Collector
```java
public class Book {
    String title;
    String author;

    public Book(String title){ // 생성자가 하나라도 선언이 되면 기본 생성자는 생성하지않는다.
        this.title = title; // this 키워드는 객체 자기 자신을 가르키는 reference이다. 객체 데이터변수와 매개변수를 구분하기위해 쓰인다.
        author = "NONE";
    }

    public Book(String title, String author){
        this.title = title;
        this.author = author;
    }

    public static void main(String[] args)
    {
        Book littlePrince = new Book("어린왕자", "생텍쥐페리"); // 할당된 객체 메모리를 프로그램에서 자동으로 반납함.
        Book loveStory = new Book("춘향전");
        System.out.println(littlePrince.title + " " + littlePrince.author);
        System.out.println(loveStory.title + " " + loveStory.author);
        
        loveStory = littlePrince; // loveStory를 가르키던 레퍼런스가 littlePrince를 가르키게 되면서 기존 가르키는 객체의 레퍼런스가 없어짐.
        // 이것을 가비지이며 자신을 가르키는 reference가 하나도 없는 객체를 뜻한다. 메모리가 낭비되기때문에 가비지 컬렉터가 자동으로 메모리를 반납함.
    }
}
```
