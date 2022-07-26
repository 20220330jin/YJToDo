package com.example.yjtodobe.service;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.yjtodobe.model.YjBoardDto;
import com.example.yjtodobe.repository.YjBoardRepositoryManager;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class YjBoardServiceImpl implements YjBoardService{

    final YjBoardRepositoryManager yjBoardRepositoryManager;

    @Override
    public void create(YjBoardDto.createParam createParam) {
       
        if(!createParam.getTitle().equals(null)){

            // db에 저장할 data 전달
            yjBoardRepositoryManager.create(createParam);
        }
    }
    
}
