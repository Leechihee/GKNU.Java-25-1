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
        // 코드를 재사용하지 않으면서 주로 사용하지 않는 기능일 때 사용한다.
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
