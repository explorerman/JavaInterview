package java_basic;

import java.io.*;

/**
 * 如下代码将文件FileInputStream转成ByteArrayOutputStream.toByteArray后进行传输，可以装在json里
 */
public class test {

    public static void main(String[] args) throws IOException {
        // 读取文件
        FileInputStream fileInputStream = new FileInputStream("/Users/lijie/IdeaProjects/123.docx");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        while ((i = fileInputStream.read()) != -1) {
            byteArrayOutputStream.write(i);
        }
        fileInputStream.close();
        // 把文件存在一个字节数组中
        byte[] filea = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();

        String fileaString = new String(filea,"ISO-8859-1");
        System.out.println(fileaString);
        // 写入文件
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/lijie/IdeaProjects/learngit/123.docx");
        fileOutputStream.write(fileaString.getBytes("ISO-8859-1"));
        fileOutputStream.flush();
        fileOutputStream.close();

        a();
    }

    public static void  a () throws IOException {
        FileReader fileReader = new FileReader(new File("/Users/lijie/IdeaProjects/123.docx"));
        FileWriter fileWriter = new FileWriter(new File("/Users/lijie/IdeaProjects/learngit/123.docx"));
        int read;
        while ((read = fileReader.read()) != -1){
            fileWriter.write(read);
        }
        fileReader.close();
        fileWriter.close();
    }

}
