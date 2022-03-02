# SecurityNote
spring-security 와 thymeleaf 뷰 구현 연습을 하기위해 
제작해 본 비밀노트입니다.

# class 정보

**memberPackage**
유저,관리자 회원가입, 정보를 저장하는 package
- UserEntity: db 에 접근할 수 있는 user 정보   
- UserDto: view 에 전달할 user 정보 (회원가입용)   
- UserRepository: db 에서 user 데이터를 꺼내옴   
- UserController: user 회원가입 control
- AdminController: 모든 유저의 노트 조회_어드민이 접근할 수 있는 노트 조회 package (user 는 못봄)
- UserService: 회원가입 메소드 구현(유저, 관리자)

- AlreadyRegisteredUserException: 이미 있는 유저인 경우 exception
- UserNotFoundException: 유저를 찾을 수 없을 때 exception


**notePackage**
유저가 작성할 수 있는 노트 package (admin 도 보기 가능)
- NoteEntity: db 에 접근할 수 있는 note 정보
- NoteDto: view 에 전달할 note 정보
- NoteRepository: db 에서 note 데이터를 꺼내옴(조회, 삭제를 위함)
- NoteController: note 조회, 생성, 삭제 (수정은 나중에 추가?)
- NoteService: note 조회, 생성, 삭제 메소드 구현

**noticePackage**
어드민이 작성할 수 있는 공지 package (user 는 볼 수 없음)
- NoticeEntity: db 에 접근할 수 있는 공지 정보
- NoticeRepository
- NoticeController: 공지 조회, 생성, 삭제
- NoticeService: 공지 조회, 생성, 삭제 메소드 구현

**config**
인증, 인가를 구현하는 package
- passwordEncoderConfig: 비번 암호화 config
  - passwordEncoder 를 사용하기 위해서는 Bean 을 주입받아야 한다.(configPackage)


# thymeleaf 정보
## 기본 문법
th:fragment: 공통 layout 을 나누고 사용함