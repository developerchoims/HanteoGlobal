package com.geumbang.task2.service.serviceImpl;

import com.geumbang.task2.service.CoinChangeService;
import org.springframework.stereotype.Service;

@Service
public class CoinChangeServiceImpl implements CoinChangeService {
    @Override
    public int getCoinSumWays(int sum, int[] coins) {
        //sumArr 배열을 생성하고 초기화
        int[] sumArr = new int[sum + 1];
        //아무 동전도 사용하지 않으므로 경우의 수는 1
        sumArr[0] = 1;

        //모든 동전 돌면서 sumArr 배열 업데이트
        for (int coin : coins) {
            for (int i = coin; i <= sum; i++) {
                sumArr[i] += sumArr[i - coin];
            }
        }

        return sumArr[sum];
    }
}
