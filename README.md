# 일정 관리 앱 (JPA)

## 프로젝트 소개
Spring Boot + JPA를 사용한 일정 관리 API입니다.  
CRUD 기능을 제공하며, 비밀번호 검증을 통해 수정/삭제가 가능합니다.

---

## API 명세서

### 1. 일정 생성

- URL: `/schedules`
- Method: `POST`

#### Request
```json
{
  "title": "공부",
  "content": "JPA 공부하기",
  "password": "1234"
}

{
  "id": 1,
  "title": "공부",
  "content": "JPA 공부하기",
  "createdAt": "2026-04-14T11:00:00"
}

[
  {
    "id": 1,
    "title": "공부",
    "content": "JPA 공부하기",
    "createdAt": "2026-04-14T11:00:00"
  },
  {
    "id": 2,
    "title": "운동",
    "content": "헬스장 가기",
    "createdAt": "2026-04-14T12:00:00"
  }
]

{
  "id": 1,
  "title": "공부",
  "content": "JPA 공부하기",
  "createdAt": "2026-04-14T11:00:00"
}

{
  "title": "수정된 제목",
  "content": "수정된 내용",
  "password": "1234"
}

{
  "id": 1,
  "title": "수정된 제목",
  "content": "수정된 내용",
  "updatedAt": "2026-04-14T12:00:00"
}

##  ERD (Entity Relationship Diagram)

### Schedule 테이블

| 컬럼명 | 타입 | 설명 |
|-------|------|------|
| id | Long | PK |
| title | String | 일정 제목 |
| content | String | 일정 내용 |
| password | String | 비밀번호 |
| createdAt | LocalDateTime | 생성일 |
| updatedAt | LocalDateTime | 수정일 |

![Untitled.png](../../Downloads/Untitled.png)