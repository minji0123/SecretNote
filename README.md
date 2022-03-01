# class 정보

**userPackage**
유저 회원가입, 정보를 저장하는 package
- UserEntity: db 에 접근할 수 있는 user 정보   
- UserDto: view 에 전달할 user 정보 (회원가입용)   
- UserRepository: db 에서 user 데이터를 꺼내옴   
- UserController: user 회원가입 control
- UserService: 회원가입 메소드 구현
- AlreadyRegisteredUserException: 이미 있는 유저인 경우 exception
- 

passwordEncoder 를 사용하기 위해서는 Bean 을 주입받아야 한다.(configPackage)    

**notePackage**
유저가 작성할 수 있는 노트 package (admin 도 보기 가능)
- noteEntity: 