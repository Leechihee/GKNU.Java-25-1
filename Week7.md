# Inheritence / extends
```java
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

class Point { // 부모클래스 / super class
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
        // System.out.println(x); // compile error / sub class에선 super class의 private 변수를 직접 수정&출력을 할 수 없다.
        showPoint(); // Point 클래스에서 상속 받았기 때문에 사용할 수 있다.
    }
}
```
**상속을 받을 때 super class의 public 메소드는 사용할 수 있지만 private 메소드는 사용할 수 없다.  
그러므로 super class의 private 메소드를 수정하고 싶다면 super class의 public 함수를 이용하여  
수정해야한다.**
