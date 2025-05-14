# 300 * 300 프레임 만들기
```java
import javax.swing.*; // JFrame을 상속 받기 위한 import

public class MyFrame extends JFrame {
    public MyFrame()
    {
        setTitle("300 * 300 Frame");
        setSize(300, 300);
        setVisible(true);
    }

    public static void main(String[] args)
    {
       MyFrame myFrame = new MyFrame();
    }
}
```
# 레이아웃 만들고 콘텐츠 넣기
```java
import javax.swing.*;
import java.awt.*;

public class ContentPaneEx extends JFrame {
    public ContentPaneEx() {
        setTitle("ContentPane Ex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 종료함수

        // 레이아웃 만들기
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.ORANGE);
        contentPane.setLayout(new FlowLayout()); // FlowLayout(align, hgap, vgap);

        //만든 레이아웃에 넣을 콘텐츠 삽입
        contentPane.add(new JButton("OK")); // 버튼을 만들고 OK라는 내용을 넣는다
        contentPane.add(new JButton("Cancel")); // 버튼을 만들고 Cencel라는 내용을 넣는다
        contentPane.add(new JButton("Ignore")); // 버튼을 만들고 Ignore라는 내용을 넣는다

        // 띄울 창 설정
        setSize(300,150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ContentPaneEx();
    }
}
```
# 문제1 500*350 빨간색 배경에 6개의 버튼 만들기
```java
import javax.swing.*;
import java.awt.*;

public class JFrameTest extends JFrame {
    public JFrameTest() {
        setTitle("TEST");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 레이아웃 만들기
        Container contentPane = getContentPane();
        contentPane.setBackground(Color.RED);
        contentPane.setLayout(new FlowLayout());

        //만든 레이아웃에 넣을 콘텐츠 삽입
        contentPane.add(new JButton("OK"));
        contentPane.add(new JButton("Cancel"));
        contentPane.add(new JButton("Ignore"));
        contentPane.add(new JButton("TEST"));
        contentPane.add(new JButton("GOOD"));
        contentPane.add(new JButton("EXIT"));

        // 띄울 창 설정
        setSize(500,350);
        setVisible(true);
    }

    public static void main(String[] args) {
        new JFrameTest();
    }
}
```
# BorderLayout 실습
```java
import javax.swing.*;
import java.awt.*;

public class BorderLayoutEx extends JFrame {
    public BorderLayoutEx() {
        setTitle("Boarder Layout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();

        c.setLayout(new BorderLayout(30,20)); BorderLayout(hgap, vgap)
        c.add(new JButton("Calculate"), BorderLayout.CENTER); // 중앙위치
        c.add(new JButton("add"), BorderLayout.NORTH); // 북쪽 위치
        c.add(new JButton("sub"),BorderLayout.SOUTH); // 남쪽 위치
        c.add(new JButton("mul"),BorderLayout.EAST); // 동쪽 위치
        c.add(new JButton("div"),BorderLayout.WEST); // 서쪽 위치

        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new BorderLayoutEx();
    }
}
```
# GridLayout 실습 / 회원가입 폼
```java
import javax.swing.*;
import java.awt.*;

public class GridLayoutEx extends JFrame {
    GridLayoutEx()
    {
        setTitle("Grid Layout");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        GridLayout grid = new GridLayout(4,2);
        grid.setVgap(5);

        Container c = getContentPane();
        c.setLayout(grid);
        c.add(new JLabel(" 이름"));
        c.add(new JTextField(""));
        c.add(new JLabel(" 학번"));
        c.add(new JTextField(""));
        c.add(new JLabel(" 학과"));
        c.add(new JTextField(""));
        c.add(new JLabel(" 과목"));
        c.add(new JTextField(""));

        setSize(300,200);
        setVisible(true);
    }
    public static void main(String[] args) {
        new GridLayoutEx();
    }
}
```
