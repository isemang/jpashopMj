package jpabook.jpashopMj.domain;

import lombok.Getter;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class Address {

    private String city;
    private String street;
    private String zipcode;

    protected Address() {
    }

    public Address(String city, String street, String zipcode) {
        this.city = city;
        this.street = street;
        this.zipcode = zipcode;
    }

}
/* 값 타입
값 타입은 변경 불가능하게 설계해야 함.
초기 생성할 때만 생성되고, getter만 열어둬서 바꾸거나 생성할 수 없음.
임베디드타입(@Embeddable)은 자바 기본 생성자를 public이나 protected로 설정해야 한다.
(protected로 설정해 두는 게 좀 더 안전함)
 */