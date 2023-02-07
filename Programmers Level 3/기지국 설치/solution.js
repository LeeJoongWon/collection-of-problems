function solution(sticker) {
    if (sticker.length <= 3) return Math.max(...sticker);

    const len = sticker.length;
    // 1번째 스티커부터 뜯은 경우
    const dp1 = new Array(len).fill(0);
    // 2번째 스티커부터 뜯은 경우
    const dp2 = new Array(len).fill(0);

    dp1[0] = dp1[1] = sticker[0];
    dp2[0] = 0;
    dp2[1] = sticker[1];
    for (let i = 2; i < len - 1; i++) {
        dp1[i] = Math.max(dp1[i - 2] + sticker[i], dp1[i - 1]);
        dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);
    }
    let i = len - 1;
    dp1[i] = Math.max(dp1[i - 1], dp1[i - 2]);
    dp2[i] = Math.max(dp2[i - 2] + sticker[i], dp2[i - 1]);

    return Math.max(dp1[i], dp2[i]);
}
