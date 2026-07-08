package com.team.memo_server.Controller;

import com.team.memo_server.domain.Memo;
import com.team.memo_server.service.MemoService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MemoController {

    private final MemoService memoService = new MemoService();

    @PostMapping("/memos")
    public String creatMemo(@RequestParam String content) {
        Long memoId = memoService.write(content);

        //브라우저 화면에 결과를 글자로 보여줌
        return memoId + "번 메모가 성공적으로 저장되었습니다!";
    }

    /**
     * * 2. 저장된 모든 메모 가져오기 (Read)
     * * GET 방식으로 http://localhost:8080/memos 주소로 요청이 오면 실행됩니다.
     */
    @GetMapping("/memos")
    public List<Memo> getAllMemos() {
        // "메모 다 긁어와 봐"라고 지시하고 그 목록(List)을 그대로 화면에 던집니다.
        return memoService.findMemos();
        }

}




