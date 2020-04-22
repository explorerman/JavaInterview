package java_basic;

import com.alibaba.fastjson.JSONReader;
import com.alibaba.fastjson.JSONWriter;

import java.io.*;

/**
 * @author 李杰
 * @version 1.0
 * @Description
 * 使用fastjson序列化和反序列化
 * @package
 * @file ${fileName.java}
 * @createTime: 创建时间: 2020/4/22 17:03
 * @title 标题:
 * @module 模块: 模块名称
 * @reviewer 审核人
 * @history 修订历史（历次修订内容、修订人、修订时间等）
 */
public class UseFastJsonToSer {

    public static void main(String[] args) throws Exception {
        SerializePerson();//序列化Person对象
        DataexVO dataexVO = DeserializePerson();//反序列Perons对象
        System.out.println(dataexVO.getCecfwTitle());
        System.out.println(dataexVO.getRemark());
        System.out.println(dataexVO.getDataexFjVO().getFile());
        System.out.println(dataexVO.getContact());
    }

    private static void SerializePerson() throws FileNotFoundException, IOException {
        DataexVO dataexVO = new DataexVO();
        DataexFjVO dataexFjVO = new DataexFjVO();
        dataexVO.setCecfwTitle("123");
        dataexVO.setRemark("备注");
        dataexVO.setContact("hahahah");
        dataexFjVO.setFile(new File("D:/work/222.pptx"));
        dataexVO.setDataexFjVO(dataexFjVO);
        JSONWriter writer = new JSONWriter(new FileWriter("result.json"));
        writer.startObject();
        writer.writeObject(dataexVO);
        writer.endObject();
        System.out.println("DataexVO对象序列化成功！");
        writer.close();
    }
    private static DataexVO DeserializePerson() throws Exception, IOException{
        JSONReader reader = new JSONReader(new FileReader("result.json"));
        DataexVO dataexVO = null;
        reader.startObject();
        if(reader.hasNext()){
             dataexVO = (DataexVO) reader.readObject(DataexVO.class);
            System.out.println("DataexVO反序列化成功");
        }else{
            System.out.println("反序列化失败");
        }
        reader.endObject();
        reader.close();
        return dataexVO;
    }

}
