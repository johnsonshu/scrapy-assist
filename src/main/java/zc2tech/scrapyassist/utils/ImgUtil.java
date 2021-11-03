package zc2tech.scrapyassist.utils;


import org.springframework.stereotype.Repository;
import zc2tech.scrapyassist.entity.ImageDownloadResult;

@Repository("imgUtil")
public class ImgUtil {

    public static String findLocalImgPath(String imgSrc, ImageDownloadResult[] dlResults) {
        for (ImageDownloadResult r : dlResults ) {
            if (r.getUrl().equals(imgSrc)) {
                return r.getPath();
            }
        }
        return null;
    }

    /**
     * The external Url to localhost:8080/image/XXXXX
     * @param oldUrl the URL for replacement
     * @param shortUrlContext site name
     * @param dlResults image download results, there are url to download file path in it
     */
    public static String ImgUrl2Local(String oldUrl,String shortUrlContext, ImageDownloadResult[] dlResults) {
        String newPath = null;
        newPath = findLocalImgPath(oldUrl,dlResults);
        if (newPath == null) {
            return "#";
        } else {
            return "/image/" + shortUrlContext + "/"
            + StringUtil.convertImagePath2Name(newPath);
        }

    }
}
