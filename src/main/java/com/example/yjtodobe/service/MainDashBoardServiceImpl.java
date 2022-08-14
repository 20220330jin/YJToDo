package com.example.yjtodobe.service;

import com.example.yjtodobe.domain.CustomCode;
import com.example.yjtodobe.exception.HJException;
import com.example.yjtodobe.model.MainDashBoardDto;
import com.example.yjtodobe.repository.MainDashBoardRepositoryManager;
import com.example.yjtodobe.repository.MainDashBoardRepositorySupport;
import com.example.yjtodobe.util.GlobalUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MainDashBoardServiceImpl implements MainDashBoardService {

    final MainDashBoardRepositoryManager mainDashBoardRepositoryManager;

    final MainDashBoardRepositorySupport mainDashBoardRepositorySupport;

    @Override
    public MainDashBoardDto.create create(MainDashBoardDto.createParam createParam) {
        return mainDashBoardRepositoryManager.create(createParam);
    }

    @Override
    public List<MainDashBoardDto.list> list() {
        List<MainDashBoardDto.list> boardList = mainDashBoardRepositorySupport.list();

        return boardList;
    }

    @Override
    public void deleteMainDashboard(MainDashBoardDto.deleteParam param) {
        if(param.getMainDashboardId() == 0L){
            throw new HJException(CustomCode.NOID, "no");
        }
        Long mainDashboardId = param.getMainDashboardId();

        mainDashBoardRepositoryManager.deleteMainDashboard(mainDashboardId);
    }

    @Override
    public void updateMainDashboard(MainDashBoardDto.updateParam param) {
        /**
         * 대시보드 글 수정 기능
         * - id값과 수정 내용을 전달받아 id에 해당하는 글을 불러온 후 content 수정 처리
         * Step1
         * -
         * Validation
         * - request parameter가 null인지 체크
         */

        /**
         * Validation
         * - request param 체크
         */
        if(GlobalUtil.nullCheck(param)){
            throw new HJException(CustomCode.NOID, "필수정보가 입력되지 않았습니다.");
        }

        mainDashBoardRepositoryManager.updateMainDashboard(param);


    }
}
