package com.example.yjtodobe.service;

import com.example.yjtodobe.model.YjTodoDto;
import com.example.yjtodobe.model.YjTodoDto.todoCheckParam;
import com.example.yjtodobe.model.YjTodoDto.todoEditParam;
import com.example.yjtodobe.repository.YjTodoRepositoryManager;
import com.example.yjtodobe.repository.YjTodoRepositorySupport;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class YjTodoServiceImpl implements YjTodoService {

    final YjTodoRepositoryManager yjTodoRepositoryManager;

    final YjTodoRepositorySupport yjTodoRepositorySupport;

    @Override
    public YjTodoDto.create create(YjTodoDto.createParam createParam) {
        return yjTodoRepositoryManager.create(createParam);
    }

	@Override
	public YjTodoDto.listAll list() {
		List<YjTodoDto.list> todoList = yjTodoRepositorySupport.list();
        YjTodoDto.listAll listAll = new YjTodoDto.listAll();

        int totalCount = todoList.size();

        int checkedCount = 0;
        for(YjTodoDto.list todoItem : todoList){
            if(todoItem.getCompletedYn() == 'Y'){
                checkedCount++;
            }
        }

        listAll.setList(todoList);
        listAll.setTotalCount(totalCount);
        listAll.setCheckedCount(checkedCount);

        return listAll;
	}
    @Override
    public void deleteTodo(YjTodoDto.todoDeleteParam param) {
        Long yjTodoId = param.getYjTodoId();
        yjTodoRepositoryManager.deleteYjTodo(yjTodoId);
    }

    @Override
    public void checkTodo(todoCheckParam param) {
        // case1. completedyn 이 y 일때 n으로 변경
        // case2. completedyn 이 n 일때 y로 변경
        // 디비버르 ㄹ보면 알수있다.
        // 셀렉트 컴프리티드 와이앤 프롬 투두 웨얼을 아이디

        Long todoId = param.getYjTodoId();
        
        char completedYn = yjTodoRepositorySupport.checkTodo(todoId);
        if(completedYn == 'Y'){
            completedYn = 'N';
        }else if(completedYn == 'N'){
            completedYn = 'Y';
        }
        
        yjTodoRepositoryManager.checkTodo(todoId, completedYn);
    }

    @Override
    public void editTodo(todoEditParam param) {
        yjTodoRepositoryManager.editTodo(param);
    }

    
}

