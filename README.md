# π SecurityNote
**spring-security** μ **thymeleaf** λ·° κ΅¬ν μ°μ΅μ μν   
πββοΈλΉλ°λΈνΈμλλ€.

# class μ λ³΄
### π member Package
μ μ ,κ΄λ¦¬μ νμκ°μ, μ λ³΄λ₯Ό μ μ₯νλ package

<details>
<summary>μμΈν λ³΄κΈ°</summary>
<div markdown="1">

- UserEntity: db μ μ κ·Όν  μ μλ user μ λ³΄
- UserDto: view μ μ λ¬ν  user μ λ³΄ (νμκ°μμ©)   
- UserRepository: db μμ user λ°μ΄ν°λ₯Ό κΊΌλ΄μ΄   
- UserController: νμκ°μ control
- AdminController: λͺ¨λ  μ μ μ λΈνΈ μ‘°ν_μ΄λλ―Όμ΄ μ κ·Όν  μ μλ λΈνΈ μ‘°ν package (user λ λͺ»λ΄)
- UserService: νμκ°μ λ©μλ κ΅¬ν(μ μ , κ΄λ¦¬μ)
  - passwordEncoder λ₯Ό μ¬μ©νκΈ° μν΄μλ Bean μ μ£Όμλ°μμΌ νλ€.(configPackage)   

  
- AlreadyRegisteredUserException: μ΄λ―Έ μλ μ μ μΈ κ²½μ° exception
- UserNotFoundException: μ μ λ₯Ό μ°Ύμ μ μμ λ exception

</div>
</details>

<hr>

### π note Package
μ μ κ° μμ±ν  μ μλ λΈνΈ package (admin λ λ³΄κΈ° κ°λ₯)

<details>
<summary>μμΈν λ³΄κΈ°</summary>
<div markdown="1">

- NoteEntity: db μ μ κ·Όν  μ μλ note μ λ³΄
- NoteDto: view μ μ λ¬ν  note μ λ³΄
- NoteRepository: db μμ note λ°μ΄ν°λ₯Ό κΊΌλ΄μ΄ (crud λ₯Ό μν¨)
- NoteController: note crud
- NoteService: note crud λ©μλ κ΅¬ν

</div>
</details>

<hr>

### π noticePackage

κ΄λ¦¬μκ° μμ±ν  μ μλ κ³΅μ§ package (user λ λ³Ό μ μμ)   
Dto λ noteDto λ₯Ό κ³΅μ  

<details>
<summary>μμΈν λ³΄κΈ°</summary>
<div markdown="1">

- NoticeEntity: db μ μ κ·Όν  μ μλ κ³΅μ§ μ λ³΄
- NoticeRepository: db μμ κ³΅μ§ λ°μ΄ν°λ₯Ό κΊΌλ΄μ΄ (crud λ₯Ό μν¨)
- NoticeController: κ³΅μ§ crud
- NoticeService: κ³΅μ§ crud λ©μλ κ΅¬ν

</div>
</details>

<hr>

### π config package

<details>
<summary>μμΈν λ³΄κΈ°</summary>
<div markdown="1">

μΈμ¦, μΈκ°λ₯Ό κ΅¬ννλ package
- passwordEncoderConfig: λΉλ² μνΈν config
  - passwordEncoder λ₯Ό μ¬μ©νκΈ° μν΄μλ Bean μ μ£Όμλ°μμΌ νλ€.(configPackage)
- JpaAuditorConfig: JPA μμ μκ°μ μλμΌλ‘ κ°μ λ£μ΄μ£Όλ κΈ°λ₯
- MvcConfig: view νμ΄μ§ μ€μ  (url => html )
- SpringSecurityConfig: security μ€μ 
- InitializeDefaultConfig: default λ°μ΄ν° μ€μ 

</div>
</details>


# πββοΈ default κ³μ  μ λ³΄

- user
  - μμ΄λ: user 
  - λΉλ°λ²νΈ: user
- admin
  - μμ΄λ: admin 
  - λΉλ°λ²νΈ: admin


# π view μ λ³΄

# main page

<img src="img/main.png" width="900px">

λΉλ° λΈνΈμ λ©μΈ νμ΄μ§ μλλ€.

### all nav

<img src="img/nav1.png" width="900px">

λͺ¨λ  μ¬λμκ² λ³΄μ΄λ nav λ° μλλ€.   

### user nav

<img src="img/usernav.png" width="900px">

λ‘κ·ΈμΈν μ μ μκ² λ³΄μ΄λ nav λ° μλλ€.

### admin nav

<img src="img/adminnav.png" width="900px">

κ΄λ¦¬μμκ² λ³΄μ΄λ nav λ° μλλ€.


# sign up page

<img src="img/signup1.png" width="500px">

νμκ°μ νμ΄μ§ μλλ€.   
μμ΄λμ λΉλ°λ²νΈλ₯Ό μλ ₯ ν, νμκ°μ λ²νΌμ λλ₯΄λ©΄   
λ‘κ·ΈμΈ νμ΄μ§λ‘ redirect λ©λλ€.

# login page

<img src="img/login.png" width="500px">

λ‘κ·ΈμΈ νμ΄μ§ μλλ€.   
μμ΄λμ λΉλ°λ²νΈλ₯Ό μλ ₯ ν, λ‘κ·ΈμΈ λ²νΌμ λλ₯΄λ©΄    
λ©μΈ νμ΄μ§λ‘ redirect λ©λλ€.

λ‘κ·ΈμΈ μ μ§νκΈ° λ²νΌμ λλ₯΄λ©΄   
μΈμμ΄ λ§λ£λκΈ° μ κΉμ§ λ‘κ·ΈμΈμ΄ μ μ§ λ©λλ€.

# user page
## user note page

<img src="img/usernote.png" width="500px">

μ μ κ° λΈνΈλ₯Ό μμ±ν  μ μλ νμ΄μ§ μλλ€.   
κ°μΈ λΈνΈλ₯Ό μμ±, μμ , μ­μ ν  μ μμ΅λλ€.   


<img src="img/usernote2.png" width="500px">
<img src="img/usernote3.png" width="500px">

new, edit λ²νΌμ λλ₯΄λ©΄ alert μ°½μ΄ λΉλλ€.   

## user notice page

<img src="img/usernotice.png" width="500px">

μ μ κ° λ³Ό μ μλ κ³΅μ§ νμ΄μ§ μλλ€.
κ΄λ¦¬μκ° μμ±ν κ³΅μ§λ₯Ό νμΈν  μ μμ΅λλ€.


# admin page

## admin note page

<img src="img/adminnote.png" width="500px">

κ΄λ¦¬μμ λΈνΈ νμ΄μ§ μλλ€.   
κ΄λ¦¬μλ μΈμ¦ λ¨κ³λ₯Ό κ±°μΉ λͺ¨λ  μ μ λ€μ λΈνΈ λͺ©λ‘μ λ³Ό μ μμ΅λλ€.


## admin notice page

<img src="img/adminnotice.png" width="500px">
<!-- <img src="img/adminnote2.png" width="900px"> -->

κ΄λ¦¬μκ° λ³Ό μ μλ κ³΅μ§ νμ΄μ§ μλλ€.   
κ΄λ¦¬μλ§μ΄ μ κ³΅μ§κΈ μμ±μ ν  μ μμ΅λλ€.    


μ μ μ λ§μ°¬κ°μ§λ‘ κΈ crud κ° κ°λ₯νλ©°,   
new, edit λ²νΌμ λλ₯΄λ©΄ alert μ°½μ΄ λΉλλ€.   