function addFood(arr, num, food) {
    if (num % 2 === 1) num--;
    num /= 2;
    console.log(num);
    for (let i = 0; i < num; i++) {
        arr.push(food);
    }
}

function solution(food) {
    let arr = [];
    for (let i = 1; i < food.length; i++) {
        addFood(arr, food[i], i);
    }
    const reversed = [...arr].reverse();
    return [...arr, 0, ...reversed].join('');
}
console.log(solution([1, 7, 1, 2]));
