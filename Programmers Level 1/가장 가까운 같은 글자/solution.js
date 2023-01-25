function solution(s) {
    let arr = new Map();
    let answer = [];
    for (let i = 0; i < s.length; i++) {
        if (arr.get(s[i]) !== undefined) {
            answer.push(i - arr.get(s[i]));
        } else {
            answer.push(-1);
        }
        arr.set(s[i], i);
    }
    return answer;
}

console.log(solution('aaabbbccc'));
