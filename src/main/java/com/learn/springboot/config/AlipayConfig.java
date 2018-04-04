package com.learn.springboot.config;

/**
 * 阿里支付config
 * Created by ThinkPad on 2018/3/22.
 */
public class AlipayConfig {

    private static String baseUrl = "http://1f31d8cc.ngrok.io";
    // 商户appid
    public static String APPID = "2016101900725525";
    // 私钥 pkcs8格式的
    public static String RSA_PRIVATE_KEY = "MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQCXmZhZaegASo6jTXqOlGNMa12XKCWJL5rMMyEo6SjBp8WkOLTPFTAaJTKId7zloVii3DGn9C8t+uJJ20HxTsP/Ys8PMaDTrarL0CxO25/+4ELC275BBVWgxkvnXnUZZcX8Nmj3k9GTdPqjYNmmR/X017FsCgpoVyfCdNsdZfw5BJouLttl3uxvfEkS/7mbDXsPVSEFfgjVsS7y2k09DUvV4dnv92khtvdeLtrXp2hcklU78bdvoYC22aGY0vM/u4VWLzUVSbrcxbMJR0xbVXv7sJXg0JGAaNom6Pcwcl3duyewq4v9YCEEBW0F19ytqvNkio6Vx8XaSdZUHZ2X5QXpAgMBAAECggEAVsQE6x/vNcN2Uca1X0dUcdd9UFcc7KB/Y2HcF7MirXudZblC2sbQqhYiDvMg/PhUZ5nJHcxm+FUAEK9Z1Yd0LAXcZmDMIHrkJxR1V4jh0Jl//FCSWlp4QLVdmgV41dlm8Ewf1ZsXtuKb1MhIqZ/ECKcul5xDiqZfTi9dfTzyl5rGEDvWlwKt6LKgL0vzuagcwxoN5azsuYd39gKnls6Af31+NFYHj5QIrAwfBxrDCeKIImMmcNgfniraBka7FdEL/7KC4vLXGSJVMg1bqpmWz0bqQbO6MWpkff4LjWtVdQyMn3/J8DWXs394M+Nr+iC455gZ5Dv8U0ntk++TnqPRJQKBgQDMTxjuI3KzpMMkU5YSwWkT4k+Ee1TSEm/hWfmkfAcbRMWSCrgo8B/54089M0q9yM0/dGBs4W9dYQNVFiRoIQWkzPmXA7oqt0pDKQL4Sv72UsCPotNQZWUVarlyW0JGYvmomACggaLAbqnyYW1SNPYg3+g0Dco61Rpey60t8JDNlwKBgQC99JXNPomXKnKKF9R72SwhKAw31pbAvcC3WsP/LtoXU/OSVlYRSbgTgPg7sAxAuvLOSbZKd33wwoXBYaL+NqiYywNMotOZ+YFtWSCn5xsyN9CLMIKMP4SOst9jqrItd5bH5gsp1jqr+Nn4KK5T+EukP8NGNffR4fWv6JwQlFo4fwKBgCwP6vqA3p3rrMJK3JTS7YyCRE/4IUTlAQgC1ZopvYaeAFYMxcbecqb75Pz38OiZQ9qpiJoyzEfBQmy5R8TFSmhOZI2zGhVYTkXJtIBD/FS3aBwSK6ytEW3bBH+rOtHfSqSXk5sKGkWSGEjTxjXyghp476U6TCEAEJ3dI05DEZelAoGBAKRtCBKulHkmhBknAYXm+f0FZnYbKUlTt3K/fbLxQlU5FTjRxRSX5F/1nmpEPIb3jF+mjMWu43Q5XYCEXIuCkrQX3xZCR7obsL4PjWXpdbAlgj5J0mdGQB8plJb4Vd1njDwi0/z19LmR4lOeGzCSWB+oFgc7hfXGi14mkpkDYYlPAoGAMGJ7xYqvSVtJL1IeUcAhM3MYMKl3xTu5kM0yaotVHwqBAX6uE02QtzmuFGrfSa99m8khTrC3wL7bI0CR80ujYz+irwezqMjXGeEsbiabu7w4FiPgqodU4O/85WMDnOujRiZCNO9ZCC7ZzkMG8421RDMnZ2jjmpDrPWO+l/0Mr34=";
    // 服务器异步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = baseUrl+"/alipay/notifyUrl";
    // 页面跳转同步通知页面路径 需http://或者https://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问 商户可以自定义同步跳转地址
    public static String return_url = baseUrl+"/alipay/returnUrl";
    // 请求网关地址
    //public static String URL = "https://openapi.alipay.com/gateway.do";
    // 沙箱网关地址
    public static String URL = "https://openapi.alipaydev.com/gateway.do";
    // 编码
    public static String CHARSET = "UTF-8";
    // 返回格式
    public static String FORMAT = "json";
    // 支付宝公钥
    public static String ALIPAY_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAreV6WD6ZOCFybGPoc60urxtvWM9vCgXaePrGEOZZUj8A7gTkwH0txMwYh1ocJTCgqRX4Hc42fJYG0QnoA2X2ZDsxI3to3wATOlTmwUm9K4yXHfGBb6if/O7gt59VAoc5k/Rv6HKZiSMTNAoL2SOZx2hVqDNdtojnxIdSZC0eyimVBFOUqkeWy0tbO9EUGkaEkCFk4v5CL4fs2e/5fu8u4UJbO/mFIcRgh0lZlLcP4JTXCoudihQMMFg9J+26nt4OKV2NkECXkH5c3CtpJknl8EHRq1PEdb6QrGwJvSAQDW7sVaUb5iw6G+wB6DV6py+1NitSznC9/BTpyQXFbZ2vDwIDAQAB";
    // 日志记录目录
    public static String log_path = "/log";
    // RSA2
    public static String SIGNTYPE = "RSA2";

}
