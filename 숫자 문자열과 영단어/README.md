# 숫자 문자열과 영단어(프로그래머스)


https://programmers.co.kr/learn/courses/30/lessons/81301

풀이방법: String 배열에 영단어표를 만들고 문자열 치환(replaceAll)을 이용하여 해결 

# 문제


1478 → "one4seveneight"


234567 → "23four5six7"


10203 → "1zerotwozero3"


이렇게 숫자의 일부 자릿수가 영단어로 바뀌어졌거나, 

혹은 바뀌지 않고 그대로인 문자열 s가 매개변수로 주어집니다. 

s가 의미하는 원래 숫자를 return 하도록 solution 함수를 완성해주세요.



영단어는 다음 표와 같습니다


숫자	영단어
0	zero
1	one
2	two
3	three
4	four
5	five
6	six
7	seven
8	eight
9	nine


입출력 


"one4seveneight"	1478


"23four5six7"	234567


"2three45sixseven"	234567


"123"	123
