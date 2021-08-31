package utils;
import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import java.util.Iterator;
import java.util.Set;

public class RedisDBHelper {
    static Jedis js = null;
    public static Logger logger = Logger.getLogger(RedisDBHelper.class);
    private static String hostUrl = BaseInfo.getRedisUrlByEnv("qa");
    private static int hostPort = Integer.parseInt(BaseInfo.HOSTPORT);
//    private static String authPassWord = BaseInfo.getInfo("authPassWord");

    /**
     * connect to redis db and init
     *
     * @return：return if init connection success
     */
    public static boolean init() {
        if (js == null) {
            js = new Jedis(hostUrl, hostPort,5000,5000);
//            js.auth("");
        }
        if (js != null) {
            logger.info("init success");
            js.select(15);
            return true;
        } else {
            return false;
        }
    }


    /**
     * delete cache
     *
     * @param key：need to delete key
     * @return：return boolean to express if delete successfully
     */
    public static boolean delete(String key) {
        if (js.exists(key)) {
            if (js.del(key) == 1) {
                logger.info("delete cache successfully");
                return true;
            } else {
                logger.info("fail to delete cache");
                return false;
            }
        } else {
            logger.info(key + "not available");
            return false;
        }
    }


    /**
     * delete redis cache by keywords
     */
    public static void deleteData(String keys) {
        //connect redis db , initilize
        init();
        Set<String> set = js.keys("*");
        if (set.size() != 0) {
            Iterator<String> it = set.iterator();
            while (it.hasNext()) {
                String key = it.next();
                if (key.contains(keys)) {
                    logger.info(key);
                    delete(key);
                }
            }
        } else {
            logger.info("no data exsit in redis db");
        }
        //close connection
        unInit();
    }


    /**
     * close connection
     */
    public static void unInit() {
        if (js != null) {
            js.close();
            js = null;
        }
    }

    public static void main(String[] args) {
        // just replace student id
        System.out.println("start to delete cache");
        hostUrl = BaseInfo.getRedisUrlByEnv(args[0]);
        System.out.printf("runtime env: %s,keyword: %s%n",args);
        deleteData(args[1]);
        System.out.println("remove cache successfully");
    }
}
