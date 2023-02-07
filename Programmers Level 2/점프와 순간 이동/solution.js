function solution(n) {
    var ans = 0;
    let num = n;
    while (num > 0) {
        if (num % 2 === 0) {
            num /= 2;
        } else {
            num--;
            ans++;
        }
    }
    return ans;
}
