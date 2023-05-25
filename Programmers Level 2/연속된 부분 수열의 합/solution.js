function solution(sequence, k) {
    // 1개의 수열로 K값과 일치할떄
    if (sequence[sequence.length] === k) return [sequence.length, sequence.length];
    if (sequence[0] === k) return [0, 0];

    let answer = [0, sequence.length];
    let front = 0;
    let back = 1;
    let sum = sequence[back] + sequence[front];

    while (back < sequence.length) {
        if (sum === k) answer = answer[1] - answer[0] > back - front ? [front, back] : answer;

        if (sum > k) {
            sum -= sequence[front];
            front++;
        } else {
            back++;
            sum += sequence[back];
        }
    }
    return answer;
}
