# 안드로이드 개발 시 Java와 Kotlin 코드 비교

## 애플리케이션 설명

```
📁app
  ┗ 📁java
    ┗ 📁data
      ┗ DataSet        -- 데이터 모음
      ┗ Person         -- 데이터 클래스
    ┗ MainActivity     -- 메인 화면
    ┗ PersonsAdapter   -- 리스트 어뎁터
  ┗ 📁res
    ┗ 📁layout
      ┗ activity_main.xml      -- 메인 뷰
      ┗ list_person_item.xml   -- 아이템 뷰
```

![image.png](https://file.notion.so/f/f/44cbb738-2208-4b07-b770-d82e94afee3f/1e960322-af84-4ddc-9fac-b55dcf25e104/image.png?table=block&id=214ad230-7c5e-8000-9700-faa57fc13554&spaceId=44cbb738-2208-4b07-b770-d82e94afee3f&expirationTimestamp=1750125600000&signature=eSQafpbNePJOe4U9zw9GpWXz6wzGeXgNOy5VYSZnz4E&downloadName=image.png))

<br>

## 비교1. 데이터 클래스

```kotlin
data class Person(
    val firstName: String = "",
    val lastName: String,
    val age: Int = 0,
    val gender: String,
)

Person("곽", "철용", 33, "M")
Person(lastName = "철용", firstName = "곽", age = 33, gender = "M")
```

```java
public class Person {
		private String firstName;
		private String lastName;
    private int age;
    private String gender;
    
    // ... 생성자, getter, ...
}

Person("곽", "철용", 33, "M")
```

|  | Kotlin                   | Java                |
| --- |--------------------------|---------------------|
| 기본값 | 설정 가능 <br> → 주생성자 하나로 해결     | 설정 불가 <br> → 생성자 여러개 필요 |
| getter 메서드 | 프로퍼티에 내장                 | 직접 적어주어야 한다.        |
| equals(), toString(),… | 데이터 클래스에 내장              | 직접 생성해주어야 한다.       |
| 인스턴스 생성 | 인자명을 적으면 인자의 순서가 섞여도 된다. | 인자의 순서가 섞이면 안 된다.   |

<br>

## 비교2. 예외처리

```kotlin
data class (
		// ...
) { 
		init {
        if (lastName.isBlank())
            throw IllegalArgumentException("이름은 공백 제외 한 글자 이상 이어야 합니다.")
        if (age < 0)
            throw IllegalArgumentException("나이는 음수를 입력할 수 없습니다.")
    }
}
```

```java
public Person(String firstName, String lastName, int age, String gender) throws IllegalAccessException {
        if (lastName.isEmpty() || lastName.trim().length() == 0)
            throw new IllegalAccessException("이름은 공백 제외 한 글자 이상 이어야 합니다.");
        if (age < 0)
            throw new IllegalAccessException("나이는 음수를 입력할 수 없습니다.");

        // ...
    }
```

Kotlin은 `try-catch`나 `throws` 명시를 강제하지 않음.

➡️ Kotlin은 Checked Exception을 지원하지 않기 때문에

> [!NOTE]
> ❓Kotlin이 Checked Exception을 지원하지 않는 이유
>
> - Checked Exception이 오히려 코드의 유연성을 해치고, try-catch의 남용을 유도한다고 생각
    >     - 람다식 및 고차함수에서 불편을 유발한다고 판단
> - 대부분의 Kotlin 개발자들은 필요할 때만 예외를 잡고, 그렇지 않으면 명확하게 실패하도록 내버려 두는 걸 선호.

<br>

## 비교3. 확장함수

```kotlin
fun Person.getFullName() = "${if (firstName.isNotBlank()) "$firstName " else ""}$lastName"
```

- Kotlin은 확장함수 지원.
  - 상속을 최소화
  - 가독성을 올림

<br>

## 비교4. 스코프 함수

```kotlin
findViewById<RecyclerView>(R.id.rv_persons).apply {
    layoutManager = LinearLayoutManager(this@MainActivity)
    adapter = personsAdapter
}
```

`apply` 로 생성과 초기화를 한 블록으로 묶음

- 같은 변수를 사용하는 그룹을 묶어서 가독성 증가

<br>

## 비교5. 함수에서 람다 표현식

```kotlin
findViewById<FloatingActionButton>(R.id.fab_add).setOnClickListener {
  Toast.makeText(this, "Add Button Click!", Toast.LENGTH_SHORT).show()
}
```

```java
findViewById(R.id.fab_add).setOnClickListener(view -> {
        Toast.makeText(this, "Add Button Click!", Toast.LENGTH_SHORT).show();
        });
```

- 단일 추상 메소드(SAM)을 가진 인터페이스의 익명 객체 → 람다 표현식
  - 코틀린은 함수 호출 시 마지막 인자가 람다 표현식이라면, 해당 람다 표현식을 괄호 밖으로 빼낼 수 있다.
  - 가독성 향상