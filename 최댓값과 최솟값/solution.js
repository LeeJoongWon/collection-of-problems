function solution(s) {
    let arr = s.split(' ');
    let min = Number(arr[0]),
        max = Number(arr[0]);
    for (let i = 1; i < arr.length; i++) {
        if (min > Number(arr[i])) min = Number(arr[i]);
        if (max < Number(arr[i])) max = Number(arr[i]);
    }
    return `${min} ${max}`;
}

console.log(solution('-1 -2 -3 -4'));
