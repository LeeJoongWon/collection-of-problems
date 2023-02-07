function solution(book_time) {
    let arr = book_time.sort((a, b) => {
        if (a[0].slice(0, 2) > b[0].slice(0, 2)) return 1;
        if (a[0].slice(0, 2) === b[0].slice(0, 2)) {
            if (a[0].slice(3, 5) > b[0].slice(3, 5)) return 1;
        }
        return -1;
    });

    let time = [];
    let room = 0;
    var person = 0;

    for (let i = 0; i < arr.length; i++) {
        time.push(Number(arr[i][1].slice(0, 2)) * 60 + Number(arr[i][1].slice(3, 5)) + 9);
        time.sort((a, b) => b - a);
        if (Number(arr[i][0].slice(0, 2)) * 60 + Number(arr[i][0].slice(3, 5)) > time[time.length - 1]) {
            time.pop();
            person--;
        }

        person++;
        if (person > room) room++;
    }

    return room;
}

console.log(
    solution([
        [
            ['09:10', '10:10'],
            ['10:20', '12:20'],
        ],
    ]),
);
