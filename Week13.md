# 화살표 키로 GUI 위의 Hello를 상하좌우로 움직이기
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class moveHello extends JFrame {
    private final int FLYING_UINT = 10; // 이동량 / 상수화하여 못바꾸도록 함
    private JLabel hello = new JLabel("Hello"); // JLabel을 이용하여 Hello 컴포넌트 선언

    public moveHello() {
        setTitle("move Hello");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane(); // 컴포넌트를 넣을 수 있는 컨테이너를 생성한다.
        c.setLayout(null); // Layout이 있으면 컴포넌트의 움직임이 제한받으므로 null
        c.addKeyListener(new MyKeyListener()); // 해당 컨테이너에 KeyListener를 삽입하여 키보드 입력값에 이벤트 처리를 하게한다.

        hello.setLocation(50,50); // Hello 텍스트의 시작지점을 50,50으로 지정한다.
        hello.setSize(100,20); // Hello 텍스트의 크기를 100,20으로 설정한다.
        c.add(hello); // Hello 텍스트를 GUI 상으로 띄운다.
        setSize(300,300); // 창의 크기를 300*300으로 지정한다.
        setVisible(true);
        c.setFocusable(true); // 컨테이너 c에 focus를 받을 수 있게 설정한다.
        c.requestFocus(); // 컨테이너 c에 focus를 강제로 지정한다.
    }

    // KeyAdapter 클래스를 이용하여 MyKeyListener 클래스 선언
    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 키보드의 키를 인식하여 상수값으로 반환

            // switch 문을 이용하여 키보드 입력값에 대한 이벤트 처리
            // GUI 상에서 0,0은 왼쪽 위 가장자리이다.
            switch (keyCode) {
                case KeyEvent.VK_UP: case KeyEvent.VK_W:
                    hello.setLocation(hello.getLocation().x, hello.getLocation().y - FLYING_UINT);
                    break;
                case KeyEvent.VK_DOWN: case KeyEvent.VK_S: // 내려가기 위해선 y값을 더한다
                    hello.setLocation(hello.getLocation().x, hello.getLocation().y + FLYING_UINT);
                    break;
                case KeyEvent.VK_LEFT: case KeyEvent.VK_A:// 왼쪽으로 가기 위해선 x값을 더한다
                    hello.setLocation(hello.getLocation().x - FLYING_UINT, hello.getLocation().y);
                    break;
                case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:// 왼쪽으로 가기 위해선 x값을 뺀다
                    hello.setLocation(hello.getLocation().x + FLYING_UINT, hello.getLocation().y);
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new moveHello();
    }
}
```
# 강아지 움직이고 짖게 하기
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class moveHello extends JFrame {
    private final int FLYING_UINT = 10; // 이동량 / 상수화하여 못바꾸도록 함
    private JLabel dog; // JLabel dog 선언
    private boolean isBarking = false;

    // 상태를 주기적으로 바꿔야하므로 전역변수로 이미지를 가져온다.
    private ImageIcon icon = new ImageIcon("dog.png");
    private ImageIcon barkIcon = new ImageIcon("dog_bark.png");

    public moveHello() {
        setTitle("move Hello");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container c = getContentPane(); // 컴포넌트를 넣을 수 있는 컨테이너를 생성한다.
        c.setLayout(null); // Layout이 있으면 컴포넌트의 움직임이 제한받으므로 null

        dog = new JLabel(icon); // 전역변수로 선언해둔 dog에 이미지 삽입

        dog.setLocation(50,50); // dog 컴포넌트의 시작지점을 50,50으로 지정한다.
        dog.setSize(icon.getIconWidth(), icon.getIconHeight()); // dog 컴포넌트의 크기를 이미지 가로, 이미지 세로으로 설정한다.
        c.add(dog); // dog 컴포넌트를 GUI 상으로 띄운다.

        c.addKeyListener(new MyKeyListener()); // 해당 컨테이너에 KeyListener를 삽입하여 키보드 입력값에 이벤트 처리를 하게한다.

        setSize(300,300); // 창의 크기를 300*300으로 지정한다.
        setVisible(true);

        c.setFocusable(true); // 컨테이너 c에 focus를 받을 수 있게 설정한다.
        c.requestFocus(); // 컨테이너 c에 focus를 강제로 지정한다.
    }

    // KeyAdapter 클래스를 이용하여 MyKeyListener 클래스 선언
    private class MyKeyListener extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            int keyCode = e.getKeyCode(); // 키보드의 키를 인식하여 상수값으로 반환

            // switch 문을 이용하여 키보드 입력값에 대한 이벤트 처리
            // GUI 상에서 0,0은 왼쪽 위 가장자리이다.
            switch (keyCode) {
                case KeyEvent.VK_UP: case KeyEvent.VK_W:
                    dog.setLocation(dog.getLocation().x, dog.getLocation().y - FLYING_UINT);
                    break;
                case KeyEvent.VK_DOWN: case KeyEvent.VK_S: // 내려가기 위해선 y값을 더한다
                    dog.setLocation(dog.getLocation().x, dog.getLocation().y + FLYING_UINT);
                    break;
                case KeyEvent.VK_LEFT: case KeyEvent.VK_A:// 왼쪽으로 가기 위해선 x값을 더한다
                    dog.setLocation(dog.getLocation().x - FLYING_UINT, dog.getLocation().y);
                    break;
                case KeyEvent.VK_RIGHT: case KeyEvent.VK_D:// 왼쪽으로 가기 위해선 x값을 뺀다
                    dog.setLocation(dog.getLocation().x + FLYING_UINT, dog.getLocation().y);
                    break;
                case KeyEvent.VK_SPACE: // space가 입력되면 이미지 바꾸기
                    if(isBarking) { // 이미 짖고 있다면
                        dog.setIcon(icon); // 안짖는 이미지로 바꾸고
                        isBarking = false; // 상태를 false로 선언
                    }
                    else // 짖고 있지 않다면
                    {
                        dog.setIcon(barkIcon); // 짖는 이미지로 바꾸고
                        isBarking = true; // 상태를 true로 선언
                    }
            }
        }
    }

    public static void main(String[] args) {
        new moveHello();
    }
}
```
# 마우스 휠로 텍스트 크기 바꾸기
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class LableZoomEx extends JFrame{
    private JLabel label;
    private int labelWidth = 100;
    private int labelHeight = 50;

    public LableZoomEx(){
        setTitle("Zoom Ex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 300);

        Container c = getContentPane();
        c.setLayout(null);
        label = new JLabel("Zoom Me!");
        label.setBounds(150, 100, labelWidth, labelHeight);
        label.setOpaque(true);
        label.setBackground(Color.CYAN);
        c.add(label);

        // 익명 클래스로 선언하여 이벤트 처리
        c.addMouseWheelListener(new MouseWheelListener() {
            public void mouseWheelMoved(MouseWheelEvent e) {
                int notches = e.getWheelRotation(); // 휠이 움직였을 때 어느 방향으로 움직였는지 감지함.
                int delta = 10; // 변화값

                if(notches < 0){
                    labelWidth += delta;
                    labelHeight += delta;
                }
                else if(notches > 0){
                    labelWidth = Math.max(10, labelWidth-delta);
                    labelHeight = Math.max(10, labelHeight-delta);
                }

                label.setBounds(label.getX(), label.getY(), labelWidth, labelHeight);
                label.setFont(new Font("Arial", Font.PLAIN, Math.max(10, labelHeight/2)));
            }
        });
        setVisible(true);
    }

    public static void main(String[] args){
        new LableZoomEx();
    }
}
```
# 버튼 컴포넌트에 3가지 상태 이미지 씌우기
```java
import javax.swing.*;
import java.awt.*;

public class ButomEx extends JFrame {
    public ButomEx() {
        setTitle("Butom Ex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        ImageIcon nornmalicon = new ImageIcon("./normalIcon.gif"); // 기본 상태의 이미지
        ImageIcon rollovericon = new ImageIcon("./rolloverIcon.gif"); // 마우스가 버튼 위에 있을 때의 이미지
        ImageIcon pressedicon = new ImageIcon("./pressedIcon.gif"); // 마우스가 버튼을 눌렀을 때의 이미지

        JButton btn = new JButton(nornmalicon); // normalalicon 이미지 객체를 기본으로 한 버튼 컴포넌트 객체 생성
        btn.setPressedIcon(pressedicon); // 버튼을 눌렀을 때, pressedicon 이미지 객체로 이미지를 바꾼다.
        btn.setRolloverIcon(rollovericon); // 버튼 위에 마우스가 있다면 rollovericon 이미지 객체로 이미지를 바꾼다.

        // 버튼 컴포넌트는 사각형 버튼을 띄우는 것이 기본이지만 아래 4줄로 사각형 형태의 버튼을 이미지 모양으로 바꿀 수 있다.
        btn.setBorderPainted(false);
        btn.setContentAreaFilled(false);
        btn.setFocusPainted(false);
        btn.setOpaque(false);

        c.add(btn);
        setSize(250, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new ButomEx();
    }
}
```
