package me.debugjoker.dao.cache;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import me.debugjoker.entity.Course;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class RedisDao {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    public final JedisPool jedisPool;

    private RuntimeSchema<Course> schema = RuntimeSchema.createFrom(Course.class);

    public RedisDao(String ip,int port) {
        jedisPool = new JedisPool(ip,port);
    }

    public Course getCourse(long courseId){
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "Course:" + courseId;
                byte[] bytes = jedis.get(key.getBytes());
                if (bytes != null){
                    Course course = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,course,schema);
                    return course;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    public String putCourse(Course course){
        try {
            Jedis jedis = jedisPool.getResource();
            try {
                String key = "Course:" + course.getCourseId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(course,schema,LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                int timeout =  60 * 60;
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

}
