package com.example.yjtodobe.api;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.yjtodobe.domain.ImageFile;
import com.example.yjtodobe.repository.ImageFileRepository;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("image")
@CrossOrigin("http://localhost:3002")

public class ImageFileRestController {
    private final ImageFileRepository imagefileRepository;
    String filepath = "C:/Users/dudwh/Desktop/YJToDoBE/src/main/resources/static/images/";  // 이미지 파일 저장할 위치path , 본인 로컬 프로젝트 내 resources 폴더에 이미지가 저장되기때문에 path 수정필요합니다

    @PostMapping("/upload")
    public ImageFile uploadImage(HttpServletRequest request,
                                  @RequestParam(value="file", required = false) MultipartFile[] files,
                                  @RequestParam(value="comment", required = false) String comment) {


        String originFileName = files[0].getOriginalFilename();
        long fileSize = files[0].getSize();
        String safeFile = System.currentTimeMillis() + originFileName;

        File f1 = new File(filepath + safeFile);
        try {
            files[0].transferTo(f1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ImageFile file = ImageFile.builder()
                .imageFilename(safeFile)
                .build();

        return imagefileRepository.save(file);
    }

}
