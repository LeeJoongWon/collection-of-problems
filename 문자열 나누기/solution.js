function solution(s) {
    let same = 1,
        other = 0,
        count = 1,
        point = s[0];
    for (let i = 1; i < s.length; i++) {
        if (same === other) {
            point = s[i];
            same = 1;
            other = 0;
            count++;
        } else if (point === s[i]) {
            same++;
        } else {
            other++;
        }
    }
    return count;
}
