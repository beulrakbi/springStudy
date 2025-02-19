package com.ohgiraffers.common;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/* @Component: spring의 컴포넌트 스캔에 의해 자동으로 인식되어 Bean으로 등록된다.
*   즉 Spring IoC 컨테이너가 이 클래스를 관리하게 된다. */
@Component
public class MemberDAO {
    /* MemberDTO의 값으로 저장하는 자료구조
    * Map: java의 컬렉션 프레임워크에 속하는 인터페이스
    * 키와 값을 쌍으로 저장하는 자료구조이다.
    * 키값은 객체여야 한다.
    * 키값 타입을 숫자형으로 사용하기 위해서 타입을 Integer로 적음
    * */
    private final Map<Integer, MemberDTO> memberMap;

    public MemberDAO() {
        memberMap = new HashMap<>();
        /* memberMap.put을 통해 값을 추가하는데
         * key는 명시적으로 지정한 값이고, value는 MemberDTO 객체이다. */
        memberMap.put(1, new MemberDTO(1, "user01", "pass01", "다람쥐"));
        memberMap.put(2, new MemberDTO(2, "user02", "pass02", "코알라"));
    }
    /* 매개변수로 전달 받은 회원 번호를 map에서 조회 후 회원 정보를 리턴하는 메소드 */
    public MemberDTO selectMember(int sequence) {
        return memberMap.get(sequence);
    }

    /* 매개변수로 전달 받은 회원 정보를 map에 추가하고 성공, 실패 여부를 boolean으로 리턴하는 메소드 */
    public boolean insertMember(MemberDTO newMember) {

        int before = memberMap.size();

        memberMap.put(newMember.getSequence(), newMember);

        int after = memberMap.size();

        return after > before ? true : false;
    }
}
