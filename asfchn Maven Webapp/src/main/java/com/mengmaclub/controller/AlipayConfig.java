package com.mengmaclub.controller;

import java.io.FileWriter;
import java.io.IOException;

public class AlipayConfig {

	
		
		//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

			// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
			public static String app_id = "2018030702332822";
			
			// 商户私钥，您的PKCS8格式RSA2私钥
		    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCHaZUv/RjWEmoUhhEgAIJNvewNd59JNNtIEJXxIqIzzMTu8SQgLoepPZLPK58wRABtnWiPMl6Mg6XL4cGqVH9gyQk2wLkLRHMR2tuw5rQNrgTVI7ngI934IFdjWKCzU2n+gzRZaQN5wP1agpvYweCvt25ooUWUZyVOVdVP2CwzVEF96g0Z5/a7Ub4tVZP9YIIr00//ymK6ZkmnnoyCZED34QJ7LtGf9k4w8FyML6MMJoJwsLtTaWwwUea1JXPmxFDLhCC2bwUAHOi69OIikt8R70wfMU5zzAA3LtJytQaXZNnQTJrOuzOYYDDc6ReGYGDJRmxjGDpLRlhEweJX+NUzAgMBAAECggEAX/d14ZKvvVdDktQI4vM5ZbtJxamXW5x4I7SNb12qMqfWkbiYb65KOqkGmIhDw0MOQqEh7wo1c8QBBmMyi3Ji68bOHt2qxs919ZtzwwVdaayAhEVTgAQrVaQmCqRPD4f4QIXf3dXMvscFRtX1eUK96ApJ1yEkXK5VBBVUnceIW78ye8jbH7jtRjT+oBp4woJSTQ5LEX0VldwA0n9KimUqKFHErn8FB4C7Y7EUwEmTxOA2z0Ftdg36/vxLA/r+Niqur7VdYnOCWwNqRY+VJPAFYg5SK0CoKrIrCpzWRLGxx6EwCYv9hknzJx+5Z4ZaYMPZCmIkLS3dYix03PNthqHU8QKBgQD2N+85MRTmc0IyuLhN4Du6Vl/uUKUOcVj4QycSk3PsS076ZQziNDcgLCygtULt6ziILDxq+O4fECRbLochKOgAAkKNllDMUbgqhVSz+5sSY64j6YGGYC6PJd2B37J1+251uIVzM/48/mG/q/BJGCA9ysoXpg4FkTdBu+1cqaCPbwKBgQCMyr13NY8kWWCTBcyuckXKq5dLrq6Wr6Di8dfZeeoTzacMSPPqHZz4ADhkwceXRjvAIdEpTMKpdvWRQbAog9mIbk/BiR+d8NKeY97NG+eoxstpyotOzI4qGs9BBcmXsKjMS2PcEcugsGZkMAlGrjJp11h1EDC4GvT03F10Q3P0fQKBgQDBeJhQn2Gl58GHq6CfCOjF9eMxl0rre2OGyPWl4hm//jkUBl1GTfNXI3751RS/cQqd7eyXvf0WiY+X2oqyIruSbjQvn4Lj2f7V4qj5OGbU32DRtUVi+qb7MqzIxacskCJu/ExYhu1qrhTPEOMh/IQxKez9Ai2YcFA0JeBQ5LVWnwKBgGkepr/u+WVGZljfp6dIItvjqh8T2b8gept3vpXd9Ou8TNFbVuKiIaT5ZSG1nXRROCOIHEcdzOoCq+88gG5/o1e+JUZ3P2gJevhP0PaLszfM1euzErhO+oZtZflCfPYJLL78Ox8BGmxryMddJk/jmDh2VNFyuS180xBPyGcaReVxAoGBAI+Sx9xp0sHiHSrmXFVwSRFMpAaep+Jl6oeLrBsDXhd0b6Hoz9ok2ZpAzGhqYGTRAeg9uJMb7Wz/tSEpdIqR+/nHGCF7yAzuzCBzD1iZooX/i6XbSlxjcLgC+3GOB7d6tdnS++ZyEZN2nCL2W4dPlR9EJulN8VszoZuXZgi8YlAz";
			
			// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
		    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjS1DGkOsI+mqxlY6RSH2cTZRiWimeYH4pUSuZMcDFZ0ctcUqfiUZFAD81YpWwjrMqfLVQzUmbTP228m/p6mlkMwaH1fkVM+0LaR9/xp3Hf+wK36zGs7NI6Ft6Pi5ajGI8hwhQ9ndSkCtUQESlN8sB0kLHssf8TwmmYsfOomS4yI3DbO17f0hw9KMP3vUAG9IZi7ROHLl181pLwdD0UkUX8H62IvKS0bDqdgbO2pehn10gHp6BJi1cXFDkvI9WPjguw8ksdD+GN4B+r1br9A1TAC37Og9sNVYrELvtZQVx7TuoAlmTVWCqpNumEbJJVxAaMisbbeKfwhSBdqpFpS2xQIDAQAB";

			// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
			public static String notify_url = "http://asfchn.cn/notify_url.jsp";

			// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
			public static String return_url = "http://asfchn.cn/return_url.jsp";

			// 签名方式
			public static String sign_type = "RSA2";
			
			// 字符编码格式
			public static String charset = "utf-8";
			
			// 支付宝网关
			public static String gatewayUrl = "https://openapi.alipay.com/gateway.do";
			
			// 支付宝网关
			public static String log_path = "C:\\";


		//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

		    /** 
		     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
		     * @param sWord 要写入日志里的文本内容
		     */
		    public static void logResult(String sWord) {
		        FileWriter writer = null;
		        try {
		            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
		            writer.write(sWord);
		        } catch (Exception e) {
		            e.printStackTrace();
		        } finally {
		            if (writer != null) {
		                try {
		                    writer.close();
		                } catch (IOException e) {
		                    e.printStackTrace();
		                }
		            }
		        }
		    }
		}


