function solution(A, B) {
    const arrA = A.sort((a, b) => a - b);
    const arrB = B.sort((a, b) => a - b);

    let count = 0;
    let pointer = 0;
    for (let i = 0; i < arrA.length; i++) {
        while (pointer < arrB.length) {
            if (arrA[i] < arrB[pointer]) {
                count++;
                arrB[pointer] = null;
                pointer++;
                break;
            }
            if (arrA[i] >= arrB[pointer]) pointer++;
        }
    }

    return count;
}
