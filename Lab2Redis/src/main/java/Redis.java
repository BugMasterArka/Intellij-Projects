import java.util.*;
import redis.clients.jedis.Jedis;

public class Redis {
    public static void main(String[] args) {
        try{
            Jedis jedis = new Jedis( "127.0.0.1");
            System.out.println( "Connection Successful ");
            System.out.println( "The server is running  " + jedis.ping());

            jedis.hset("products","smartphone", String.valueOf(15000));
            jedis.hset("products","ledtv",String.valueOf(25000));
            jedis.hset("products","shoes",String.valueOf(700));
            jedis.hset("products","headphones",String.valueOf(500));
            jedis.hset("products","toys",String.valueOf(1500));

            Map<String,String> m= jedis.hgetAll("products");
            for(Map.Entry<String,String> e: m.entrySet()){
                System.out.print(e.getKey()+" : "+e.getValue()+"\n");
            }

            jedis.zadd("set-products",15000,"smartphone");
            jedis.zadd("set-products",25000,"ledtv");
            jedis.zadd("set-products",700,"shoes");
            jedis.zadd("set-products",500,"headphones");
            jedis.zadd("set-products",1500,"toys");

            System.out.println(jedis.zrange("set-products",0,25000));

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
