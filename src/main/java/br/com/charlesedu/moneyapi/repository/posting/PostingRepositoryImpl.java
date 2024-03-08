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

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import br.com.charlesedu.moneyapi.model.Posting;
import br.com.charlesedu.moneyapi.model.Posting_;
import br.com.charlesedu.moneyapi.repository.filter.PostingFilter;

public class PostingRepositoryImpl implements PostingRepositoryQuery {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public Page<Posting> filter(PostingFilter postingFilter, Pageable pageable) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Posting> criteria = builder.createQuery(Posting.class);

        Root<Posting> root = criteria.from(Posting.class);

        // Create the restrictions (predicates)
        Predicate[] predicates = createRestrictions(postingFilter, builder, root);

        criteria.where(predicates);

        TypedQuery<Posting> query = manager.createQuery(criteria);

        addPaginationRestrictions(query, pageable);

        return new PageImpl<>(query.getResultList(), pageable, total(postingFilter));
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

    private void addPaginationRestrictions(TypedQuery<Posting> query, Pageable pageable) {
        int currentPage = pageable.getPageNumber();
        int totalRecordsPerPage = pageable.getPageSize();
        int firstRecordOfPage = currentPage * totalRecordsPerPage;

        query.setFirstResult(firstRecordOfPage);
        query.setMaxResults(totalRecordsPerPage);
    }

    private Long total(PostingFilter postingFilter) {
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Long> criteria = builder.createQuery(Long.class);

        Root<Posting> root = criteria.from(Posting.class);

        Predicate[] predicates = createRestrictions(postingFilter, builder, root);

        criteria.where(predicates);

        criteria.select(builder.count(root));

        return manager.createQuery(criteria).getSingleResult();
    }
}
