package utils;

public class BaseInfo {

    public static final String QA_REDIS_URL = "cne1qapdredis1.nsmena.ng.0001.cnn1.cache.amazonaws.com.cn";
    public static final String STG_REDIS_URL = "cne1stgpdredis1.nsmena.ng.0001.cnn1.cache.amazonaws.com.cn";
    public static final String PRD_REDIS_URL = "cne1prdpdredis1.nsmena.ng.0001.cnn1.cache.amazonaws.com.cn";
    public static final String HOSTPORT = "6379";

    public static String getRedisUrlByEnv(String env){
        String hostUrl;
        hostUrl = env.startsWith("qa")?QA_REDIS_URL:env.startsWith("stg")?STG_REDIS_URL:PRD_REDIS_URL;
        return hostUrl;
    }
}
