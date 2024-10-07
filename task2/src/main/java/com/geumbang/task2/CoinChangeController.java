package com.geumbang.task2;

import com.geumbang.task2.service.CoinChangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class CoinChangeController {

    @Autowired
    private final CoinChangeService coinChangeService;

    @GetMapping("/coin-change")
    public int getCoinSumWays(@RequestParam int sum, @RequestParam int[] coins) {
        return coinChangeService.getCoinSumWays(sum, coins);
    }
}
