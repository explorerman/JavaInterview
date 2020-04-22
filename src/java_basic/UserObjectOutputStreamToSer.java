package java_basic;

import java.io.*;

/**
 * @author 李杰
 * @version 1.0
 * @Description
 * 使用ObjectOutputStream序列化和反序列化
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/22 16:56
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class UserObjectOutputStreamToSer {
    public static void main(String[] args) throws Exception {
        SerializePerson();//序列化DataexVO对象
        //反序列DataexVO对象
        DataexVO dataexVO = DeserializePerson();
        System.out.println(dataexVO.getCecfwTitle());
        System.out.println(dataexVO.getRemark());
        System.out.println(dataexVO.getDataexFjVO().getFile());
    }

    private static void SerializePerson() throws FileNotFoundException,
            IOException {
        DataexVO dataexVO = new DataexVO();
        DataexFjVO dataexFjVO = new DataexFjVO();
        dataexVO.setCecfwTitle("123");
        dataexVO.setRemark("备注");
        dataexFjVO.setFile(new File("D:/work/222.pptx"));
        dataexVO.setDataexFjVO(dataexFjVO);
        // ObjectOutputStream 对象输出流，将DataexVO对象存储到E盘的DataexVO.txt文件中，完成对Person对象的序列化操作
        ObjectOutputStream oo = new ObjectOutputStream(new FileOutputStream(
                new File("result.obj")));  //相当于在内存中设置一个虚拟的字符串，用来标识输入和输出用的key
        oo.writeObject(dataexVO);
        System.out.println("dataexVO对象序列化成功！");
        oo.close();
    }

    private static DataexVO DeserializePerson() throws Exception, IOException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(
                new File("result.obj")));
        DataexVO dataexVO = (DataexVO) ois.readObject();
        System.out.println("dataexVO对象反序列化成功！");
        return dataexVO;
    }
}
