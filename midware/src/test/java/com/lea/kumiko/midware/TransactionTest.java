package com.lea.kumiko.midware;

import com.lea.kumiko.midware.entity.Student;
import com.lea.kumiko.midware.service.IStudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.retry.RetryCallback;
import org.springframework.retry.RetryContext;
import org.springframework.retry.support.RetryTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TransactionTest {

    @Autowired
    private IStudentService studentService;
    @Autowired
    private RetryTemplate retryTemplate;

    @Test
    public void testStudentList(){
        List<Student> students = studentService.listAll();
        System.out.println(students.size());
    }

    @Test
    public void testInsert(){
        String name = "kitty";
        Integer age = 14;

        retryTemplate.execute(new RetryCallback<Integer, RuntimeException>() {
            @Override
            public Integer doWithRetry(RetryContext context) throws RuntimeException {
                System.out.println(context);
                studentService.insert(name, age);
                return age;
            }
        });

    }

}
