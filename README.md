# HanteoGlobal

## 사용 skill
<div>
    <h2>Technology Stack</h2>
    <section>
        <h3>Backend</h3>
        <img src="https://img.shields.io/badge/IntelliJ-000000?style=for-the-badge&logo=IntelliJ-&logoColor=white" alt="IntelliJ">
        <img src="https://img.shields.io/badge/Spring Boot-6DB33F?style=for-the-badge&logo=Spring Boot-&logoColor=white" alt="Spring Boot">
        <img src="https://img.shields.io/badge/JPA-6DB33F?style=for-the-badge&logo=JPA-&logoColor=white" alt="JPA">
        <img src="https://img.shields.io/badge/Java-4B4B77?style=for-the-badge&logo=Java-&logoColor=white" alt="Java">
    </section>
    <section>
        <h3>Database</h3>
        <img src="https://img.shields.io/badge/MySQL-4479A1?style=for-the-badge&logo=MySQL-&logoColor=white" alt="MySQL">
    </section>
    <section>
        <h3>Collaboration and Testing Tools</h3>
        <img src="https://img.shields.io/badge/GitHub-181717?style=for-the-badge&logo=GitHub-&logoColor=white" alt="GitHub">
        <img src="https://img.shields.io/badge/Postman-FF6C37?style=for-the-badge&logo=Postman&logoColor=white" alt="Postman">
    </section>
</div>
</br></br></br></br>

## Directory
hanteo</br>
L task1(게시판 카테고리 구분 모듈)</br>
L task2(동전 교환 문제 모듈)</br>
</br></br></br></br>

## Fast Start
- 리파지토리를 fork합니다.
- 함께 드린 category script.sql을 이용해 table을 생성해주세요
- 생성한 db table과 springboot를 연동해주세요
- postman을 이용해 test 가능하십니다.</br>
(편의를 위해 postman을 이용한 결과를 첨부해놓았으니 하단을 참고해주세요.)
</br></br></br></br>

## task 1 : 게시판 카테고리 구분
![image](https://github.com/user-attachments/assets/9e1ca0c0-2848-491a-861a-c2b6f072d8e9)

### DB 구조
![image](https://github.com/user-attachments/assets/665156da-901b-4aab-9f69-ef6fd9a795f6)

### postman 확인 결과
1. getCategory test</br>
   [id 또는 name 입력 경우](https://web.postman.co/workspace/getCategory-Test~8ea0ff0d-18ca-4b63-bb9f-b5ecc169dd66/request/37825355-54b49252-556a-4909-8ca5-05b74c9a589d)</br>
   id, name 중 존재하는 것을 감지하여 데이터 반환</br>

   - 남자로 검색했을 경우
```
       {
    "1": [
        {
            "id": 2,
            "name": "엑소",
            "boardId": null,
            "posts": []
        },
        {
            "id": 7,
            "name": "방탄소년단",
            "boardId": null,
            "posts": []
        }
    ],
    "2": [
        {
            "id": 3,
            "name": "공지사항",
            "boardId": 1,
            "posts": []
        },
        {
            "id": 4,
            "name": "첸",
            "boardId": 2,
            "posts": []
        },
        {
            "id": 5,
            "name": "백현",
            "boardId": 3,
            "posts": []
        },
        {
            "id": 6,
            "name": "시우민",
            "boardId": 4,
            "posts": []
        }
    ],
    "7": [
        {
            "id": 8,
            "name": "공지사항",
            "boardId": 5,
            "posts": []
        },
        {
            "id": 9,
            "name": "익명게시판",
            "boardId": 6,
            "posts": []
        },
        {
            "id": 10,
            "name": "뷔",
            "boardId": 7,
            "posts": []
        }
    ]
}
```

   - 7로 검색했을 경우
```
     {
    "7": [
        {
            "id": 8,
            "name": "공지사항",
            "boardId": 5,
            "posts": []
        },
        {
            "id": 9,
            "name": "익명게시판",
            "boardId": 6,
            "posts": []
        },
        {
            "id": 10,
            "name": "뷔",
            "boardId": 7,
            "posts": []
        }
    ]
}
```
   -공지사항 검색 결과
   공지사항은 두 가지가 존재하기 때문에 Exception 처리했습니다.</br>
   ![image](https://github.com/user-attachments/assets/1af075a3-d990-4bbf-b99b-2252c809abdb)

</br></br></br></br>

## task 2 : 동전 교환 문제

### postman 확인 결과
1. getCoinSumWays test</br>
   [10, {2,3,5,6} 입력](https://web.postman.co/workspace/getCategory-Test~8ea0ff0d-18ca-4b63-bb9f-b5ecc169dd66/request/37825355-c51a41d7-69bf-4744-aaa6-6cbca8fc28c0)
   ![image](https://github.com/user-attachments/assets/0097ec1e-33d8-42fa-a10a-3080489ea0d6)

</br></br></br></br>

## task 처리 과정
1. git issue 사용</br>
    ![image](https://github.com/user-attachments/assets/54ce9f32-f3ca-40d5-9932-25a8d76e4263) </br>


2. pull request</br>
   ![image](https://github.com/user-attachments/assets/cedf4e7b-27d8-4393-b9cd-8a25cfd38d58)</br>

     
