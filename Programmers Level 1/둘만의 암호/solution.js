function solution(s, skip, index) {
    var answer = '';
    let charArr = [];
    let skipArr = [];

    // 알파벳 to 아스키코드
    for (let i = 0; i < s.length; i++) {
        charArr.push(s.charCodeAt(i) % 97);
    }

    // 알파벳 to 아스키코드
    for (let i = 0; i < skip.length; i++) {
        skipArr.push(skip.charCodeAt(i) % 97);
    }

    for (let i = 0; i < charArr.length; i++) {
        let count = 0;

        while (count < index) {
            charArr[i]++;
            if (charArr[i] === 26) charArr[i] = 0;
            if (!skipArr.includes(charArr[i])) count++;
        }

        answer += String.fromCharCode(charArr[i] + 97);
    }
    return answer;
}

console.log(solution('ybcde', 'az', 1));
