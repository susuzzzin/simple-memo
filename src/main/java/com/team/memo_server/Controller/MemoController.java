package com.team.memo_server.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemoController {

    @GetMapping("/hello")
        public String hello () {
            return "메모장 서버 시작!";
        }


}
