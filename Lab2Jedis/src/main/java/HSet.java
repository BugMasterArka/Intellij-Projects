import java.util.*;
import redis.clients.jedis.Jedis;

public class HSet {
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

        }catch(Exception e){
            System.out.println(e);
        }
    }
}
