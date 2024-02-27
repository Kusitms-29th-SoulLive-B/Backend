# Backend

## 📑 Commit Convention
커밋 메세지는 **커밋 태그: 커밋 내용** 으로 작성  
ex) `git commit -m "feat: 로그인 기능 구현`
|커밋태그|설명|
|:---:|---|
|feat|신규 기능 구현 작업|
|fix|버그 수정|
|docs|문서 수정|
|style|코드 스타일 변경|
|design|UI 디자인 변경|
|refactor|코드 리팩토링|
|rename|변수, 클래스, 메소드, 패키지명 변경|
|build|dependencies 추가 및 삭제|
|chore|기타 변경사항(빌드 관련, 패키지 매니징, CI/CD, assets 등)|
|test|테스트 코드 추가|

## 🐬 Git Flow 전략
![image](https://github.com/nohy6630/readme_test/assets/129354455/c39dfa00-4d8a-4d7b-b0f5-262ec544b12a)
|브랜치명|설명|
|:---:|---|
|main|출시 또는 배포 가능한 코드의 브랜치|
1. 이슈 등록후 해당 이슈에 관한 브랜치 생성후 작업
- (브랜치명: feat/기능 또는 fix/기능)
- feat로 시작하는 브랜치: 기능 구현 브랜치
- fix로 시작하는 브랜치: 버그 수정 브랜치

2. 기능 구현 완료후 pr 올리고 다른 사람들이 리뷰, 커멘트 후 머지
