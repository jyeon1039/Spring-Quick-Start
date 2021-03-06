# Spring-Quick-Start
"스프링 퀵 스타트" 책 공부 (책 목차와 정리의 목차는 관계 없음)
# ✏️ DAY 01

## 1.1. 프레임워크란?
### 1.1.1 개념
* 전체 애플리케이션의 구조를 결정하는 아키텍처에 해당하는 골격 코드를 프레임워크가 제공한다.
### 1.1.2 장점
1. <b> 빠르구현 시간 </b> 
   + 프레임워크를 사용하면 아키텍처에 해당하는 골격 코드를 프레임워크에서 제공한다. 따라서 개발자는 비즈니스 로직만 구현하면 되므로 제한된 시간에 많은 기능을 구현할 수 있다.

2. <b> 쉬운 관리 </b>
    + 같은 프레임워크가 적용된 애플리케이션들은 아키텍처가 같으므로 관리하기가 쉽다.

3. <b> 개발자들의 역량 획일화 </b>
    + 프레임워크를 사용하면 숙련된 개발자와 초급 개발자가 생성한 코드가 비슷해지므로, 관리자 입장에서 개발 인력을 더 효율적으로 구성할 수 있다.

4. <b> 검증된 아키텍처의 재사용과 일관성 유지 </b>
    + 프레임워크에서 제공하는 아키텍처를 이용하므로 아키텍처에 관한 별다른 고민이나 검증 없이 소프트웨어를 개발할 수 있다. 또한, 이렇게 개발한 시스템은 시간이 지나도 유지보수 과정에서 
    아키텍처가 왜곡되거나 변형되지 않는다.
    
### 1.1.3. 특징
1. <b> 경량 </b>
    * 스프링은 여러 개의 모듈로 구성되어 있으며, 각 모듈은 하나 이상의 JAR 파일로 구성되어 있고, 이 몇 개의 JAR 파일만 있으면 개발과 실행이 모두 가능하다. 따라서 스프링을 이용해서 만든 
    애플리케이션의 배포 역시 매우 빠르고 쉽다.
    * 스프링 프레임워크가 POJO(Plain Old Java Object) 형태의 객체를 관리하기 때문이다. POJO는 클래스를 구현하는 데 특별한 규칙이 없는 단순하고 가벼운 객체이므로 POJO를 관리하는 것은 
    기존의 EJB 객체를 관리하는 것보다 훨씬 가볍고 빠를 수밖에 없다.
2. <b> 제어의 역행 (IoC : Inversion of Control) </b>
     * 스프링은 IoC를 통해 애플리케이션을 구성하는 개체 간의 느슨한 결합, 즉 낮은 결합도를 유지한다. IoC가 적용되면 객체 생성을 자바 코드로 직접 처리하는 것이 아니라 컨테이너가 대신 
    처리하고, 객체와 객체 사이의 의존관계 역시 컨테이너가 처리한다.
3. <b> 관점지향 프로그래밍 (AOP : Aspect Oriented Programming) </b>
    * 관점지향 프로그래밍은 비즈니스 메소드를 개발할 때, 핵심 비즈니스 로직과 각 비즈니스 메소드마다 반복해서 등장하는 공통 로직을 분리함으로써 응집도가 높게 개발할 수 있도록 지원한다.
    공통적으로 사용하는 기능들을 외부의 독립된 클래스로 분리하고, 해당 기능들을 프로그램 코드에 직접 명시하지 않고 선언적으로 처리하여 적용하는 것이 관점지향 프로그래밍의 기본 개념이다.
    이렇게 되면 공통 기능을 분리하여 관리할 수 있으므로 응집도가 높은 비즈니스 컴포넌트를 만들 수 있을 뿐만 아니라 유지보수를 혁신적으로 향상시킬 수 있다.
    
4. <b> 컨테이너 </b>
    * 컨테이너는 특정 객체의 생성과 관리를 담당하며 객체 운용에 필요한 다양한 기능을 제공한다. 대표적인 컨테이너로 Servlet 객체를 생성하고 관리하는 'Servlet 컨테이너'와 EJB 객체를 
    생성하고 관리하는 'EJB 커네이너'가 있다. 그리고 애플리케이션 운용에 필요한 객체를 생성하고 객체 간의 의존관계를 관리한다는 점에서 스프링도 일종의 컨테이너라고 할 수 있다.

