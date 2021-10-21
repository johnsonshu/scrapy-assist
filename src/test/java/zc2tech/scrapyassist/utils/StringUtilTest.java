package zc2tech.scrapyassist.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringUtilTest {

    @Test
    void convertSiteUrl2Context() {
        String expect1 = "/mongo/www-womenadvancenc-org";
        String str1 = "https://www.womenadvancenc.org";
        String expect2 = "/mongo/bakusai-com";
        String str2 = "http://bakusai.com/";
        String expect3 = "/mongo/www-moe-gov-cn";
        String str3 = "http://www.moe.gov.cn/";
        String expect4 = "/mongo/www-idcpc-org-cn";
        String str4 = "https://www.idcpc.org.cn/";
        assertEquals(expect1,StringUtil.convert2Context(str1));
        assertEquals(expect2,StringUtil.convert2Context(str2));
        assertEquals(expect3,StringUtil.convert2Context(str3));
        assertEquals(expect4,StringUtil.convert2Context(str4));
    }

    @Test
    void convertImageName2Path() {
        String str01 = "00fe40eec17c807115248c259a12d4137902742784a51ede35ddd3f13952adc4.png";
        String expect01 = "00f/e40/00fe40eec17c807115248c259a12d4137902742784a51ede35ddd3f13952adc4.png";
        assertEquals(expect01,StringUtil.convertImageName2Path(str01));

    }

    @Test
    void convertImagePath2Name() {
        String str01 = "00f/e40/00fe40eec17c807115248c259a12d4137902742784a51ede35ddd3f13952adc4.png";
        String expect01 = "00fe40eec17c807115248c259a12d4137902742784a51ede35ddd3f13952adc4.png";
        assertEquals(expect01,StringUtil.convertImagePath2Name(str01));
    }
}