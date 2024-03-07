package br.com.charlesedu.moneyapi.repository.posting;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.util.StringUtils;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.model.Posting_;
import br.com.charlesedu.moneyapi.repository.filter.PostingFilter;

public class PostingRepositoryImpl implements PostingRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Posting> filter(PostingFilter postingFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Posting> criteria = builder.createQuery(Posting.class);

        Root<Posting> root = criteria.from(Posting.class);

        // Create the restrictions (predicates)
        Predicate[] predicates = createRestrictions(postingFilter, builder, root);

        criteria.where(predicates);

        TypedQuery<Posting> query = manager.createQuery(criteria);

        return query.getResultList();
    }

    private Predicate[] createRestrictions(PostingFilter postingFilter, CriteriaBuilder builder, Root<Posting> root) {
        List<Predicate> predicates = new ArrayList<>();

        if (!StringUtils.isEmpty(postingFilter.getPostingDescription())) {
            predicates.add(builder.like(builder.lower(root.get(Posting_.postingDescription).as(String.class)),
                    "%" + postingFilter.getPostingDescription().toLowerCase() + "%"));
        }

        if (postingFilter.getDueDateFrom() != null) {
            predicates.add(builder.greaterThanOrEqualTo(root.get(Posting_.dueDate), postingFilter.getDueDateFrom()));
        }

        if (postingFilter.getDueDateTo() != null) {
            predicates.add(builder.lessThanOrEqualTo(root.get(Posting_.dueDate), postingFilter.getDueDateTo()));
        }

        return predicates.toArray(new Predicate[predicates.size()]);
    }
}
