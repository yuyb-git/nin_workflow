package cn.netinnet.workflow.util;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

import javax.imageio.ImageIO;

import cn.netinnet.workflow.common.constant.GlobalConstant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;

public class ImageUtil {

    private static Logger log = LoggerFactory.getLogger(ImageUtil.class);

    private static Boolean DEFAULT_FORCE = false;//建议该值为false

    /**
     * 方法描述 
     * @description： 上传图片
     * @date：2019年3月20日下午3:35:45
     * @author：yuyb
     * @param filePath
     * @param file
     * @param fileName
     * @return String
     */
    public static String imageUpload(String filePath, MultipartFile file, String fileName) {

        File f = new File(filePath);
        if(!f.exists()){
            f.mkdirs();
        }

        String originalName = file.getOriginalFilename();
        String fileType = originalName.substring(originalName.indexOf(".") + 1);

        if (!filePath.endsWith(File.separator) && !filePath.endsWith(StringUtilForFile.SLASH)) {
            filePath += File.separator;
        }

        fileName = fileName + "." + fileType;
        File dest = new File(filePath + File.separator + fileName);

        try {
            file.transferTo(dest);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fileName;
    }

    /**
     * Title: thumbnailImage
     * @Description:       根据图片路径生成缩略图
     * @param imgFile      原图片路径
     * @param w            缩略图宽
     * @param h            缩略图高
     * @param prevfix      生成缩略图的前缀
     * @param force        是否强制按照宽高生成缩略图(如果为false，则生成最佳比例缩略图)
     */
    public static String thumbnailImage(File imgFile, int w, int h, String prevfix, boolean force){
        if(imgFile.exists()){
            try {
                // ImageIO 支持的图片类型 : [BMP, bmp, jpg, JPG, wbmp, jpeg, png, PNG, JPEG, WBMP, GIF, gif]
                String types = Arrays.toString(ImageIO.getReaderFormatNames());
                String suffix = null;
                // 获取图片后缀
                if(imgFile.getName().contains(".")) {
                    suffix = imgFile.getName().substring(imgFile.getName().lastIndexOf(".") + 1);
                }
                // 类型和图片后缀全部小写，然后判断后缀是否合法
                if(suffix == null || types.toLowerCase().contains(suffix.toLowerCase())){
                    log.error("非法的图片格式, 支持以下图片格式: {}." + types);
                    return "";
                }
                log.debug("target image's size, width:{}, height:{}.",w,h);
                Image img = ImageIO.read(imgFile);
                if(!force){
                    // 根据原图与要求的缩略图比例，找到最合适的缩略图比例
                    int width = img.getWidth(null);
                    int height = img.getHeight(null);
                    if((width*1.0)/w < (height*1.0)/h){
                        if(width > w){
                            h = Integer.parseInt(new java.text.DecimalFormat("0").format(height * w/(width*1.0)));
                            log.debug("change image's height, width:{}, height:{}.",w,h);
                        }
                    } else {
                        if(height > h){
                            w = Integer.parseInt(new java.text.DecimalFormat("0").format(width * h/(height*1.0)));
                            log.debug("change image's width, width:{}, height:{}.",w,h);
                        }
                    }
                }
                BufferedImage bi = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
                Graphics g = bi.getGraphics();
                g.drawImage(img, 0, 0, w, h, Color.LIGHT_GRAY, null);
                g.dispose();
                String p = imgFile.getPath();
                // 将图片保存在原目录并加上前缀
                String newFileName = prevfix +imgFile.getName();
                String newFilePath = p.substring(0,p.lastIndexOf(File.separator)) + File.separator + prevfix +imgFile.getName();
                ImageIO.write(bi, suffix, new File(newFilePath));
                return newFileName;
            } catch (IOException e) {
                log.error("生成缩略图失败!", e);
                return "";
            }
        }else{
            log.warn("图片不存在!");
            return "";
        }
    }

    public static String thumbnailImage(String imagePath, int w, int h, String prevfix, boolean force){
        File imgFile = new File(imagePath);
        return thumbnailImage(imgFile, w, h, prevfix, force);
    }

    public static String thumbnailImage(String imagePath, int w, int h, boolean force){
        return thumbnailImage(imagePath, w, h, GlobalConstant.DEFAULT_PREVFIX, force);
    }

    public static String thumbnailImage(String imagePath, int w, int h){
        return thumbnailImage(imagePath, w, h, DEFAULT_FORCE);
    }


}
