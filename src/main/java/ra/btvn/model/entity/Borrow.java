package ra.btvn.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "borrows")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Borrow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "borrowDate",nullable = false)
    private LocalDateTime borrowDate;

    @Column(name = "returnDate")
    private LocalDateTime returnDate;

    @ManyToOne
    @JoinColumn(name = "member_id",referencedColumnName = "id")
    private Member member;

    @PrePersist
    public void onCreate() {
        this.borrowDate = LocalDateTime.now();
    }
}
