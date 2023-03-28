function solution(board) {
    const visited = new Array(board.length).fill(false).map(() => Array(board[0].length).fill(false));
    const dy = [-1, 1, 0, 0];
    const dx = [0, 0, -1, 1];
    let queue = [];
    // 시작지점 찾기
    for (let i = 0; i < board.length; i++) {
        if (board[i].indexOf('R')) {
            queue.push([i, board[i].indexOf('R'), 0]);
            break;
        }
    }

    while (queue.length) {
        const [curY, curX, count] = queue.shift();
        // 도착지점에 도착하면 이동횟수 리턴
        if (board[curY][curX] === 'G') return count;
        visited[curY][curX] = true;
        let nextX, nextY;

        // 상
        nextY = curY;
        while (nextY > 0) {
            if (board[nextY - 1][curX] === 'D') break;
            nextY--;
        }
        if (!visited[nextY][curX]) queue.push([nextY, curX, count + 1]);

        // 하
        nextY = curY;
        while (nextY < board.length - 1) {
            if (board[nextY + 1][curX] === 'D') break;
            nextY++;
        }
        if (!visited[nextY][curX]) queue.push([nextY, curX, count + 1]);

        // 좌
        nextX = curX;
        while (nextX > 0) {
            if (board[curY][nextX - 1] === 'D') break;
            nextX--;
        }
        if (!visited[curY][nextX]) queue.push([curY, nextX, count + 1]);

        // 우
        nextX = curX;
        while (nextX < board[curY].length - 1) {
            if (board[curY][nextX + 1] === 'D') break;
            nextX++;
        }
        if (!visited[curY][nextX]) queue.push([curY, nextX, count + 1]);
    }

    return -1;
}
