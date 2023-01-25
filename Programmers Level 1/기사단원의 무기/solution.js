const getDivisors = (num) => {
    const divisors = [];
    for (let i = 1; i <= Math.sqrt(num); i++) {
        if (num % i === 0) {
            divisors.push(i);
            if (num / i != i) divisors.push(num / i);
        }
    }
    return divisors.length;
};

function solution(number, limit, power) {
    console.log('실행', number);
    var answer = 0;
    for (let i = 1; i <= number; i++) {
        let weaponPower = getDivisors(i);
        if (weaponPower > limit) {
            answer += power;
        } else {
            answer += weaponPower;
        }
    }
    console.log(answer);
    return answer;
}

solution(5, 3, 2);
