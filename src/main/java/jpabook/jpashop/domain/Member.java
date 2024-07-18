package jpabook.jpashop.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter // Lombok
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    @Embedded
    private Address address;

    // 하나의 회원이 여러 개의 상품 주문 // 회원(Member) One -> 주문(Order) Many
    @OneToMany(mappedBy = "member")
    private List<Order> orders = new ArrayList<>();
}
