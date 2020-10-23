package com.shilin.gulimall.thirdparty;

import com.aliyun.oss.OSSClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

@SpringBootTest
class GulimallThirdPartyApplicationTests {

	@Resource
    private OSSClient ossClient;

	@Test
	public void test() throws FileNotFoundException {
        /*// Endpoint以杭州为例，其它Region请按实际情况填写。
        String endpoint = "http://oss-cn-qingdao.aliyuncs.com";
		// 云账号AccessKey有所有API访问权限，建议遵循阿里云安全最佳实践，创建并使用RAM子账号进行API访问或日常运维，
		// 请登录 https://ram.console.aliyun.com 创建。
        String accessKeyId = "LTAI4G6nFN9mtFxZZzdH1oo2";
        String accessKeySecret = "MZg6gBTghZVlIOLzaYynAIaQpyeTHY";

		// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

		// 上传文件流。

        ossClient.putObject("gulimall-shilin", "illust_57793944_20200806_091052.png", inputStream);

		// 关闭OSSClient。
        ossClient.shutdown();*/
        InputStream inputStream = new FileInputStream("C:\\Users\\shilin\\Desktop\\文档\\新建文件夹\\illust_75863098_20200806_090703.png");
        ossClient.putObject("gulimall-shilin","illust.png",inputStream);
		System.out.println("上传成功");
	}
	@Test
	void contextLoads() {
	}

}
