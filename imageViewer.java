// 작성하기 위한 import
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.filechooser.*;

public class Main extends JFrame {
    // 클래스 내부에서 활용할 전역 변수&객체 선언부
    private final JLabel imageLabel = new JLabel(); // 이미지를 저장하기 위한 Label 객체 생성
    private final JLabel fileName = new JLabel("없음"); // 파일 이름을 담을 JLabel 객체 / 파일 이름이 들어가기 전까진 "없음" 유지
    private BufferedImage originalImg = null; // 원본 이미지 담을 BufferedImage 객체 / 파일을 넣기 전까지 null 값 유지, 원본 이미지 크가와 sacleF 값으로 비율 조정
    private double scaleF = 1.0; // Scale Factor, 원본 이미지와 같이 사용하여 이미지 비율 조정
    private final int imgAreaSize = 400; // 이미지 영억 사이즈 크기를 상수화하여 고정

    // image Viewer Main Window(생성자)
    public Main() {
        setTitle("ImageViewer"); // Main Window Title 설정
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 창을 닫으면 프로그램 종료, 이 함수가 없으면 백그라운드 실행
        Container c = getContentPane(); // 컴포넌트를 배치할 공간 생성
        c.setLayout(new BorderLayout()); // BorderLayout으로 배치관리자 지정, BorderLayout.CENTER, NORTH, SOUTH 등으로 컴포넌트 위치 지정

        // 상단 UI
        JPanel top = new JPanel(); // 상단에 들어갈 이미지 열기, 이미지 삭제, 파일 이름을 삽입하기 위한 JPanel 객체 선언
        top.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout으로 배치관리자 지정, 왼쪽에서 오른쪽으로 컴포넌트 위치 지정, 공간 부족시 다음 라인으로 이동,
                                                        // FlowLayout.LEFT,CENTER, RIGHT로 정렬위치 지정
        // 이미지 열기 JButton 컴포넌트
        JButton insertButton = new JButton("이미지 열기"); // 이미지 불러오기 위한 Button 객체 생성
        top.add(insertButton); // 상단 UI에 삽입
        // 이미지 닫기 JButton 컴포넌트
        JButton deleteButton = new JButton("이미지 삭제"); // imageLabel에 담겨있는 이미지를 없애기 위한 button 객체 생성
        top.add(deleteButton);// 상단 UI에 삽입
        // 파일 이름 JLabel 컴포넌트
        top.add(new JLabel("파일 이름 : ")); // 고정 값이기 때문에 filename 객체와는 별개로 선언 후 삽입
        top.add(fileName); // 그 뒤에 filename 객체 삽입

        // 이미지 영억 UI
        JPanel bottom = new JPanel(); // 이미지 영역을 담기 위한 JPanel 객체 선언
        bottom.setLayout(new FlowLayout(FlowLayout.LEFT)); // FlowLayout으로 배치 관리자 지정
        bottom.add(imageLabel); // 이미지 영역에 imageLabel 객체 삽입
        imageLabel.setPreferredSize(new Dimension(imgAreaSize, imgAreaSize)); // 이미지 영역을 GUI 상으로 띄우기 위한 함수이며 이미지가 상단 UI와 겹치지 않도록 하는 영역
        imageLabel.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY)); // 이미지 영역의 테두리의 색상을 밝은 회색으로 지정
        imageLabel.setOpaque(true); // 컴포넌트 불투명 여부를 묻는 함수 기본값으로 false(투명)이며 true로 하여 컴포넌트를 불투명하게 함
        imageLabel.setBackground(new Color(254, 254, 251)); // 이미지 영역 BackGround 색을 아이보리색으로 지정
        imageLabel.setHorizontalAlignment(JLabel.CENTER); // JLabel에 담긴 content의 수평 정렬 위치 지정
        imageLabel.setVerticalAlignment(JLabel.CENTER); // JLabel에 담긴 content의 수직 정렬 위치 지정

        // 이벤트 리스너 클래스 삽입부
        insertButton.addActionListener(new ButtonEventListener()); // insertButton 버튼을 눌렀을 때의 이벤트를 처리하기 위한 리스너 클래스 삽입
        deleteButton.addActionListener(new ButtonEventListener()); // deleteButton 버튼을 눌렀을 때의 이벤트를 처리하기 위한 리스너 클래스 삽입
        c.addMouseWheelListener(new ImageReSizeClass()); // 마우스 휠 이벤트 리스너 삽입, 마우스 휠로 입력 받은 이미지를 비율에 맞게 변환

        // UI 삽입부
        c.add(top, BorderLayout.NORTH); // 상단 UI를 북쪽에 위치 시킴
        c.add(imageLabel, BorderLayout.CENTER); // 이미지 영역을 중앙에 위치시킴
        setSize(450,450); // Image Viewer Main Window 사이즈 설정
        setVisible(true); // 실행 시켰을 때, 백그라운드 실행이 아닌 바로 띄우기
    }

    // 버튼 이벤트 리스너 클래스
    // insertButton을 눌렀을 때, 이미지 선택창을 띄우고 파일을 선택하게 함.
    // deleteButton을 눌렀을 때, 현재 선택된 이미지을 이미지 영역에서 지우고 값을 비움
    private class ButtonEventListener implements ActionListener
    {
        private JFileChooser chooser = new JFileChooser(); // 파일을 선택하는 객체

        // 클래스 생성자로 선택지를 한번만 생성하도록 함
        // 이벤트 리스너 함수에 선언하게 되면 버튼을 누를 때마다 FileNameExtensionFilter 객체가 선언되어 동일 내용이 중복 안내함
        public ButtonEventListener() {
            FileNameExtensionFilter filter = new FileNameExtensionFilter("JPG & GIF Images", "jpg", "gif"); // 확장자 JPG와 GIF 확장자를 지원
            chooser.setFileFilter(filter); // filter 객체에 삽입
        }

        @Override // ActionListener는 interface이기 때문에 내부에 선언된 함수를 모두 재정의 해줘야함
        public void actionPerformed(ActionEvent e) {
            JButton b = (JButton)e.getSource(); // 전달 받은 이벤트 객체를 JButton 객체로 다운캐스팅 후 삽입
            if(b.getText().equals("이미지 열기")) // 전달 받은 JButton 객체가 "이미지 열기" 버튼이라면
            {
                int ret = chooser.showOpenDialog(null); // 파일 탐색기 띄우고 파일 경로 입력 받기
                if (ret != JFileChooser.APPROVE_OPTION) { // 파일을 선택하지 않았을 때의 예외처리
                    JOptionPane.showMessageDialog(null,"파일을 선택하지 않았습니다.","경고",JOptionPane.INFORMATION_MESSAGE); // 메세지 창을 띄우고
                    return; // 이벤트 처리 함수 종료
                }

                File selectFile = chooser.getSelectedFile(); // 파일 경로를 담을 File 객체를 선언하고 파일 경로를 삽입
                if(!selectFile.exists()) // 파일 경로가 존재하지 않을 때의 예외처리
                {
                    JOptionPane.showMessageDialog(null,"파일이 존재하지 않습니다.","경고",JOptionPane.INFORMATION_MESSAGE); // 메세지 창을 띄우고
                    return; // 이벤트 처리 함수 종료
                }
                else // 정상적으로 파일 경로를 입력 받았다면
                {
                    imageLabel.setIcon(new ImageIcon(selectFile.getPath())); // 이미지를 imageLabel에 삽입하고
                    originalImg = toBufferedImage(((ImageIcon)imageLabel.getIcon()).getImage()); // 크기 조절을 하기위한 원본 이미지를 저장
                    fileName.setText(selectFile.getName()); // 지금 선택된 파일 이름을 저장
                }
            }
            else if(b.getText().equals("이미지 삭제")) // 누른 버튼이 "이미지 삭제" 버튼이라면
            {
                imageLabel.setIcon(null); // 지금 설정된 이미지를 지우고
                originalImg = null; // 원본 이미지를 지우고
                fileName.setText("없음"); // 선택된 파일 이름을 없음으로 바꾼다.
            }

        }
    }

    // 기존 image를 BufferedImage로 바꾸는 메서드는 없기 때문에 정의해줘야함.
    // 매개변수로 Image를 받아 width, height를 반환받고
    // BufferedImage 객체를 새로 선언한다.
    // 그 후에 Graphics2D 객체를 이용하여 Image를 BufferedImage로 복사 후 반환한다.
    private static BufferedImage toBufferedImage(Image img) {
        int width = img.getWidth(null); // 가로 값 반환받기
        int height = img.getHeight(null); // 세로 값 반환받기
        BufferedImage bimage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB); // 반환받은 값들로 객체 선언

        Graphics2D bGr = bimage.createGraphics(); // BufferenImage에 이미지를 그릴 Graphics2D 객체 생성
        bGr.drawImage(img, 0, 0, null); // 매개변수로 받은 img를 BufferedImage에 복사
        bGr.dispose(); // 그릴 때 사용한 리소스 정리

        return bimage; // Image로 생성된 img를 BufferedImage으로 형 변환 후 반환
    }

    // 마우스 휠 이벤트 리스너 클래스
    // 이미지 영역 안에 있는 이미지를 마우스 휠을 이용하여 비율에 맞게 크기를 조절하는 클래스
    // 원본 이미지인 originalImg와 크기 변환할 때 쓰이는 변수 scaleF를 이용하여 이미지 크기 조절
    // 마우스 휠로 scaleF의 값을 조절하여 크기를 조절함
    private class ImageReSizeClass implements MouseWheelListener {
        @Override
        public void mouseWheelMoved(MouseWheelEvent e) {
            if(originalImg == null) // 이미지가 없을 때 실행되면 안되기 때문에 이미지가 null 값이면
                return; // 이벤트를 실행시키지 말고 바로 종료
            int notches = e.getWheelRotation(); // 마우스 휠 이벤트 감지
            double scaleFDelta = 0.1; // 스케일 변화량
            if (notches < 0) // 감소하는 방향으로 움직인다면
            {
                scaleF -= scaleFDelta; // 스케일 변화값을 0.1 줄인다.
                scaleF = Math.max(scaleF, 0.1); // 너무 작아지면 안되기 때문에 0.1보다 크게 지정
            }
            else if (notches > 0) // 증가하는 방향으로 움직인다면
                scaleF += scaleFDelta; // 스케일 변화값을 0.1 늘린다.

            int newWid = (int) (originalImg.getWidth() * scaleF); // 새로운 가로값 지정
            int newHei = (int) (originalImg.getHeight() * scaleF); // 새로운 세로값 지정
            imageLabel.setIcon(new ImageIcon(originalImg.getScaledInstance(newWid, newHei, Image.SCALE_SMOOTH))); // 크기가 조절된 이미지를 이미지 영역에 띄운다.
        }
    }

    // 메인 함수
    public static void main(String[] args) {
        new Main();
    }
}
