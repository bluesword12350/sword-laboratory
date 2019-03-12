package top.bluesword.web.laboratory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;
import top.bluesword.web.laboratory.crawler.LiBaiCrawler;

@SpringBootApplication
@MapperScan(basePackages="top.bluesword.web.laboratory.dao")
public class WebLaboratoryApplication {
	public static void main(String[] args) throws Exception {
		SpringApplication.run(WebLaboratoryApplication.class, args);
        new LiBaiCrawler("crawl",false,
                "https://sou-yun.com/PoemIndex.aspx?dynasty=Tang&author=%E6%9D%8E%E7%99%BD").start(1);

        for(int pageIndex = 1; pageIndex < 53; pageIndex++) {
            new LiBaiCrawler("crawl",false,
                    String.format("https://sou-yun.com/PoemIndex.aspx?dynasty=Tang&author=李白&type=All&page=%d",
                            pageIndex)).start(1);
            Thread.sleep(1000);
        }
	}
}