<hr />


## 1.2 결합도가 높은 프로그램
결합도란 하나의 클래스가 다르 클래스와 얼마나 많이 연결되어 있는지를 나타내는 표현이며, 결합도가 높은 프로그램은 유지보수가 어렵다.
결합도가 높은 프로그램이 왜 유지보수가 어려운지 아래의 예시를 보면 이해가 갈 것이다.

* SamsungTV 클래스
```Java
package polymorphism;

public class SamsungTV {
  public void powerOn(){
    System.out.println("SamsungTV --- 전원 켠다.");
  }
  
  public void powerOff(){
    System.out.println("SamsungTV --- 전원 끈다.");
  }
  
  public void volumeUP(){
    System.out.println("SamsungTV --- 소리 올린다.");
  }
  
  public void volumeDown(){
    System.out.println("SamsungTV --- 소리 줄인다.");
  }
}
```

* LgTV 클래스

```Java
package polymorphism;

public class LgTV {
  public void turnON(){
    System.out.println("SamsungTV --- 전원 켠다.");
  }
  
  public void turnOff(){
    System.out.println("SamsungTV --- 전원 끈다.");
  }
  
  public void soundUp(){
    System.out.println("SamsungTV --- 소리 올린다.");
  }
  
  public void soundDown(){
    System.out.println("SamsungTV --- 소리 줄인다.");
  }
}
```

* SamsungTV를 시청하는 TVUser 클래스

```Java
package polymorphism;

public class TVUser {
  public static void main(String[] args){
    SamsungTV tv = new SamsungTV();
    tv.powerOn();
    tv.volumeUp();
    tv.volumeDown();
    tv.powerOff();
  }
}
```

* LgTV를 시청하는 TVUser 클래스

```Java
package polymorphism;

public class TVUser {
  public static void main(String[] args){
    LgTV tv = new LgTV();
    tv.turnON();
    tv.soundUp();
    tv.soundDown();
    tv.turnOff();
  }
}
```

⭐ 위의 코드를 보면 알 수 있듯이 TVUser 코드 대부분을 수정해야 TV를 교체할 수 있다. 
만약 TVUser와 같은 클라이언트 프로그램이 하나가 아니라 여러 개라면 유지보수는 더욱더 힘들 것이며, TV 교체를 결정하기가 쉽지 않을 것이다.

⭐ 결합도를 낮추기 위한 방법에는 다형성 이용하기(인터페이스 생성), 디자인 패턴 이용하기 등이 있다. 이에 코드는 commit에서 "결합도 낮추기 - 다형성" , "결합도 낮추기 - 디자인 패턴" 에서
확인할 수 있다.


## 1.3 스프링 컨테이너 
### 1.3.1. 스프링 컨테이너의 종류
* 스프링에서는 BeanFactory와 이를 상속한 ApplicationContext 두 가지 유형의 컨테이너를 제공한다. 
* <b>BeanFactory</b>는 스프링 설정 파일에 등록된 <bean> 객체를 생성하고 관리하는 가장
   기본적인 컨테이너만 제공한다. 그리고 컨테이너가 구동될 때 <bean> 객체를 생성하는 것이 아니라, 클라이언트의 요청(Lookup) 에 의해서만 <bean> 객체가 생성되는 지연 로딩(Lazy Loading) 방식을 사용한다. 따라서 일반적인 스프링 프로젝트에서 BeanFactory를 사용할 일은 없다.
* <b>ApplicationContext</b>는 BeanFactory가 제공하는 <bean> 객체 관리 기능 외에도 트랜잭션 관리나 메시지 기반의 다국어 처리 등 다양한 기능을 지원한다. 또한, 컨테이너가 구동되는 시점에 
   <bean> 등록된 클래스들을 객체 생성하는 즉시 로딩(pre-loading) 방식으로 동작한다. 그리고 웹 애플리케이션 개발도 지원하므로 대부분 스프링 프로젝트는 ApplicationContext 유형의
      컨테이너를 이용한다.
      
