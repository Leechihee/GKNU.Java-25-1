# 직사각형 그리기
```java
import javax.swing.*;
import java.awt.*;

public class paintJPanelEx extends JFrame {
    private Panel panel = new Panel();

    public paintJPanelEx() {
        setTitle("PaintJPanelEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(250,220);
        setVisible(true);
    }

    // JPanel 클래스를 상속 받아 Panel 클래스를 작성
    private class Panel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // JPanel 생성자를 호출하여 객체 생성
            g.setColor(Color.RED); // JPanel의 메서드 중 하나인 setColor로 그릴 도형의 색 지정
            g.drawRect(10,10,50,50); // 빨간색 직사각형을 GUI 상의 (10,10) 지점에 50*50 사이즈로 그림
            g.setColor(Color.BLUE);
            g.drawRect(50,50, 50,50); // 파란색 직사각형을 GUI 상의 (50,50) 지점에 50*50 사이즈로 그림
            g.setColor(Color.GREEN);
            g.drawRect(90,90,50,50); // 초록색 직사각형을 GUI 상의 (90,90) 지점에 50*50 사이즈로 그림
        }
    }

    public static void main(String[] args) {
        new paintJPanelEx();
    }
}
```
# drawString / 문자열 그리기
```java
import javax.swing.*;
import java.awt.*;

public class paintJPanelEx extends JFrame {
    private Panel panel = new Panel();

    public paintJPanelEx() {
        setTitle("PaintJPanelEx");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(panel);
        setSize(250,220);
        setVisible(true);
    }

    // JPanel 클래스를 상속 받아 Panel 클래스를 작성
    private class Panel extends JPanel {
        public void paintComponent(Graphics g) {
            super.paintComponent(g); // JPanel 생성자를 호출하여 객체 생성
            g.drawString("PaintJPanelEx", 50, 50);
        }
    }

    public static void main(String[] args) {
        new paintJPanelEx();
    }
}
```
