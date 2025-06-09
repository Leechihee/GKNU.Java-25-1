import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.filechooser.*;

public class Main extends JFrame {
    private JLabel imageLabel = new JLabel(); // 이미지를 저장하기 위한 Label 객체 생성
    private JButton insertButton = new JButton("이미지 열기"); // 이미지 불러오기 위한 Button 객체 생성
    private JButton deleteButton = new JButton("이미지 삭제"); // imageLabel에 담겨있는 이미지를 없애기 위한 button 객체 생성
    private JLabel filePath = new JLabel("없음");
    public Main() {
        setTitle("ImageViewer");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());

        JPanel top = new JPanel();
        top.setLayout(new FlowLayout(FlowLayout.LEFT));
        top.add(insertButton);
        top.add(deleteButton);
        top.add(new JLabel("파일 이름 : "));
        top.add(filePath);

        JPanel bottom = new JPanel();
        bottom.setLayout(new FlowLayout(FlowLayout.LEFT));
        bottom.add(imageLabel);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        imageLabel.setVerticalAlignment(JLabel.CENTER);
        JScrollPane scrollPane = new JScrollPane(imageLabel);

        c.add(top, BorderLayout.NORTH);
        c.add(scrollPane, BorderLayout.CENTER);
        setSize(500,500);
        setVisible(true);
    }

    private class ButtonEventListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource();
            if(b.getText().equals("이미지 열기"))

            else if(b.getText().equals("이미지 삭제"))

        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
