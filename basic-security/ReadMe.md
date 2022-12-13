# 스프링 시큐리티

## 1. 프로젝트 구성 및 의존성 추가

- 의존성을 추가한다.

```
implementation 'org.springframework.boot:spring-boot-starter-security:2.5.3'
```
- 기존에 컨트롤러를 통해서 접근하면 아무런 일도 일어나지 않았었다.
- 하지만 security 의존을 추가하고 나서부터 login 페이지가 나온다.
  - 콘솔에 security password가 출력 된다.

<img alt="img.png" height="150" src="images/section01/01.png" width="200"/>

- ID : user
- PW : 콘솔 security password

<img alt="img.png" height="150" src="images/section01/02.png" width="200"/>


> ### 1. 인증 API - 스프링 시큐리티 의존성 추가
> 
> - 스프링 시큐리티 의존성 추가 시 발생
>   - 서버가 가동시
>     - 스프링 시큐리티의 초기화 작업 및 보안 설정이 이루어진다.
>   - 별도의 설정이나 구현 없이
>     - 기본적인 웹 보안 기능이 현재 시스템에 연동되어 작동함
>       - 모든 요청은 인증 되어야 접근 가능
>       - 인증 방식은 "폼 로그인 방식", "httpBasic" 로그인 방식을 제공
>       - 기본 로그인 페이지 제공
>       - 기본 계정 한개 제공 (user / password(랜덤문자열))
> - 문제점
>   - 계정 추가, 권한 추가, DB 연동
>   - 기본적인 보안 기능 외에 
>     - 시스템에서 필요로 하는 더 세부적이고 추가적인 보안 기능이 필요