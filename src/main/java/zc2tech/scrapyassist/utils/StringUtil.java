package zc2tech.scrapyassist.utils;


import org.springframework.stereotype.Repository;

@Repository("stringUtil")
public class StringUtil {

    /**
     * Change String like "http://bakusai.com/"
     * to "/_bakusai_com"
     *
     * @param str
     * @return
     */
    public static String convert2Context(String str) {
        if (str == null) {
            return "";
        }
        String prefix = "/mongo/";
        return prefix + str.replaceAll("/$","")
                .replaceAll("https?://","")
                .replace('.','-');
    }

    /**
     *
     * 00fe40eec17c807115248c259a12d4137902742784a51ede35ddd3f13952adc4.png
     * to 00f/e40/xxxxxxxxxxxxxxx.png
     *
     * @param str
     * @return
     */
    public static String convertImageName2Path(String str) {
        if (str == null || str.length() < 10 ) {
            return "";
        }
        return str.substring(0,3) + "/" + str.substring(3,6) + "/"
                + str;
    }

    /**
     *
     * 00f/e40/xxxxxxxxxxxxxxx.png
     * to xxxxxxxxxxxxxxx.png
     *
     * @param str
     * @return
     */
    public static String convertImagePath2Name(String str) {
        if (str == null || str.charAt(3) != '/' || str.charAt(7) != '/' ) {
            return "";
        }
        return str.substring(8);
    }
}
