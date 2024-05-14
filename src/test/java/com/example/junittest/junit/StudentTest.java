package com.example.junittest.junit;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest // Spring Boot 기반 테스트를 실행하는 테스트 클래스에 지정할 수 있는 주석입니다.
@TestInstance(TestInstance.Lifecycle.PER_CLASS) // 테스트 클래스의 인스턴스 라이프 사이클을 지정하는 데 사용.
//    PER_CLASS: 이 모드를 사용하면 테스트 클래스당 한 번씩 새 테스트 인스턴스가 생성됩니다. 이는 기본값입니다.
//    PER_METHOD: 이 모드를 사용하면 각 테스트 메서드, 테스트 팩토리 메서드 또는 테스트 템플릿 메서드에 대해 새 테스트 인스턴스가 생성됩니다.이 모드는 JUnit 버전 1~4의 동작과 유사합니다.
class StudentTest {
    @DisplayName("학생 객체 생성 테스트") // 테스트 케이스의 이름을 지정 공백, 특수 문자, 이모티콘까지 포함될 수 있다.
    @Test // 테스트 케이스임을 알림
    @Disabled // 테스트를 비활성화하는 데 사용, 테스트를 임시로 비활성화하고 나중에 다시 활성화할 수 있습니다.
    public void create() throws Exception{
        Student student = new Student("John", 20);
        System.out.println(student.getName());
    }
    @Test
    public void create2() throws Exception{
        System.out.println("create2");
    }
    @BeforeEach // 테스트 메소드 실행 전에 실행되는 메소드, 테스트에 필요한 목업 데이터 세팅, 모든 테스트 메소드 실행전 실행됨
    public void beforeEach() {
        System.out.println("테스트 시작전");
    }
    @BeforeAll // @BeforeEach 메소드와 달리 @BeforeAll 메소드는 주어진 테스트 클래스에 대해 한 번만 실행됩니다. static 으로 선언해야 사용가능
    public static void beforeAll() {
        System.out.println("테스트 시작전 All");
    }
    @AfterEach // 테스트 메소드 실행 후에 실행되는 메소드, 각각 테스트 메서드 실행후 특정 작업 할경우, 모든 테스트 메소드 실행후 실행
    public void afterEach() {
        System.out.println("테스트 시작후");
    }
    @AfterAll // @AfterEach 메소드와 달리 @AfterAll 메소드는 주어진 테스트 클래스에 대해 한 번만 실행됩니다., static 으로 선언해야 사용가능
    public static void afterAll() {
        System.out.println("테스트 시작후 All");
    }
    @ParameterizedTest
//    주석이 달린 메서드가 매개변수화된 테스트 메서드임을 알리는 데 사용, 이러한 메서드는 비공개이거나 정적이어서는 안 됩.
    @ValueSource(strings = {"John", "Jane", "Doe"})
//    리터럴 값 배열에 대한 액세스를 제공하는 Arguments, 지원되는 유형에는 shorts, bytes, ints, longs, floats, doubles, chars, boolean, strings 및 클래스가 포함. 유형 중 하나만 지정
    @NullSource
//    메서드에 null 인수를 제공하는 ArgumentsSource
    @EmptySource
//    메서드에 단일 빈 인수를 제공하는 ArgumentsSource
    @CsvSource(value = {"test1:FIRST", "test2:SECOND", "test3:THIRD"}, delimiterString = ":")
//    value 속성 또는 textBlock 속성을 통해 제공된 하나 이상의 CSV 레코드에서 쉼표로 구분된 값(CSV)을 읽는 ArgumentsSource, delimiterString 속성을 사용하여 구분자를 지정
    public void param(String name) throws Exception{
        System.out.println(name);
    }
    @RepeatedTest(value = 10, name = "{displayName} 중 {currentRepetition} of {totalRepetitions}")
//    테스트 메서드를 반복하는 데 사용, 지정된 횟수만큼 테스트 메서드를 반복 실행
    @DisplayName("반복 테스트")
    void repeatedTest() {
        System.out.println("repeatedTest");
    }
    @ParameterizedTest
    @ValueSource(ints = {1})
    @DisplayName("숫자 일치 assertion 테스트")
    public void test1(int num) throws Exception{
        assertEquals(num, 1); // 예상값과 실제값이 동일한지 테스트
        assertNotEquals(num, 2); // 예상값과 실제값이 다른지 테스트
        assertSame(num, 1); // 예상객체와 실제객체가 동일한지 테스트
        assertNotSame(num, 2); // 예상객체와 실제객체가 다른지 테스트
        assertTrue(num == 1); // 조건이 참인지 테스트
        assertFalse(num == 2); // 조건이 거짓인지 테스트
        assertNull(null); // 객체가 null인지 테스트
        assertNotNull(num); // 객체가 null이 아닌지 테스트
        assertThrows(Exception.class, () -> {throw new Exception();}); // 예외가 발생하는지 테스트
        assertDoesNotThrow(() -> {}); // 예외가 발생하지 않는지 테스트
        assertTimeout(Duration.ofMillis(10), () -> Thread.sleep(1)); // 지정된 시간 내에 실행이 완료되는지 테스트
        assertAll(
                () -> assertEquals(num, 1),
                () -> assertEquals(num, 2),
                () -> fail() // 테스트 실패 처리
        ); // 제공된 모든 실행 파일이 예외를 발생시키지 않는지 확인.
    }
    @Test
    @DisplayName("숫자 테스트")
    public void number_test() throws Exception{
        int num = 3;
        int result = add(num, 2);

//        assert j
//        다양한 유형에 대한 어설션 메서드의 진입점. 이 클래스의 각 메서드는 유형별 어설션 개체에 대한 정적 팩토리.
        assertThat(5).isEqualTo(result);
    }
    int add(int num1, int num2){
        return num1 + num2;
    }
}
