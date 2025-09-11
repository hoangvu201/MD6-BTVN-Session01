package ra.btvn.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "borow_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BorrowDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "borrow_id",referencedColumnName = "id")
    private Borrow borrow;

    @ManyToOne
    @JoinColumn(name = "book_id",referencedColumnName = "id")
    private Book book;

    @Column(name = "quantity")
    private Integer quantity;
}
