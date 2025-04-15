# Inheritence / extends
### Point.java
```java
public class Point { // 부모클래스 / super class
	private int x, y;
	public void setPoint(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	public void showPoint()
	{
		System.out.println("("+x+", "+y+")");
	}
}

// inheritence
class ColorPoint extends Point{ // extends 키워드로 상속을 한다. 자식클래스/sub class
	// 보이지는 않지만 Point에게 상속받은 x,y을 가지고 있다.
	private String color;
	public void setColor(String color)
	{
		this.color = color;
	}
	public void showColorPoint()
	{
		System.out.println(color);
		showPoint(); // Point 클래스에서 상속 받았기 때문에 사용할 수 있다.
	}
}
```
### ColorPointEX.java
```java
// 다른 java 파일에서 선언된 Point, ColorPoint를 사용하는 파일
public class ColorPointEX {

	public static void main(String[] args) {
		Point p = new Point();
		p.setPoint(1, 2);
		p.showPoint();
		
		ColorPoint cp = new ColorPoint();
		cp.setPoint(3,4); // Point로부터 상속 받았기때문에 사용할 수 있다.
		cp.setColor("red");
		cp.showColorPoint();
	}

}

```
