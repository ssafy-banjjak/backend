<div align="center">
 <image src="https://github.com/ssafy-banjjak/backend/assets/65287117/5f2590ef-7203-40b9-8cfa-e9b9141351e8"/>
<h2>[2023] 싸피 관통 프로젝트 - 반짝🛩️</h2>
원하는 여행지를<br/>
반짝과 함께<br/>
여행을 반짝과 함께 떠나고
여행을 반짝으로 공유해보세요.🍀
</div>

## Project Overview

![스크린샷 2023-11-24 오전 9 14 17](https://github.com/ssafy-banjjak/backend/assets/65287117/54691292-4b22-486a-a46c-abf1c0e68fa6)

원하는 여행지를 반짝과 함께🍀<br>
혼자 여행을 가기보단 여럿이서 여행을 떠나고 싶으셨나요? 반짝을 통해 여행을 반짝과 함께 떠나고, 여행을 반짝으로 공유해보세요😆

- 반짝과 함께 떠나는 여행 🙋‍♀️🙋<br>
  반짝에서는 반짝 여행을 통해서 여행을 같이 즐길 반짝들을 모집할 수 있습니다. 원하는 여행지, 원하는 장소등을 선택한 후 날짜, 모집할 반짝들의 수를 반짝 여행에 업로드하여 같이 여행갈 인원을 모집해 보세요!!
- 반짝으로 여행을 공유 📱<br>
  자체의 숏폼인 반짝을 통해서 다녀왔던 여행 혹은 소소한 일상을 공유해 보세요! 각각의 반짝은 동영상과 썸네일을 업로드하여 영상을 공유할 수 있습니다. 또한 좋아요와 싫어요를 통해 다른 사람의 반응을 확인해 보세요!!
- 여행지 검색 💻<br>
  수많은 여행지와 관광지, 어떠한 정보가 있을지 궁금하지 않으신가요? 여행지 검색을 통해서 시/도 별로 구분된 각각의 관광지 정보를 확인해 보세요!!

## Team Info

<div align="center">

|                                                              **이태호**                                                               |                                                                                      **차재환**                                                                                       |
| :-----------------------------------------------------------------------------------------------------------------------------------: | :-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
| [<img src="https://avatars.githubusercontent.com/u/100212241?v=4" height=150 width=150> <br/> @leetaggg](https://github.com/leetaggg) | [<img src="https://avatars.githubusercontent.com/u/65287117?s=400&u=da3c5f3967057ff5d1bd906c7f03d683b887fde4&v=4" height=150 width=150> <br/> @barded](https://github.com/barded1998) |

</div> 
<h2 id="stacks"> 🛠️  Tech Stacks </h2>

<img width="500" alt="Guessme_project_architecture" src="https://github.com/ssafy-banjjak/backend/assets/65287117/d8a2a94b-fde1-491c-9115-fcabe00e62c6">

### 🚉 Platform

- [Google Cloud Platform](https://cloud.google.com/)
- [Google Cloud Storage](https://cloud.google.com/storage)

### 🦾 Server

- [JAVA 8](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html)
- [Spring Boot v2.7.9](https://spring.io/projects/spring-boot)
- [MySQL](https://www.mysql.com/)
- [JWT](https://jwt.io/)
- [Mybatis](https://mybatis.org/mybatis-3/)
- [redis](https://redis.io/)

<h2 id="structure"> 🕹️ Source Code Structure </h2>

### Server

```
Server/
📦src
 ┣ 📂main
 ┃ ┣ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂ssafy
 ┃ ┃ ┃ ┃ ┗ 📂banjjak
 ┃ ┃ ┃ ┃ ┃ ┣ 📂attraction
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AttractionController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AttractionMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AttractionDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜AttractionService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜AttractionServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂config
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜MyBatisConfig.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SwaggerConfiguration.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜WebConfig.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂global
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseErrorResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseException.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜BaseResponse.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜GlobalExceptionHandler.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂interceptor
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JWTInterceptor.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂post
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostDetailDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostWrtieDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂post_attraction
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostAttractionMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostAttractionDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┣ 📂post_user
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostUserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostUserMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostUserDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜PostUserService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜PostUserServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂shorts
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShortController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShortMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜Pagination.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜SearchCond.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ShortDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShortFile.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜ShortService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜ShortServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂user
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂controller
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserController.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂model
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserMapper.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserLoginResponseDto.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📂service
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┣ 📜UserService.java
 ┃ ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜UserServiceImpl.java
 ┃ ┃ ┃ ┃ ┃ ┣ 📂util
 ┃ ┃ ┃ ┃ ┃ ┃ ┗ 📜JWTUtil.java
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BanjjakApplication.java
 ┃ ┗ 📂resources
 ┃ ┃ ┣ 📂db
 ┃ ┃ ┃ ┗ 📜ddl.sql
 ┃ ┃ ┣ 📂mapper
 ┃ ┃ ┃ ┣ 📜attraction.xml
 ┃ ┃ ┃ ┣ 📜post.xml
 ┃ ┃ ┃ ┣ 📜post_attraction.xml
 ┃ ┃ ┃ ┣ 📜post_user.xml
 ┃ ┃ ┃ ┣ 📜short.xml
 ┃ ┃ ┃ ┗ 📜user.xml
 ┃ ┃ ┣ 📂static
 ┃ ┃ ┣ 📂templates
 ┃ ┃ ┣ 📜application.properties
 ┃ ┃ ┗ 📜master-chariot-405800-57664c0f6400.json
 ┗ 📂test
 ┃ ┗ 📂java
 ┃ ┃ ┗ 📂com
 ┃ ┃ ┃ ┗ 📂ssafy
 ┃ ┃ ┃ ┃ ┗ 📂banjjak
 ┃ ┃ ┃ ┃ ┃ ┗ 📜BanjjakApplicationTests.java
```
