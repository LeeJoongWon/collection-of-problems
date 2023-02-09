# 단어 변환 (프로그래머스)

https://school.programmers.co.kr/learn/courses/30/lessons/43163

# 문제 설명

두 개의 단어 begin, target과 단어의 집합 words가 있습니다.

아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.

2. words에 있는 단어로만 변환할 수 있습니다.

예를 들어 begin이 "hit", target가 "cog", words가 ["hot","dot","dog","lot","log","cog"]라면

"hit" -> "hot" -> "dot" -> "dog" -> "cog"와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때,

최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

# 풀이

큐 자료구조를 이용하여 풀었습니다

조건이 문자열중에 2개의 char가 일치해야된다는 조건이 있습니다

이 조건을 통과한 문자를 큐에 저장합니다

큐에 변환된 문자와 몇번째 변환인지 값을 같이 저장합니다

입출력 예제 1번 기준으로 아래의 순처와 같이 동작합니다

1. queue [ [ 'hit', 0 ] ]
2. queue [ [ 'hot', 1 ] ]
3. queue [ [ 'dot', 2 ], [ 'lot', 3 ] ]
4. queue [ [ 'lot', 3 ], [ 'dog', 3 ] ]
5. queue [ [ 'dog', 3 ], [ 'log', 4 ] ]
6. queue [ [ 'log', 4 ], [ 'cog', 4 ] ]
7. queue [ [ 'cog', 4 ] ]

이것을 정리하자면

시작 => hit

1회 변환으로 가능한 단어들 => 'hot'

2회 변환으로 가능한 단어들 => 'dot',

3회 변환으로 가능한 단어들 => 'lot', 'dog'

4회 변환으로 가능한 단어들 => 'log', 'cog'

이런식으로 탐색가능한 모든 경로를 돌면서 (2글자가 일치하는 단어들) 최소한의 변환으로 target으로 바꾸는 횟수를 구할수 있습니다

탈출조건으로 queue담긴 데이터가 target과 일치할때 같이 담겨있는 카운트값을 리턴하면 정답을 구할 수 있습니다
