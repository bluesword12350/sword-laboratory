package com.huaban.analysis.jieba;

import org.junit.jupiter.api.Test;

class JiebaSegmenterTest {

    @Test
    void processIndex(){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String sentence = "四川成都武侯火车南站街道";
        System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.INDEX));
    }

    @Test
    void processSearch(){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String sentence = "四川成都武侯火车南站街道";
        System.out.println(segmenter.process(sentence, JiebaSegmenter.SegMode.SEARCH));
    }

    @Test
    void sentenceProcess(){
        JiebaSegmenter segmenter = new JiebaSegmenter();
        String sentence = "四川成都武侯火车南站街道";
        System.out.println(segmenter.sentenceProcess(sentence));
    }
}
