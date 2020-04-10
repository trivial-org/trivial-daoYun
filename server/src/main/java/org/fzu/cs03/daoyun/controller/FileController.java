package org.fzu.cs03.daoyun.controller;


import org.fzu.cs03.daoyun.GlobalConstant;
import org.fzu.cs03.daoyun.StatusCode;
import org.fzu.cs03.daoyun.service.FileService;
import org.fzu.cs03.daoyun.service.ResponseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/10 12:04
 */

@RestController
@CrossOrigin
public class FileController {

    @Autowired
    FileService fileService;
    @Autowired
    ResponseService responseService;
    private final Logger logger = LoggerFactory.getLogger(FileController.class);


    @GetMapping(value = "/profilePhoto", produces = MediaType.IMAGE_JPEG_VALUE)
    public BufferedImage getProfilePhoto(
                @RequestParam(value = "profilePhotoName",required = false) String imgPath,
                HttpServletRequest request, HttpServletResponse response) {

        if (imgPath == null) return null;
        // 注意关闭流
        try ( InputStream is = new FileInputStream(GlobalConstant.profilePhotoPath + imgPath) ) {
            return ImageIO.read(is);

        } catch ( Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @PostMapping("/profilePhoto")
    public String updateProfilePhoto(
            @RequestParam("profilePhoto") MultipartFile file,
            HttpServletRequest request) {
        try {
            return fileService.updateProfilePhoto(file);
        } catch ( Exception e) {
//            e.printStackTrace();
            return responseService.responseFactory(StatusCode.RESPONSE_ERR,e.toString());
        }
    }






}
