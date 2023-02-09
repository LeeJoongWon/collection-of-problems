function solution(begin, target, words) {
    let answer = 0;
    const visited = new Array(words.length).fill(false);
    const queue = [];

    if (!words.includes(target)) return 0;

    queue.push([begin, answer]);

    while (queue) {
        console.log('🚀  queue', queue);
        let [v, cnt] = queue.shift();
        if (v === target) {
            return cnt;
        }

        words.forEach((word, index) => {
            if (visited[index]) return;

            let notEqual = 0;
            for (let i = 0; i < word.length; i++) {
                if (word[i] !== v[i]) notEqual++;
            }

            if (notEqual === 1) {
                console.log(word);
                queue.push([word, ++cnt]);
                visited[index] = true;
            }
        });
    }

    return answer;
}

console.log(solution('hit', 'cog', ['hot', 'dot', 'dog', 'lot', 'log', 'cog']));
