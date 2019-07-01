package nkw.xz2018;

import java.io.*;

/**
 * @author: fangcong
 * @date: 2019/6/30
 */
public class FileDemo {
    public static void main(String[] args) {
        File file = new File("D:/test.txt");
        File dest = new File("D:/dest.txt");

        try {
            InputStream inputStream = new FileInputStream(file);
            OutputStream outputStream = new FileOutputStream(dest);

            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String s = bufferedReader.readLine();
            String[] strings = s.split(" ");
            String head = strings[0] +" " + strings[1] + " " + strings[2] + "\r\n";
            outputStreamWriter.write(head);
            int count = 0;
            for(int i = 3; i < strings.length; i ++){
                if(count == 3){
                    count = 0;
                    outputStreamWriter.write(strings[i] + "\r\n");
                }else{
                    outputStreamWriter.write(strings[i] + " ");
                    count++;
                }
            }
            outputStreamWriter.flush();
            System.out.println(s);
        } catch (IOException e)  {
            e.printStackTrace();
        }
    }
}
