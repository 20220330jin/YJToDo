package com.example.yjtodobe.api;

import lombok.RequiredArgsConstructor;
import lombok.Value;

import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.example.yjtodobe.domain.ImageFile;
import com.example.yjtodobe.model.ImageFileDto;
import com.example.yjtodobe.repository.ImageFileRepository;
import com.example.yjtodobe.service.ImageFileService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.*;
import java.net.URLEncoder;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("image")
@CrossOrigin("http://localhost:3002")

public class ImageFileRestController {

    final ImageFileService imageFileService;
    final ImageFileRepository imageFileRepository;
    
    String filepath = "C:/Users/dudwh/Desktop/YJToDoBE/src/main/resources/static/images/";  // 이미지 파일 저장할 위치path , 본인 로컬 프로젝트 내 resources 폴더에 이미지가 저장되기때문에 path 수정필요합니다

    @PostMapping("/upload")
    public ImageFile uploadImage(HttpServletRequest request,
                                  @RequestParam(value="file", required = false) MultipartFile[] files,
                                  @RequestParam(value="comment", required = false) String comment) {

        String originFileName = files[0].getOriginalFilename();
        String safeFile =  + System.currentTimeMillis() + originFileName; // 중복된 이름이 있을경우를 대비하여 

        File f1 = new File(filepath + safeFile);
        try {
            files[0].transferTo(f1);
        } catch (IOException e) {
            e.printStackTrace();
        }

        final ImageFile file = ImageFile.builder()
                .imageFilename(safeFile)
                .delYn('N')
                .useYn('Y')
                .build();

        return imageFileRepository.save(file);
    }
    // @GetMapping("/read")
    // public List<ImageFile> findAllImages() { return imageFileRepository.findAll(Sort.by(Sort.Direction.DESC, "CreateDateTime")); }

    @GetMapping("read")
    public List<ImageFileDto.read> read() {
        return imageFileService.read();
    }

    @GetMapping("/detail")
    public ImageFileDto.detailRead detailRead(@ModelAttribute ImageFileDto.detailReadParam param) {
        return imageFileService.detailRead(param);
    }    

    @GetMapping("/download")
    public List<ImageFile> downloadImage(
            HttpServletRequest request,
            HttpServletResponse response,
            @RequestParam(value="imageFilename", required = true) String imageFilename) {

        File file = new File(filepath+imageFilename);

        FileInputStream fis = null;    // FileInputStream 는 InputStream 를 상속받았으며, 파일로 부터 바이트로 입력받아, 바이트 단위로 출력할 수 있는 클래스
        BufferedInputStream bis = null;  
        ServletOutputStream sos = null;

        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            sos = response.getOutputStream();

            // String originFileName = files[0].getOriginalFilename();

            String reFilename = "";
            // IE로 실행한 경우인지 -> IE는 따로 인코딩 작업을 거쳐야 함
            boolean isMSIE = request.getHeader("user-agent").indexOf("MSIE") != -1 || request.getHeader("user-agent").indexOf("Trident") != -1;

            if(isMSIE) {
                reFilename = URLEncoder.encode(imageFilename, "utf-8");
                reFilename = reFilename.replaceAll("\\+", "%20");
            }
            else {
                reFilename = new String(imageFilename.getBytes("utf-8"), "ISO-8859-1");
            }

            response.setContentType("application/octet-stream;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment;filename=\""+reFilename+"\"");
            response.setContentLength((int)file.length());

            int read = 0;
            while((read = bis.read()) != -1) {
                sos.write(read);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return null;
    }

    @PutMapping("/delete")
    public void delete(@RequestBody ImageFileDto.boardDeleteParam param){
        imageFileService.boardDelete(param);
    }
}
