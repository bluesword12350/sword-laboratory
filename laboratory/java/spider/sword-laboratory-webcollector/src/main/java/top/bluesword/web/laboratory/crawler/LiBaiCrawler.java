package top.bluesword.web.laboratory.crawler;

import cn.edu.hfut.dmic.webcollector.model.CrawlDatums;
import cn.edu.hfut.dmic.webcollector.model.Page;
import cn.edu.hfut.dmic.webcollector.plugin.berkeley.BreadthCrawler;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.nodes.Element;
import top.bluesword.web.laboratory.dao.PoetryMapper;
import top.bluesword.web.laboratory.entity.Poetry;
import top.bluesword.web.laboratory.util.SpringUtil;

public class LiBaiCrawler extends BreadthCrawler {

    private PoetryMapper poetryMapper;

    public LiBaiCrawler(String crawlPath, boolean autoParse,String seed){
        super(crawlPath, autoParse);
        poetryMapper = SpringUtil.getBean(PoetryMapper.class);
        this.addSeed(seed);
    }

    @Override
    public void visit(Page page, CrawlDatums crawlDatums) {

        String title = null;
        for (Element element : page.select("[id^='item']")) {
            String titleText = element.select(".title").text();
            titleText = titleText.substring(0,titleText.indexOf("（唐·李白）")).replaceAll("　"," ").trim();
            if (StringUtils.isBlank(title) || !titleText.startsWith("其")){
                title = titleText;
            }else {
                title+=titleText;
            }
            Poetry poetry = new Poetry();
            poetry.setTitle(title);
            String content = element.select(".content").text();
            poetry.setContent(content);
            Poetry key = poetryMapper.selectByPrimaryKey(content);
            if (key==null) poetryMapper.insert(poetry);
            else poetryMapper.updateByPrimaryKey(poetry);
        }
    }
}
