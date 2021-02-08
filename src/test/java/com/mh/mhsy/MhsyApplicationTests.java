package com.mh.mhsy;

import com.mh.mhsy.service.IEmailService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
class MhsyApplicationTests {

    /**
     * 注入发送邮件的接口
     */
    @Resource
    private IEmailService mailService;

    /**
     * 测试发送文本邮件
     */
    @Test
    public void sendmail() {
        try{
            mailService.sendSimpleMail("1142080948@qq.com","主题：你好普通邮件","内容：第一封邮件");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    void contextLoads() {
    }

}
