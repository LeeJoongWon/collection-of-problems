function solution(k, m, score) {
    // 정렬
    let arr = [...score];
    arr.sort(function (a, b) {
        return a - b;
    });

    let total = 0; // 최대 이익
    let idx = arr.length % m; //박스(m)를 채울 수 없다면 나머지는 버림
    while (idx < arr.length) {
        total += arr[idx] * m; // 최저 사과점수 X 상자에 담긴 갯수 = 이익
        idx += m; // 상자에 담긴 갯수만큼 건너뜀
    }

    return total;
}
console.log(solution(4, 3, [4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2]));
console.log(solution(3, 4, [1, 2, 3, 1, 2, 3, 1]));
