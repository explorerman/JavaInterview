package NIO;

import java.nio.ByteBuffer;

public class ByteBufferTest {
    public static void main(String[] args) {
        //初始化长度为16的ByteBuffer
        ByteBuffer byteBuffer = ByteBuffer.allocate(16);
        ByteBuffer wrap = ByteBuffer.wrap(new byte[16]);
        //向ByteBuffer写入1字节
        byteBuffer.put((byte) 1);
        System.out.println("write 1 byte : position = " + byteBuffer.position() +
                " limit = " + byteBuffer.limit() + " capacity = " + byteBuffer.capacity()
                + " The length of the remaining " + byteBuffer.remaining());
        //写入4字节
        byteBuffer.putInt(33);
        System.out.println("write 4 byte : position = " + byteBuffer.position()
                + " limit = " + byteBuffer.limit() + " capacity = " + byteBuffer.capacity()
                +  " The length of the remaining " + byteBuffer.remaining());
        //使用rewind()复位
        // 该方法仅仅是简单粗暴地将position直接复原到0，limit不变。这样进行读取操作的话，就是从第一个字节开始读取了
        //该方法虽然复位了position，可以从头开始读取数据，但是并未标记处有效数据的结束位置.
        //如本例所述，ByteBuffer总容量为16字节，但实际上只读取了9个字节的数据，因此最后的7个字节是无效的数据。
        // 故rewind()方法常常用于字节数组的完整拷贝。
        //byteBuffer.rewind();
        System.out.println("rewind reset : position = " + byteBuffer.position()
                + " limit = " + byteBuffer.limit() + " capacity = " + byteBuffer.capacity()
                +  " The length of the remaining " + byteBuffer.remaining());
        //使用flip()复位
        //该方法不仅将position复位为0，同时也将limit的位置放置在了position之前所在的位置上，这样position和limit之间即为新读取到的有效数据
        byteBuffer.flip();
        System.out.println("flip reset : position = " + byteBuffer.position()
                + " limit = " + byteBuffer.limit() + " capacity = " + byteBuffer.capacity()
                +  " The length of the remaining " + byteBuffer.remaining());
        //从byteBuffer中读取数据, 读取1个字节
        byte b = byteBuffer.get();
        System.out.println("b = " + b);
        //从byteBuffer中读取数据, 读取4个字节
        int c = byteBuffer.getInt();
        System.out.println("c = " + c);
        //继续写入数据
        //该方法就是将 position 到 limit 之间还未读取的数据拷贝到 ByteBuffer 中数组的最前面，然后再将 position 移动至这些数据之后的一位，
        // 将 limit 移动至 capacity。这样 position 和 limit 之间就是已经读取过的老的数据或初始化的数据，就可以放心大胆地继续写入覆盖了
        byteBuffer.compact();


    }
}
