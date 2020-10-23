package com.shilin.gulimall.product;

import com.shilin.gulimall.product.service.BrandService;
import com.shilin.gulimall.product.service.CategoryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.io.FileNotFoundException;
import java.util.Arrays;

@SpringBootTest
@Slf4j
class GulimallProductApplicationTests {

    @Resource
    BrandService brandService;

    @Resource
//    private OSSClient ossClient;

    @Autowired
    private CategoryService categoryService;

    @Test
    public void test2(){
        Long[] catelogPath = categoryService.findCatelogPath(225L);
        log.info("路径：*****" + Arrays.toString(catelogPath));
    }
    @Test
    public void test1() throws FileNotFoundException {
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
        /*InputStream inputStream = new FileInputStream("C:\\Users\\shilin\\Desktop\\文档\\新建文件夹\\illust_75863098_20200806_090703.png");
        ossClient.putObject("gulimall-shilin","illust_75863098_20200806_090703.png",inputStream);*/
        System.out.println("上传成功");
    }

    @Test
    void contextLoads() {
        /*BrandEntity brandEntity = new BrandEntity();
//		brandEntity.setName("华为");
//		brandService.save(brandEntity);
//		brandEntity.setBrandId(1L);
//		brandEntity.setDescript("华为1");
//		brandService.updateById(brandEntity);
        List<BrandEntity> brandEntities = brandService.list(new QueryWrapper<BrandEntity>().eq("brand_id", 1));
        brandEntities.forEach(System.out::println);*/
    }

}
