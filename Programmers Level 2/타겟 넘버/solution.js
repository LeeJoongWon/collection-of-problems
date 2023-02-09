function solution(A, B) {
    var answer = 0;

    let ascendArr1 = A.sort((a, b) => a - b);
    let descendArr2 = B.sort((a, b) => b - a);
    answer = ascendArr1.reduce((accumulator, currentValue, index) => {
        return accumulator + currentValue * descendArr2[index];
    }, 0);

    return answer;
}
