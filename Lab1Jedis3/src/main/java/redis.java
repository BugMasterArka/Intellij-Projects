import java.util.*;

import redis.clients.jedis.Jedis;
public class redis {
    public static void main(String[] args) throws Exception{
        try {
            Jedis jedis = new Jedis( "127.0.0.1");
            System.out.println( "Connection Successful ");
            System.out.println( "The server is running  " + jedis.ping());
            jedis.set( "company-name ",  "500Rockets.io ");
            jedis.set( "company-name1 ",  "400Rockets.io ");
            jedis.lpush( "tutorial-list ",  "Redis ");
            jedis.lpush( "tutorial-list ",  "Mongodb ");
            jedis.lpush( "tutorial-list ",  "Mysql ");
            List<String> list = jedis.lrange( "tutorial-list ", 0 ,5);
            for(int i = 0; i<list.size(); i++) {
                System.out.println( "Stored string in redis::  "+list.get(i));
            }
            System.out.println( "Stored string in redis:  "+ jedis.get( "company-name "));
        }catch(Exception e) {
            System.out.println(e);
        }
    }
}