package com.xuecheng.manage_cms;

import org.bson.types.ObjectId;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.gridfs.GridFsTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

@SpringBootTest
@RunWith(SpringRunner.class)
public class CmsMongoGridFsTest {

    @Autowired
    GridFsTemplate gridFsTemplate;

    @Test
    public void insertGridFs() throws FileNotFoundException {
        //要存储的文件
        File file = new File("G:\\IdeaProject\\LearnOnline\\xc-service-manage-cms\\src\\main\\resources\\templates\\index_banner.html");
        //定义输入流
        FileInputStream inputStram = new FileInputStream(file);
        //向GridFS存储文件
        ObjectId objectId = gridFsTemplate.store(inputStram, "index_banner_template.html", "");
        //得到文件ID
        String fileId = objectId.toString();
        System.out.println(fileId);
    }
}
