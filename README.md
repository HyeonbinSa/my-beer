## 🍻 나만의 맥주 

---
### 초안 - 흐름
#### 일반 사용자
1. 페이지 접속 시 로그인 요청 
   1. 로그인 
   2. 회원가입
2. 로그인 시 맥주 목록 화면
   1. 카테고리별 Filter
   2. 좋아요 Filter
3. 맥주 클릭 시 맥주 상세 페이지 이동
4. 맥주 상세 페이지 - 리뷰 
   1. 리뷰 작성
   2. 리뷰 수정
   3. 리뷰 삭제
   4. 리뷰 조회
#### 관리자
1. 맥주 등록 
2. 회원 관리

### 📕 핵심 기능 


### 📋 도메인
1. 맥주
2. 사용자
3. 리뷰

### API
- User
  - /users
  - /users/join
  - /users/{userId}
  - /users/
- Beer
  - /beers
  - /beers/add
  - /beers/update
  - /beers/remove