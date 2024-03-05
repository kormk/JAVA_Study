# 아이템 42. 익명 클래스보다는 람다를 사용하라

## 낡은 방식: 익명 클래스의 인스턴스를 함수 객체로 사용

```java
Collections.sort(words, new Comparator<String>(){
	pulbic int compare(String s1, String s2){
		return Integer.compare(s1.length(), s2.length());
	}
});
```

`Comparator 인터페이스`: 정렬을 담당하는 추상 전략을 뜻함

⇒ 문자열을 정렬하는 구체적인 전략을 익명 클래스로 구현

익명 클래스 방식은 코드가 너무 길기 때문에 자바는 함수형 프로그래밍에 적합하지 않았다.

## 람다식을 함수 객체로 사용: 익명 클래스 대체

```java
Collection.sort(words,
	(s1, s2) -> Integer.compare(s1.length(), s2.length()));
```

코드에는 언급되어있지 않지만 람다, 매개변수, 반환값은 각각 다음과 같다.

람다 : Comparator<String>

매개변수: String

반환 값: int

코드에 각각의 타입이 명시되지 않는 이유는 우리 대신 컴파일러가 문맥을 살펴 타입을 추론해줬기 때문이다.

상황에 따라 컴파일러가 타입을 결정하지 못 할 수도 있는데, 그럴 때는 개발자가 직접 명시해야한다.

<타입을 명시해야 코드가 더 명확할 때만 제외하고는, 람다의 모든 매개변수 타입은 생략해보자>

> 람다 자리에 비교자 생성 메서드를 사용하면 코드를 더욱 간결하게 만들 수 있다.
> 

```java
Collection.sort(words, comparingInt(String::length));
```

</br>

> JAVA 8 에서 추가된 sort 메서드를 이용하면 더욱 짧아진다.
> 

```java
words.sort(comparingInt(String::length));
```
</br>

## 적용 예시
> 상수병 클래스 몸체와 데이터를 사용한 열거타입
> 

```java
public enum Operation{
	PULS("+"){
	public double apply(double x, double y) { return x + y; }
	}
	MINUS("-"){
	public double apply(double x, double y) { return x - y; }
	}
	...
	private final String symbol;

	Operation(String symbol) { this.symbol = symbol; }

	@override public String toString(){ return symbol; }
	public abstract double apply(double x, double y);
}
```

</br>

> 람다를 인스턴스 필드에 저장해 상수별 동작을 구현한 열거 타입
> 

단순히 각 열거 타입 상수의 동작을 람다로 구현해 생성자에 넘기고, 생성자는 이 람다를 인스턴스 필드로 저장해둔다. 그런다음 apply 메서드에서 필드에 저장된 람다를 호출하기만 하면된다.

```java
public enum Operation{
	PLUS("+", (x,y) -> x + y),
	MINUS("-", (x,y) -> x- y),
	...
	private final String symbol;
	private final DoubleBinaryOperator op;
	
	Operation(String symbol, DoubleBinaryOperator op){
		this.symbol = symbol;
		this.op = op;
	}

	@override public String toString(){ return symbol; }
	
	public double apply(double x, double y){
		return op.applyAsDouble(x,y);
	}
}
```

람다기반 Operation 열거타입을 보면 상수별 클래스 몸체는 더 이상 사용할 이유가 없다고 느껴진다…

하지만 꼭 그렇지만은 않다. 

메서드나 클래스와 달리 람다는 이름이 없고 문서화도 못한다. 따라서 자체로 동작이 명확히 설명되지 않거나 코드 줄 수가 많아지면 람다를 쓰지 말아야하한다.

(람다는 한줄일 때 가장 좋고 길어야 세줄안에 끝나는 것이 좋다. 그 이상의 경우에는 리팩토링을 거치는 것을 권장)

열거 타입 생성자에 넘겨지는 인수들의 타입도 컴파일타임에 추론된다. 따라서 열거타입 생겅자 안의 람다는 열거 타입의 인스턴스 멤버에 접근할 수 없다(인스턴스는 런타임에 만들어지기 때문).

따라서 상수별 동작을 단 몇 줄로 구혀하기 어렵거나, 인스턴스 필드나 메서드를 사용해야만 하는 상황이라면 상수별 클래스 몸체를 사용해야 한다.

> 람다의 시대가 열리면서 익명 클래스는 설 자리가 크게 좁아진 게 사실이다. 
하지만 람다로 대체할 수 없는 곳이 있다.
> 

람다는 함수형 인터페이스에서만 쓰인다. 

예컨데 추상 클래스의 인스턴스를 만들 때 람다를 쓸 수 없으니 익명 클래스를 써야한다. 

비슷하게 추상 메서드가 여러 개인 인터페이스의 인스턴스를 만들 때도 익명클래스를 쓸 수 있다.

마지막으로 람다는 자기 자신을 참조할 수없다.

람다에서의 `this` 키워드는 바깥 인스턴스를 가리킨다. 반면 익명클래스에서의 `this` 는 익명 클래스의 인스턴스 자신을 가리킨다. 그래서 함수객체가 자신을 참조해야한다면 반드시 익명 클래스를 써야한다.

람다도 익명클래스처럼 직렬화 형태가 구현별로 다를 수 있다. 따라서 람다를 직렬화 하는 일은 극히 삼가헤야한다.(익명클래스 또한 마찬가지)


### 📌 익명 클래스는 (함수형 인터페이스가 아닌) 타입의 인스턴스를 만들 때만 사용하라