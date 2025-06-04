# TextField와 TextArea로 문자 입력받고 출력하기
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class TextAreaEx extends JFrame {
    private JTextField tf = new JTextField(20); // 텍스트를 입력할 field 객체 선언
    private JTextArea ta = new JTextArea(7,20); // 입력할 텍스트를 출력할 Area 객체 선언
    private String temp = ""; // 입력한 텍스트를 저장할 string 변수 선언

    public TextAreaEx() {
        setTitle("TextArea Ex");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new FlowLayout());

        c.add(new JLabel("입력 후 <Enter> 키를 입력하세요.")); // 입력 안내문을 JLabel로 입력 후 삽입
        c.add(tf); // textfield 객체 삽입
        c.add(new JScrollPane(ta)); //

        // 익명 클래스로 선언하여 이벤트 처리
        tf.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField t = (JTextField)e.getSource();
                temp += t.getText()+'\n'; // TextField로 입력받은 텍스트를 저장한다.
                ta.setText(temp); // 저장된 텍스트를 TextArea로 출력한다.
                t.setText(""); // 그리고 다음 텍스트를 받을 준비를 한다.
            }
        });

        setSize(300,300);
        setVisible(true);
    }
    public static void main(String[] args) {
        new TextAreaEx();
    }
}
```
# 메뉴바 만들기
```java
import javax.swing.*;

public class MenuEx extends JFrame{
    public MenuEx(){
        setTitle("MenuEx");
        createMenu(); // 함수로 메뉴바를 생성한다.
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,200);
        setVisible(true);
    }

    private void createMenu(){
        JMenuBar mb = new JMenuBar(); // 메뉴바 객체를 생성
        JMenu screenMenu = new JMenu("Screen"); // 메뉴바에 들어갈 내용을 생성

        // 메뉴의 세부 내용 객체 생성
        screenMenu.add(new JMenuItem("Load"));
        screenMenu.add(new JMenuItem("Hide"));
        screenMenu.add(new JMenuItem("ReShow"));

        mb.add(screenMenu); // 메뉴바 객체에 메뉴 객체를 삽입

        setJMenuBar(mb); // 해당 메뉴바를 메인 창에 띄운다.
    }

    public static void main(String [] args){
        new MenuEx();
    }
}
```
# 이미지 불러오기
```java
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class MenuAndFileDialogEx extends JFrame {
    private JLabel imageLabel = new JLabel(); // 이미지를 삽입하기 위한 Label 객체 생성
    public MenuAndFileDialogEx() {
        setTitle("Menu and File");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.add(imageLabel); // 내용 없는 객체 삽입
        creatMenu(); // 메뉴바 생성
        setSize(350,200);
        setVisible(true);
    }

    // 메뉴바 생성 함수
    private void creatMenu() {
        JMenuBar mb = new JMenuBar(); // 메뉴바 객체 생성
        JMenu fileMenu = new JMenu("File"); // File 이라는 이름을 가진 JMenu 객체 생성
        JMenuItem openItem = new JMenuItem("Open"); // file 메뉴 객체 안의 item으로 Open 이라는 이름을 가진 JMenuItem 객체 생성

        openItem.addActionListener(new OpenActionListener()); // openItem 객체를 눌렀을 때의 이벤트처리 클래스 삽입
        fileMenu.add(openItem); // File 이름의 메뉴 객체 안에 Open 이름의 item 객체을 삽입
        mb.add(fileMenu); // 메뉴 바에 File 이름의 메뉴를 삽입
        setJMenuBar(mb); // 메인 스크린에 메뉴 바 삽입
    }

    // Open 메뉴 아이템을 눌렀을 때의 이벤트 처리 클래스 (내부 클래스 선언)
    private class OpenActionListener implements ActionListener {
        private JFileChooser chooser; // 파일을 선택하는 객체

        public OpenActionListener() {
            chooser = new JFileChooser();
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif");
            chooser.setFileFilter(filter);

            int ret = chooser.showOpenDialog(null);
            if (ret != JFileChooser.APPROVE_OPTION) {
                JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            String filePath = chooser.getSelectedFile().getPath();
            imageLabel.setIcon(new ImageIcon(filePath));
            pack();
        }
    }

    public static void main(String[] args) {
        new MenuAndFileDialogEx();
    }
}
```
