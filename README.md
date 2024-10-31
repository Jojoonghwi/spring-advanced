# SPRING ADVANCED
## Lv 3. 추가 기능 개선 `선택`

### **1. 코드 개선 퀴즈 -** Early Return

- [x] 조건에 맞지 않는 경우 즉시 리턴하여, 불필요한 로직의 실행을 방지하고 성능을 향상시킵니다.

---

### **2. 리팩토링 퀴즈 - 불필요한 `if-else` 피하기**

- [x] 복잡한 `if-else` 구조는 코드의 가독성을 떨어뜨리고 유지보수를 어렵게 만듭니다. 불필요한 `else` 블록을 없애 코드를 간결하게 합니다.

---

### **3. 코드 클린업 : 불필요한 주석 제거, 코드 포맷팅, 일관된 네이밍 컨벤션 적용**

- [x]  불필요한 주석 제거
    - [x]  코드가 명확하게 이해될 수 있도록 불필요한 주석은 제거합니다.
        - [ ]  주석의 추상화 수준과 코드의 추상화 수준의 동일한 경우
        - [ ]  주석이 코드의 내용을 중복하는 경우 제거
        - [ ]  설명이 불명확하거나 혼란스러운 주석 삭제
        - [ ]  코드의 동작을 설명하기보다는 '왜' 해당 코드를 작성했는지를 설명하는 주석은 남김
- [x]  코드 포맷팅
    - [x]  일관된 코드 스타일을 유지하기 위해 코드 포맷팅을 적용합니다.
        - [x]  각 클래스, 메서드, 변수에 대한 적절한 공백 및 줄바꿈 적용
        - [x]  2칸 또는 4칸의 스페이스(탭) 사용, 팀 내 합의된 방식에 따름
        - [x]  괄호 `{}`는 다음 줄에 위치시키거나 같은 줄에 위치시키는 규칙을 팀 내에서 정하고 적용
        - [x]  한 줄의 최대 길이는 80~120자로 제한
        - [x]  메서드 인자와 파라미터 목록 간의 공백 적용
        - [x]  코드 정렬 및 정리(예: import 문 정리)
        - [x]  `Hint!` google-java-formatter, ktlint 와 같은 린트도 찾아서 활용해보세요!
- [x]  일관된 네이밍 컨벤션 적용
    - [x]  변수명, 메서드명, 클래스명 등 모든 네이밍에 대해 일관된 규칙을 적용합니다.
        - [x]  클래스 이름은 대문자로 시작하는 파스칼 케이스(`PascalCase`) 사용
        - [x]  메서드 이름 및 변수 이름은 소문자로 시작하는 카멜 케이스(`camelCase`) 사용
        - [x]  상수 이름은 모두 대문자로 작성하고 단어 사이에 언더스코어(`_`) 사용 (예: `MAX_LENGTH`)
        - [x]  이름이 그 행위를 충분히 설명하고 있는지? 
        이밍은 의미를 명확히 전달하도록 작성 (예: `getUserById`는 `findUserById`로 변경 가능)
        - [x]  접두사 또는 접미사를 통한 일관성 유지 (예: DTO는 `UserDTO`, Service는 `UserService` 등)

---

### **4. 중복 코드 제거 : 반복적으로 사용되는 코드의 재사용성 향상**

- [ ]  중복 코드 식별
    - [ ]  프로젝트 내에서 반복적으로 사용되는 코드를 찾아냅니다.
        - [ ]  유사한 로직이 여러 곳에서 사용되는지 확인
        - [ ]  동일한 기능을 수행하는 코드 블록을 검색
        - [ ]  메서드 내의 반복적인 코드나 클래스 간의 중복 코드 파악
- [ ]  메서드로 추출
    - [ ]  중복된 코드를 유틸리티 메서드로 추출하여 재사용성을 높입니다.
        - [ ]  중복 코드의 기능을 분석하고, 재사용 가능한 메서드를 생성
        - [ ]  메서드 이름은 기능을 명확히 전달할 수 있도록 작성
        - [ ]  메서드는 단일 책임 원칙(SRP)을 준수해야 하며, 한 가지 기능만 수행하도록 구현
    - [ ]  단순 private 메소드로의 추출을 기대하는게 아니라고 강조되었으면 좋겠습니다. 해당 코드를 더 잘 수행할 것 같은 객체에게 위임하거나 객체를 만들어서 메소드를 분리해야하는데, private 메소드를 먼저 떠올리면 구조적인 고민을 할 기회가 없어지기 때문입니다.

## Lv 4. 테스트코드 & AOP `선택`
### **1. 테스트 연습 1 (예상대로 성공하는지에 대한 케이스입니다.)**
- [x] 테스트 패키지 `package org.example.expert.config;` 의 `PassEncoderTest` 클래스에 있는 `matches_메서드가_정상적으로_동작한다()` 테스트가 의도대로 성공할 수 있게 수정해 주세요.

### **2. 테스트 연습 2 (예상대로 예외처리 하는지에 대한 케이스입니다.**
- [x] 테스트 패키지 `package org.example.expert.domain.manager.service;` 의 `ManagerServiceTest` 의 클래스에 있는 `manager_목록_조회_시_Todo가_없다면_NPE_에러를_던진다()` 테스트가 성공하고 컨텍스트와 일치하도록 **테스트 코드**와 **테스트 코드 메서드 명**을 수정해 주세요.

- [x] 테스트 패키지 `org.example.expert.domain.comment.service;` 의 `CommentServiceTest` 의 클래스에 있는 `comment_등록_중_할일을_찾지_못해_에러가_발생한다()` 테스트가 성공할 수 있도록 **테스트 코드**를 수정해 주세요.

- [x] 테스트 패키지 `org.example.expert.domain.manager.service`의 `ManagerServiceTest` 클래스에 있는 `todo의_user가_null인_경우_예외가_발생한다()` 테스트가 성공할 수 있도록 **서비스 로직**을 수정해 주세요.

### **3. AOP**
- [x] Spring AOP를 사용하여 해당 API들에 대한 접근 로그를 기록하는 기능을 구현
- 어드민 사용자만 접근할 수 있는 특정 API에는 접근할 때마다 접근 로그를 기록해야 합니다.
    - 패키지 `org.example.expert.domain.comment.controller;` 의 `CommentAdminController` 클래스에 있는 `deleteComment()`
    - 패키지 `package org.example.expert.domain.user.controller;` 의 `UserAdminController` 클래스에 있는 `changeUserRole()`
