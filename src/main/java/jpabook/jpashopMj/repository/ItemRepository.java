package jpabook.jpashopMj.repository;

import jpabook.jpashopMj.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {

    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            em.persist(item);
        } else {
            em.merge(item);
        }
    }

    public Item findOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
/*
em.merge가 뭐냐?
merge는 모든 데이터를 다 바꿔치기 함.
모든 데이터를 바꿔치기 한다!!

병합 시 조심해야 할 점
변경 감지 기능을 사용하면 원하는 속성만 선택해서 변경할 수 있지만, 병합을 사용하면 모든 속성이 변경됨.
병합 시 값이 없으면 다 그냥 null로 변경됨
따라서 merge보다는 변경감지로 써야 안전함
 */