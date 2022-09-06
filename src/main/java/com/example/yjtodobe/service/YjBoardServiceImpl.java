package com.example.yjtodobe.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.example.yjtodobe.model.YjBoardDto;
import com.example.yjtodobe.model.YjBoardDto.boardAddCountParam;
import com.example.yjtodobe.model.YjBoardDto.boardDeleteParam;
import com.example.yjtodobe.model.YjBoardDto.boardUpdateParam;
import com.example.yjtodobe.repository.YjBoardRepositoryManager;
import com.example.yjtodobe.repository.YjBoardRepositorySupport;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class YjBoardServiceImpl implements YjBoardService{

    final YjBoardRepositoryManager yjBoardRepositoryManager;
   
    final YjBoardRepositorySupport yjBoardRepositorySupport;


    @Override
    public void create(YjBoardDto.createParam createParam) {
       
        if(!createParam.getTitle().equals(null)){

            // db에 저장할 data 전달
            yjBoardRepositoryManager.create(createParam);
        }
    }

    @Override
    public List<YjBoardDto.read> read() {
        
        return yjBoardRepositorySupport.read();
    }

     @Override
    public List<YjBoardDto.read> search(YjBoardDto.searchParam param) {

        String searchKeyword = param.getSearchKeyword();
        String searchType = param.getSearchType();
     
        return yjBoardRepositorySupport.search(searchKeyword, searchType);
    }
    
    @Override
    public YjBoardDto.detailRead detailRead(YjBoardDto.detailReadParam param) {
        return yjBoardRepositorySupport.detailRead(param);
       
    }

    @Override
    public void boardDelete(boardDeleteParam param) {
        yjBoardRepositoryManager.boardDelete(param);

    }

    @Override
    public void boardUpdate(boardUpdateParam param) {
        yjBoardRepositoryManager.boardUpdate(param);
    }
    
    @Override
    public void boardAddCount(boardAddCountParam param) {
        Long boardId = param.getDetailParamId();
        Long count = yjBoardRepositorySupport.boardCountRead(param);
        count = count + 1;

        yjBoardRepositoryManager.boardAddCount(boardId, count);

        // update()
        // set(viewCount, count)
    }

}
