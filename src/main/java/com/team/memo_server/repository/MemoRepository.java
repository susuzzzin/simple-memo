package com.team.memo_server.repository;

import com.team.memo_server.domain.Memo;

import java.util.List;
import java.util.Optional;

/*
메모들을 저장할 자바 객체
(예: Map<Long, Memo>)
save(Memo memo): 메모를 창고에 저장하는 메서드
findAll(): 창고에 있는 모든 메모를 꺼내주는 메서드
 */
public interface MemoRepository {
    Memo save(Memo memo);
    Optional<Memo> findById(Long id);
    List<Memo> findByContent(String content);
    List<Memo> findAll();


}
