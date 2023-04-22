package com.example.transactions.module;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // we save user_id
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "created_date_time", nullable = false)
    private LocalDateTime createdDateTime;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList;

    @PrePersist
    private void onCreate(){
        this.createdDateTime = LocalDateTime.now();
    }
}
