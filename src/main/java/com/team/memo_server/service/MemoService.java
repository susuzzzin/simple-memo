package com.team.memo_server.service;

import com.team.memo_server.domain.Memo;
import com.team.memo_server.repository.MemoRepository;
import com.team.memo_server.repository.MemoryMemoRepository;

import java.util.List;

/*
writeMemo(String content): 메모 내용을 받아서 Memo 객체로 만들고, Repository에 저장을 지시하는 메서드

getMemoList(): Repository에서 메모 목록을 가져와서 전달하는 메서드
 */

//Service는 Repository(창고)를 무조건 가지고 있어야 일 할 수 있다.
public class MemoService {
    private final MemoRepository memoRepository = new MemoryMemoRepository();


    /*
    메모작성 기능 (내용을 받아서 Memo 객체로 만들고 창고에 저장)
     */
    public Long write(String content) {
        Memo memo = new Memo();
        memo.setContent(content);
        memoRepository.save(memo);
        return memo.getId();
    }

    /*
    전체 메모 조회 기능
     */
    public List<Memo> findMemos() {
        return memoRepository.findAll();
    }

}
