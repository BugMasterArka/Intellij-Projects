import java.util.*;
import redis.clients.jedis.Jedis;
public class Redis2 {
    public static void main(String[] args) {
        try{
            Jedis jedis = new Jedis( "127.0.0.1");
            System.out.println( "Connection Successful ");
            System.out.println( "The server is running  " + jedis.ping());

            jedis.hset("prog","java",String.valueOf(87));
            jedis.hset("prog","c++",String.valueOf(84));
            jedis.hset("prog","python",String.valueOf(90));
            jedis.hset("prog","c",String.valueOf(70));

            Map<String,String> m= jedis.hgetAll("products");
            for(Map.Entry<String,String> e: m.entrySet()){
                System.out.print(e.getKey()+" : "+e.getValue()+"\n");
            }

            jedis.zadd("langs",87,"java");
            jedis.zadd("langs",84,"c++");
            jedis.zadd("langs",90,"python");
            jedis.zadd("langs",70,"c");

            System.out.println(jedis.zrange("langs",0,10));

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
