package co.kr.rlandboot3project.admin.menu.repository;

import co.kr.rlandboot3project.entity.Menu;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MenuCustomRepositoryImpl implements MenuCustomRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Page<Menu> findAll(String korName, Integer price, Integer page, Integer size) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Menu> query = cb.createQuery(Menu.class); // from, where(predicate)
        // "from Menu where title=:title"

        // from menu
        Root<Menu> root = query.from(Menu.class);

        List<Predicate> predicates = new ArrayList<Predicate>();
        // where [predicate] and [predicate] or [......]
        if (korName != null && !korName.isEmpty()) {

            predicates.add(cb.like(root.get("korName"), korName));
        }
//        Predicate korNamePre =cb.like(root.get("korName"), "%" + korName + "%");

        if (price != null) {

            predicates.add(cb.greaterThanOrEqualTo(root.get("price"), price));
        }
//        Predicate pricePre = cb.gt(root.get("price"), price);

        Predicate orPredicate = cb.or(predicates.toArray(new Predicate[0]));

        //        predicates.add(cb.like(c, v));

        query.where(orPredicate);  // predicates.toArray(new Predicate[0])
        query.orderBy(cb.desc(root.get("regDate")));

        List<Menu> menus = entityManager.createQuery(query)
                .setFirstResult((page-1) * size) // offset
                .setMaxResults(size) // limit
                .getResultList();

        // select * from ...
        // select count(id) from ...
        CriteriaQuery<Long> countQuery = cb.createQuery(Long.class);
        Root<Menu> countRoot = countQuery.from(Menu.class);
        List<Predicate> countPredicates = new ArrayList<Predicate>();

        if (korName != null && !korName.isEmpty()) {
            countPredicates.add(cb.like(countRoot.get("korName"), korName));
        }

        if (price != null) {

            countPredicates.add(cb.greaterThanOrEqualTo(countRoot.get("price"), price));
        }

        countQuery.select(cb.count(countRoot));
        countQuery.where(countPredicates.toArray(new Predicate[0]));
        Long count = entityManager.createQuery(countQuery).getSingleResult();

        return new PageImpl<>(menus, PageRequest.of(page-1, size), count);
    }

}