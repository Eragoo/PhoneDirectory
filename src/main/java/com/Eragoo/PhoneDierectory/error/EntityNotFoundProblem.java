package com.Eragoo.PhoneDierectory.error;

import org.zalando.problem.AbstractThrowableProblem;

import static org.zalando.problem.Status.NOT_FOUND;

public class EntityNotFoundProblem extends AbstractThrowableProblem {

    public EntityNotFoundProblem(String title) {
        super(null, title, NOT_FOUND);
    }
}

