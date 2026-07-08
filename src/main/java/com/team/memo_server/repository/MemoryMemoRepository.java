package com.team.memo_server.repository;

import com.team.memo_server.domain.Memo;

import java.util.*;

public class MemoryMemoRepository implements MemoRepository {

    private static Map<Long, Memo> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Memo save (Memo memo) {
        memo.setId(++sequence);
        store.put(memo.getId(), memo);
        return memo;
    }

    @Override
    public Optional<Memo> findById(Long id) {
        //Map에는 id로 찾는다.
        // 만약 찾는 id가 없어서 null이 나오더라도, Optional 상자에 안전하게 담아서 반환
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<Memo> findAll() {
        //Map에 저장된 모든 메모를 (store.valu())을 싹 다 긁어모아서
        // 새로운 ArrayList(리스트 형태)로 포장해서 반환
        return new ArrayList<>(store.values());
    }

    @Override
    public List<Memo> findByContent(String content) {
        return store.values().stream()
                .filter(memo -> memo.getContent().equals(content))
                .toList();
    }



    public void clearStore() {
        store.clear();
    }


}
