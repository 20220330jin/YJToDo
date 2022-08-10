package com.example.yjtodobe.service;

import com.example.yjtodobe.model.YjTodoDto;
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
	public List<YjTodoDto.list> list() {
		List<YjTodoDto.list> todoList = yjTodoRepositorySupport.list();

        return todoList;
	}
    @Override
    public void deleteTodo(YjTodoDto.todoDeleteParam param) {
        Long yjTodoId = param.getYjTodoId();
        yjTodoRepositoryManager.deleteYjTodo(yjTodoId);
    }
}

