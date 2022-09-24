package com.example.yjtodobe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.yjtodobe.model.ImageFileDto;
import com.example.yjtodobe.model.ImageFileDto.boardDeleteParam;
import com.example.yjtodobe.repository.ImageFileRepositoryManager;
import com.example.yjtodobe.repository.ImageFileRepositorySupport;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ImageFileServiceImpl implements ImageFileService {

    final ImageFileRepositorySupport imageFileRepositorySupport;
    final ImageFileRepositoryManager imageFileRepositoryManager;

    @Override
    public ImageFileDto.detailRead detailRead(ImageFileDto.detailReadParam param) {
        
        return imageFileRepositorySupport.detailRead(param);
    }

    @Override
    public void boardDelete(boardDeleteParam param) {
        imageFileRepositoryManager.boardDelete(param);
    }

    @Override
    public List<ImageFileDto.read> read() {
        
        return imageFileRepositorySupport.read();
    }
    
}
