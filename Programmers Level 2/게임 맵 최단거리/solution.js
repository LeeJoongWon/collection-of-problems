function solution(maps) {
    var answer = 0;
    const visited = Array(maps.length)
        .fill(0)
        .map(() => Array(maps[0].length).fill(0));
    const dy = [1, 0, -1, 0];
    const dx = [0, 1, 0, -1];
    const queue = [];
    queue.push([0, 0]);
    visited[0][0] = 1;

    if (maps[maps.length - 1][maps[0].length - 2] === 0 && maps[maps.length - 2][maps[0].length - 1] === 0) return -1;

    while (queue.length) {
        const [curY, curX] = queue.shift();

        for (let i = 0; i < 4; i++) {
            let nextY = curY + dy[i];
            let nextX = curX + dx[i];

            if (nextY < 0 || nextX < 0 || nextY >= maps.length || nextX >= maps[0].length || maps[nextY][nextX] === 0) continue;
            if (visited[nextY][nextX]) continue;
            queue.push([nextY, nextX]);
            visited[nextY][nextX] = visited[curY][curX] + 1;
        }
    }
    answer = visited[maps.length - 1][maps[0].length - 1];

    if (!answer) return -1;
    return answer;
}

console.log(
    solution([
        [1, 0, 1, 1, 1],
        [1, 0, 1, 0, 1],
        [1, 0, 1, 1, 1],
        [1, 1, 1, 0, 1],
        [0, 0, 0, 0, 1],
    ]),
);
