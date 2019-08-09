import java.io.*;
import java.net.URL;

/**
 * @author: fangcong
 * @date: 2019/8/9
 */
public class CopyFile {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        String src = "E:/huffman.c";
//        String dist = "E:/copyHuffman.c";
//        FileInputStream in = new FileInputStream(src);
//        FileOutputStream out = new FileOutputStream(dist);
//        byte[] buffer = new byte[512];
//        int cnt;
//        while((cnt = in.read(buffer,0, buffer.length)) != -1){
//            out.write(buffer, 0, cnt);
//        }
//        in.close();
//        out.close();

//        String s = "方聪";
//        byte[] bytes = s.getBytes();
//        byte[] bytes1 = s.getBytes("utf-16be");
//        String str2 = new String(bytes1,"utf-16be");
//        System.out.println(str2);
//        System.out.println(bytes.length);
//        System.out.println(bytes1.length);

//        String src = "E:/huffman.c";
//        FileReader fileReader = new FileReader(src);
//        BufferedReader bufferedReader = new BufferedReader(fileReader);
//        String line;
//        while ((line = bufferedReader.readLine()) != null){
//            System.out.println(line);
//        }
//        bufferedReader.close();


//        A a = new A("fnag", "聪");
////        String objectFile = "E:/copyHufman";
////        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
////        objectOutputStream.writeObject(a);
////        objectOutputStream.close();
////
////
////        ObjectInputStream in = new ObjectInputStream(new FileInputStream(objectFile));
////        A a2 = (A) in.readObject();
////        objectOutputStream.close();
////        System.out.println(a2);

        URL url = new URL("https://www.baidu.com");
        InputStream is = url.openStream();
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(isr);
        String line;
        while((line = br.readLine()) != null){
            System.out.println(line);
        }
        br.close();
    }
}
