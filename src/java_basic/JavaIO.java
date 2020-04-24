package java_basic;

import java.io.*;

/**
 * http通过json传输文件（参考io文件拷贝源码，使用byte数组来传输）
 * json只能传输String等基本数据，所以可以将byte转成字符串
 * 如下代码将文件FileInputStream转成ByteArrayOutputStream.toByteArray后进行传输，可以装在json里
 */
public class JavaIO {
    public static long start = System.currentTimeMillis();

    public static void main(String[] args) throws IOException {
        d();
    }

    public static void a() throws IOException {
        FileReader fileReader = new FileReader(new File("/Users/lijie/IdeaProjects/123.docx"));
        FileWriter fileWriter = new FileWriter(new File("/Users/lijie/IdeaProjects/learngit/123.docx"));
        int read;
        while ((read = fileReader.read()) != -1) {
            fileWriter.write(read);
        }
        fileReader.close();
        fileWriter.close();
    }

    public static void b() throws IOException {
        // 读取文件
        FileInputStream fileInputStream = new FileInputStream("D:\\work\\一个大点的文件.doc");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i;
        while ((i = fileInputStream.read()) != -1) {
            byteArrayOutputStream.write(i);
        }
        fileInputStream.close();
        // 把文件存在一个字节数组中
        byte[] filea = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.close();

        String fileaString = new String(filea, "ISO-8859-1");
        System.out.println("cost: " + (System.currentTimeMillis() - start));
//        System.out.println(fileaString);
        // 写入文件
        FileOutputStream fileOutputStream = new FileOutputStream("D:/work/new/一个大点的文件.doc");
        fileOutputStream.write(fileaString.getBytes("ISO-8859-1"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    public static void c() throws IOException {
        // 读取文件
        FileInputStream fileInputStream = new FileInputStream("D:\\work\\一个大点的文件.doc");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[2048];
        while (true) {
            int temp = fileInputStream.read(bytes);
            if (temp == -1) {
                break;
            }
            byteArrayOutputStream.write(bytes, 0, temp);
        }
        fileInputStream.close();
        // 把文件存在一个字节数组中
        byte[] filea = byteArrayOutputStream.toByteArray();
        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();

        String fileaString = new String(filea, "ISO-8859-1");
        System.out.println("cost: " + (System.currentTimeMillis() - start));
//        System.out.println(fileaString);
        // 写入文件
        FileOutputStream fileOutputStream = new FileOutputStream("D:/work/new/一个大点的文件.doc");
        fileOutputStream.write(fileaString.getBytes("ISO-8859-1"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }

    //废弃不可用
    public static void d() throws IOException {
    // 读取文件
        FileInputStream fileInputStream = new FileInputStream("D:\\work\\一个大点的文件.doc");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(objectOutputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
        char[] bytes = new char[2048];
//        byte[] bytes = new byte[2048];
        while (true) {
            int temp = bufferedReader.read(bytes);
            if (temp == -1) {
                break;
            }
            bufferedWriter.write(bytes, 0, temp);
//            byteArrayOutputStream.write(bytes,0, temp);
        }
        fileInputStream.close();
        // 把文件存在一个字节数组中
        byte[] filea = byteArrayOutputStream.toByteArray();

        byteArrayOutputStream.flush();
        byteArrayOutputStream.close();
        bufferedReader.close();
        inputStreamReader.close();
        bufferedWriter.close();
        objectOutputStream.close();
        outputStreamWriter.close();
        String fileaString = new String(filea, "ISO-8859-1");
        System.out.println("cost: " + (System.currentTimeMillis() - start));
//        System.out.println(fileaString);
        // 写入文件
        FileOutputStream fileOutputStream = new FileOutputStream("D:/work/new/一个大点的文件.doc");
        fileOutputStream.write(fileaString.getBytes("ISO-8859-1"));
        fileOutputStream.flush();
        fileOutputStream.close();
    }
}
