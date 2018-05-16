package com.yizhen.demo.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
//import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import com.yizhen.demo.utils.RedisUtil;
import redis.clients.jedis.Jedis;

/**
 * redis支持的数据类型：string(字符串),hash(哈希),list(列表),set(集合)及zset(sorted set:有序集合)
 * redis(两个特殊场景外，它是首选)是一个单进程、单线程的基于内存的key-value数据库，不必单进程多线程的同样基于内存的KV数据系统Memcached(优势在于
 * 小型静态数据处理和有横向扩展[需要优化性能时，横向扩展是增加机器数量，而纵向扩展是增加单个机器的性能]需求的场景)差
 * redis的所有数据都是保存在内存中，然后不定期的通过异步方式保存到磁盘上(这称为“半持久化模式”,rdb，记录的书数据)；
 * 也可以把每一次数据变化都写入到一个append only file(aof)里面(这称为“全持久化模式”,aof,记录的是操作)。
 * redis快的主要原因是：
 *   1、完全基于内存
 *   2、数据结构简单，对数据操作也简单
 *   3、使用多路 I/O 复用模型（操作系统为你提供了一个功能，当你的某个socket可读或者可写的时候，它可以给你一个通知。这样当配合非阻塞的socket使用时，
 *      只有当系统通知我哪个描述符可读了，我才去执行read操作，可以保证每次read都能读到有效数据而不做纯返回-1和EAGAIN的无用功。写操作类似。
 *      操作系统的这个功能通过select/poll/epoll/kqueue之类的系统调用函数来使用，这些函数都可以同时监视多个描述符的读写就绪状况，这样，
 *      多个描述符的I/O操作都能在一个线程内并发交替地顺序完成，这就叫I/O多路复用，这里的“复用”指的是复用同一个线程)。
 * @author liuyizhen
 *
 */
public class JedisTest {
	
    private static Jedis jedis;
    
    static {
        //连接redis服务器，192.168.0.100:6379
        jedis = new Jedis("127.0.0.1", 6379);  
    }
  
    /**
     * redis存储字符串
     */
    @Test
    public void testString() {
        //-----添加数据----------  
	    jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
	    System.out.println(jedis.get("name"));//执行结果：xinxin  
	  
	    jedis.append("name", " is my lover"); //拼接
	    System.out.println(jedis.get("name")); 
	  
	    long result = jedis.del("name");  //删除某个键
	    System.out.println("result = " + result);
	    System.out.println(jedis.get("name"));
	    //设置多个键值对
	    jedis.mset("name","liuling","age","23","qq","476777XXX");
	    jedis.incr("age"); //进行加1操作
	    System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));	          
	}

    /**
      * redis操作Map
      */
    @Ignore
    public void testMap() {
        //-----添加数据----------  
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "xinxin");
        map.put("age", "22");
        map.put("qq", "123456");
        //hashMap Set
        String result = jedis.hmset("user",map);
        System.out.println("result = " + result);
        //取出user中的name，执行结果:[minxr]-->注意结果是一个泛型的List  
        //第一个参数是存入redis中map对象的key，后面跟的是放入map中的对象的key，后面的key可以跟多个，是可变参数  
        //hashMap Get
        List<String> rsmap = jedis.hmget("user", "name", "age", "qq");
        System.out.println(rsmap);  
   
        //删除map中的某个键值  
        jedis.hdel("user","age");
        System.out.println(jedis.hmget("user", "age")); //因为删除了，所以返回的是null  
        System.out.println(jedis.hlen("user")); //返回key为user的键中存放的值的个数2 
        System.out.println(jedis.exists("user"));//是否存在key为user的记录 返回true  
        System.out.println(jedis.hkeys("user"));//返回map对象中的所有key  
        System.out.println(jedis.hvals("user"));//返回map对象中的所有value 
   
        Iterator<String> iter=jedis.hkeys("user").iterator();  
        while (iter.hasNext()){  
            String key = iter.next();  
            System.out.println(key+":"+jedis.hmget("user",key));  
        }  
    }
    
    @Ignore  
    public void testList(){  
        //开始前，先移除所有的内容  
        jedis.del("java framework");  
        System.out.println(jedis.lrange("java framework",0,-1));  
        //先向key java framework中存放三条数据,从头部插入
        jedis.lpush("java framework","spring");  
        jedis.lpush("java framework","struts");  
        jedis.lpush("java framework","hibernate");  
        //再取出所有数据jedis.lrange是按范围取出，  
        // 第一个是key，第二个是起始位置，第三个是结束位置，jedis.llen获取长度 -1表示取得所有  
        System.out.println(jedis.lrange("java framework",0,-1));  
         
        jedis.del("java framework");
        //先向key java framework中存放三条数据,从尾部插入
        jedis.rpush("java framework","spring");  
        jedis.rpush("java framework","struts");  
        jedis.rpush("java framework","hibernate"); 
        System.out.println(jedis.lrange("java framework",0,-1));
     }  

    @Ignore 
    public void testSet(){  
        //添加  
        jedis.sadd("user","liuling");  
        jedis.sadd("user","xinxin");  
        jedis.sadd("user","ling");  
        jedis.sadd("user","zhangxinxin");
        jedis.sadd("user","who");  
        //移除noname  
        jedis.srem("user","who");  
        System.out.println(jedis.smembers("user"));//获取所有加入的value  
        System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素  
        System.out.println(jedis.srandmember("user"));  
        System.out.println(jedis.scard("user"));//返回集合的元素个数  
    } 
    
    
    @Ignore  
    public void test() throws InterruptedException {  
        //jedis 排序  
        //注意，此处的rpush和lpush是List的操作。是一个双向链表（但从表现来看的）  
        jedis.del("a");//先清除数据，再加入数据进行测试  
        jedis.rpush("a", "1");  
        jedis.lpush("a","6");  
        jedis.lpush("a","3");  
        jedis.lpush("a","9");  
        System.out.println(jedis.lrange("a",0,-1));// [9, 3, 6, 1]  
        System.out.println(jedis.sort("a")); //[1, 3, 6, 9]  //输入排序后结果  
        System.out.println(jedis.lrange("a",0,-1));  
    } 
    
    @Ignore
    public void testRedisPool() {
        RedisUtil.getJedis().set("newname", "中文测试");
        System.out.println(RedisUtil.getJedis().get("newname"));
    }
}
