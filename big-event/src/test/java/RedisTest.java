import org.example.BigEventApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest(classes = {BigEventApplication.class})
@RunWith(SpringRunner.class)
public class RedisTest {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;


    @Test
    public void testSet(){
      ValueOperations<String,String> operations= stringRedisTemplate.opsForValue();
      operations.set("username","shanglin");
      System.out.println(operations.get("username"));
    }

//    @Test
//    void testGet(){
//        ValueOperations<String,String> operations= stringRedisTemplate.opsForValue();
//        System.out.println(operations.get("username"));
//    }
}
