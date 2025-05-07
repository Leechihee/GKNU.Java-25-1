# FileReader // 텍스트 파일 읽기
```java
import java.io.*;

public class Main {
    public static void main(String[] args) {
        FileReader fr = null;
        try {
            fr = new FileReader("c:\\windows\\system.ini");
            int c;
            while ((c = fr.read()) != -1)
                System.out.print((char) c);
            fr.close();
        }
        catch (IOException e)
        {
            System.out.println("입출력 오류");
        }
    }
}

```
