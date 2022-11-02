# Calculator

##개 요
###더하기,빼기,곱하기,나누기 기능을 가진 계산기를 제작하였다.
###실수계산이 가능하도록 제작하였다.
###Back버튼과 Cancle버튼을 추가하여 입력한 숫자를 삭제할 수 있도록 제작하였다. 
###과거에 계산했던 계산식을 리스트형식으로 볼 수 있게 제작하였다.
###리스트에 있는 계산식을 길게 누르면 저장되어있던 계산식이 삭제되도록 제작하였다.

## 개발환경

| 구 분 | 내 용 |
| --- | --- |
| OS | Windows 10 home |
| Language | Kotlin |
| Editor | Android Studio Dolphin |
| Github | https://github.com/fkrbtjs/calculator |

## 개발기간

2022.10.22(토) ~ 2022.10.23(일)

## 기능 요약 및 설명
###textView에 입력된 값을 Double값으로 바꿔 연산 후 출력
###GridLayout 사용하여 계기판 제작
###dropLast() 사용하여 마지막 자릿수를 삭제하는 기능 구현
###visibility값을 버튼을 클릭함에 따라 변경하여 하나의 Activity에 두개의 layout을 삽입
###계산이 완료된 식을 data class 에 저장하여 CustomAdapter를 통하여 recyclerView에 표현

## 실행화면

https://user-images.githubusercontent.com/115532120/199502575-6ff499a0-c64a-4400-80a8-190a24b44f4b.mp4

