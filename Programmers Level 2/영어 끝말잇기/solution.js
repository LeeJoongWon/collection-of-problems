function solution(n, words) {
    const dupCheck = new Set();
    dupCheck.add(words[0]);

    for (let i = 1; i < words.length; i++) {
        let pre = words[i - 1];
        let cur = words[i];

        if (pre[pre.length - 1] !== cur[0]) return [(i % n) + 1, Math.floor(i / n) + 1];
        if (dupCheck.has(cur)) return [(i % n) + 1, Math.floor(i / n) + 1];

        dupCheck.add(cur);
    }

    return [0, 0];
}