|구현 클래스|기능|
|:---|:---|
|GenericXmlApplicationContext|파일 시스템이나 클래스 경로에 있는 XML 설정 파일을 로딩하여 구동하는 컨테이너|
|XmlWebApplicationContext| 웹 기반의 스프링 애플리케이션을 개발할 때 사용하는 컨테이너|

### 1.3.2. <beans> 루트 엘리먼트
* 스프링 컨테이너는 <bean> 저장소에 해당하는 XMl 설정 파일을 참조하여 <bean> 의 생명주기를 관리하고 여러 가지 서비스를 제공한다. 스프링 설정 파일 이름은 무엇을 사용하든 상관없지만
   <beans>를 루트 엘리먼트로 사용해야 한다.

### 1.3.2. <import> 엘리먼트
* 스프링 설정 파일 하나에 우리가 만든 모든 클래스를 <bean> 으로 등록하고 관리할 수도 있지만, 스프링 기반의 애플리케이션은 단순한 <bean> 등록 외에도 트랜잭션 관리, 예외 처리, 다국어 
   처리 등 복잡하고 다양한 설정이 필요하다. 이런 모든 설정을 하나의 파일로 모두 처리할 수도 있겠지만, 그렇게 하면 스프링 설정 파일이 너무 길어지므로, 기능별 여러 XML 파일로 나누어
   설정하는 것이 더 효율적인데, 이렇게 분리하여 작성한 설정 파일들을 하나로 통합할 때 <import> 엘리먼트를 사용한다.
```Java
<beans>
   <import resource="context-datasource.xml" />
	<import resource="context-transaction.xml" />
</beans>
```

### 1.3.3. <bean> 엘리먼트
* 스프링 설정 파일에 클래스를 등록하려면 <bean> 엘리먼트를 사용한다.
* id 속성값에 해당하는 문자열은 자바의 식별자 작성 규칙을 따르며 일반적으로 '낙타 표기법'을 사용한다. name 속성은 자바 식별자 작성 규칙을 따르지 않는 문자열을 허용한다. 따라서 특수기호가 포함된 아이디는 name 속성을 사용한다.
```
id = "7userService"
name = "http://www.naver.com"   
```
   
### 1.3.4 <bean> 엘리먼트 속성
1. <b>init-method</b> 속성
   * 스프링 컨테이너는 스프링 설정 파일에 등록된 클래스를 객체 생성할 때 디폴트 생성자를 호출한다. 따라서 객체를 생성한 후에 멤버변수 초기화 작업이 필요하다면, Servlet의 init() 같은 
   메소드가 필요하다. 이를 위해 스프링에서는 <bean> 엘리먼트에 init-method 속성을 지원한다.
2. <b>destroy-method</b> 속성
   * init-method 와 마찬가지로 <bean> 엘리먼트에서 destroy-method 속성을 이용하여 스프링 컨테이너가 객체를 삭제하기 직전에 호출될 임의의 메소드를 지정할 수 있따.
3. <b>lazy-init</b> 속성
   * ApplicationContext를 이용하여 컨테이너를 구동하면 컨테이너가 구동되는 시점에 스프링 설정 파일에 등록된 <bean> 들을 생성하는 즉시 로딩(pre-loading) 방식으로 동작한다. 그런데 어
   떤 <bean>은 자주 사용되지도 않으면서 메모리를 많이 차지하여 시스템에 부담을 주는 경우도 있다. 따라서 특정 <bean>을 등록할 때, lazy-init="true"로 설정하면 클라이언트가 요청하는 
   시점에 객체를 생성한다. 결국, 메모리 관리를 더 효율적으로 할 수 있게 된다.
4. <b>scope</b> 속성
   * 동일한 클래스에서 하나의 객체만 생성해도 될 때, scope="singleton"을 사용하면 같은 id를 가져올 때 하나의 객체만 생성된다. (생략해도 singleton으로 적용된다)
   * scope="prototype 으로 지정하면, 스프링 컨테이너는 <bean>이 요청될 때마다 매번 새로운 객체를 생성하여 반환한다.

## 1.4. 의존성
