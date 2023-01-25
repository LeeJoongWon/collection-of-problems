function solution(s) {
    let openCount = 0;
    let closeCount = 0;
    for (let i = 0; i < s.length; i++) {
        switch (s[i]) {
            case '(':
                openCount++;
                break;
            case ')':
                closeCount++;
                if (openCount < closeCount) return false;
                break;
            default:
                break;
        }
    }
    return openCount === closeCount ? true : false;
}
