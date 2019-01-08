package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Random;

@EnableScheduling
@EnableJpaAuditing
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class DemoApplication {


    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);


//        for(int i=0; ;i++)
//        {
//            System.out.println("【"+i+"】"+"      【the verification code is】       "+createVerificationCode(10));
//        }

    }


    public static final String createVerificationCode(int verificationCodeLength)
    {
        //    所有候选组成验证码的字符，可以用中文
        String[] verificationCodeArrary={"0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
                "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
                "A","B","C","D","E","F","G","H","I","J", "K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"
        };
        String verificationCode = "";
        Random random = new Random();
        //此处是生成验证码的核心了，利用一定范围内的随机数做为验证码数组的下标，循环组成我们需要长度的验证码，做为页面输入验证、邮件、短信验证码验证都行
        for(int i=0;i<verificationCodeLength;i++){verificationCode += verificationCodeArrary[random.nextInt(verificationCodeArrary.length)];}
        return verificationCode;
    }


}

