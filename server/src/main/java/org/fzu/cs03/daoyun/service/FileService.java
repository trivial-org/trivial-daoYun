package org.fzu.cs03.daoyun.service;

import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.mapper.FileMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/10 12:04
 */
@Service
public class FileService {

    @Autowired
    private FileMapper fileMapper;
    @Autowired
    private ResponseService responseService;

    private final Logger logger = LoggerFactory.getLogger(FileService.class);

    public String updateProfilePhoto(MultipartFile file) throws Exception{
        if (file.isEmpty())
            return "空的";
        String fileName = file.getOriginalFilename();
        String suffixName = fileName.substring(fileName.lastIndexOf("."));

        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        String dateStr = format.format(date);
        fileName = dateStr + "_" + fileName;
//        System.out.println(fileName);
//        System.out.println(suffixName);
        File dest = new File(GlobalConstant.profilePhotoPath + fileName);
        if (!dest.getParentFile().exists())
            dest.getParentFile().mkdir();

        file.transferTo(dest);
        return responseService.responseFactory(StatusCode.RESPONSE_OK,"图像上传成功",fileName);
    }


//    @GetMapping(value = "/file/{fileName}")
//    public ResponseEntity<FileSystemResource> getFile(@PathVariable("fileName") String fileName) throws FileNotFoundException {
//        File file = new File(filePath, fileName);
//        if (file.exists()) {
//            return export(file);
//        }
//        System.out.println(file);
//        return null;
//    }
//
//
//    public ResponseEntity<FileSystemResource> export(File file) {
//        if (file == null) {
//            return null;
//        }
//        HttpHeaders headers = new HttpHeaders();
//        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
//        headers.add("Content-Disposition", "attachment; filename=" + file.getName());
//        headers.add("Pragma", "no-cache");
//        headers.add("Expires", "0");
//        headers.add("Last-Modified", new Date().toString());
//        headers.add("ETag", String.valueOf(System.currentTimeMillis()));
//        return ResponseEntity.ok().headers(headers).contentLength(file.length()).contentType(MediaType.parseMediaType("application/octet-stream")).body(new FileSystemResource(file));
//    }



//    @GetMapping("/profilePhoto")
//    public BufferedImage getProfilePhoto(
//            @RequestParam(value = "profilePhotoName",required = false) String imgPath,
//            HttpServletRequest request, HttpServletResponse response) {
//
//        if (imgPath == null) return null;
//        // 注意关闭流
//        try ( InputStream is = new FileInputStream(GlobalConstant.profilePhotoPath + imgPath) ) {
//            return ImageIO.read(is);
//
//        } catch ( IOException e) {
////            e.printStackTrace();
//        }
//        return null;
//    }


}
