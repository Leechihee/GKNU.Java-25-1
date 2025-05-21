# indepClassListener / ActionEventClass 외부 선언
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class indepClassListener extends JFrame
{
    public indepClassListener()
    {
        setTitle("Action Event Listener EX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton b1 = new JButton("Action"); // 버튼 객체를 선언
        // Action 리스너 객체를 달아둔다. 현재 이벤트 리스너는 MyActionListener
        // 버튼을 누른다면 Jbutton 객체를 object 변수로 MyActionListener 객체로 전달한다.
        b1.addActionListener(new MyActionListener());
        c.add(b1); // 버튼을 GUI 상에 띄운다.

        setSize(350,150);
        setVisible(true);
    }

    static public void main(String[] args)
    {
        new indepClassListener();
    }
}

// 이벤트 리스너인 ActionListner를 포함하여 클래스를 작성한다.
class MyActionListener implements ActionListener // interface이므로 implements 사용
{
    // abstruct function이므로 재정의를 하지 않으면 컴파일 에러
    public void actionPerformed(ActionEvent e)
    {
        JButton b = (JButton)e.getSource(); // getSource는 object을 반환(확실하다면 형변환(다운케스팅)을 이용한다.)
        if(b.getText().equals("Action")) // 버튼 안에 있는 Text를 반환한 값이 "Action"이라면
            b.setText("액션"); // 버튼 Text를 액션으로 바꾼다.
        else
            b.setText("Action"); // 버튼 Text를 Action으로 바꾼다.
    }
}
```
# InnerClassListener / ActionEventClass 내부 선언
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class InnerClassListener extends JFrame
{
    public InnerClassListener()
    {
        setTitle("Action Event Listener EX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton b1 = new JButton("Action"); // 버튼 객체를 선언
        b1.addActionListener(new MyActionListener()); // Action 리스너 객체를 달아둔다. 현재 이벤트 리스너는 MyActionListener
        c.add(b1); // 버튼을 GUI 상에 띄운다.

        setSize(350,150);
        setVisible(true);
    }

    static public void main(String[] args)
    {
        new InnerClassListener();
    }

    // 클래스 외부로 작성하는 것이 아닌 내부클래스 private 접근지정자로 선언하여 다른 클래스가 접근 불가
    private class MyActionListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            JButton b = (JButton)e.getSource();
            if(b.getText().equals("Action"))
                b.setText("액션");
            else
                b.setText("Action");
            InnerClassListener.this.setTitle(b.getText());
        }
    }
}
```
# AnonymoutClassListener / ActionListener 익명 선언
```java
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AnonymousClassListener extends JFrame {
    public AnonymousClassListener() {
        setTitle("Action 이벤트 리스너 작성");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        JButton btn = new JButton("Action");
        c.add(btn);

        // 익명으로 선언하여 해당 함수가 실행될 때 객체가 생성되어 사용하고 함수가 종료될 때 소멸하는 방식이다.
        // 코드를 재사용하지 않으면서 자주 사용하지 않는 기능일 때 사용한다.
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JButton b = (JButton)e.getSource();
                if(b.getText().equals("Action"))
                    b.setText("액션");
                else
                    b.setText("Action");
                setTitle(b.getText());
            }
        });
        setSize(350, 150);
        setVisible(true);
    }
    public static void main(String [] args) {
        new AnonymousClassListener();
        }
}
```
# MouseListenerClass / MouseEvent 처리
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseListenerEx extends JFrame
{
    // 텍스트를 private로 선언하여 클래스 내부에서만 사용할 수 있게 함
    private JLabel lb = new JLabel("HELLO");

    public MouseListenerEx()
    {
        setTitle("Mouse Event Listener EX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        // Container 구역에 MouseListener 객체를 선언하여 해당 구역 내의 마우스 이벤트를 처리
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null); // 구역이 있으면 텍스트의 움직임이 제한되므로 null
        lb.setSize(100,20); // 텍스트 크기 설정
        lb.setLocation(30,30); // 텍스트가 보일 지점 설정
        c.add(lb); // Container에 텍스트 추가
        setSize(500,500);
        setVisible(true);
    }

    // 내부 priavate 클래스로 선언
    private class MyMouseListener implements MouseListener
    {
        @Override // 재정의
        // 마우스 눌렀을 때
        public void mousePressed(MouseEvent e) {
            int x = e.getX(); // 매개변수로 받은 MouseEvent의 x 값 반환
            int y = e.getY(); // 매개변수로 받은 MouseEvent의 y 값 반환
            lb.setText("(" + x + ", " + y + ")");
            lb.setLocation(x, y); // 위 코드에서 받은 x, y 값으로 텍스트 위치 재설정
        }

        // MouseListener는 interface이므로 해당 interface 안에 선언된 함수들을 모두 재정의해줘야함.
        // 하지만 이 코드에선 mousePressed만 사용하므로 재정의를 하되 구현은 하지 않는다.
        public void mouseReleased(MouseEvent e) {} // 마우스를 누르고 땠을 때
        public void mouseClicked(MouseEvent e) {} 
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
    }

    static public void main(String[] args)
    {
        new MouseListenerEx();
    }
}
```
# MouseAdapterClass / 어뎁더 클래스
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class MouseAdapterEx extends JFrame
{
    private JLabel lb = new JLabel("HELLO");

    public MouseAdapterEx()
    {
        setTitle("Mouse Event Listener EX");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.addMouseListener(new MyMouseListener());

        c.setLayout(null);
        lb.setSize(100,20);
        lb.setLocation(30,30);
        c.add(lb);
        setSize(500,500);
        setVisible(true);
    }

    // MouseAdapter 클래스는 각종 MouseEvent interface를 모은 집합체이며
    // 기본적으로 구현이 없는 재정의를 해두었기 때문에 내가 필요한 함수만 재정의하여 사용하면 된다.
    private class MyMouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            lb.setText("(" + x + ", " + y + ")");
            lb.setLocation(x, y);
        }

        // interface로 상속 받을 때는 모든 함수가 추상 함수이므로 재정의를 무조권 해줘야하지만
        // MouseAdapter로 상속받을 때는 MouseAdapter 클래스 안에 구현 없는 재정의가 되어있고
        // 내가 사용할 이벤트만 재정의하는 방식으로 사용할 수 있다. 코드 간결성과 유지보수가 증가한다.
        /*public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}*/
    }

    static public void main(String[] args)
    {
        new MouseAdapterEx();
    }
}
```
