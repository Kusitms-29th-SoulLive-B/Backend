package com.soullive_b.soullive_be.domain.awsS3.controller;

import com.soullive_b.soullive_be.BaseResponse.BaseResponse;
import com.soullive_b.soullive_be.domain.awsS3.service.AwsS3Service;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/s3")
public class AwsS3Controller {
    private final AwsS3Service awsS3Service;
    public AwsS3Controller(AwsS3Service awsS3Service) {
        this.awsS3Service = awsS3Service;
    }

    @PostMapping("/file")
    public BaseResponse<String> uploadFile(@RequestPart(name = "file") MultipartFile image) {
        String fileUrl = awsS3Service.uploadFile(image);
        return new BaseResponse<>(fileUrl);
    }

    @DeleteMapping("")
    public BaseResponse<String> deleteFile(@RequestPart(name = "file") String fileName) {
        awsS3Service.deleteFile(fileName);
        return new BaseResponse<>("성공했습니다.");
    }

}
