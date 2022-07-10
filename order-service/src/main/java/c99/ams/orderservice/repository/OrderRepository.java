package c99.ams.orderservice.repository;

import c99.ams.orderservice.entity.Order;
import c99.ams.orderservice.utils.enums.State;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    Optional<Order> findByEmailAndState(String email, State cart);

    Boolean existsByEmailAndState(String email, State cart);

    Optional<Order> findByIdAndState(Long id, State cart);

    Page<Order> findAllByEmailAndState(String email, State state, Pageable pageable);

    Page<Order> findAllByEmail(String email, Pageable pageable);

    List<Order> findAllByEmailAndStateNot(String email, State state);

    List<Order> findAllByEmailAndState(String email, State state);
}
