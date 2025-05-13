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
        contentPane.setLayout(new FlowLayout());

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
